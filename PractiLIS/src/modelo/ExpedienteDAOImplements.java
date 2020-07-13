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
 * @author ALDO
 */
public class ExpedienteDAOImplements implements ExpedienteDAO {

   @Override
   public ExpedienteVO obtenerExpedienteEstudiante(String matricula) throws Exception {
      String sql = crearSQLRecuperarExpedienteEstudiante(matricula);
      ExpedienteVO expedienteRecuperado = new ExpedienteVO();
      Connection connection = null;
      Statement statement = null;
      ConexionBD conexion = new ConexionBD();
      ResultSet resultset = null;
      try {
         connection = conexion.conectarMySQL();
         statement = connection.createStatement();
         resultset = statement.executeQuery(sql);
         if (resultset.next()) {
            int idExpediente = resultset.getInt("idExpediente");

            expedienteRecuperado = new ExpedienteVO(idExpediente);

         }
         connection.close();
         statement.close();
         resultset.close();
      } catch (SQLException exception) {
         throw new SQLException("Error en obtenerExpediente SQLException " + exception.getMessage());
      } catch (NullPointerException exception) {
         throw new NullPointerException("Error en obtenerExpediente NullPointerException " + exception.getMessage());
      }catch (ConnectException exception) {
         throw new ConnectException("Error en obtenerExpediente ConnectException " + exception.getMessage());
      } catch (Exception exception) {
         throw new Exception("Error en obtenerExpediente Exception " + exception.getMessage());
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
      return expedienteRecuperado;
   }

   @Override
   public String crearSQLRecuperarExpedienteEstudiante(String matricula) {
      String sql;
      sql = "SELECT idExpediente FROM Expediente INNER JOIN "
              + "Asignacion ON Expediente.idAsignacion=Asignacion.idAsignacion "
              + "INNER JOIN Estudiante ON Asignacion.matriculaEstudiante=Estudiante.matricula "
              + "WHERE matricula= '" + matricula + "';";
      System.out.println(sql);
      return sql;
   }

   @Override
   public boolean create(ExpedienteVO expediente) throws Exception {
      boolean created = false;
      Connection connection = null;
      Statement statement = null;
      String sql = "INSERT INTO expediente VALUES (null, '" + expediente.getIdAsignacion() + "')";
      System.out.println(sql);
      try {
         connection = new ConexionBD().conectarMySQL();
         statement = connection.createStatement();
         statement.execute(sql);
         created = true;
         statement.close();
         connection.close();
      } catch (SQLException exception) {
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
}
