/*
 * LISTA DE CONTENIDO:
 * > Paquete de la clase  
 * > Clases o librerias utilizadas
 * > Atributos de la clase 
 * > Método Before
 * > Métodos Test
 */
package modeloTest;

import modelo.EncargadoProyectoDAOImplements;
import modelo.EncargadoProyectoVO;
import modelo.ProyectoVO;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Esta clase es la encargada de probar los métodos de la clase EncargadoProyectoDAOImplements
 *
 * @author Luis Gerardo Rendon Martinez
 */
public class EncargadoProyectoDAOImplementsTest {

   EncargadoProyectoDAOImplements encargadoProyectoDAOImplements;
   ProyectoVO proyectoVO;
   EncargadoProyectoVO encargadoProyectoVO;

   /**
    * Este metodo inicializa todos los atributos necesarios para desarrollar las pruebas y siempre
    * es el primero en ejecutarse.
    */
   @Before
   public void before() {
      encargadoProyectoDAOImplements = new EncargadoProyectoDAOImplements();
      proyectoVO = new ProyectoVO(1, "Contabilidad Coronavirus", "Proyecto enfocado a llevar la esta"
              + "distica del nuevo virus en Mexico", 3, 0, "Asignado", 3, 1);
      encargadoProyectoVO = new EncargadoProyectoVO(1, "Luis Gerardo Rendon Martinez",
              "Jefe de Recursos Humanos", "rendon.luisgerardo@gmail.com");
   }

   /**
    * Este Test prueba el método recuperarEncargaqdoProyecto de la clase
    * EncargadoProyectoDAOImplements
    */
   @Test
   public void recuperarEncargadoProyectoTest() {
      EncargadoProyectoVO encargadoRecuperado = new EncargadoProyectoVO();
      try {
         encargadoRecuperado = encargadoProyectoDAOImplements.recuperarEncargadoProyecto(proyectoVO);
      } catch (Exception ex) {
         ex.printStackTrace();
      }
      assertEquals(encargadoProyectoVO, encargadoRecuperado);
   }

}
