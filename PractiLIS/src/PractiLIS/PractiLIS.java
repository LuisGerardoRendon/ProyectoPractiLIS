/*
 * LISTA DE CONTENIDO:
 * > Paquete de la clase  
 * > Clases o librerias utilizadas
 * > Método Main
 * > Método Star
 */
package PractiLIS;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Clase encaragada de lanzar la primera pantalla del sistema (FXMLiniciarSesion.fxml)
 * @author Luis Gerardo Rendon Martinez
 */
public class PractiLIS extends Application {

   /**
    * Está función es la principal, 
    * Invoca a la funcion launch que es la que indica la ejecución del sistema
    * @param args Argumentos de la linea de comandos
    */
   public static void main(String[] args) {
        launch(args);
        
    }
   /**
    * El método start es el encargado de caragar  la ventana FXMLiniciarSesin y mostrarla.
    * @param stage Este atributo es necesario para indicar el stage principal 
    * @throws Exception Arroja cualquier excepcion que ocurra durante la ejecución, regularmente 
    * lanza excepciones cuando la ruta está equivocada o cuando no existe el archivo de la vista.
    */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/vista/FXMLiniciarSesion.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();        
    }
   
}
