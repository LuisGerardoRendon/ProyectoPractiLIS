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

import java.awt.Desktop;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.EstudianteVO;
import modelo.ReporteDAOImplements;
import vista.Alerta;
import vista.FXMLAlerta;

/**
 * Clase que contiene los metodos que controlan a la ventana FXMLSubirNuevoReporte
 *
 * @author ALDO
 */
public class FXMLSubirNuevoReporteController implements Initializable {

   private TextField campoHorasReportas;
   @FXML
   private Button botonCancelar;
   @FXML
   private Button botonCargarReporte;
   @FXML
   private Button botonImportarArchivo;
   @FXML
   private DatePicker datePickerFechaInicio;
   @FXML
   private Label labelNombreArchivo;
   @FXML
   private DatePicker datePickerFechaFin;
   @FXML
   private TextField campoHorasReportadas;

   private EstudianteVO estudianteLogeado;

   private Desktop desktop = Desktop.getDesktop();

   ReporteDAOImplements reporteDAO;

   public int horasReportadas = 0;

   public String fechaInicio;

   public String fechaFin;

   public File archivo;

   Alerta alerta;

   /**
    * Metodo constructor que permite el paso de parametros desde la ventan FXMLSubirReporte
    *
    * @param estudianteLogeado
    */
   FXMLSubirNuevoReporteController(EstudianteVO estudianteLogeado) {
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

      reporteDAO = new ReporteDAOImplements();
   }

   /**
    * Metodo que permite lanzar el elemento de selección de fecha de la ventana
    *
    * @param event Lanza el evento de la ventana
    */
   @FXML
   private void seleccionarFechaInicio(ActionEvent event) {
   }

   /**
    * Metodo que permite lanzar el elemento de la sección de fecha de la ventana
    *
    * @param event Lanza el evento de fecha de la ventana
    */
   @FXML
   private void seleccionarFechaFin(ActionEvent event) {
   }

   /**
    * Metodo para terminar el caso de uso y regresar a la ventana FXMLMenuPrincipal
    *
    * @param event Lanza el evento descrito
    */
   @FXML
   private void cancelar(ActionEvent event) {
      cerrarVentana(event);
      abrirMenuPrincipalEstudiante();
   }

   /**
    * Metodo que permite cargar el reporte de los campos que se llenaron
    *
    * @param event Lanza el evento descrito
    */
   @FXML
   private void cargarReporte(ActionEvent event) {

      if (validarFormulario() && validarSeleccionDeArchivo()) {
         
         abrirReporteCargado();
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
    * Metodo para abrir la ventana FXMLReporteCargado
    */
   public void abrirReporteCargado() {

      try {
         horasReportadas = Integer.parseInt(campoHorasReportadas.getText());
         fechaInicio = datePickerFechaInicio.getValue().toString();
         fechaFin = datePickerFechaFin.getValue().toString();

         FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/"
                 + "FXMLReporteCargado.fxml"));
         FXMLReporteCargadoController controladorReporteCargado = new FXMLReporteCargadoController
         (horasReportadas, fechaInicio, fechaFin, archivo, estudianteLogeado);

         loader.setController(controladorReporteCargado);
         Parent root = loader.load();

         Scene scene = new Scene(root);
         Stage stage = new Stage();
         stage.initModality(Modality.APPLICATION_MODAL);
         stage.setScene(scene);
         stage.show();

      } catch (IOException e) {

      }

   }

   /**
    * Metodo que permite abrir el explorador local de archivos para seleccionar el Reporte
    *
    * @param event Permite lanzar el evento antes descrito
    */
   @FXML
   private void importarArchivo(ActionEvent event) {
      Stage stage = (Stage) this.botonImportarArchivo.getScene().getWindow();
      FileChooser fileChooser = new FileChooser();
      fileChooser.setTitle("Open Resource File");
      archivo = fileChooser.showOpenDialog(stage);
      cargarReporte();
   }

