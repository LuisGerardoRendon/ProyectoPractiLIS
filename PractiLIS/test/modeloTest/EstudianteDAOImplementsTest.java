/*
 * LISTA DE CONTENIDO:
 * > Paquete de la clase  
 * > Clases o librerias utilizadas
 * > Atributos de la clase 
 * > Método Before
 * > Métodos Test
 */
package modeloTest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modelo.EstudianteDAOImplements;
import modelo.EstudianteVO;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Esta clase es la encargada de probar los métodos de la clase EstudianteDAOImplements
 *
 * @author Luis Gerardo Rendon Martinez
 */
public class EstudianteDAOImplementsTest {

   EstudianteDAOImplements estudianteDAOImplements;
   EstudianteVO estudianteVO;
   ObservableList<EstudianteVO> estudiantesRecuperados;

   /**
    * Este metodo inicializa todos los atributos necesarios para desarrollar las pruebas y siempre
    * es el primero en ejecutarse.
    */
   @Before
   public void before() {
      estudianteDAOImplements = new EstudianteDAOImplements();
      estudianteVO = new EstudianteVO("S18012187", "123456", "Victor Rendon", "vicren@gmail.com",
              "Asignado");
      estudiantesRecuperados = FXCollections.observableArrayList();
   }

   /**
    * Este test se encarga de probar el método recuperarEstudiante de la clase
    * EstudianteDAOImplements
    */
   @Test
   public void recuperarEstudianteTest() {
      EstudianteVO estudianteRecuperado = new EstudianteVO();
      try {
         estudianteRecuperado = estudianteDAOImplements.recuperarEstudiante(estudianteVO.getMatricula(),
                 estudianteVO.getContrasenia());
      } catch (Exception ex) {

      }
      assertEquals(estudianteVO, estudianteRecuperado);
   }

   /**
    * Este test se encarga de probar el método recuperarEstudiantesSinAsignar de la clase
    * EstudianteDAOImplements
    */
   @Test
   public void recuperarEstudiantesSinAsignarTest() {
      boolean recuperados = false;
      try {
         estudiantesRecuperados = estudianteDAOImplements.recuperarEstudiantesSinAsignar();
      } catch (Exception ex) {
      }
      if (!estudiantesRecuperados.isEmpty()) {
         recuperados = true;
      }
      assertTrue(recuperados);
   }

   /**
    * Este test se encarga de probar el método cambiarStatusAsignado de la clase
    * EstudianteDAOImplements
    */
   @Test
   public void cambiarStatusTest() {
      boolean statusCambiado = false;
      try {
         statusCambiado = estudianteDAOImplements.cambiarStatusAsignado("S18012230");
      } catch (Exception ex) {

      }
      assertTrue(statusCambiado);
   }

}
