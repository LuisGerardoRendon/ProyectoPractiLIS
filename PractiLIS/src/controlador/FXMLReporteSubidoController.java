/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

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
import javafx.stage.Stage;
import modelo.EstudianteVO;

/**
 * FXML Controller class
 *
 * @author ALDO
 */
public class FXMLReporteSubidoController implements Initializable {

   @FXML
   private Button botonAceptar;
   
   private EstudianteVO estudianteLogeado;

   /**
    * Initializes the controller class.
    */
   @Override
   public void initialize(URL url, ResourceBundle rb) {
      // TODO
   }

   FXMLReporteSubidoController(EstudianteVO estudianteLogeado) {
      this.estudianteLogeado=estudianteLogeado;
   }

   @FXML
   private void aceptar(ActionEvent event) {
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
   
   public void cerrarVentana(ActionEvent event) {
      Node source = (Node) event.getSource();
      Stage stage = (Stage) source.getScene().getWindow();
      stage.close();
   }
   

}
