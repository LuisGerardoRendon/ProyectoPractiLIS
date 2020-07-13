/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 * @version 1.1, 11/jul/2020
 */
public class CoordinadorDAOImplements implements CoordinadorDAO {

   @Override
   public boolean login(String usuario, String contrasenia) throws Exception {
      String sql = crearSQLrecuperarCoordinador(usuario, contrasenia);
      boolean encontrado = false;
      Connection connection = null;
      Statement statement = null;
      ConexionBD conexion = new ConexionBD();
      ResultSet resultset = null;

      try {
         connection = conexion.conectarMySQL();
         statement = connection.createStatement();
         resultset = statement.executeQuery(sql);
         if (resultset.next()) {
            encontrado = true;
         }
         statement.close();
         resultset.close();
         connection.close();
      } catch (SQLException exception) {
         throw new SQLException("Error en login SQLException " + exception.getMessage());
      } catch (NullPointerException exception) {
         throw new NullPointerException("Error en login NullPointerException " + exception.getMessage());
      } catch (ConnectException exception) {
         throw new ConnectException("Error en login ConnectException " + exception.getMessage());
      } catch (Exception exception) {
         throw new Exception("Error en login Exception " + exception.getMessage());
      } finally {
         try {
            if (statement != null) {
               statement.close();
            }
         } catch (Exception exception) {
         };
         try {
            if (resultset != null) {
               resultset.close();
            }
         } catch (Exception exception) {
         };
         try {
            if (connection != null) {
               connection.close();
            }
         } catch (Exception exception) {
         };
      }
      return encontrado;

   }

   @Override
   public String crearSQLrecuperarCoordinador(String usuario, String contrasenia) {
      String sql = "SELECT * FROM coordinador WHERE usuario "
              + "= '" + usuario + "'" + "AND contrasenia = '" + contrasenia + "';";

      return sql;
   }

}
