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
   
   @Before
   public void before(){
      proyectoDAOImplements = new ProyectoDAOImplements();
      proyectosRecuperadosList = FXCollections.observableArrayList();
      
   }
   
   
   @Test
   public void recuperarProyectosSinAsignarTest(){
      boolean recuperados = false;
      try {
         proyectosRecuperadosList = proyectoDAOImplements.recuperarProyectosSinAsignar();
      } catch (Exception ex) {
         
      }
      if(!proyectosRecuperadosList.isEmpty()){
         recuperados = true;
      }
      assertTrue(recuperados);
   }
}
