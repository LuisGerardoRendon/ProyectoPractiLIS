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
   

   /**
    * Initializes the controller class.
    */
   @Override
   public void initialize(URL url, ResourceBundle rb) {
      // TODO
      reporteDAO = new ReporteDAOImplements();
   }

   @FXML
   private void cancelar(ActionEvent event) {
      Node source = (Node) event.getSource();
      Stage stage = (Stage) source.getScene().getWindow();
      stage.close();
   }

   @FXML
   private void cargarReporte(ActionEvent event) {

      try {
         if (validarFormulario() && validarArchivo()) {

            horasReportadas = Integer.parseInt(campoHorasReportas.getText());
            fechaInicio = datePickerFechaInicio.getValue().toString();
            fechaFin = datePickerFechaFin.getValue().toString();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/Practicante"
                    + "/ReporteCargado_.fxml"));

            FXMLReporteCargadoController controladorReporteCargado = new FXMLReporteCargadoController(horasReportadas,
                    fechaInicio, fechaFin, archivo);
            controladorReporteCargado.setEstudianteLogeado(estudianteLogeado);
            loader.setController(controladorReporteCargado);
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.show();

            Node source = (Node) event.getSource();
            Stage stagee = (Stage) source.getScene().getWindow();
            stagee.close();
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
   }

   public boolean validarArchivo() {
      boolean archivoValido = true;

      if (archivo == null) {
         archivoValido = false;
         FXMLAlerta alerta = new FXMLAlerta((Stage) this.botonImportarArchivo.getScene()
                 .getWindow());
         alerta.alertaError("Archivo No elegido", "Realiza lo siguiente", "Debes elegir  "
                 + "un archivo");
      } else {
         if (!validarExtencionArchivo()) {
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
      System.out.println(extencion);

      if (!extencion.equals(".docx") && !extencion.equals(".pdf")) {
         extencionValida = false;
         FXMLAlerta alerta = new FXMLAlerta((Stage) this.botonImportarArchivo.getScene()
                 .getWindow());
         alerta.alertaError("Extención invalida", "Realiza lo siguiente", "Solo se permiten "
                 + "archivos doxc. y pdf.");
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
      String horas = campoHorasReportas.getText();

      if (horas.isEmpty() || datePickerFechaFin.getValue() == null || datePickerFechaFin.getValue()
              == null) {
         camposLlenos = false;
         FXMLAlerta alerta = new FXMLAlerta((Stage) this.botonCargarReporte.getScene().getWindow());
         alerta.alertaError("Campos vacios o incompletos", "Realiza lo siguiente",
                 "Llena todos los campos");
      }
      return camposLlenos;
   }

   public boolean validarFormatoDatos() {
      boolean formatoCorrecto = true;

      if (!validarHoras() || !validarFechaInicio() || !validarFechaFin()) {
         formatoCorrecto = false;
      }
      return formatoCorrecto;
   }

   public boolean validarHoras() {
      boolean horasValidas = true;
      String horasReportadas = campoHorasReportas.getText();
      if (!horasReportadas.matches("^-?[0-9]+$")) {
         horasValidas = false;
         FXMLAlerta alerta = new FXMLAlerta((Stage) this.botonCargarReporte.getScene().getWindow());
         alerta.alertaError("Formato de horas incorrecto", "Realiza lo siguiente",
                 "Ingresa un dato de tipo entero");
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
         alerta.alertaError("Formato fecha inicio invalido", "Realiza lo siguiente",
                 "Ingresa un formato de fecha valido");
      }
      return fechaInicioValida;
   }

   public boolean validarFechaFin() {
      boolean fechaFinValida = true;
      if (!datePickerFechaFin.getValue().toString().matches("^\\d{4}\\-(0[1-9]|1[012])\\-"
              + "(0[1-9]|[12][0-9]|3[01])$")) {
         fechaFinValida = false;
         FXMLAlerta alerta = new FXMLAlerta((Stage) this.datePickerFechaFin.getScene().getWindow());
         alerta.alertaError("Formato fecha fin ivalido", "Realiza lo siguiente",
                 "Ingresa un formato de fecha valido");
      }

      return fechaFinValida;
   }

   @FXML
   private void seleccionarFechaInicio(ActionEvent event) {
   }

   @FXML
   private void seleccionarFechaFin(ActionEvent event) {
   }

}
