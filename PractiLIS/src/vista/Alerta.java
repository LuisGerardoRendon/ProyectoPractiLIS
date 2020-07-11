/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import javafx.stage.Stage;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 * @version 1.1, 10/jul/2020
 */
public abstract class Alerta {
    protected Stage ventanaPropietaria;
    
    public Alerta(Stage ventanaPropietaria){
        this.ventanaPropietaria = ventanaPropietaria;
    }
    public  abstract  void alertaInformacion(String titulo, String encabezado, String contenido);
    public abstract void alertaError(String titulo, String encabezado, String contenido);
    public abstract boolean alertaConfirmacion(String titulo, String encabezado, String contenido);
    
}

