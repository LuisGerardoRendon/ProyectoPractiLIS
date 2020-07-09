/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Luis Gerardo
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
    private TableView<?> tablaReportesEntregados;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void regresar(ActionEvent event) {
    }
    
}
