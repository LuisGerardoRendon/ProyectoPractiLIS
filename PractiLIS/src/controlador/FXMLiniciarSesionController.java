/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.net.ConnectException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.CoordinadorDAO;
import modelo.CoordinadorDAOImplements;
import modelo.EstudianteDAOImplements;
import modelo.EstudianteVO;
import vista.FXMLAlerta;

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
   private CoordinadorDAOImplements coordinadorDAOImplements;
   @FXML
   private TextField campoMatricula;

   /**
    * Initializes the controller class.
    */
   @Override
   public void initialize(URL url, ResourceBundle rb) {
      estudianteDAOImplements = new EstudianteDAOImplements();
      coordinadorDAOImplements = new CoordinadorDAOImplements();
      // TODO
   }

   @FXML
   private void iniciarSesion(ActionEvent event) {

      String matricula = this.campoMatricula.getText();
      String contrasenia = this.campoContrasenia.getText();
      if (validarMatricula(matricula).length() > 0) {
         FXMLAlerta alerta = new FXMLAlerta((Stage) this.botonIniciarSesion.getScene().getWindow());
         alerta.alertaInformacion("Hay un error", validarMatricula(matricula), "Por favor, verifica los "
                 + "campos requeridos");
      } else {
         matricula = formatearMatricula(matricula);
         EstudianteVO estudianteLogeado = null;
         try {
            estudianteLogeado
                    = estudianteDAOImplements.recuperarEstudiante(matricula, contrasenia);
            if (estudianteLogeado != null) {
               cerrarVentanaInicio();
               mostrarFXMLmenuPrincipalEstudiante(estudianteLogeado);

            } else if (coordinadorDAOImplements.login(matricula, contrasenia)) {
               cerrarVentanaInicio();
               mostrarFXMLasignarProyecto();

            } else {
               FXMLAlerta alerta = new FXMLAlerta((Stage) this.botonIniciarSesion.getScene().getWindow());
               alerta.alertaInformacion("USUARIO NO ENCONTRADO",
                       "Usuario no encontrado en la base de datos", "Por favor, Ingresa los "
                       + "campos requeridos");
            }

         }  catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("");
            alert.setContentText("ERROR. No hay conexión con la base de datos, inténtelo más tarde");
            alert.showAndWait();

         }  catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR.Algo Orurrio");
            alert.setHeaderText("");
            alert.setContentText(e.getMessage());
            alert.showAndWait();

         }
      }

   }

   private String validarMatricula(String matricula) {
      String mensaje = "";

      if (hayCamposVacios().length() == 0) {
         if (matricula.length() == 9) {
            if (matricula.charAt(0) != 'S' && matricula.charAt(0) != 's') {
               mensaje = "Matricula no válida";
               System.out.println(matricula.charAt(0) + "!= S o s");
               System.out.println("No inicia con S y tiene mas de 9 caracteres");
            }
         } else if (matricula.length() == 10) {
            if (matricula.charAt(0) != 'Z' && matricula.charAt(0) != 'z') {
               mensaje = "Matrícula no válida";
               System.out.println("Tiene 10 caracteres, pero no comiensa con Z");
            } else {
               if (matricula.charAt(1) != 'S' && matricula.charAt(1) != 's') {
                  mensaje = "Matricula no válida";
                  System.out.println("Comienza con Z pero la siguiente letre no es una S");
               }
            }

         } else {
            mensaje = "Matricula no válida";
         }

      } else {
         FXMLAlerta alerta = new FXMLAlerta((Stage) this.botonIniciarSesion.getScene().getWindow());
         alerta.alertaInformacion("Campos vacíos", hayCamposVacios(), "Por favor, Ingresa los "
                 + "campos requeridos");
      }

      return mensaje;
   }

   private String hayCamposVacios() {

      String mensajeCamposVacios = "";
      if (campoMatricula.getText().length() == 0) {
         mensajeCamposVacios = "El campo de la matricula está vacío";
      }
      if (campoContrasenia.getText().length() == 0) {
         mensajeCamposVacios += "\nEl campo de la contraseña está vacío";
      }
      return mensajeCamposVacios;
   }

   public String formatearMatricula(String matricula) {
      String matriculaFormateada = "S";
      if (matricula.length() == 9) {
         if (matricula.charAt(0) != 'S') {
            for (int i = 1; i < matricula.length(); i++) {
               matriculaFormateada += matricula.charAt(i);
            }
         } else {
            matriculaFormateada = matricula;
         }
      } else if (matricula.length() == 10) {
         for (int i = 2; i < matricula.length(); i++) {
            matriculaFormateada += matricula.charAt(i);
         }
      }
      return matriculaFormateada;
   }

   private void mostrarFXMLmenuPrincipalEstudiante(EstudianteVO estudianteLogeado) {
      try {
         FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/vista/FXMLmenuPrincipalEstudiante.fxml"));
         Parent ventanaPrincipal = (Parent) fXMLLoader.load();
         FXMLmenuPrincipalEstudianteController controlador = fXMLLoader.getController();
         controlador.setEstudianteLogeado(estudianteLogeado);
         Stage stage = new Stage();
         stage.setScene(new Scene(ventanaPrincipal));
         stage.show();
      } catch (IOException e) {
         System.out.println("Error al abrir la ventana");
         e.printStackTrace();
      }
   }

   private void mostrarFXMLasignarProyecto() {
      try {
         FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/vista/FXMLasignarProyecto.fxml"));
         Parent ventanaPrincipal = (Parent) fXMLLoader.load();
         Stage stage = new Stage();
         stage.setScene(new Scene(ventanaPrincipal));
         stage.show();
      } catch (IOException e) {
         System.out.println("Error al abrir la ventana");
         e.printStackTrace();
      }
   }

   public void cerrarVentanaInicio() {
      Stage stage = (Stage) this.botonIniciarSesion.getScene().getWindow();
      stage.close();
   }
}
