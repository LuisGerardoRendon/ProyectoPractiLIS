/**
 * LISTA DE CONTENIDO:
 *    > Paquete de la clase
 *    > Clases o librerias importadas
 *    > Atributos de la clase
 *    > Constructor
 *    > Metodos de la clase
 */
package vista;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 * Clase donde se implementa la clase FXMLAlerta que extiende de Alerta
 *
 * @author Luis Gerardo Rendon
 */
public class FXMLAlerta extends Alerta {

   private Alert alert;

   /**
    * Constructor de la clase que permite crear la alerta
    *
    * @param ventanaPropietaria Define la ventana desde donde se lanza la alerta
    */
   public FXMLAlerta(Stage ventanaPropietaria) {
      super(ventanaPropietaria);
   }

   /**
    * Metodo que lanza una alerta de datos
    *
    * @param titulo Define el titulo de la alerta
    * @param encabezado Define el encabezado de la alerta
    * @param contenido Define el contenido de la alerta
    */
   public void AlertaDatos(String titulo, String encabezado, String contenido) {
      alert.setTitle(titulo);
      alert.setHeaderText(encabezado);
      alert.setContentText(contenido);
      this.alert.initOwner(ventanaPropietaria);
   }

   /**
    * Metodo que lanza la alerta de tipo información
    *
    * @param titulo Define el titulo de la alerta
    * @param encabezado Define el encabezado de la alerta
    * @param contenido Define el contenido de la alerta
    */
   @Override
   public void alertaInformacion(String titulo, String encabezado, String contenido) {
      this.alert = new Alert(Alert.AlertType.INFORMATION);
      this.AlertaDatos(titulo, encabezado, contenido);
      alert.showAndWait();

   }

   /**
    * Metodo que lanza la alerta de tipo error
    *
    * @param titulo Define el titulo de la alerta
    * @param encabezado Define el encabezado de la alerta
    * @param contenido Define el contenido de la alerta
    */
   @Override
   public void alertaError(String titulo, String encabezado, String contenido) {
      this.alert = new Alert(Alert.AlertType.ERROR);
      this.AlertaDatos(titulo, encabezado, contenido);
      this.alert.showAndWait();
   }

   /**
    * Metodo que lanza la laerta de confirmación
    *
    * @param titulo Define el titulo de la alerta
    * @param encabezado Define el encabezado de la alerta
    * @param contenido Define el contenido de la alerta
    * @return Regresa true en caso de que la respuesta se verdadera y false en caso de ser falsa
    */
   @Override
   public boolean alertaConfirmacion(String titulo, String encabezado, String contenido) {
      boolean respuesta = true;
      this.alert = new Alert(Alert.AlertType.CONFIRMATION);
      this.AlertaDatos(titulo, encabezado, contenido);
      ButtonType resultado = alert.showAndWait().orElse(ButtonType.OK);
      if (ButtonType.NO.equals(resultado)) {
         respuesta = false;
      }
      return respuesta;

   }

}
