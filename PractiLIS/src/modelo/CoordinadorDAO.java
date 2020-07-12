/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 * @version 1.1, 11/jul/2020
 */
public interface CoordinadorDAO {

   public boolean login(String usuario, String contrasenia)throws Exception;
   public String crearSQLrecuperarCoordinador(String usuario, String contrasenia);
}
