/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloTest;


import modelo.EncargadoProyectoDAOImplements;
import modelo.EncargadoProyectoVO;
import modelo.ProyectoVO;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class EncargadoProyectoDAOImplementsTest {

   EncargadoProyectoDAOImplements encargadoProyectoDAOImplements;
   ProyectoVO proyectoVO;
   EncargadoProyectoVO encargadoProyectoVO;

   @Before
   public void before() {
      encargadoProyectoDAOImplements = new EncargadoProyectoDAOImplements();
      proyectoVO = new ProyectoVO(1, "Contabilidad Coronavirus", "Proyecto enfocado a llevar la esta"
              + "distica del nuevo virus en Mexico", 3, 0, "Asignado", 3, 1);
      encargadoProyectoVO = new EncargadoProyectoVO(1, "Luis Gerardo Rendon Martinez",
              "Jefe de Recursos Humanos", "rendon.luisgerardo@gmail.com");
   }

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
