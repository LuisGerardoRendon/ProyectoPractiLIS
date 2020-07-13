/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javafx.collections.ObservableList;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 * @version 1.1, 09/jul/2020
 */
public interface EstudianteDAO {

   public EstudianteVO recuperarEstudiante(String matricula, String contrasenia) throws Exception;

   public String crearSQLestaRegistrado(String matricula, String contrasenia);

   public ObservableList<EstudianteVO> recuperarEstudiantesSinAsignar() throws Exception;
   
   public boolean cambiarStatusAsignado(String matricula) throws Exception;
   
}
