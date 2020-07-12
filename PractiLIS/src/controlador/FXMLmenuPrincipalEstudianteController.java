/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.EstudianteVO;

/**
 * FXML Controller class
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class FXMLmenuPrincipalEstudianteController implements Initializable {

   @FXML
   private Button botonSubirReporte;
   @FXML
   private Button botonConsultarProgreso;

   private EstudianteVO estudianteLoeagado;
   @FXML
   private Label labeNombre;
   @FXML
   private Label labelMatricula;

   /**
    * Initializes the controller class.
    */
   @Override
   public void initialize(URL url, ResourceBundle rb) {
       
   }

   @FXML
   private void subirReporte(ActionEvent event) {
      cerrarMenuPrincipalEstudiante();
      mostrarFXMLSubirReporte();
   }

   @FXML
   private void consultarProgreso(ActionEvent event) {
      cerrarMenuPrincipalEstudiante();
      mostrarFXMLmenuconsultarAvance();
   }

   private void mostrarFXMLmenuconsultarAvance() {
      try {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/FXMLmenuConsultarAvance.fxml"));
        
         FXMLmenuConsultarAvanceController controladorReporteCargado = new FXMLmenuConsultarAvanceController(estudianteLoeagado);
         loader.setController(controladorReporteCargado);
         Parent root =loader.load();
         Scene scene = new Scene(root);
         Stage stage = new Stage();
         stage.initModality(Modality.APPLICATION_MODAL);
         stage.setScene(scene);
         stage.show();
      } catch (IOException e) {
         System.out.println("Error al abrir la ventana");
         e.printStackTrace();
      }
   }

   public void setEstudianteLogeado(EstudianteVO estudianteLogeado) {
      this.estudianteLoeagado = estudianteLogeado;
      inicializarDatosEstudianteLogeado();
   }

   public void cerrarMenuPrincipalEstudiante() {
      Stage stage = (Stage) this.botonConsultarProgreso.getScene().getWindow();
      stage.close();
   }
   private void mostrarFXMLSubirReporte() {
      try {
         FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/vista/FXMLSubirReporte.fxml"));
         Parent ventanaPrincipal = (Parent) fXMLLoader.load();
         FXMLSubirReporteController controlador = fXMLLoader.getController();
         controlador.setEstudianteLogeado(estudianteLoeagado);
         Stage stage = new Stage();
         stage.setScene(new Scene(ventanaPrincipal));
         stage.show();
      } catch (IOException e) {
         System.out.println("Error al abrir la ventana");
         e.printStackTrace();
      }
   }
   private void inicializarDatosEstudianteLogeado(){
      this.labeNombre.setText(estudianteLoeagado.getNombre()); 
      this.labelMatricula.setText(estudianteLoeagado.getMatricula());
   }

}
