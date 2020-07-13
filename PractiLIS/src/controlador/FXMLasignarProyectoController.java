/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import modelo.AsignacionDAOImplements;
import modelo.AsignacionVO;
import modelo.EstudianteDAOImplements;
import modelo.EstudianteVO;
import modelo.ExpedienteDAOImplements;
import modelo.ExpedienteVO;
import modelo.ProyectoDAOImplements;
import modelo.ProyectoVO;
import vista.FXMLAlerta;

/**
 * FXML Controller class
 *
 * @author Daniel Pale Parra
 */
public class FXMLasignarProyectoController implements Initializable {

   @FXML
   private TableView<EstudianteVO> tablaEstudiantes;
   @FXML
   private TableColumn<EstudianteVO, String> columnaNombreEstudiantes;
   @FXML
   private TableColumn<EstudianteVO, String> columnaMatricula;
   @FXML
   private Button botonMostrarSolicitudes;
   @FXML
   private Button botonAsignar;
   @FXML
   private TableView<ProyectoVO> tablaSolicitudes;
   @FXML
   private TableColumn<ProyectoVO, String> columnaNombreProyectoSolicitado;
   @FXML
   private TableColumn<ProyectoVO, Integer> columnaCupoProyectoSolicitado;
   @FXML
   private TableView<ProyectoVO> tablaProyectos;
   @FXML
   private TableColumn<ProyectoVO, String> columnaNombreProyecto;
   @FXML
   private TableColumn<ProyectoVO, Integer> columnaCupoProyecto;

   private ProyectoDAOImplements proyectoDAOImp;
   private EstudianteDAOImplements estudianteDAOImp;
   private AsignacionDAOImplements asignacionDAOImp;
   private ExpedienteDAOImplements expedienteDAOImp;

   private ObservableList<ProyectoVO> proyectos;
   private ObservableList<ProyectoVO> proyectosSolicitados;
   private ObservableList<EstudianteVO> estudiantes;

   /**
    * Initializes the controller class.
    */
   @Override
   public void initialize(URL url, ResourceBundle rb) {
      try {
         //LLena tabla de proyecto
         proyectoDAOImp = new ProyectoDAOImplements();
         proyectos = FXCollections.observableArrayList();

         //Llena tabla de estudiantes
         estudianteDAOImp = new EstudianteDAOImplements();
         estudiantes = FXCollections.observableArrayList();

         this.inicializarTablas();
      } catch (Exception e) {
         FXMLAlerta alerta = new FXMLAlerta((Stage) this.tablaEstudiantes.getScene().getWindow());
         alerta.alertaError("Error", "Ocurrio un error al realizar la operacion con la base de datos",
                 e.getMessage());
      }
   }

   @FXML
   private void mostrarSolicitudes(ActionEvent event) {
      EstudianteVO estudianteSeleccionado = this.tablaEstudiantes.getSelectionModel().getSelectedItem();

      if (estudianteSeleccionado != null) {
         this.obtenerProyectosSolicitados(estudianteSeleccionado.getMatricula());
         this.columnaNombreProyectoSolicitado.setCellValueFactory(new PropertyValueFactory("nombre"));
         this.columnaCupoProyectoSolicitado.setCellValueFactory(new PropertyValueFactory("capacidadEstudiantes"));
         this.tablaSolicitudes.setItems(proyectosSolicitados);
      } else {
         FXMLAlerta alerta = new FXMLAlerta((Stage) this.tablaSolicitudes.getScene().getWindow());
         alerta.alertaError("ERROR", "", "No se ha seleccionado ningún estudiante.");
      }
   }

