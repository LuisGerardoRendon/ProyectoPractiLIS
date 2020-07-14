/*
 * LISTA DE CONTENIDO.
 *    > Paquete de la clase 
 *    > Clases o librerias utilizadas
 *    > Atributos de la clase
 *    > Constructor
 *    > Método initialize
 *    > Métodos Action Event
 *    > Otros Métodos de la clase
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
 * Clase para controlar la ventana FXMLReporteSubidoExito
 *
 * @author Aldo Colorado
 */
public class FXMLReporteSubidoController implements Initializable {

   @FXML
   private Button botonAceptar;

   private EstudianteVO estudianteLogeado;

   /**
    * Constructor de la clase que permite pasar el estudiante logeado en el sistema
    *
    * @param estudianteLogeado Estudiante logeado en el sistema
    */
   FXMLReporteSubidoController(EstudianteVO estudianteLogeado) {
      this.estudianteLogeado = estudianteLogeado;
   }

   /**
    * Inizializa el controlador de la clase
    */
   @Override
   public void initialize(URL url, ResourceBundle rb) {
   }

   /**
    * Metodo que termina el caso de uso
    *
    * @param event Lanza el evento de aceptar
    */
   @FXML
   private void aceptar(ActionEvent event) {
      cerrarVentana(event);
      abrirMenuPrincipalEstudiante();
   }

   /**
    * Metodo para abrir la ventana FXMLMenuPrincipalEstudiante
    */
   public void abrirMenuPrincipalEstudiante() {
      try {
         FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/vista/"
                 + "FXMLmenuPrincipalEstudiante.fxml"));
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

   /**
    * Metodo para cerrar la ventana
    *
    * @param event Lanza el evento de cerrar ventana
    */
   public void cerrarVentana(ActionEvent event) {
      Node source = (Node) event.getSource();
      Stage stage = (Stage) source.getScene().getWindow();
      stage.close();
   }

}
