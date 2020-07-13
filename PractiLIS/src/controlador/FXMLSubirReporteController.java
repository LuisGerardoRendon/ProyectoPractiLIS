/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.EstudianteVO;
import modelo.ProyectoDAOImplements;
import modelo.ProyectoVO;
import modelo.ReporteDAOImplements;
import modelo.ReporteVO;

/**
 * FXML Controller class
 *
 * @author ALDO
 */
public class FXMLSubirReporteController implements Initializable {

   @FXML
   private TableView<ReporteVO> tablaReportes;
   @FXML
   private TableColumn<ReporteVO, Integer> columnaNumeroReporte;
   @FXML
   private TableColumn<ReporteVO, String> columnaFechaCarga;
   @FXML
   private TableColumn<ReporteVO, Integer> columnaHorasCubiertas;
   @FXML
   private Button botonSubirNuevoReporte;
   @FXML
   private Button botonRegresar;
   @FXML
   private Label labelNombreProyecto;
   @FXML
   private Label labelHorasAcumuladas;

   private EstudianteVO estudianteLogeado;

   private ProyectoVO proyectoRecuperado;

   private ObservableList<ReporteVO> reportesRecuperados;

   ReporteDAOImplements reporteDAO;

   ProyectoDAOImplements proyectoDAO;

   /**
    * Initializes the controller class.
    */
   @Override
   public void initialize(URL url, ResourceBundle rb) {

      reporteDAO = new ReporteDAOImplements();
      proyectoDAO = new ProyectoDAOImplements();
      recuperarReportes();
      recuperarProyecto();
      setNombreProyecto();
      calcularHoras();
      inicializarTabla();

   }

   public void setEstudianteLogeado(EstudianteVO estudianteLogeado) {
      this.estudianteLogeado = estudianteLogeado;

   }
   
   public void inicializarTabla() {

      this.columnaNumeroReporte.setCellValueFactory(new PropertyValueFactory("numero"));
      this.columnaFechaCarga.setCellValueFactory(new PropertyValueFactory("fechaCarga"));
      this.columnaHorasCubiertas.setCellValueFactory(new PropertyValueFactory("horasReportadas"));
      this.tablaReportes.setItems(reportesRecuperados);

   }

   public FXMLSubirReporteController(EstudianteVO estudianteLogeado) {
      this.estudianteLogeado = estudianteLogeado;
   }

   @FXML
   private void subirNuevoReporte(ActionEvent event) {

      try {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/"
                 + "FXMLSubirNuevoReporte.fxml"));
         FXMLSubirNuevoReporteController controladorSubirNuevoReporte = new FXMLSubirNuevoReporteController(estudianteLogeado);
         loader.setController(controladorSubirNuevoReporte);
         Parent root = loader.load();

         Scene scene = new Scene(root);
         Stage stage = new Stage();
         stage.initModality(Modality.APPLICATION_MODAL);
         stage.setScene(scene);
         stage.show();

         cerrarVentana(event);
      } catch (IOException e) {
         System.out.println(e.getMessage());
         e.printStackTrace();
      }

      Node source = (Node) event.getSource();
      Stage stagee = (Stage) source.getScene().getWindow();
      stagee.close();
   }

   @FXML
   private void regresar(ActionEvent event) {
      cerrarVentana(event);
      try {
         FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/vista/FXMLmenuPrincipalEstudiante.fxml"));
         Parent ventanaPrincipal = (Parent) fXMLLoader.load();
         FXMLmenuPrincipalEstudianteController controlador = fXMLLoader.getController();
         controlador.setEstudianteLogeado(estudianteLogeado);
         Stage stage = new Stage();
         stage.setScene(new Scene(ventanaPrincipal));
         stage.show();
      } catch (Exception e){
        e.getMessage();
        e.printStackTrace();
      } 
   }

   

   public void setNombreProyecto() {
      String nombreProyectoRecuperado = proyectoRecuperado.getNombre();
      this.labelNombreProyecto.setText(nombreProyectoRecuperado);
   }

   public void recuperarProyecto() {
      try {
         proyectoRecuperado = this.proyectoDAO.recuperarProyectoEstudiante("2020-2021",
                 estudianteLogeado.getMatricula());
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public void recuperarReportes() {
      try {
         reportesRecuperados = this.reporteDAO.recuperarReportesDeEstudiante("2020-2021",
                 estudianteLogeado.getMatricula());
      } catch (Exception e) {
         e.printStackTrace();
      }

   }

   public void calcularHoras() {
      int sumaHoras = 0;
      for (ReporteVO tab : reportesRecuperados) {
         sumaHoras += tab.getHorasReportadas();
      }
      this.labelHorasAcumuladas.setText(sumaHoras + "");
   }

   public void cerrarVentana(ActionEvent event) {
      Node source = (Node) event.getSource();
      Stage stage = (Stage) source.getScene().getWindow();
      stage.close();
   }

}
