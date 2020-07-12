/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
      // TODO

   }

   @FXML
   private void regresar(ActionEvent event) {
      Stage stage = (Stage) this.botonRegresar.getScene().getWindow();
      stage.close();

   }

   public void inicializarTabla() {
      this.ColumnaHorasCubiertas.setCellValueFactory(new PropertyValueFactory("horasReportadas"));
      this.columnaNombreReporte.setCellValueFactory(new PropertyValueFactory("numero"));
      this.comlumnaFechaEntrega.setCellValueFactory(new PropertyValueFactory("fechaCarga"));
      this.tablaReportesEntregados.setItems(reportesRecuperados);

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

   public void setEstudianteUsuario(EstudianteVO estudiante) {
      this.estudianteLogeado = estudiante;
      try {
         this.reportesRecuperados = this.reporteDAO.recuperarReportes("2020-2021", 
                 this.estudianteLogeado.getMatricula());
         this.proyectoRescatado = this.proyectoDAO.recuperarProyectoEstudiante("2020-2021",
                 this.estudianteLogeado.getMatricula());
         
      } catch (Exception e) {
         
      }

      setNombreProyecto();
      calcularAvance();
      inicializarTabla();
   }

}
