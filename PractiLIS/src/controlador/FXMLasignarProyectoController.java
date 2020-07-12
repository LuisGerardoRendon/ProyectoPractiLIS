/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import modelo.EstudianteDAOImplements;
import modelo.EstudianteVO;
import modelo.ProyectoDAOImplements;
import modelo.ProyectoVO;
import vista.FXMLAlerta;

/**
 * FXML Controller class
 *
 * @author Daniel Pale Parra
 */
public class FXMLasignarProyectoController implements Initializable {

   @FXML
   private TableView<EstudianteVO> tablaEstudiantes;
   @FXML
   private TableColumn<EstudianteVO, String> columnaNombreEstudiantes;
   @FXML
   private TableColumn<EstudianteVO, String> columnaMatricula;
   @FXML
   private Button botonMostrarSolicitudes;
   @FXML
   private Button botonAsignar;
   @FXML
   private TableView<ProyectoVO> tablaSolicitudes;
   @FXML
   private TableColumn<ProyectoVO, String> columnaNombreProyectoSolicitado;
   @FXML
   private TableColumn<ProyectoVO, Integer> columnaCupoProyectoSolicitado;
   @FXML
   private TableView<ProyectoVO> tablaProyectos;
   @FXML
   private TableColumn<ProyectoVO, String> columnaNombreProyecto;
   @FXML
   private TableColumn<ProyectoVO, Integer> columnaCupoProyecto;

   private ProyectoDAOImplements proyectoDAOImp;
   private EstudianteDAOImplements estudianteDAOImp;

   private ObservableList<ProyectoVO> proyectos;
   private ObservableList<ProyectoVO> proyectosSolicitados;
   private ObservableList<EstudianteVO> estudiantes;

   /**
    * Initializes the controller class.
    */
   @Override
   public void initialize(URL url, ResourceBundle rb) {
      //LLena tabla de proyecto
      proyectos = FXCollections.observableArrayList();
      obtenerProyectos();

      this.columnaNombreProyecto.setCellValueFactory(new PropertyValueFactory("nombre"));
      this.columnaCupoProyecto.setCellValueFactory(new PropertyValueFactory("capacidadEstudiantes"));

      this.tablaProyectos.setItems(proyectos);

      //Llena tabla de estudiantes
      estudiantes = FXCollections.observableArrayList();
      obtenerEstudiantes();

      this.columnaNombreEstudiantes.setCellValueFactory(new PropertyValueFactory("nombre"));
      this.columnaMatricula.setCellValueFactory(new PropertyValueFactory("matricula"));

      this.tablaEstudiantes.setItems(estudiantes);
   }

   @FXML
   private void seleccionarEstudiante(MouseEvent event) {
   }

   @FXML
   private void mostrarSolicitudes(ActionEvent event) {
      EstudianteVO e = this.tablaEstudiantes.getSelectionModel().getSelectedItem();

      if (e != null) {
         //proyectosSolicitados = e.obtenerProyectosSolicitados();

         this.columnaNombreProyectoSolicitado.setCellValueFactory(new PropertyValueFactory("nombre"));
         this.columnaCupoProyectoSolicitado.setCellValueFactory(new PropertyValueFactory("capacidadEstudiantes"));

         this.tablaSolicitudes.setItems(proyectosSolicitados);

      } else {
         Alert alert = new Alert(Alert.AlertType.ERROR);
         alert.setTitle("ERROR");
         alert.setHeaderText(null);
         alert.setContentText("No se ha seleccionado un estudiante");
         alert.showAndWait();
      }
   }

   @FXML
   private void asignar(ActionEvent event) {
   }

   @FXML
   private void seleccionarProyectoSolicitado(MouseEvent event) {
   }

   @FXML
   private void seleccionarProyecto(MouseEvent event) {
   }

   public void obtenerProyectos() {
      try {
         this.proyectos = proyectoDAOImp.recuperarProyectos();
      } catch (Exception ex) {
         Logger.getLogger(FXMLasignarProyectoController.class.getName()).log(Level.SEVERE, null, ex);
      }
   }

   public void obtenerEstudiantes() {
      try {
         this.estudiantes = estudianteDAOImp.recuperarEstudiantes();
      } catch (Exception e) {
         FXMLAlerta alerta = new FXMLAlerta((Stage) this.tablaEstudiantes.getScene().getWindow());
         alerta.alertaError("Error", "Ocurrio un error al realizar la operacion con la base de datos",
                 e.getMessage());
      }

   }

   public void obtenerProyectosSolicitados(String matricula) {
      //this.proyectosSolicitados = estudianteDAOImp.recuperarProyectosSolicitados(matricula);
   }
   //.
}
