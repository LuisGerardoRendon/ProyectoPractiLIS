/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * FXML Controller class
 *
 * @author ALDO
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

   ReporteDAOImplements reporteDAO;

   ExpedienteDAOImplements expedienteDAO;

   /**
    * Initializes the controller class.
    */
   @Override
   public void initialize(URL url, ResourceBundle rb) {
      // TODO
      reporteDAO = new ReporteDAOImplements();
      expedienteDAO = new ExpedienteDAOImplements();
      inicializarFechaDeCarga();
      cargarReporte();
      crearReporte();
      crearExpediente(estudianteLogeado.getMatricula());
   }

   public FXMLReporteCargadoController(int horasReportadas, String fechaInicio,
           String fechaFin, File archivo, EstudianteVO estudianteLogeado) {

      this.horasReportadas = horasReportadas;
      this.fechaInicio = fechaInicio;
      this.fechaFin = fechaFin;
      this.archivo = archivo;
      this.estudianteLogeado = estudianteLogeado;

   }

   public void setEstudianteLogeado(EstudianteVO estudianteLogeado) {
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
   private void subirReporte(ActionEvent event) {

      try {
         subirReporte();
         
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/FXMLReporteSubido.fxml"));
         FXMLReporteSubidoController controladorReporteCargado = new FXMLReporteSubidoController(estudianteLogeado);

         loader.setController(controladorReporteCargado);
         Parent root = loader.load();

         Scene scene = new Scene(root);
         Stage stage = new Stage();
         stage.initModality(Modality.APPLICATION_MODAL);
         stage.setScene(scene);
         stage.show();

         cerrarVentana(event);

      } catch (IOException e) {
         e.printStackTrace();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public void crearReporte() {
      reporte = new ReporteVO(horasReportadas, fechaCarga, estado, archivo, fechaInicio, fechaFin);
   }

   public void subirReporte() {
      boolean creado = false;
      try {
         creado = this.reporteDAO.create(reporte, expediente.getIdExpediente());
      } catch (Exception e) {
         e.printStackTrace();
      }
      if (!creado) {
         FXMLAlerta alerta = new FXMLAlerta((Stage) this.botonSubirReporte.getScene().getWindow());
         alerta.alertaError("ERROR", "No se pudo subir el reporte", "Intentelo mas tarde");
      }
   }

   public void crearExpediente(String matricula) {
      try {
         expediente = this.expedienteDAO.obtenerExpediente(matricula);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public void cargarReporte() {
      this.labelNombreArchivo.setText(archivo.getName());
   }

   public void inicializarFechaDeCarga() {

      DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
      Date date = new Date();
      String fecha = dateFormat.format(date);
      fechaCarga = fecha;
   }

   public void cerrarVentana(ActionEvent event) {
      Node source = (Node) event.getSource();
      Stage stage = (Stage) source.getScene().getWindow();
      stage.close();
   }

}