   /**
    * Metodo que permite inizializar el nombre del archivo una vez que ha sido cargado
    */
   public void cargarReporte() {
      this.labelNombreArchivo.setText(archivo.getName());
   }

   /**
    * Metodo que permite validar el tamanio del archivo seleccionado
    *
    * @return Regresa true si el archivo es valido y false en caso de que no lo sea
    */
   public boolean validarTamanioArchivo() {
      boolean archivoValido = true;

      long tamanioArchivoEnBytes = archivo.length();
      long tamanioArchivoEnKiloBytes = tamanioArchivoEnBytes / 1024;
      long tamanioArchivoEnMegas = tamanioArchivoEnKiloBytes / 1024;

      if (tamanioArchivoEnMegas > 2.5) {
         FXMLAlerta alerta = new FXMLAlerta((Stage) this.botonImportarArchivo.getScene()
                 .getWindow());
         alerta.alertaError("ERROR EN ARCHIVO", "El archivo sobrepasa el tamanio maximo",
                 "Elige un archivo de tamanio menor");
         archivoValido = false;
      }

      return archivoValido;
   }

   /**
    * Metodo que permite validar que haya un archivo seleccionado
    *
    * @return Regresa true si el archivo fue seleccionado y false en caso de que no
    */
   public boolean validarSeleccionDeArchivo() {
      boolean archivoValido = true;

      if (archivo == null) {
         archivoValido = false;
         FXMLAlerta alerta = new FXMLAlerta((Stage) this.botonImportarArchivo.getScene()
                 .getWindow());
         alerta.alertaError("ARCHIVO NO ELEGIDO", "No has seleccionado el archivo del reporte",
                 "Debes elegir un archivo");
      } else {
         if (!validarExtencionArchivo()) {
            archivoValido = false;
         } else if (!validarTamanioArchivo()) {
            archivoValido = false;
         }
      }

      return archivoValido;
   }

   /**
    * Metodo que permite validar la extención del archivo
    *
    * @return Regresa true si es valido y false en caso de que no sea valido
    */
   public boolean validarExtencionArchivo() {
      boolean extencionValida = true;

      String extencion = "";
      String nombre = archivo.getName();

      int lastIndexOf = nombre.lastIndexOf(".");
      if (lastIndexOf == -1) {
         extencion = "";
      }
      extencion = nombre.substring(lastIndexOf);

      if (!extencion.equals(".docx") || !extencion.equals(".pdf")) {
         extencionValida = false;
         FXMLAlerta alerta = new FXMLAlerta((Stage) this.botonImportarArchivo.getScene()
                 .getWindow());
         alerta.alertaError("ERROR EN EL ARCHIVO", "No se permita archivos con extencion" + extencion,
                 "Solo se permiten archivos doxc.");
      }

      return extencionValida;

   }

   /**
    * Metodo para validar el formulario
    *
    * @return Regresa true si el formulario es valido y false si no es valido
    */
   public boolean validarFormulario() {
      boolean formularioValido = true;
      boolean camposLlenos = validarCamposLlenos();
      boolean formatoDatos = true;

      if (camposLlenos) {
         formatoDatos = validarFormatoDatos();
      }

      if (!camposLlenos || !formatoDatos) {
         formularioValido = false;
      }

      return formularioValido;
   }

   /**
    * Metodo que valida que el usuario haya llenado todos los campos de texto requeridos
    *
    * @return Regresa tue si los todos los campos estan llenos y false si no lo estan
    */
   public boolean validarCamposLlenos() {
      boolean camposLlenos = true;

      if (campoHorasReportadas.getText().trim().equals("") || datePickerFechaFin.getValue() == null
              || datePickerFechaFin.getValue() == null) {
         camposLlenos = false;
         FXMLAlerta alerta = new FXMLAlerta((Stage) this.botonCargarReporte.getScene().getWindow());
         alerta.alertaError("CAMPOS INCORRECTOS", "Tienes campos vacios",
                 "Por favor completa la informacion requerida");
      }
      return camposLlenos;
   }

