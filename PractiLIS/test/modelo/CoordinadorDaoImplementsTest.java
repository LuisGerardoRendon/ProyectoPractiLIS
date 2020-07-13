/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class CoordinadorDaoImplementsTest {

   CoordinadorDAOImplements coordinadorDAOImplements;
   String matricula;
   String contrasenia;

   @Before
   public void before() {

      coordinadorDAOImplements = new CoordinadorDAOImplements();
      matricula = "S18012188";
      contrasenia = "123456";

   }

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
