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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
         FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/vista/FXMLmenuConsultarAvance.fxml"));
         Parent ventanaPrincipal = (Parent) fXMLLoader.load();
         FXMLmenuConsultarAvanceController controlador = fXMLLoader.getController();
         System.out.println("ESTUDIANTE LOGEADO ES " + estudianteLoeagado.getNombre());
         controlador.setEstudianteUsuario(estudianteLoeagado);
         Stage stage = new Stage();
         stage.setScene(new Scene(ventanaPrincipal));
         stage.show();
      } catch (IOException e) {
         System.out.println("Error al abrir la ventana");
      }
   }

   public void setEstudianteLogeado(EstudianteVO estudianteLogeado) {
      this.estudianteLoeagado = estudianteLogeado;
   }

   public void cerrarMenuPrincipalEstudiante() {
      Stage stage = (Stage) this.botonConsultarProgreso.getScene().getWindow();
      stage.close();
   }

   private void mostrarFXMLSubirReporte() {
      try {

         FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/FXMLSubirReporte.fxml"));

         FXMLSubirReporteController controladorSubirReporte = new FXMLSubirReporteController(estudianteLoeagado);
         loader.setController(controladorSubirReporte);
         Parent root = loader.load();

         Scene scene = new Scene(root);
         Stage stage = new Stage();
         stage.initModality(Modality.APPLICATION_MODAL);
         stage.setScene(scene);
         stage.show();

      } catch (IOException e) {
         System.out.println("Error al abrir la ventana");
         e.getMessage();
         e.printStackTrace();

      }
   }

}
