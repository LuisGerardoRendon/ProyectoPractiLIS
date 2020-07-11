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
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import modelo.EstudianteDAOImplements;
import modelo.EstudianteVO;

/**
 * FXML Controller class
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class FXMLiniciarSesionController implements Initializable {

   @FXML
   private Button botonIniciarSesion;

   @FXML
   private PasswordField campoContrasenia;

   private EstudianteDAOImplements estudianteDAOImplements;
   @FXML
   private TextField campoMatricula;

   /**
    * Initializes the controller class.
    */
   @Override
   public void initialize(URL url, ResourceBundle rb) {
      estudianteDAOImplements = new EstudianteDAOImplements();
      // TODO
   }

   @FXML
   private void iniciarSesion(ActionEvent event) {
      String matricula = this.campoMatricula.getText();
      String contrasenia = this.campoContrasenia.getText();
      EstudianteVO estudianteLogeado = null;
      try {
         estudianteLogeado
                 = estudianteDAOImplements.recuperarEstudiante(matricula, contrasenia);

      } catch (Exception e) {
         e.printStackTrace();
      }
      if (estudianteLogeado != null) {
         System.out.println("Entró al sistema");
      }
   }

   

   private boolean esUsuarioValido() {
      String errorMensaje = "";
      if (this.campoMatricula.getText() == null || this.campoMatricula.getText().length() == 0) {
         errorMensaje = " Ingresa un nombre!";
      }
      if (this.campoContrasenia.getText().length() == 0) {
         errorMensaje += "\n Ingresa una contraseña!";
      }

      if (this.campoMatricula.getText().contains(" ")) {
         errorMensaje += "\n Ingresa una matrícula válida, sin espacios.";
      }
      if (errorMensaje.length() == 0) {
         return true;
      } else {
         Alert alert = new Alert(Alert.AlertType.ERROR);
         alert.setTitle("Inicio de sesión inválido");
         alert.setHeaderText("Realizar lo siguiente");
         alert.setContentText(errorMensaje);
         alert.showAndWait();
         return false;
      }
   }
   
   private String validarMatricula(){
      String mensajeError = "";
      final int CANTIDAD_CARACTERES_MATRICULA = 9;
      
      
      String matricula = this.campoMatricula.getText().toUpperCase();
      
      if(matricula.charAt(0)=='Z'){
         if(matricula.length()-1!=CANTIDAD_CARACTERES_MATRICULA){
            mensajeError = "Matricula no valida";
         }
      }
      for(int i = 0; i<matricula.length(); i++){
         
      }
      
      return mensajeError;
   }

}
