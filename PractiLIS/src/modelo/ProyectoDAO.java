/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javafx.collections.ObservableList;

/**
 *
 * @author Daniel Pale Parra
 */
public interface ProyectoDAO {

   public ObservableList<ProyectoVO> recuperarProyectos() throws Exception;

   public ProyectoVO recuperarProyectoEstudiante(String periodo, String matricula) throws Exception;

   public String crearSQLRecuperarProyectoEstudiante(String periodo, String matricula);

   public ObservableList<ProyectoVO> recuperarProyectosSolicitados(String matricula) throws Exception;
   //.
}
