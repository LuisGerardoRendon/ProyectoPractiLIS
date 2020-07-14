/*
 * LISTA DE CONTENIDO:
 * > Paquete de la clase  
 * > Clases o librerias utilizadas
 * > Atributos de la clase 
 * > Método Before
 * > Métodos Test
 */
package modeloTest;

import modelo.ExpedienteDAOImplements;
import modelo.ExpedienteVO;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Esta clase es la encargada de probar los métodos de la clase ExpedienteDAOImplements
 *
 * @author Luis Gerardo Rendon Martinez
 */
public class ExpedienteDAOImplementsTest {

   ExpedienteDAOImplements expedienteDAOImplements;
   String matricula;
   ExpedienteVO expedienteVO;

   /**
    * Este metodo inicializa todos los atributos necesarios para desarrollar las pruebas y siempre
    * es el primero en ejecutarse.
    */
   @Before
   public void before() {
      expedienteDAOImplements = new ExpedienteDAOImplements();
      matricula = "S18012187";
      expedienteVO = new ExpedienteVO(1);
   }

   /**
    * Este test se encarga de probar el método obtenerExpedienteEstudiante de la clase
    * ExpedienteDAOImplements
    */
   @Test
   public void obtenerExpedienteEstudianteTest() {
      ExpedienteVO expedienteRecuperado = new ExpedienteVO();
      try {
         expedienteRecuperado = expedienteDAOImplements.obtenerExpedienteEstudiante(matricula);
      } catch (Exception ex) {

      }
      assertEquals(expedienteVO, expedienteRecuperado);
   }

   /**
    * Este test se encarga de probar el método create de la clase ExpedienteDAOImplements
    */
   @Test
   public void createTest() {
      boolean creado = false;
      ExpedienteVO expedienteCreado = new ExpedienteVO(0, 5);
      try {
         creado = expedienteDAOImplements.create(expedienteCreado);
      } catch (Exception ex) {
      }
      assertTrue(creado);
   }

}
