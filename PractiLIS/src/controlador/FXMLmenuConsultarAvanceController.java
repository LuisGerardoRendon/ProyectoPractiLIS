/*
 * LISTA DE CONTENIDO:
 * > Paquete de la clase  
 * > Clases o librerias utilizadas
 * > Atributos de la clase 
 * > Constructor 
 * > Método initialize 
 * > Métodos con Action Event
 * > Otros Métodos de la clase 
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modelo.EstudianteVO;
import modelo.ProyectoDAOImplements;
import modelo.ProyectoVO;
import modelo.ReporteDAOImplements;
import modelo.ReporteVO;


/**
 * Decripcion de la Clase: Esta clase es la encargada de cargar la información y de implementar los
 * componentes y Eventos de la vista FXMLmenuCOnsultarAvance.fxml.
 *
 * @author Luis Gerardo Rendon
 */
public class FXMLmenuConsultarAvanceController implements Initializable {

   @FXML
   private Label labelProgreso;
   @FXML
   private Button botonRegresar;
   @FXML
   private Label labelNombreProyecto;
   @FXML
   private Label labelSetNombreProyecto;
   @FXML
   private Label labelHorasRegistradas;
   @FXML
   private Label labelSetHorasRegistradas;
   @FXML
   private Label labelTotalHoras;
   @FXML
   private Label label200;
   @FXML
   private TableView<ReporteVO> tablaReportesEntregados;
   @FXML
   private TableColumn<?, ?> columnaNombreReporte;
   @FXML
   private TableColumn<?, ?> comlumnaFechaEntrega;
   @FXML
   private TableColumn<?, ?> ColumnaHorasCubiertas;
   @FXML
   private Label labelSetAvance;
   @FXML
   private Label labelAvance;

   private EstudianteVO estudianteLogeado;

   private ReporteDAOImplements reporteDAOImp;
   private ProyectoDAOImplements proyectoDAOImp;

   ObservableList<ReporteVO> reportesRecuperados;
   ProyectoVO proyectoRescatado;

   /**
    * Constructor de la ventana: Este constructor es utilizado para pasar parámetros entre ventanas.
    *
    * @param estudianteLogeado Es el Estudiante que es recuperado desde el login, es indispensable
    * para recuparar la información que es mostrada en la ventana.
    */
   public FXMLmenuConsultarAvanceController(EstudianteVO estudianteLogeado) {
      this.estudianteLogeado = estudianteLogeado;
   }

   /**
    * Método initialize es el primer método que se ejecuta al mostrar la ventana, es el encargado de
    * instanciar los atributos de la ventana y cargar la información necesaria.
    */
   @Override
   public void initialize(URL url, ResourceBundle rb) {
      reporteDAOImp = new ReporteDAOImplements();
      proyectoDAOImp = new ProyectoDAOImplements();
      reportesRecuperados = FXCollections.observableArrayList();
      estudianteLogeado = new EstudianteVO();
      proyectoRescatado = new ProyectoVO();
      if (inicializarDatos()) {
         setNombreProyecto();
         calcularAvance();
         inicializarTabla();
      }

   }

   /**
    * Medodo regresar es el método ligado al ActionEvent de dar clic al botón regresar. Se encarga
    * de hacer que se regrese a la ventana anterior cuando se le da clic a botón regresar.
    *
    * @param event Clic en botón regresar
    */
   @FXML
   private void regresar(ActionEvent event) {
      cerrarEstaVentana();
      mostrarFXMLmenuPrincipalEstudiante(estudianteLogeado);

   }

   /**
    * Metodo inicializarTabla se encarga de definir el tipo de atributos con los que se llenarán las
    * columnas de las tabla de reportes, tambien se encarga de cargar la lista de reportes
    * recuperados de la base de datos.
    */
   public void inicializarTabla() {

      this.ColumnaHorasCubiertas.setCellValueFactory(new PropertyValueFactory("horasReportadas"));
      this.columnaNombreReporte.setCellValueFactory(new PropertyValueFactory("numero"));
      this.comlumnaFechaEntrega.setCellValueFactory(new PropertyValueFactory("fechaCarga"));
      this.tablaReportesEntregados.setItems(reportesRecuperados);
      hayReportesSubidos();

   }

