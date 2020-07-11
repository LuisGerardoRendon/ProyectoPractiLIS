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
import modelo.ReporteDAOImplements;
import modelo.ReporteVO;

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
   private Label labelSetNombreArchivo;
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

   ReporteDAOImplements reporte_DAO;

   /**
    * Initializes the controller class.
    */
   @Override
   public void initialize(URL url, ResourceBundle rb) {
      // TODO
      reporte_DAO = new ReporteDAOImplements();
      inicializarFechaDeCarga();
      cargarReporte();
      crearReporte();
   }

   public FXMLReporteCargadoController(int horasReportadas, String fechaInicio,
           String fechaFin, File archivo) {

      this.horasReportadas = horasReportadas;
      this.fechaInicio = fechaInicio;
      this.fechaFin = fechaFin;
      this.archivo = archivo;

   }
   
   public void setEstudiante(EstudianteVO estudianteLogeado){
      this.estudianteLogeado=estudianteLogeado;
   }

   @FXML
   private void cancelar(ActionEvent event) {
      Node source = (Node) event.getSource();
      Stage stage = (Stage) source.getScene().getWindow();
      stage.close();
   }

   @FXML

   private void subirReporte(ActionEvent event) {

      try {
         
         boolean creado = this.reporte_DAO.create(reporte);
       
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/Practicante/ReporteSubidoExito.fxml"));
         FXMLReporteSubidoController controladorReporteExito = new FXMLReporteSubidoController();
         loader.setController(controladorReporteExito);
         Parent root = loader.load();

         Scene scene = new Scene(root);
         Stage stage = new Stage();
         stage.initModality(Modality.APPLICATION_MODAL);
         stage.setScene(scene);
         stage.show();

         Node source = (Node) event.getSource();
         Stage stagee = (Stage) source.getScene().getWindow();
         stagee.close();

      } catch (IOException e) {
         e.printStackTrace();
      } catch (Exception e){
         e.printStackTrace();
      }
   }

   public void crearReporte() {
      reporte = new ReporteVO(horasReportadas, fechaCarga, estado, archivo, fechaInicio, fechaFin);
   }

   public void cargarReporte() {
      System.out.println("");
      this.labelSetNombreArchivo.setText(archivo.getName());
   }

   public void inicializarFechaDeCarga() {

      DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
      Date date = new Date();
      String fecha = dateFormat.format(date);
      fechaCarga = fecha;

   }

}