   @FXML
   private void asignar(ActionEvent event) {
      EstudianteVO estudiante = this.tablaEstudiantes.getSelectionModel().getSelectedItem();
      ProyectoVO proyecto = this.obtenerProyectoSeleccionado();
      //Datos de la asignacion
      String periodo = "Ene 2020-Ago 2020";
      float progreso = 0;

      if (estudiante != null && proyecto != null) {
         try {
            AsignacionVO asignacion = new AsignacionVO(periodo, progreso, proyecto.getIdProyecto(),
                    estudiante.getMatricula());
            asignacionDAOImp = new AsignacionDAOImplements();
            asignacionDAOImp.create(asignacion);
            cambiarStatus(estudiante.getMatricula());
            cambiarEstudiantesAsignados(proyecto);
            this.crearExpediente(estudiante.getMatricula(), periodo);
            FXMLAlerta alerta = new FXMLAlerta((Stage) this.botonAsignar.getScene().getWindow());
            alerta.alertaInformacion("EXITO", "", "La asignación se realizó con éxito");
            this.inicializarTablas();
         } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("");
            alert.setContentText("ERROR. No hay conexión con la base de datos, inténtelo más tarde");
            alert.showAndWait();
         } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR.Algo Ocurrio");
            alert.setHeaderText("");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
         }
      } else {
         FXMLAlerta alerta = new FXMLAlerta((Stage) this.botonAsignar.getScene().getWindow());
         alerta.alertaError("ERROR", "", "No se ha seleccionado un estudiante o proyecto.");
      }
   }

   @FXML
   private void seleccionarEstudiante(MouseEvent event) {
      EstudianteVO estudianteSeleccionado = this.tablaEstudiantes.getSelectionModel().getSelectedItem();
   }

   @FXML
   private void seleccionarProyecto(MouseEvent event) {
      ProyectoVO proyectoSeleccionado = this.tablaProyectos.getSelectionModel().getSelectedItem();
      this.tablaSolicitudes.getSelectionModel().select(null);
   }

   @FXML
   private void seleccionarProyectoSolicitado(MouseEvent event) {
      ProyectoVO proyectoSolicitadoSeleccionado = this.tablaSolicitudes.getSelectionModel().getSelectedItem();
      this.tablaProyectos.getSelectionModel().select(null);
   }

   public void obtenerProyectos() {
      try {
         this.proyectos = proyectoDAOImp.recuperarProyectosSinAsignar();
      } catch (Exception e) {
         FXMLAlerta alerta = new FXMLAlerta((Stage) this.tablaEstudiantes.getScene().getWindow());
         alerta.alertaError("Error", "Ocurrio un error al realizar la operacion con la base de datos",
                 e.getMessage());
      }
   }

   public void obtenerEstudiantes() {
      try {
         this.estudiantes = estudianteDAOImp.recuperarEstudiantesSinAsignar();
      } catch (Exception e) {
         FXMLAlerta alerta = new FXMLAlerta((Stage) this.tablaEstudiantes.getScene().getWindow());
         alerta.alertaError("Error", "Ocurrio un error al realizar la operacion con la base de datos",
                 e.getMessage());
      }

   }

   public void obtenerProyectosSolicitados(String matricula) {
      try {
         if (!proyectosSolicitados.isEmpty()) {
            this.proyectosSolicitados = proyectoDAOImp.recuperarProyectosSolicitados(matricula);
         } else {
            FXMLAlerta alerta = new FXMLAlerta((Stage) this.tablaEstudiantes.getScene().getWindow());
            alerta.alertaError("Error", "",
                    "Los PROYECTOS solicitados por este estudiante no tienen cupo");
         }
      } catch (SQLException e) {
         Alert alert = new Alert(Alert.AlertType.ERROR);
         alert.setTitle("ERROR");
         alert.setHeaderText("");
         alert.setContentText("ERROR. No hay conexión con la base de datos, inténtelo más tarde");
         alert.showAndWait();

      } catch (Exception e) {
         Alert alert = new Alert(Alert.AlertType.ERROR);
         alert.setTitle("ERROR.Algo Orurrio");
         alert.setHeaderText("");
         alert.setContentText(e.getMessage());
         alert.showAndWait();
      }
   }

   public ProyectoVO obtenerProyectoSeleccionado() {
      ProyectoVO proyectoTablaProyectos = this.tablaProyectos.getSelectionModel().getSelectedItem();
      ProyectoVO proyectoTablaSolicitudes = this.tablaSolicitudes.getSelectionModel().getSelectedItem();
      ProyectoVO proyectoSeleccionado;

      if (proyectoTablaProyectos != null) {
         proyectoSeleccionado = proyectoTablaProyectos;
      } else {
         proyectoSeleccionado = proyectoTablaSolicitudes;
      }
      return proyectoSeleccionado;
   }

   public void cambiarStatus(String matricula) {
      try {
         boolean changed = this.estudianteDAOImp.cambiarStatusAsignado(matricula);
         if (changed == false) {
            FXMLAlerta alerta = new FXMLAlerta((Stage) this.botonAsignar.getScene().getWindow());
            alerta.alertaError("ERROR", "", "No se ha podido asignar el estudiante a proyecto");
         }
      } catch (Exception e) {
         FXMLAlerta alerta = new FXMLAlerta((Stage) this.tablaEstudiantes.getScene().getWindow());
         alerta.alertaError("Error", "Ocurrio un error al realizar el método cambiarStatus",
                 e.getMessage());
      }
   }

   public void cambiarEstudiantesAsignados(ProyectoVO proyecto) {
      if ((proyecto.getCapacidadEstudiantes() - (proyecto.getNumEstudiantesAsignados() + 1)) != 0) {
         try {
            boolean changed = this.proyectoDAOImp.cambiarEstudiantesAsignados(proyecto.getIdProyecto(), (proyecto.getNumEstudiantesAsignados() + 1), "Sin asignar");
         } catch (Exception e) {
            FXMLAlerta alerta = new FXMLAlerta((Stage) this.tablaEstudiantes.getScene().getWindow());
            alerta.alertaError("Error", "Ocurrio un error al realizar el método cambiarEstudianteAsignado",
                    e.getMessage());
         }
      } else {
         try {
            this.proyectoDAOImp.cambiarEstudiantesAsignados(proyecto.getIdProyecto(), (proyecto.getNumEstudiantesAsignados() + 1), "Asignado");
         } catch (Exception e) {
            FXMLAlerta alerta = new FXMLAlerta((Stage) this.tablaEstudiantes.getScene().getWindow());
            alerta.alertaError("Error", "Ocurrio un error al realizar el método cambiarEstudianteAsignado",
                    e.getMessage());
         }
      }
   }

   public void inicializarTablas() {
      this.obtenerProyectos();
      this.columnaNombreProyecto.setCellValueFactory(new PropertyValueFactory("nombre"));
      this.columnaCupoProyecto.setCellValueFactory(new PropertyValueFactory("capacidadEstudiantes"));
      this.tablaProyectos.setItems(proyectos);

      this.obtenerEstudiantes();
      this.columnaNombreEstudiantes.setCellValueFactory(new PropertyValueFactory("nombre"));
      this.columnaMatricula.setCellValueFactory(new PropertyValueFactory("matricula"));
      this.tablaEstudiantes.setItems(estudiantes);
   }

   public void crearExpediente(String matricula, String periodo) {
      expedienteDAOImp = new ExpedienteDAOImplements();
      try {
         int idAsignacion = this.asignacionDAOImp.obtenerIdAsingacion(matricula, periodo);
         System.out.println(idAsignacion);
         ExpedienteVO expediente = new ExpedienteVO(0, idAsignacion);
         boolean created = this.expedienteDAOImp.create(expediente);
         if (created == false) {
            FXMLAlerta alerta = new FXMLAlerta((Stage) this.botonAsignar.getScene().getWindow());
            alerta.alertaError("ERROR", "", "No se ha podido crear el expediente");
         }
      } catch (Exception e) {
         FXMLAlerta alerta = new FXMLAlerta((Stage) this.tablaEstudiantes.getScene().getWindow());
         alerta.alertaError("Error", "Ocurrio un error al realizar el método crear Expediente",
                 e.getMessage());
         e.printStackTrace();
      }
   }
}
