/*
 * LISTA DE CONTENIDO:
 * > Paquete de la clase  
 * > Clases o librerias utilizadas
 * > Atributos de la clase 
 * > Método Before
 * > Métodos Test
 */
package modeloTest;

import modelo.CoordinadorDAOImplements;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Esta clase se encarga de probar los métodos de la clase CoordinadorDAOImplementsTest
 *
 * @author Luis Gerardo Rendon Martinez
 */
public class CoordinadorDaoImplementsTest {

   CoordinadorDAOImplements coordinadorDAOImplements;
   String matricula;
   String contrasenia;

   /**
    * Este metodo inicializa todos los atributos necesarios para desarrollar las pruebas y siempre
    * es el primero en ejecutarse.
    */
   @Before
   public void before() {

      coordinadorDAOImplements = new CoordinadorDAOImplements();
      matricula = "S18012188";
      contrasenia = "123456";

   }

   /**
    * Este test prueba el método login de la clase CoordinadorDAOImplements
    */
   @Test
   public void testLoginTrue() {
      boolean logeado = false;
      try {
         logeado = coordinadorDAOImplements.login(matricula, contrasenia);
      } catch (Exception ex) {
         ex.printStackTrace();
      }
      assertTrue(logeado);
   }

}
