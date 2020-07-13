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
 * @author Daniel Pale
 */
public class AsignacionDAOImplements implements AsignacionDAO {

   @Override
   public boolean create(AsignacionVO asignacion) throws Exception {
      boolean created = false;
      Connection connection = null;
      Statement statement = null;
      ResultSet resultSets = null;
      String sql = "INSERT INTO asignacion VALUES (null,'" + asignacion.getPeriodo() + "',null,"
              + asignacion.getProgreso() + "," + asignacion.getIdProyecto() + ",null,'"
              + asignacion.getMatriculaEstudiante() + "')";
      try {
         connection = new ConexionBD().conectarMySQL();
         statement = connection.createStatement();
         statement.execute(sql);
         created = true;
         statement.close();
         connection.close();
      }catch (SQLException exception) {
         throw new SQLException("Error en create SQLException " + exception.getMessage());
      } catch (NullPointerException exception) {
         throw new NullPointerException("Error en create NullPointerException " + exception.getMessage());
      }catch (ConnectException exception) {
         throw new ConnectException("Error en create ConnectException " + exception.getMessage());
      } catch (Exception exception) {
         throw new Exception("Error en create Exception " + exception.getMessage());
      } finally {
         try {
            if (statement != null) {
               statement.close();
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
      return created;
   }

   @Override
   public int obtenerIdAsingacion(String matricula, String periodo) throws Exception {
      int idAsignacion = 0;
      Connection connection = null;
      Statement statement = null;
      ResultSet resultset = null;
      String sql = "SELECT idAsignacion FROM asignacion WHERE matriculaEstudiante = '"
              + matricula + "' AND periodo = '" + periodo + "'";
      System.out.println(sql);
      try {
         connection = new ConexionBD().conectarMySQL();
         statement = connection.createStatement();
         resultset = statement.executeQuery(sql);
         if(resultset.next()){
            idAsignacion = resultset.getInt("idAsignacion");
         }
         statement.close();
         resultset.close();
         connection.close();
      }catch (SQLException exception) {
         throw new SQLException("Error en obtenerIdAsingacion SQLException " + exception.getMessage());
      } catch (NullPointerException exception) {
         throw new NullPointerException("Error en obtenerIdAsingacion NullPointerException " + exception.getMessage());
      }catch (ConnectException exception) {
         throw new ConnectException("Error en obtenerIdAsingacion ConnectException " + exception.getMessage());
      } catch (Exception exception) {
         throw new Exception("Error en obtenerIdAsingacion Exception " + exception.getMessage());
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
      return idAsignacion;
   }
}
