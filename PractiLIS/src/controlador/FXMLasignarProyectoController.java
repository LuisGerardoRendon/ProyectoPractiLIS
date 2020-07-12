/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
         this.obtenerProyectos();
         this.columnaNombreProyecto.setCellValueFactory(new PropertyValueFactory("nombre"));
         this.columnaCupoProyecto.setCellValueFactory(new PropertyValueFactory("capacidadEstudiantes"));
         this.tablaProyectos.setItems(proyectos);

         //Llena tabla de estudiantes
         estudianteDAOImp = new EstudianteDAOImplements();
         estudiantes = FXCollections.observableArrayList();
         this.obtenerEstudiantes();
         this.columnaNombreEstudiantes.setCellValueFactory(new PropertyValueFactory("nombre"));
         this.columnaMatricula.setCellValueFactory(new PropertyValueFactory("matricula"));
         this.tablaEstudiantes.setItems(estudiantes);
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
      ProyectoVO proyectoSolicitado = this.tablaSolicitudes.getSelectionModel().getSelectedItem();
      ProyectoVO proyecto = this.tablaProyectos.getSelectionModel().getSelectedItem();

      //Datos de la asignacion
      String periodo = "Ene 2020-Ago 2020";
      float progreso = 0;
      //Crear método para validar de que tabla se elige el proyecto.
      if (estudiante != null && proyecto != null && proyectoSolicitado != null) {
         FXMLAlerta alerta = new FXMLAlerta((Stage) this.botonAsignar.getScene().getWindow());
         alerta.alertaError("ERROR", "", "No se ha seleccionado un estudiante o proyecto.");
      } else {
         if (proyecto != null) {
            AsignacionVO asignacion = new AsignacionVO(periodo, progreso, proyecto.getIdProyecto(),estudiante.getMatricula());
            asignacionDAOImp = new AsignacionDAOImplements();
            try {
               asignacionDAOImp.create(asignacion);
            } catch (Exception e) {
               FXMLAlerta alerta = new FXMLAlerta((Stage) this.tablaEstudiantes.getScene().getWindow());
               alerta.alertaError("Error", "Ocurrio un error al realizar la operacion con la base de datos",
                       e.getMessage());
            }
         } else {
            AsignacionVO asignacion = new AsignacionVO(periodo, progreso, proyectoSolicitado.getIdProyecto(), estudiante.getMatricula());
            asignacionDAOImp = new AsignacionDAOImplements();
            try {
               asignacionDAOImp.create(asignacion);
            } catch (Exception e) {
               FXMLAlerta alerta = new FXMLAlerta((Stage) this.tablaEstudiantes.getScene().getWindow());
               alerta.alertaError("Error", "Ocurrio un error al realizar la operacion con la base de datos",
                       e.getMessage());
            }
         }

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
         this.proyectos = proyectoDAOImp.recuperarProyectos();
      } catch (Exception e) {
         FXMLAlerta alerta = new FXMLAlerta((Stage) this.tablaEstudiantes.getScene().getWindow());
         alerta.alertaError("Error", "Ocurrio un error al realizar la operacion con la base de datos",
                 e.getMessage());
      }
   }

   public void obtenerEstudiantes() {
      try {
         this.estudiantes = estudianteDAOImp.recuperarEstudiantes();
      } catch (Exception e) {
         FXMLAlerta alerta = new FXMLAlerta((Stage) this.tablaEstudiantes.getScene().getWindow());
         alerta.alertaError("Error", "Ocurrio un error al realizar la operacion con la base de datos",
                 e.getMessage());
      }

   }

   public void obtenerProyectosSolicitados(String matricula) {
      try {
         this.proyectosSolicitados = proyectoDAOImp.recuperarProyectosSolicitados(matricula);
         if (proyectosSolicitados.isEmpty()) {
            FXMLAlerta alerta = new FXMLAlerta((Stage) this.tablaEstudiantes.getScene().getWindow());
            alerta.alertaError("Error", "",
                    "Los PROYECTOS solicitados por este estudiante no tienen cupo");
         }
      } catch (Exception e) {
         FXMLAlerta alerta = new FXMLAlerta((Stage) this.tablaEstudiantes.getScene().getWindow());
         alerta.alertaError("Error", "Ocurrio un error al realizar la operacion con la base de datos",
                 e.getMessage());
      }
   }
}
