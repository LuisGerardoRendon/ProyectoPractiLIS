/*
 * LISTA DE CONTENIDO:
 * > Paquete de la clase  
 * > Clases o librerias utilizadas
 * > Atributos de la clase 
 * > Método Before
 * > Métodos Test
 */
package controladorTest;

import controlador.FXMLiniciarSesionController;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Esta clase se encarga de probar algunos métodos de la clase FXMLiniciarSesionController
 *
 * @author Luis Gerardo Rendon Martinez
 */
public class FXMLiniciarSesionControllerTest {

   FXMLiniciarSesionController controlador;
   String matricula;

   /**
    * Este metodo inicializa todos los atributos necesarios para desarrollar las pruebas.
    */
   @Before
   public void before() {
      controlador = new FXMLiniciarSesionController();
      matricula = "zs18012187";
   }

   /**
    * Test que prueba el método formatearMatricula de la clase FXMLiniciarSesionController
    */
   @Test
   public void testFormatearMatricula() {
      String matriculaFormateada = controlador.formatearMatricula(matricula);
      assertEquals("S18012187", matriculaFormateada);
   }

}
