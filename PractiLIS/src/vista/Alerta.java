/**
 * LISTA DE CONTENIDO:
 *    > Paquete de la clase
 *    > Clases y librerias importadas
 *    > Atributos de la clase
 *    > Constructor
 *    > Declaración de metodos de la clase
 */
package vista;

import javafx.stage.Stage;

/**
 * Clase abstracta donde se definen los metodos de Alerta
 *
 * @author Luis Gerardo Rendon
 */
public abstract class Alerta {

   protected Stage ventanaPropietaria;

   /**
    * Constructor de el objeto Alerta
    * @param ventanaPropietaria Define la ventana de donde se carga la alerta
    */
   public Alerta(Stage ventanaPropietaria) {
      this.ventanaPropietaria = ventanaPropietaria;
   }

   public abstract void alertaInformacion(String titulo, String encabezado, String contenido);

   public abstract void alertaError(String titulo, String encabezado, String contenido);

   public abstract boolean alertaConfirmacion(String titulo, String encabezado, String contenido);

}
