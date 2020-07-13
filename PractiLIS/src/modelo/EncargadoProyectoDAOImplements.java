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

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 * @version 1.1, 09/jul/2020
 */
public class EncargadoProyectoDAOImplements implements EncargadoProyectoDAO {

   @Override
   public EncargadoProyectoVO recuperarEncargadoProyecto(ProyectoVO proyectoVO) throws Exception {
      int idProyecto = proyectoVO.getIdProyecto();
      String sql = "SELECT * FROM EncargadoProyecto WHERE idEncargadoProyecto = "
              + proyectoVO.getIdEncargadoProyecto();
      EncargadoProyectoVO encargadoProyectoRecuperdo = new EncargadoProyectoVO();
      Connection connection = null;
      Statement statement = null;
      ConexionBD conexion = new ConexionBD();
      ResultSet resultset = null;
      try {
         connection = conexion.conectarMySQL();
         statement = connection.createStatement();
         resultset = statement.executeQuery(sql);
         resultset.next();
         int idEncargado = resultset.getInt("idEncargadoProyecto");
         String nombre = resultset.getString("nombre");
         String cargo = resultset.getString("cargo");
         String correoElectronico = resultset.getString("correoElectronico");
         encargadoProyectoRecuperdo = new EncargadoProyectoVO(idEncargado,
                 nombre, cargo, correoElectronico);
         connection.close();
         statement.close();
         resultset.close();
      } catch (SQLException exception) {
         throw new SQLException("Error en recuperarEncargadoProyecto SQLException " + exception.getMessage());
      } catch (NullPointerException exception) {
         throw new NullPointerException("Error en recuperarEncargadoProyecto NullPointerException " 
                 + exception.getMessage());
      } catch (ConnectException exception) {
         throw new ConnectException("Error en recuperarEncargadoProyecto ConnectException " 
                 + exception.getMessage());
      } catch (Exception exception) {
         throw new Exception("Error en recuperarEncargadoProyecto Exception " + exception.getMessage());
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
      return encargadoProyectoRecuperdo;
   }
}
