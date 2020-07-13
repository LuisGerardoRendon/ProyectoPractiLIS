/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorTest;

import controlador.FXMLiniciarSesionController;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class FXMLiniciarSesionControllerTest {
   FXMLiniciarSesionController controlador;
   String matricula;
   
   @Before
   public void before(){
      controlador = new FXMLiniciarSesionController();
      matricula = "zs18012187";
   }
   
   @Test
   public void testFormatearMatricula(){
      String matriculaFormateada = controlador.formatearMatricula(matricula);
      assertEquals("S18012187", matriculaFormateada);   
   }
   
   
   
   
}
