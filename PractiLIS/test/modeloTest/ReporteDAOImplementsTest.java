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
import modelo.ReporteDAOImplements;
import modelo.ReporteVO;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ReporteDAOImplementsTest {

   public ReporteDAOImplements reporteDAOImplements;
   ObservableList<ReporteVO> reportesRecuperados;

   @Before
   public void before() {
      reporteDAOImplements = new ReporteDAOImplements();
      reportesRecuperados = FXCollections.observableArrayList();
   }
   @Test
   public void recuperarReportesDeEstudianteTest(){
      boolean recuperados = false;
      try {
         reportesRecuperados = reporteDAOImplements.
                 recuperarReportesDeEstudiante("2020-2021", "S18012187");
      } catch (Exception ex) {
      }
      if(!reportesRecuperados.isEmpty()){
         recuperados = true;
      }
      assertTrue(recuperados);
   }

}
