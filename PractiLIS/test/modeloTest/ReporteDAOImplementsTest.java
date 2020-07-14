/*
 * LISTA DE CONTENIDO:
 * > Paquete de la clase  
 * > Clases o librerias utilizadas
 * > Atributos de la clase 
 * > Método Before
 * > Métodos Test
 */
package modeloTest;

import java.io.File;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modelo.ReporteDAOImplements;
import modelo.ReporteVO;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Esta clase es la encargada de probar los métodos de la clase ReporteDAOImplements
 *
 * @author Luis Gerardo Rendon Martinez
 */
public class ReporteDAOImplementsTest {

   ReporteDAOImplements reporteDAOImplements;
   ObservableList<ReporteVO> reportesRecuperados;
   ReporteVO reporteVO;
   File archivo;

   /**
    * Este metodo inicializa todos los atributos necesarios para desarrollar las pruebas y siempre
    * es el primero en ejecutarse.
    */
   @Before
   public void before() {
      reporteDAOImplements = new ReporteDAOImplements();
      reportesRecuperados = FXCollections.observableArrayList();
      archivo = new File("D:\\Archivos\\Construcción\\Estandar.docx");
      reporteVO = new ReporteVO(30, "2020-07-13 22:55:08", "Sin comentar", archivo,
              "2020-07-19", "2020-07-19");

   }

   /**
    * Este test se encarga de probar el método recuperarReportesDeEstudiante de la clase
    * ReporteDAOImplements
    */
   @Test
   public void recuperarReportesDeEstudianteTest() {
      boolean recuperados = false;
      try {
         reportesRecuperados = reporteDAOImplements.
                 recuperarReportesDeEstudiante("2020-2021", "S18012187");
      } catch (Exception ex) {
      }
      if (!reportesRecuperados.isEmpty()) {
         recuperados = true;
      }
      assertTrue(recuperados);
   }

   /**
    * Este test se encarga de probar el método createe de la clase ReporteDAOImplements
    */
   @Test
   public void createTest() {
      boolean creado = false;
      try {
         creado = reporteDAOImplements.create(reporteVO, 1);
      } catch (Exception e) {
      }
      assertTrue(creado);
   }

}
