/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloTest;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modelo.EstudianteDAOImplements;
import modelo.EstudianteVO;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class EstudianteDAOImplementsTest {

   EstudianteDAOImplements estudianteDAOImplements;
   EstudianteVO estudianteVO;
   ObservableList<EstudianteVO> estudiantesRecuperados;

   @Before
   public void before() {
      estudianteDAOImplements = new EstudianteDAOImplements();
      estudianteVO = new EstudianteVO("S18012187", "123456", "Victor Rendon", "vicren@gmail.com",
              "Asignado");
      estudiantesRecuperados = FXCollections.observableArrayList();
   }

   /*@Test
   public void recuperarEstudianteTest() {
      EstudianteVO estudianteRecuperado = new EstudianteVO();
      try {
         estudianteRecuperado = estudianteDAOImplements.recuperarEstudiante(estudianteVO.getMatricula(),
                 estudianteVO.getContrasenia());
      } catch (Exception ex) {

      }
      assertEquals(estudianteVO, estudianteRecuperado);
   }*/

   /*@Test
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
   }*/

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
