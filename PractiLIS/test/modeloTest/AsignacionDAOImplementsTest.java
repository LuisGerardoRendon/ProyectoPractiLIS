/*
 * LISTA DE CONTENIDO:
 * > Paquete de la clase  
 * > Clases o librerias utilizadas
 * > Atributos de la clase 
 * > Método Before
 * > Métodos Test
 */
package modeloTest;

import modelo.AsignacionDAOImplements;
import modelo.AsignacionVO;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Esta clase se encarga de probar los métodos de la clase AsignacionDAOImplements
 *
 * @author Luis Gerardo Rendon Martinez
 */
public class AsignacionDAOImplementsTest {

   AsignacionDAOImplements asignacionDAOImplements;
   AsignacionVO asignacion;
   String matriculaEstudiante;
   String periodo;

   /**
    * Este metodo inicializa todos los atributos necesarios para desarrollar las pruebas y siempre
    * es el primero en ejecutarse.
    */
   @Before
   public void before() {
      asignacionDAOImplements = new AsignacionDAOImplements();
      asignacion = new AsignacionVO("2020-2021", "NRC2", 0, 2, "S20012199", "S18012230", "METER FECHA");
      asignacionDAOImplements = new AsignacionDAOImplements();
      matriculaEstudiante = "S18012187";
      periodo = "2020-2021";
   }

   /**
    * Test que se encarga de probar el método Create de la clase AsignacionDAOImplements
    */
   @Test
   public void testCreateTrue() {
      boolean resultado = false;
      try {
         resultado = asignacionDAOImplements.create(asignacion);
      } catch (Exception e) {
         e.printStackTrace();
      }
      assertTrue(resultado);
   }

   /**
    * Test que se encarga de probar el método obtenerIdAsignacion de la clase
    * AsignacionDAOImplements
    */
   @Test
   public void testobtenerIdAsingacion() {
      int idOrganizacion = 0;
      try {
         idOrganizacion = asignacionDAOImplements.obtenerIdAsingacion(matriculaEstudiante, periodo);
      } catch (Exception ex) {
         ex.printStackTrace();
      }
      assertEquals(1, idOrganizacion);
   }

}
