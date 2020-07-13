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
public class AsignacionDAOImplementsTest {

   AsignacionDAOImplements asignacionDAOImplements;
   AsignacionVO asignacion;
   String matriculaEstudiante;
   String periodo;

   @Before
   public void before() {
      asignacionDAOImplements = new AsignacionDAOImplements();
      asignacion = new AsignacionVO("2020-2021", "NRC2", 0, 2, "S20012199", "S18012230");
      asignacionDAOImplements = new AsignacionDAOImplements();
      matriculaEstudiante = "S18012187";
      periodo = "2020-2021";
   }

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
