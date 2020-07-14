/*
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
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.EstudianteVO;
import vista.FXMLAlerta;

/**
 * Clase Controlador de la ventana FXMLmenuPrincipalEstudiante.fxml
 *
 * @author Luis Gerardo Rendon Martinez
 */
public class FXMLmenuPrincipalEstudianteController implements Initializable {

   @FXML
   private Button botonSubirReporte;
   @FXML
   private Button botonConsultarProgreso;

   private EstudianteVO estudianteLoeagado;

   /**
    * Método initialize es el primer método que se ejecuta al mostrar la ventana, es el encargado de
    * instanciar los atributos de la ventana y cargar la información necesaria.
    */
   @Override
   public void initialize(URL url, ResourceBundle rb) {

   }

   /**
    * Método ligado al ActionEvent de dar clic en el botón "Subir Reporte", cierra la ventana acutal
    * y muestra la ventena FXMLSubirReporte.fxml
    *
    * @param event Dar clic al boton "Subir Reporte"
    */
   @FXML
   private void subirReporte(ActionEvent event) {
      if (estudianteLoeagado.getStatus().equals("Asignado")) {
         cerrarMenuPrincipalEstudiante();
         mostrarFXMLSubirReporte();
      } else {
         FXMLAlerta alerta = new FXMLAlerta((Stage) this.botonConsultarProgreso.getScene().getWindow());
         alerta.alertaInformacion("No tienes ningun proyecto asignado",
                 "No se ha encontrado ningun proyecto asignado", "Espera a que te asignen uno");
      }

   }

   /**
    * Método ligado al ActionEvente de darclic en el botón "Consultar Progreso", cierra la ventana
    * actual y muestra a ventana FXMLmenuConsultarAcance.
    *
    * @param event Dar clic en botón "Consultar Progreso"
    */
   @FXML
   private void consultarProgreso(ActionEvent event) {
      if (estudianteLoeagado.getStatus().equals("Asignado")) {
         cerrarMenuPrincipalEstudiante();
         mostrarFXMLmenuconsultarAvance();
      } else {
         FXMLAlerta alerta = new FXMLAlerta((Stage) this.botonConsultarProgreso.getScene().getWindow());
         alerta.alertaInformacion("No tienes ningun proyecto asignado",
                 "No se ha encontrado ningun proyecto asignado", "Espera a que te asignen uno");
      }

   }

   /**
    * muestra la ventana FXMLmenuconsultarAvance.fxml y le pasa el Estudiante Logeado previammente
    *
    */
   private void mostrarFXMLmenuconsultarAvance() {
      try {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/FXMLmenuConsultarAvance.fxml"));

         FXMLmenuConsultarAvanceController controladorReporteCargado = new FXMLmenuConsultarAvanceController(estudianteLoeagado);
         loader.setController(controladorReporteCargado);
         Parent root = loader.load();
         Scene scene = new Scene(root);
         Stage stage = new Stage();
         stage.initModality(Modality.APPLICATION_MODAL);
         stage.setScene(scene);
         stage.show();
      } catch (IOException e) {
         System.out.println("Error al abrir la ventana");
         e.printStackTrace();
      }
   }

   /**
    * Este método Asigna el estudiante pasado como parametró al atributo EstudianteLogeado de la
    * ventana, sirve para arrastrar al Estudiante logeado hacia las ventanas posteriores.
    *
    * @param estudianteLogeado Estudiante logeado previamente
    */
   public void setEstudianteLogeado(EstudianteVO estudianteLogeado) {
      this.estudianteLoeagado = estudianteLogeado;
   }

   /**
    * Este método se encarga de cerrar la ventana actual.
    */
   public void cerrarMenuPrincipalEstudiante() {
      Stage stage = (Stage) this.botonConsultarProgreso.getScene().getWindow();
      stage.close();
   }

   /**
    * Este método se encarga de mostrar la ventana FXMLSubirReporte.fxml y arrastra el estudiante
    * logeado previamente en la pantalla de login hacía la pantalla FXMLSubirReporte.fxml.
    */
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