   /**
    * Método calcularAvance se encarga de calcular el avance del estudiante logeado, extrallendo y
    * sumando todas las horas reportadas de los reportes recuperados de la base de datos y después
    * aplicando una regla de tres para obtener el porcentaje y mostrarlo en la ventana
    * correspondiente.
    */
   public void calcularAvance() {
      int suma = 0;
      for (ReporteVO tab : reportesRecuperados) {
         suma += tab.getHorasReportadas();
      }
      this.labelSetHorasRegistradas.setText(suma + "");
      float avance = (suma * 100) / 200;
      this.labelSetAvance.setText(avance + "%");
   }

   /**
    * Metodo setNombreProyecto se encarga unicamente de asignar el nombre del proyecto recuperado a
    * su label correspondiente, para que de esta manera se pueda visualizar en el nombre del
    * proyecto recuperado.
    */
   public void setNombreProyecto() {
      String nombreProyectoRecuperado = proyectoRescatado.getNombre();
      this.labelSetNombreProyecto.setText(nombreProyectoRecuperado);
   }

   /**
    * Metodo cerrarEstaVentana se encarga de cerrar la ventana.
    */
   public void cerrarEstaVentana() {
      Stage stage = (Stage) this.botonRegresar.getScene().getWindow();
      stage.close();
   }

   /**
    * Método mostrarFXMLmenuPrincipalEstudiante se encarga de mostrar la ventana
    * FXMLmenuPrincipalEstudiante.
    *
    * @param estudianteLogeado instancia del estudiante acutalmente logeado
    */
   private void mostrarFXMLmenuPrincipalEstudiante(EstudianteVO estudianteLogeado) {
      try {
         FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/vista/FXMLmenuPrincipalEstudiante.fxml"));
         Parent ventanaPrincipal = (Parent) fXMLLoader.load();
         FXMLmenuPrincipalEstudianteController controlador = fXMLLoader.getController();
         controlador.setEstudianteLogeado(estudianteLogeado);
         Stage stage = new Stage();
         stage.setScene(new Scene(ventanaPrincipal));
         stage.show();
      } catch (IOException exception) {
         System.out.println("Error al abrir la ventana");
         exception.printStackTrace();
      }
   }

   /**
    * Método hayReportesSubidos es el encargado de validar que la lista de reportes recuperados de
    * la base de datos no esté vacía, Si está vacía: El método mostrará un mensaje que avise que no
    * existen reportes en el proyecto y que por lo tanto no hay progreso. Si la lista está llena:
    * Simplemente regresará TRUE
    *
    * @return retorna TRUE si la lista de reportes no está vacía y retorna FALSE si la lista de
    * reportes está vacía.
    */
   public boolean hayReportesSubidos() {
      boolean hayReportesSubidos = false;

      if (!this.reportesRecuperados.isEmpty()) {
         hayReportesSubidos = true;
      } else {
         System.out.println("No hay reportes");
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("INFORMACIÓN");
         alert.setHeaderText("No hay avance en este proyecto");
         alert.setContentText("Nombre del proyecto: " + this.proyectoRescatado.getNombre());
         alert.showAndWait();

      }
      return hayReportesSubidos;

   }

   /**
    * El método inicializarDatos se encarga de recuperar la información de la base de datos, tambien
    * valida si fue posible posible conectar con la base de datos. Si no fue posible conectar con la
    * base de datos: Muestra una alerta con el mensaje de "ERROR. No hay conexión con la base de
    * datos, inténtelo más tarde" y Retorna FALSE Si fue pisible conectar con la base de datos:
    * Retorna TRUE
    *
    * @return TRUE si fue posible conectar con la base de datos y FALSE si no se pudo conectar con
    * la base de datos.
    */
   private boolean inicializarDatos() {
      boolean datosInicializados = false;
      try {
         this.reportesRecuperados = this.reporteDAOImp.recuperarReportesDeEstudiante("2020-2021",
                 this.estudianteLogeado.getMatricula());
         this.proyectoRescatado = this.proyectoDAOImp.recuperarProyectoEstudiante("2020-2021",
                 this.estudianteLogeado.getMatricula());
         datosInicializados = true;

      } catch (SQLException exception) {
         Alert alert = new Alert(Alert.AlertType.ERROR);
         alert.setTitle("ERROR");
         alert.setHeaderText("");
         alert.setContentText("ERROR. No hay conexión con la base de datos, inténtelo más tarde");
         alert.showAndWait();

      } catch (Exception exception) {
         Alert alert = new Alert(Alert.AlertType.ERROR);
         alert.setTitle("ERROR. Algo malo ocurrió");
         alert.setHeaderText("");
         alert.setContentText(exception.getMessage());
         alert.showAndWait();
      }
      return datosInicializados;
   }

}
