/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloTest;

import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ExpedienteDAOImplements;
import modelo.ExpedienteVO;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ExpedienteDAOImplementsTest {

   ExpedienteDAOImplements expedienteDAOImplements;
   String matricula;
   ExpedienteVO expedienteVO ;

   @Before
   public void before() {
      expedienteDAOImplements = new ExpedienteDAOImplements();
      matricula = "S18012187";
      expedienteVO = new ExpedienteVO(1);
   }
   
   @Test
   public void obtenerExpedienteEstudianteTest(){
      ExpedienteVO expedienteRecuperado = new ExpedienteVO();
      try {
         expedienteRecuperado = expedienteDAOImplements.obtenerExpedienteEstudiante(matricula);
      } catch (Exception ex) {
         
      }
      assertEquals(expedienteVO, expedienteRecuperado);
   }
   @Test
   public  void createTest(){
      boolean creado = false;
      ExpedienteVO expedienteCreado = new ExpedienteVO(0, 5);
      try {
         creado = expedienteDAOImplements.create(expedienteCreado);
      } catch (Exception ex) {
      }
      assertTrue(creado);
   }
   

}
