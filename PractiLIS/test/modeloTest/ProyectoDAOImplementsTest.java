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
import modelo.ProyectoDAOImplements;
import modelo.ProyectoVO;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Esta clase es la encargada de probar los métodos de la clase ProyectoDAOImplements
 *
 * @author Luis Gerardo Rendon Martinez
 */
public class ProyectoDAOImplementsTest {

   ProyectoDAOImplements proyectoDAOImplements;
   ObservableList<ProyectoVO> proyectosRecuperadosList;
   ObservableList<ProyectoVO> proyectosSolicitadosRecuperadosList;
   ProyectoVO proyectoVO;
   String periodo;
   String matricula;

   /**
    * Este metodo inicializa todos los atributos necesarios para desarrollar las pruebas y siempre
    * es el primero en ejecutarse.
    */
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

   /**
    * Este test se encarga de probar el método recuperarProyectosSinAsignar de la clase
    * ProyectoDAOImplements
    */
   @Test
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

   /**
    * Este test se encarga de probar el método recuperarProyectoEstudiante de la clase
    * ProyectoDAOImplements
    */
   @Test
   public void recuperarProyectoEstudianteTest() {
      ProyectoVO proyectoRecuperado = new ProyectoVO();

      try {
         proyectoRecuperado = proyectoDAOImplements.recuperarProyectoEstudiante(periodo, matricula);
      } catch (Exception ex) {
      }
      assertEquals(proyectoVO, proyectoRecuperado);

   }

   /**
    * Este test se encarga de probar el método recuperarProyectosSolicitados de la clase
    * ProyectoDAOImplements
    */
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
   }

   /**
    * Este test se encarga de probar el método cambiarEstudiantesAsignados de la clase
    * ProyectoDAOImplements
    */
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
