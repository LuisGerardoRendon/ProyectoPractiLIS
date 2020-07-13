/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class AsignacionDAOImplementsTest {
   AsignacionDAOImplements asignacionDAOImplements;
   AsignacionVO asignacion;
   @Before
    public void before() {
        asignacionDAOImplements = new AsignacionDAOImplements();
        asignacion = new AsignacionVO("2020-2021", "NRC2", 0, 2, "S20012199", "S18012230");
        asignacionDAOImplements = new AsignacionDAOImplements();
        
    }
    @Test
    public void testCreateTrue(){
       boolean  resultado = false;
       try {
          resultado = asignacionDAOImplements.create(asignacion);
      } catch (Exception e) {
         e.printStackTrace();
      }
       assertTrue(resultado);
    }
   
  
   
}
