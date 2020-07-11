/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 * @version 1.1, 10/jul/2020
 */
public class FXMLAlerta extends Alerta {
   private Alert alert;

    public FXMLAlerta(Stage ventanaPropietaria) {
        super(ventanaPropietaria);
    }

    public void AlertaDatos(String titulo, String encabezado, String contenido) {
        alert.setTitle(titulo);
        alert.setHeaderText(encabezado);
        alert.setContentText(contenido);
        this.alert.initOwner(ventanaPropietaria);
    }

    @Override
    public void alertaInformacion(String titulo, String encabezado, String contenido) {
        this.alert = new Alert(Alert.AlertType.INFORMATION);
        this.AlertaDatos(titulo, encabezado, contenido);
        alert.showAndWait();
        
        
    }

    @Override
    public void alertaError(String titulo, String encabezado, String contenido) {
        this.alert = new Alert(Alert.AlertType.ERROR); 
        this.AlertaDatos(titulo, encabezado, contenido);
        this.alert.showAndWait();
    }

    @Override
    public boolean alertaConfirmacion(String titulo, String encabezado, String contenido) {
        boolean respuesta = true;
        this.alert = new Alert(Alert.AlertType.CONFIRMATION);
        this.AlertaDatos(titulo, encabezado, contenido);
        ButtonType resultado = alert.showAndWait().orElse(ButtonType.OK);
        if(ButtonType.NO.equals(resultado)){
            respuesta = false;
        }
        return respuesta;
        
    }
}
