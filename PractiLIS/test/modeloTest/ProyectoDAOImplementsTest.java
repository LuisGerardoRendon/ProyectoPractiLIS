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
import modelo.ProyectoDAOImplements;
import modelo.ProyectoVO;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ProyectoDAOImplementsTest {

   ProyectoDAOImplements proyectoDAOImplements;
   ObservableList<ProyectoVO> proyectosRecuperadosList;
   ObservableList<ProyectoVO> proyectosSolicitadosRecuperadosList;
   ProyectoVO proyectoVO;
   String periodo;
   String matricula;

   @Before
   public void before() {
      proyectoDAOImplements = new ProyectoDAOImplements();
      proyectosRecuperadosList = FXCollections.observableArrayList();
      proyectosSolicitadosRecuperadosList = FXCollections.observableArrayList();
      matricula = "S18012187";
      periodo = "2020-2021";
      proyectoVO = new ProyectoVO(1, "Contabilidad Coronavirus", "Proyecto enfocado a llevar la esta"
              + "distica del nuevo virus en Mexico", 3, 0, "Asignado", 3, 1);
   }

   /*@Test
   public void recuperarProyectosSinAsignarTest() {
      boolean recuperados = false;
      try {
         proyectosRecuperadosList = proyectoDAOImplements.recuperarProyectosSinAsignar();
      } catch (Exception ex) {

      }
      if (!proyectosRecuperadosList.isEmpty()) {
         recuperados = true;
      }
      assertTrue(recuperados);
   }

   @Test
   public void recuperarProyectoEstudianteTest() {
      ProyectoVO proyectoRecuperado = new ProyectoVO();

      try {
         proyectoRecuperado = proyectoDAOImplements.recuperarProyectoEstudiante(periodo, matricula);
      } catch (Exception ex) {
      }
      assertEquals(proyectoVO, proyectoRecuperado);

   }
   @Test
   public void recuperarProyectosSolicitadosTest() {
      boolean recuperados = false;
      try {
         proyectosSolicitadosRecuperadosList = proyectoDAOImplements
                 .recuperarProyectosSolicitados(matricula);
      } catch (Exception ex) {
      }
      if (!proyectosSolicitadosRecuperadosList.isEmpty()) {
         recuperados = true;
      }
      assertTrue(recuperados);
   }*/
   @Test
   public void cambiarEstudiantesAsignadosTest() {
      boolean cambiado = false;

      try {
         cambiado = proyectoDAOImplements.cambiarEstudiantesAsignados(1, 2, "2020-2021");
      } catch (Exception ex) {

      }
      assertTrue(cambiado);
   }
}