   /**
    * Metodo que valida que el formato de los datos ingresados sea correcto
    *
    * @return Regresa true si el formato de los datos es correcto
    */
   public boolean validarFormatoDatos() {
      boolean formatoCorrecto = true;

      if (!validarHoras() || !validarFechaInicio() || !validarFechaFin() || !validarFechas()) {
         formatoCorrecto = false;
      }
      return formatoCorrecto;
   }

   /**
    * Metodo que valida que el formato de horas sea correcto
    *
    * @return Regresa true si el formato es valido y false si no lo es
    */
   public boolean validarHoras() {
      boolean horasValidas = true;
      String horasReportadas = campoHorasReportadas.getText();
      if (!horasReportadas.matches("^-?[0-9]+$")) {
         horasValidas = false;
         FXMLAlerta alerta = new FXMLAlerta((Stage) this.botonCargarReporte.getScene().getWindow());
         alerta.alertaError("ERROR:","El campo de texto horas contiene informacion invalida",
                 "Por favor revisa y corrige");
      }
      return horasValidas;
   }

   /**
    * Metodo que valida el formato de la fecha de inicio
    *
    * @return Regresa true si el formato es correcto y false si no lo es
    */
   public boolean validarFechaInicio() {
      boolean fechaInicioValida = true;
      if (!datePickerFechaInicio.getValue().toString().matches("^\\d{4}\\-(0[1-9]|1[012])\\"
              + "-(0[1-9]|[12][0-9]|3[01])$")) {
         fechaInicioValida = false;
         FXMLAlerta alerta = new FXMLAlerta((Stage) this.datePickerFechaInicio.getScene()
                 .getWindow());
         alerta.alertaError("ERROR EN FECHA INICIO", "El formato de fecha inicio es incorrecto",
                 "Por favor usa la herramienta de fecha para elegir un formato correcto");
      }
      System.out.println(datePickerFechaInicio.getValue().toString());
      return fechaInicioValida;
   }

   /**
    * Metodo que valida el formato de la fecha fin
    *
    * @return Regresa true si el formato es correcto y false si no lo es
    */
   public boolean validarFechaFin() {
      boolean fechaFinValida = true;
      if (!datePickerFechaFin.getValue().toString().matches("^\\d{4}\\-(0[1-9]|1[012])\\-"
              + "(0[1-9]|[12][0-9]|3[01])$")) {
         fechaFinValida = false;
         FXMLAlerta alerta = new FXMLAlerta((Stage) this.datePickerFechaFin.getScene().getWindow());
         alerta.alertaError("ERROR FECHA FIN", "Formato de la fecha invalido",
                 "Por favor usa la herramienta de fecha para elegir un formato correcto");
      }

      return fechaFinValida;
   }

   /**
    * Metodo que valida que la fecha final no sea menor a la fecha de inicio
    *
    * @return Regresa true si las fechas son correctas
    */
   public boolean validarFechas() {
      boolean fechasValidas = true;

      try {
         SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
         Date fechaInicio = date.parse(datePickerFechaInicio.getValue().toString());
         Date fechaFin = date.parse(datePickerFechaFin.getValue().toString());

         if (!(fechaFin.compareTo(fechaInicio) >= 0)) {
            FXMLAlerta alerta = new FXMLAlerta((Stage) this.datePickerFechaFin.getScene().getWindow());
            alerta.alertaError("ERROR: FECHA INICIO ES MAYOR A LA FECHA FIN", "La fecha inicio"
                    + " debe ser menor a la fecha fin",
                    "Por favor ingresa las fechas correctas");
            fechasValidas = false;
            System.out.println("Entro");
         }
      } catch (Exception e) {
         e.getMessage();
         e.printStackTrace();
      }

      return fechasValidas;
   }

   /**
    * Metodo que cierra la ventana
    *
    * @param event Lanza el evento antes descrito
    */
   public void cerrarVentana(ActionEvent event) {
      Node source = (Node) event.getSource();
      Stage stage = (Stage) source.getScene().getWindow();
      stage.close();
   }
   
}
