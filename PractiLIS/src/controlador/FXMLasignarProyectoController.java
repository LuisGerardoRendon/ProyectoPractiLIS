/**
 * LISTA DE CONTENIDO:
 * > Paquete de la clase
 * > Clases o librerias utilizadas
 * > Atributos de la clase
 * > Método initialize
 * > Métodos con Action Event
 * > Otros Métodos de la clase
 */
package controlador;

import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
 * Clase que contiene los métodos que controlan la ventana FXMLasignarProyectoController
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
    * Método que inicializa los elementos de la ventana
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

   /**
    * Método que muestra las solicitudes del Estudiante en la tablaSolicitudes
    *
    * @param event Lanza el evento descrito
    */
   @FXML
   private void mostrarSolicitudes(ActionEvent event) {
      EstudianteVO estudianteSeleccionado = this.tablaEstudiantes.getSelectionModel().getSelectedItem();

      if (estudianteSeleccionado != null) {
         this.obtenerProyectosSolicitados(estudianteSeleccionado.getMatricula());
         this.calcularCupo(proyectosSolicitados);
         this.columnaNombreProyectoSolicitado.setCellValueFactory(new PropertyValueFactory("nombre"));
         this.columnaCupoProyectoSolicitado.setCellValueFactory(new PropertyValueFactory("capacidadEstudiantes"));
         this.tablaSolicitudes.setItems(proyectosSolicitados);
      } else {
         FXMLAlerta alerta = new FXMLAlerta((Stage) this.tablaSolicitudes.getScene().getWindow());
         alerta.alertaError("ERROR", "", "No se ha seleccionado ningún estudiante.");
      }
   }

   /**
    * Método que asigna un Estudiante seleccionado de la tablaEstudiantes a un Proyecto de la
    * tablaProyectos y crea el Expediente de Estudiante
    *
    * @param event Lanza el evento descrito
    */
   @FXML
   private void asignar(ActionEvent event) {
      EstudianteVO estudiante = this.tablaEstudiantes.getSelectionModel().getSelectedItem();
      ProyectoVO proyecto = this.obtenerProyectoSeleccionado();
      //Datos de la asignacion
      String periodo = "2020-2021";
      float progreso = 0;
      String fecha=this.obtenerFechaActual();
      if (estudiante != null && proyecto != null) {
         try {
            AsignacionVO asignacion = new AsignacionVO(periodo, progreso, proyecto.getIdProyecto(),
                    estudiante.getMatricula(), fecha);
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

   /**
    * Método que selecciona un Estudiante de la tablaEstudiantes
    *
    * @param event Lanza el evento descrito
    */
   @FXML
   private void seleccionarEstudiante(MouseEvent event) {
      EstudianteVO estudianteSeleccionado = this.tablaEstudiantes.getSelectionModel().getSelectedItem();
   }

   /**
    * Método que selecciona un Proyecto de la tablaProyectos y deselecciona el Proyecto de la
    * tablaSolicitudes si aplica
    *
    * @param event Lanza el evento descrito
    */
   @FXML
   private void seleccionarProyecto(MouseEvent event) {
      ProyectoVO proyectoSeleccionado = this.tablaProyectos.getSelectionModel().getSelectedItem();
      this.tablaSolicitudes.getSelectionModel().select(null);
   }

   /**
    * Método que selecciona un Proyecto de la tablaSolicitudes y deselecciona el Proyecto de la
    * tablaProyectos si aplica
    *
    * @param event
    */
   @FXML
   private void seleccionarProyectoSolicitado(MouseEvent event) {
      ProyectoVO proyectoSolicitadoSeleccionado = this.tablaSolicitudes.getSelectionModel()
              .getSelectedItem();
      this.tablaProyectos.getSelectionModel().select(null);
   }

   /**
    * Método que llama al método recuperarProyectoSinAsignar de ProyectoDAOImplements y verifica que
    * la lista regresada no este vacia
    */
   public void obtenerProyectos() {
      try {
         this.proyectos = proyectoDAOImp.recuperarProyectosSinAsignar();
      } catch (Exception e) {
         FXMLAlerta alerta = new FXMLAlerta((Stage) this.tablaEstudiantes.getScene().getWindow());
         alerta.alertaError("Error", "Ocurrio un error al realizar la operacion con la base de datos",
                 e.getMessage());
      }
   }

   /**
    * Método que llama al método recuperarEstudiantesSinAsignar de EstudianteDAOImplements y
    * verifica que la lista regresada no este vacia
    */
   public void obtenerEstudiantes() {
      try {
         this.estudiantes = estudianteDAOImp.recuperarEstudiantesSinAsignar();
      } catch (Exception e) {
         FXMLAlerta alerta = new FXMLAlerta((Stage) this.tablaEstudiantes.getScene().getWindow());
         alerta.alertaError("Error", "Ocurrio un error al realizar la operacion con la base de datos",
                 e.getMessage());
      }

   }

   /**
    * Método que llama al método recuperarProyectosSolicitados de ProyectoDAOImplements y verifica
    * que la lista regresada no este vacia
    *
    * @param matricula Define la matricula del Estudiante
    */
   public void obtenerProyectosSolicitados(String matricula) {
      try {

         this.proyectosSolicitados = proyectoDAOImp.recuperarProyectosSolicitados(matricula);
         if (proyectosSolicitados.isEmpty()) {
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
         System.out.println("ENTRO AL CATCH OBTENER");
         Alert alert = new Alert(Alert.AlertType.ERROR);
         alert.setTitle("ERROR.Algo Orurrio");
         alert.setHeaderText("");
         alert.setContentText(e.getMessage());
         e.printStackTrace();
         alert.showAndWait();
      }
   }

   /**
    * Método que verifica de que tabla se está seleccionando el Proyecto que se quiere asignar
    *
    * @return Regresa el proyecto seleccionado de alguna de tablas de tablasProyectos o 
    * tablaSoliciutes
    */
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

   /**
    * Método que llama al método cambiarStatusAsignado de EstudianteDAOImplements y verifica que el
    * cambio se haya realizado con éxito
    *
    * @param matricula Define la matricula del Estudiante al cual se le cambia status
    */
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

   /**
    * Método llama al método cambiarEstudiantesAsignados de ProyectoDAOImplements y verfica que el
    * cambio se haya realizado con éxito
    *
    * @param proyecto Defiene el objeto Proyecto al cual se quiere realizar el cambio
    */
   public void cambiarEstudiantesAsignados(ProyectoVO proyecto) {
      
      if (proyecto.getCapacidadEstudiantes()>0){
         try {
            boolean changed = this.proyectoDAOImp.cambiarEstudiantesAsignados(proyecto.getIdProyecto(),
                    (proyecto.getNumEstudiantesAsignados() + 1), "Sin asignar");
         } catch (Exception e) {
            FXMLAlerta alerta = new FXMLAlerta((Stage) this.tablaEstudiantes.getScene().getWindow());
            alerta.alertaError("Error", "Ocurrio un error al realizar el método "
                    + "cambiarEstudianteAsignado",
                    e.getMessage());
         }
      } else {
         try {
            this.proyectoDAOImp.cambiarEstudiantesAsignados(proyecto.getIdProyecto(),
                    (proyecto.getNumEstudiantesAsignados() + 1), "Asignado");
         } catch (Exception e) {
            FXMLAlerta alerta = new FXMLAlerta((Stage) this.tablaEstudiantes.getScene().getWindow());
            alerta.alertaError("Error", "Ocurrio un error al realizar el método "
                    + "cambiarEstudianteAsignado",
                    e.getMessage());
         }
      }
   }

   /**
    * Método que inicializa tablaEstudiantes y tablaProyectos
    */
   public void inicializarTablas() {
      this.obtenerProyectos();
      this.calcularCupo(proyectos);

      this.columnaNombreProyecto.setCellValueFactory(new PropertyValueFactory("nombre"));
      this.columnaCupoProyecto.setCellValueFactory(new PropertyValueFactory("capacidadEstudiantes"));
      this.tablaProyectos.setItems(proyectos);

      this.obtenerEstudiantes();
      this.columnaNombreEstudiantes.setCellValueFactory(new PropertyValueFactory("nombre"));
      this.columnaMatricula.setCellValueFactory(new PropertyValueFactory("matricula"));
      this.tablaEstudiantes.setItems(estudiantes);
   }

   /**
    * Método que llama al método Create de ExpedienteDAOImplements y revisa que la creación se haga
    * correctamente.
    *
    * @param matricula Define la matricula del Estudiante al cual se creará Expediente
    * @param periodo Define el periodo actual.
    */
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

   /**
    * Método encargado de calcular el cupo de los Proyectos de una ObservableList
    *
    * @param proyectosList ObservableList que se editará
    */
   private void calcularCupo(ObservableList<ProyectoVO> proyectosList) {
      int cupo = 0;
      for (ProyectoVO tab : proyectosList) {
         cupo = tab.getCapacidadEstudiantes() - tab.getNumEstudiantesAsignados();
         tab.setCapacidadEstudiantes(cupo);
      }
   }
   
   /**
    * Metodo para inizializar la fecha en la que se realiza la asignacion
    * 
    * @return fecha Define la fecha que se regresa
    */
   public String obtenerFechaActual() {

      DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
      Date date = new Date();
      String fecha = dateFormat.format(date);
      return fecha;
   }
}
