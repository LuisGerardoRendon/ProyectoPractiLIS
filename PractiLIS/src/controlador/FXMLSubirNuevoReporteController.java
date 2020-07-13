/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * FXML Controller class
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

   private EstudianteVO estudianteLogeado;

   private Desktop desktop = Desktop.getDesktop();

   ReporteDAOImplements reporteDAO;

   public int horasReportadas = 0;

   public String fechaInicio;

   public String fechaFin;

   public File archivo;

   Alerta alerta;
   @FXML
   private TextField campoHorasReportadas;

   /**
    * Initializes the controller class.
    */
   @Override
   public void initialize(URL url, ResourceBundle rb) {
      // TODO

      reporteDAO = new ReporteDAOImplements();
   }

   FXMLSubirNuevoReporteController(EstudianteVO estudianteLogeado) {
      this.estudianteLogeado = estudianteLogeado;
   }

   @FXML
   private void cancelar(ActionEvent event) {
      cerrarVentana(event);
      try {
         FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/vista/FXMLmenuPrincipalEstudiante.fxml"));
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

   @FXML
   private void cargarReporte(ActionEvent event) {

      try {
         if (validarFormulario() && validarArchivo()) {

            horasReportadas = Integer.parseInt(campoHorasReportadas.getText());
            fechaInicio = datePickerFechaInicio.getValue().toString();
            fechaFin = datePickerFechaFin.getValue().toString();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/FXMLReporteCargado.fxml"));
            FXMLReporteCargadoController controladorReporteCargado = new FXMLReporteCargadoController(horasReportadas,
                    fechaInicio, fechaFin, archivo, estudianteLogeado);

            loader.setController(controladorReporteCargado);
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.show();

            cerrarVentana(event);
         }

      } catch (IOException e) {

         System.out.println(e.getMessage());
         e.printStackTrace();

      }
   }

   @FXML
   private void importarArchivo(ActionEvent event) {
      Stage stage = (Stage) this.botonImportarArchivo.getScene().getWindow();
      FileChooser fileChooser = new FileChooser();
      fileChooser.setTitle("Open Resource File");
      archivo = fileChooser.showOpenDialog(stage);
      cargarReporte();
   }
   
   public void cargarReporte() {
      this.labelNombreArchivo.setText(archivo.getName());
   }

   public boolean validarTamanioArchivo() {
      boolean archivoValido = true;
      
      long tamanioArchivoEnBytes = archivo.length();
      long tamanioArchivoEnKiloBytes = tamanioArchivoEnBytes / 1024;
      long tamanioArchivoEnMegas = tamanioArchivoEnKiloBytes / 1024;

      if (tamanioArchivoEnMegas > 12) {
         FXMLAlerta alerta = new FXMLAlerta((Stage) this.botonImportarArchivo.getScene()
                 .getWindow());
         alerta.alertaError("ERROR EN ARCHIVO", "El archivo sobrepasa el tamanio maximo",
                  "Elige un archivo de tamanio menor 12MB");
         archivoValido=false;
      }
      
      return archivoValido;
   }

   public boolean validarArchivo() {
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
         }else if(!validarTamanioArchivo()){
            archivoValido = false;
         }
      }

      return archivoValido;
   }

   public void setEstudianteLogeado(EstudianteVO estudianteLogeado) {
      this.estudianteLogeado = estudianteLogeado;
   }

   public boolean validarExtencionArchivo() {
      boolean extencionValida = true;

      String extencion = "";
      String nombre = archivo.getName();

      int lastIndexOf = nombre.lastIndexOf(".");
      if (lastIndexOf == -1) {
         extencion = "";
      }
      extencion = nombre.substring(lastIndexOf);

      if (!extencion.equals(".docx") && !extencion.equals(".pdf")) {
         extencionValida = false;
         FXMLAlerta alerta = new FXMLAlerta((Stage) this.botonImportarArchivo.getScene()
                 .getWindow());
         alerta.alertaError("ERROR EN EL ARCHIVO", "No se permita archivos con extencion" + extencion,
                  "Solo se permiten archivos doxc. y pdf.");
      }

      return extencionValida;

   }

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

   public boolean validarCamposLlenos() {
      boolean camposLlenos = true;

      if (campoHorasReportadas.getText().trim().equals("") || datePickerFechaFin.getValue() == null
              || datePickerFechaFin.getValue()
              == null) {
         camposLlenos = false;
         FXMLAlerta alerta = new FXMLAlerta((Stage) this.botonCargarReporte.getScene().getWindow());
         alerta.alertaError("CAMPOS INCORRECTOS", "Tienes campos incompletos o incorrectos",
                 "Por favor llena todos los campos");
      }
      return camposLlenos;
   }

   public boolean validarFormatoDatos() {
      boolean formatoCorrecto = true;

      if (!validarHoras() || !validarFechaInicio() || !validarFechaFin() || !validarFechas()) {
         formatoCorrecto = false;
      }
      return formatoCorrecto;
   }

   public boolean validarHoras() {
      boolean horasValidas = true;
      String horasReportadas = campoHorasReportadas.getText();
      if (!horasReportadas.matches("^-?[0-9]+$")) {
         horasValidas = false;
         FXMLAlerta alerta = new FXMLAlerta((Stage) this.botonCargarReporte.getScene().getWindow());
         alerta.alertaError("ERROR DE FORMATO", "Formato de horas invalido",
                 "Por favor ingresa un numero en el campo de horas");
      }
      return horasValidas;
   }

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
  
   public boolean validarFechas() {
      boolean fechasValidas = true;

      try {
         SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
         Date fechaInicio = date.parse(datePickerFechaInicio.getValue().toString());
         Date fechaFin = date.parse(datePickerFechaFin.getValue().toString());

         if (!(fechaFin.compareTo(fechaInicio) >=0)) {
            FXMLAlerta alerta = new FXMLAlerta((Stage) this.datePickerFechaFin.getScene().getWindow());
            alerta.alertaError("ERROR: FECHA INICIO ES MAYOR A LA FECHA FIN", "La fecha inicio"
                    + " debe ser menor a la fecha fin",
                    "Por favor ingresa las fechas correctas");
            fechasValidas=false;
            System.out.println("Entro");
         }
      } catch (Exception e) {
         e.getMessage();
         e.printStackTrace();
      }

      return fechasValidas;
   }
   
   
   public void cerrarVentana(ActionEvent event) {
      Node source = (Node) event.getSource();
      Stage stage = (Stage) source.getScene().getWindow();
      stage.close();
   }

   @FXML
   private void seleccionarFechaInicio(ActionEvent event) {
   }

   @FXML
   private void seleccionarFechaFin(ActionEvent event) {
   }

}
