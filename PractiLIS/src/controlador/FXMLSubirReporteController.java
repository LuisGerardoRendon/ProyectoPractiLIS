/*
 * LISTA DE CONTENIDO.
 *    > Paquete de la clase 
 *    > Clases o librerias utilizadas
 *    > Atributos de la clase
 *    > Constructor
 *    > Método initialize
 *    > Métodos Action Event
 *    > Otros Métodos de la clase
 */
package controlador;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.EstudianteVO;
import modelo.ProyectoDAOImplements;
import modelo.ProyectoVO;
import modelo.ReporteDAOImplements;
import modelo.ReporteVO;
import vista.FXMLAlerta;

/**
 * Clase que contiene los metodos que controlan a la ventana FXMLSubirReporte
 *
 * @author Aldo Colorado 
 */
public class FXMLSubirReporteController implements Initializable {

   @FXML
   private TableView<ReporteVO> tablaReportes;
   @FXML
   private TableColumn<ReporteVO, Integer> columnaNumeroReporte;
   @FXML
   private TableColumn<ReporteVO, String> columnaFechaCarga;
   @FXML
   private TableColumn<ReporteVO, Integer> columnaHorasCubiertas;
   @FXML
   private Button botonSubirNuevoReporte;
   @FXML
   private Button botonRegresar;
   @FXML
   private Label labelNombreProyecto;
   @FXML
   private Label labelHorasAcumuladas;
   
   private EstudianteVO estudianteLogeado;
   
   private ProyectoVO proyectoRecuperado;
   
   private ObservableList<ReporteVO> reportesRecuperados;
   
   ReporteDAOImplements reporteDAOImp;
   
   ProyectoDAOImplements proyectoDAOImp;
   

   /**
    * Constructor de la clase que permite el paso de parametros desde la ventana
    * FXMLMenuPrincipalEstudiante
    *
    * @param estudianteLogeado Define el estudiante que se recibe en esta ventana
    */
   public FXMLSubirReporteController(EstudianteVO estudianteLogeado) {
      this.estudianteLogeado = estudianteLogeado;
   }

   /**
    * Metodo que inicializa la ventana y sus componentes
    *
    * @param url Representa la ubicación del archivo de la ventana
    * @param rb Prove de mecanismos para la inicialización de recursos
    */
   @Override
   public void initialize(URL url, ResourceBundle rb) {

      reporteDAOImp = new ReporteDAOImplements();
      proyectoDAOImp = new ProyectoDAOImplements();
      
      if(recuperarReportes()){
         recuperarProyecto();
         setNombreProyecto();
         calcularHoras();
         inicializarTabla();
      }
      
      

   }

   /**
    * Metodo para cargar la ventana FXMLSubirNuevoReporte
    *
    * @param event Lanza el vento de la ventana
    */
   @FXML
   private void subirNuevoReporte(ActionEvent event) {

      abrirVentanaSubirNuevoReporte();

      cerrarVentana(event);
   }

   /**
    * Metodo para regresar al Menu principal del estudiante
    *
    * @param event
    */
   @FXML
   private void regresar(ActionEvent event) {

      cerrarVentana(event);

      abrirMenuPrincipalEstudiante();
   }
   
   /**
    * Metodo para cerrar la ventana FXMLSubirReporte
    *
    * @param event Atributo que lanza el evento de cerrar la ventana
    */
   public void cerrarVentana(ActionEvent event) {
      Node source = (Node) event.getSource();
      Stage stage = (Stage) source.getScene().getWindow();
      stage.close();
   }
 
   /**
    * Metodo para abrir la ventana FXMLSubirNuevoReporte
    */
   public void abrirVentanaSubirNuevoReporte() {

      try {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/"
                 + "FXMLSubirNuevoReporte.fxml"));
         FXMLSubirNuevoReporteController controladorSubirNuevoReporte = new 
         FXMLSubirNuevoReporteController(estudianteLogeado);
         loader.setController(controladorSubirNuevoReporte);
         Parent root = loader.load();

         Scene scene = new Scene(root);
         Stage stage = new Stage();
         stage.initModality(Modality.APPLICATION_MODAL);
         stage.setScene(scene);
         stage.show();

      } catch (IOException e) {
         System.out.println(e.getMessage());
         e.printStackTrace();
      }
   }

   /**
    * Metodo para abrir la ventana FXMLMenuPrincipalEstudiante
    */
   public void abrirMenuPrincipalEstudiante() {
      try {
         FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/vista/"
                 + "FXMLmenuPrincipalEstudiante.fxml"));
         Parent ventanaPrincipal = (Parent) fXMLLoader.load();
         FXMLmenuPrincipalEstudianteController controlador = fXMLLoader.getController();
         controlador.setEstudianteLogeado(estudianteLogeado);
         Stage stage = new Stage();
         stage.setScene(new Scene(ventanaPrincipal));
         stage.show();
      } catch (Exception e) {
         e.getMessage();
         e.printStackTrace();
      }
   }

   /**
    * Metodo para inicializar la tabla de los reportes del estudiante
    */
   public void inicializarTabla() {

      this.columnaNumeroReporte.setCellValueFactory(new PropertyValueFactory("numero"));
      this.columnaFechaCarga.setCellValueFactory(new PropertyValueFactory("fechaCarga"));
      this.columnaHorasCubiertas.setCellValueFactory(new PropertyValueFactory("horasReportadas"));
      this.tablaReportes.setItems(reportesRecuperados);

   }

   /**
    * Metodo para inicializar el nombre del proyecto del estudiante
    */
   public void setNombreProyecto() {
      String nombreProyectoRecuperado = proyectoRecuperado.getNombre();
      this.labelNombreProyecto.setText(nombreProyectoRecuperado);
   }

   /**
    * Metodo para recuperar el proyecto a que el estudiante esta asignado
    */
   public void recuperarProyecto() {
      try {
         proyectoRecuperado = this.proyectoDAOImp.recuperarProyectoEstudiante("2020-2021",
                 estudianteLogeado.getMatricula());
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   /**
    * Metodo para recuperar los reportes del estudiante
    */
   public boolean recuperarReportes() {
      boolean exitoRecuperarReportes=true;
              
      try {
         reportesRecuperados = this.reporteDAOImp.recuperarReportesDeEstudiante("2020-2021",
                 estudianteLogeado.getMatricula());
      } catch (SQLException e) {
         exitoRecuperarReportes=false;
         Alert alert = new Alert(Alert.AlertType.ERROR);
         alert.setTitle("ERROR");
         alert.setHeaderText("");
         alert.setContentText("ERROR. No hay conexión con la base de datos, inténtelo más tarde");
         alert.showAndWait();
         e.printStackTrace();
         abrirMenuPrincipalEstudiante();
      } catch (Exception e){
         e.printStackTrace();
         Alert alert = new Alert(Alert.AlertType.ERROR);
         alert.setTitle("ERROR. Algo malo ocurrió");
         alert.setHeaderText("");
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         abrirMenuPrincipalEstudiante();
      }
      
      return exitoRecuperarReportes;
   }

   /**
    * Metodo para calcular las horas reportadas por el estudiante
    */
   public void calcularHoras() {
      int sumaHoras = 0;
      for (ReporteVO tab : reportesRecuperados) {
         sumaHoras += tab.getHorasReportadas();
      }
      this.labelHorasAcumuladas.setText(sumaHoras + "");
   }

}
