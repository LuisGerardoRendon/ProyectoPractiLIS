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
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modelo.EstudianteVO;
import modelo.ProyectoDAOImplements;
import modelo.ProyectoVO;
import modelo.ReporteDAOImplements;
import modelo.ReporteVO;
import vista.FXMLAlerta;

/**
 * FXML Controller class
 *
 * @author Luis Gerardo Rendon
 */
public class FXMLmenuConsultarAvanceController implements Initializable {

   @FXML
   private Label labelProgreso;
   @FXML
   private Button botonRegresar;
   @FXML
   private Label labelNombreProyecto;
   @FXML
   private Label labelSetNombreProyecto;
   @FXML
   private Label labelHorasRegistradas;
   @FXML
   private Label labelSetHorasRegistradas;
   @FXML
   private Label labelTotalHoras;
   @FXML
   private Label label200;
   @FXML
   private TableView<ReporteVO> tablaReportesEntregados;
   @FXML
   private TableColumn<?, ?> columnaNombreReporte;
   @FXML
   private TableColumn<?, ?> comlumnaFechaEntrega;
   @FXML
   private TableColumn<?, ?> ColumnaHorasCubiertas;
   @FXML
   private Label labelSetAvance;
   @FXML
   private Label labelAvance;

   private EstudianteVO estudianteLogeado;

   ReporteDAOImplements reporteDAO = new ReporteDAOImplements();
   ProyectoDAOImplements proyectoDAO = new ProyectoDAOImplements();

   ObservableList<ReporteVO> reportesRecuperados;
   ProyectoVO proyectoRescatado;

   /**
    * Initializes the controller class.
    */
   @Override
   public void initialize(URL url, ResourceBundle rb) {
      if (inicializarDatos()) {
         setNombreProyecto();
         calcularAvance();
         inicializarTabla();
      }

   }

   public FXMLmenuConsultarAvanceController(EstudianteVO estudianteLogeado) {
      this.estudianteLogeado = estudianteLogeado;
   }

   @FXML
   private void regresar(ActionEvent event) {
      cerrarEstaVentana();
      mostrarFXMLmenuPrincipalEstudiante(estudianteLogeado);

   }

   public void inicializarTabla() {

      this.ColumnaHorasCubiertas.setCellValueFactory(new PropertyValueFactory("horasReportadas"));
      this.columnaNombreReporte.setCellValueFactory(new PropertyValueFactory("numero"));
      this.comlumnaFechaEntrega.setCellValueFactory(new PropertyValueFactory("fechaCarga"));
      this.tablaReportesEntregados.setItems(reportesRecuperados);
      hayReportesSubidos();

   }

   public void calcularAvance() {
      int suma = 0;
      for (ReporteVO tab : reportesRecuperados) {
         suma += tab.getHorasReportadas();
      }
      this.labelSetHorasRegistradas.setText(suma + "");
      float avance = (suma * 100) / 200;
      this.labelSetAvance.setText(avance + "%");
   }

   public void setNombreProyecto() {
      String nombreProyectoRecuperado = proyectoRescatado.getNombre();
      this.labelSetNombreProyecto.setText(nombreProyectoRecuperado);
      System.out.println(proyectoRescatado.toString());
   }

   public void cerrarEstaVentana() {
      Stage stage = (Stage) this.botonRegresar.getScene().getWindow();
      stage.close();
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

   public boolean hayReportesSubidos() {
      boolean hayReportesSubidos = false;

      if (!this.reportesRecuperados.isEmpty()) {
         hayReportesSubidos = true;
      } else {
         System.out.println("No hay reportes");
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("INFORMACIÓN");
         alert.setHeaderText("No hay avance en este proyecto");
         alert.setContentText("Nombre del proyecto: " + this.proyectoRescatado.getNombre());
         alert.showAndWait();

      }
      return hayReportesSubidos;

   }

   private boolean inicializarDatos() {
      boolean datosInicializados = false;
      try {
         this.reportesRecuperados = this.reporteDAO.recuperarReportesDeEstudiante("2020-2021",
                 this.estudianteLogeado.getMatricula());
         this.proyectoRescatado = this.proyectoDAO.recuperarProyectoEstudiante("2020-2021",
         this.estudianteLogeado.getMatricula());
         datosInicializados = true;

      } catch (SQLException e) {
         Alert alert = new Alert(Alert.AlertType.ERROR);
         alert.setTitle("ERROR");
         alert.setHeaderText("");
         alert.setContentText("ERROR. No hay conexión con la base de datos, inténtelo más tarde");
         alert.showAndWait();

      } catch (Exception e) {
         Alert alert = new Alert(Alert.AlertType.ERROR);
         alert.setTitle("ERROR. Algo malo ocurrió");
         alert.setHeaderText("");
         alert.setContentText(e.getMessage());
         alert.showAndWait();
      }
      return datosInicializados;
   }

}
