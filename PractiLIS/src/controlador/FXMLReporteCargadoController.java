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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.EstudianteVO;
import modelo.ExpedienteDAOImplements;
import modelo.ExpedienteVO;
import modelo.ReporteDAOImplements;
import modelo.ReporteVO;
import vista.FXMLAlerta;

/**
 * Clase que contiene los metodos que controlan a la ventana FXMLReporteCargadoController
 *
 * @author Aldo Colorado
 */
public class FXMLReporteCargadoController implements Initializable {

   @FXML
   private Label labelReporteCargado;
   @FXML
   private Label labelNombreArchivo;
   @FXML
   private Button botonCancelar;
   @FXML
   private Button botonSubirReporte;

   private EstudianteVO estudianteLogeado;

   public int horasReportadas;

   public String fechaCarga;

   public String fechaInicio;

   public String estado = "Concluido";

   public String fechaFin;

   public File archivo;

   ReporteVO reporte;

   ExpedienteVO expediente;

   ReporteDAOImplements reporteDAOImp;

   ExpedienteDAOImplements expedienteDAOImp;

   /**
    * Constructor que permite el paso de parametros entre las ventanas
    *
    * @param horasReportadas Define las horas del reporte
    * @param fechaInicio Define la fecha de inicio del reporte
    * @param fechaFin Define le fecha de fin del reporte
    * @param archivo Define el archivo del reporte
    * @param estudianteLogeado Define el estudiante logeado en el sistema
    */
   public FXMLReporteCargadoController(int horasReportadas, String fechaInicio,
           String fechaFin, File archivo, EstudianteVO estudianteLogeado) {

      this.horasReportadas = horasReportadas;
      this.fechaInicio = fechaInicio;
      this.fechaFin = fechaFin;
      this.archivo = archivo;
      this.estudianteLogeado = estudianteLogeado;

   }

   /**
    * Metodo para inizializar los elementos de la ventana
    */
   @Override
   public void initialize(URL url, ResourceBundle rb) {
      // TODO
      reporteDAOImp = new ReporteDAOImplements();
      expedienteDAOImp = new ExpedienteDAOImplements();
     
      cargarNombreArchivo();
      
      crearExpediente(estudianteLogeado.getMatricula());
   }
   
   /**
    * Metodo para cancelar el caso de uso
    * @param event Lanza el evento descrito
    */
   @FXML
   private void cancelar(ActionEvent event) {
      cerrarVentana(event);
      abrirMenuPrincipalEstudiante();
   }

   /**
    * Metodo para subir el reporte
    * @param event Lanza el evento descrito
    */
   @FXML
   private void subirReporte(ActionEvent event) {
      inicializarFechaDeCarga();
      crearReporte();
      if (subirReporte()) {
         abrirReporteSubidoExito();
         cerrarVentana(event);
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
    * Metodo para abrir la ventana FXMLReporteSubidoExito
    */
   public void abrirReporteSubidoExito() {
      try {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/"
                 + "FXMLReporteSubido.fxml"));
         FXMLReporteSubidoController controladorReporteCargado = new FXMLReporteSubidoController
        (estudianteLogeado);

         loader.setController(controladorReporteCargado);
         Parent root = loader.load();

         Scene scene = new Scene(root);
         Stage stage = new Stage();
         stage.initModality(Modality.APPLICATION_MODAL);
         stage.setScene(scene);
         stage.show();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   /**
    * Metodo para crear la instancia de reporte
    */
   public void crearReporte() {
      reporte = new ReporteVO(horasReportadas, fechaCarga, estado, archivo, fechaInicio, fechaFin);
   }

   /**
    * Metodo para subir el reporte a la base de datos
    *
    * @return Regresa true en caso de exito y false en caso de falla
    */
   public boolean subirReporte() {
      boolean creado = false;
      try {
         creado = this.reporteDAOImp.create(reporte, expediente.getIdExpediente());
      } catch (Exception e) {
         e.printStackTrace();
      }
      if (!creado) {
         FXMLAlerta alerta = new FXMLAlerta((Stage) this.botonSubirReporte.getScene().getWindow());
         alerta.alertaError("ERROR", "No se pudo subir el reporte", "Intentelo mas tarde");
      }
      return creado;
   }

   /**
    * Metodo para crear el expediente del estudiante
    *
    * @param matricula Define la matricula del estudiante
    */
   public void crearExpediente(String matricula) {
      try {
         expediente = this.expedienteDAOImp.obtenerExpedienteEstudiante(matricula);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   /**
    * Metodo para inizializar el nombre del archivo
    */
   public void cargarNombreArchivo() {
      this.labelNombreArchivo.setText(archivo.getName());
   }

   /**
    * Metodo para inizializar la fecha de carga del reporte
    */
   public void inicializarFechaDeCarga() {

      DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
      Date date = new Date();
      String fecha = dateFormat.format(date);
      fechaCarga = fecha;
   }

   /**
    * Metodo para cerrar la ventana
    *
    * @param event Lanza el evento descrito
    */
   public void cerrarVentana(ActionEvent event) {
      Node source = (Node) event.getSource();
      Stage stage = (Stage) source.getScene().getWindow();
      stage.close();
   }

}
