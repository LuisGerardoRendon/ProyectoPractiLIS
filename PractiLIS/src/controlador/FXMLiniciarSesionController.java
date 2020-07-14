/**
 * LISTA DE CONTENIDO:
 * > Paquete de la clase
 * > Clases o librerias utilizadas
 * > Atributos de la clase
 * > Método initialize
 * > Métodos con Action Event
 * > Otros Métodos de la clase
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
 * FXML Controller de la vista FXMLiniciarSesion.fxml, esta clase se encarga de comunicar a la
 * vista con la base de datos, tratar las excepciones y realizar procedimientos necesarios como:
 * validaciones y cálculos.
 *
 * @author Luis Gerardo Rendon Martínez
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
    * Inicializa el controlador de la vista FXMLiniciarSesion.fxml
    */
   @Override
   public void initialize(URL url, ResourceBundle rb) {
      estudianteDAOImplements = new EstudianteDAOImplements();
      coordinadorDAOImplements = new CoordinadorDAOImplements();
      // TODO
   }
/**
 * Método encargado de identificar el tipo de usuario que quiere ingresar y recuperarlo de la base
 * de datos y si es un usuario válido permite la entrada a la funcionalidad restante. Este método
 * está ligado al clic en el botón iniciar sesión.
 * @param event clic en botón iniciar sesión
 */
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

         } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("");
            alert.setContentText("ERROR. No hay conexión con la base de datos, inténtelo más tarde");
            alert.showAndWait();

         } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR.Algo Ocurrio");
            alert.setHeaderText("");
            alert.setContentText(e.getMessage());
            alert.showAndWait();

         }
      }

   }
/**
 * Este método valida que la matricula introducida sea válida esto quiere decir que:
 * Si contiene 9 caracteres debe iniciar con la letra S o s
 * Si contiene 10 caracateres debe iniciar con la letra z o Z seguida de la S o s.
 * @param matricula matricula recuperada del campoMatricula de la ventana
 * @return  Una cadena indicando la invalidez, si la cadena es "", significa que la matricula es
 * valida
 */
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
/**
 * Este método valida que los campos de la ventana no estén vacíos
 * @return En caso de que los campos estén vacíos, regresa un string indicando que campo está vacío.
 * En el caso de que los campos no estén vacíos, regresa un string ""
 */
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
/**
 * Esté método se encarga de formatear la matricula que es pasada como parámetro
 * Primero, valida el tamaño en caracteres de la cadena, despues valida la letra con la que inicia
 * para poder determinar las modificaciones necesarias en la cadena.
 * @param matricula sin formatear
 * @return Matricula con formato S00000000
 */
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
   
/**
 * Este método se encarga de mostrar la ventana FXMLmenuPrincupalEstudiante.fxml, también es
 * responsable de pasar el estudiante logeado a la siguiente ventana.
 * @param estudianteLogeado Estudiante actualmente logeado
 */
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

   /**
    * Este método se encarga de cargar y mostrar la ventana FXMLasignarProyecto.fxml
    */
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
/**
 * Este método se encarga de cerrar la ventana FXMLInicarSesion.fxnl
 */
   public void cerrarVentanaInicio() {
      Stage stage = (Stage) this.botonIniciarSesion.getScene().getWindow();
      stage.close();
   }
}
