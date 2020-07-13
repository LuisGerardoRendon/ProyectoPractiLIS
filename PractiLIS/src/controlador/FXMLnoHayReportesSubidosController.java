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
import javafx.stage.Stage;
import modelo.EstudianteVO;

/**
 * FXML Controller class
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class FXMLnoHayReportesSubidosController implements Initializable {

   @FXML
   private Button botonAceptar;
   @FXML
   private Label labelNombreProyecto;
   
   

   /**
    * Initializes the controller class.
    */
   @Override
   public void initialize(URL url, ResourceBundle rb) {
      // TODO
   }   

   @FXML
   private void clicAceptar(ActionEvent event) {
      cerrarVentana();
      mostrarFXMLmenuPrincipalEstudiante();
   }
   
   public void setNombreProyecto(String nombreDelProyecto){
      this.labelNombreProyecto.setText(nombreDelProyecto);
   }
   private void cerrarVentana(){
      Stage stage = (Stage) this.botonAceptar.getScene().getWindow();
      stage.close();
   }
   private void mostrarFXMLmenuPrincipalEstudiante() {
      try {
         FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/vista/FXMLmenuPrincipalEstudiante.fxml"));
         Parent ventanaPrincipal = (Parent) fXMLLoader.load();
         FXMLmenuPrincipalEstudianteController controlador = fXMLLoader.getController();
         Stage stage = new Stage();
         stage.setScene(new Scene(ventanaPrincipal));
         stage.show();
      } catch (IOException e) {
         System.out.println("Error al abrir la ventana");
         e.printStackTrace();
      }
   }
   
}
