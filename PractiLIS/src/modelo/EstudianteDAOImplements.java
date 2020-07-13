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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 * @version 1.1, 09/jul/2020
 */
public class EstudianteDAOImplements implements EstudianteDAO {

   @Override
   public EstudianteVO recuperarEstudiante(String matricula, String contrasenia) throws Exception {
      EstudianteVO estudianteRecuperado = null;
      String sql = crearSQLestaRegistrado(matricula, contrasenia);
      Connection connection = null;
      Statement statement = null;
      ConexionBD conexion = new ConexionBD();
      ResultSet resultset = null;
      try {
         connection = conexion.conectarMySQL();
         statement = connection.createStatement();
         resultset = statement.executeQuery(sql);
         if (resultset.next()) {
            String nombre = resultset.getString("nombre");
            String correoElectronico = resultset.getString("correo");
            String status = resultset.getString("status");
            estudianteRecuperado = new EstudianteVO(matricula, contrasenia, nombre, correoElectronico, status);
         }
         connection.close();
         statement.close();
         resultset.close();
      } catch (SQLException exception) {
         throw new SQLException("Error en recuperarEstudiante SQLException " + exception.getMessage());
      } catch (NullPointerException exception) {
         throw new NullPointerException("Error en recuperarEstudiante NullPointerException " + exception.getMessage());
      }catch (ConnectException exception) {
         throw new ConnectException("Error en recuperarEstudiante ConnectException " + exception.getMessage());
      } catch (Exception exception) {
         throw new Exception("Error en recuperarEstudiante Exception " + exception.getMessage());
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

      return estudianteRecuperado;
   }

   @Override
   public String crearSQLestaRegistrado(String matricula, String contrasenia) {
      String sql = "SELECT * FROM Estudiante WHERE matricula = '" + matricula;
      sql += "' AND contrasenia = '" + contrasenia + "';";
      return sql;
   }

   @Override
   public ObservableList<EstudianteVO> recuperarEstudiantesSinAsignar() throws Exception {
      Connection connection = null;
      Statement statement = null;
      ResultSet resultset = null;
      String sql = "SELECT * FROM estudiante WHERE status='Sin asignar'";

      ObservableList<EstudianteVO> estudiantesSinAsignarList = FXCollections.observableArrayList();

      try {
         connection = new ConexionBD().conectarMySQL();
         statement = connection.createStatement();
         resultset = statement.executeQuery(sql);
         while (resultset.next()) {
            String matricula = resultset.getString("matricula");
            String contrasenia = resultset.getString("contrasenia");
            String nombre = resultset.getString("nombre");
            String correo = resultset.getString("correo");
            String status = resultset.getString("status");

            EstudianteVO estudianteRecuperado = new EstudianteVO(matricula, contrasenia, nombre, correo, status);
            estudiantesSinAsignarList.add(estudianteRecuperado);
         }
         statement.close();
         resultset.close();
         connection.close();
      } catch (SQLException exception) {
         throw new SQLException("Error en recuperarEstudiantes SQLException " + exception.getMessage());
      } catch (NullPointerException exception) {
         throw new NullPointerException("Error en recuperarEstudiantes NullPointerException " + exception.getMessage());
      }catch (ConnectException exception) {
         throw new ConnectException("Error en recuperarEstudiantes ConnectException " + exception.getMessage());
      } catch (Exception exception) {
         throw new Exception("Error en recuperarEstudiantes Exception " + exception.getMessage());
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
      return estudiantesSinAsignarList;
   }

   @Override
   public boolean cambiarStatusAsignado(String matricula) throws Exception {
      boolean changed = false;
      Connection connection = null;
      Statement statement = null;
      String sql = "UPDATE estudiante SET status='Asignado' WHERE matricula='" + matricula + "'";

      try {
         connection = new ConexionBD().conectarMySQL();
         statement = connection.createStatement();
         statement.execute(sql);
         changed = true;
         statement.close();
         connection.close();
      } catch (SQLException exception) {
         throw new SQLException("Error en cambiarStatus SQLException " + exception.getMessage());
      } catch (NullPointerException exception) {
         throw new NullPointerException("Error en cambiarStatus NullPointerException " + exception.getMessage());
      }catch (ConnectException exception) {
         throw new ConnectException("Error en cambiarStatus ConnectException " + exception.getMessage());
      } catch (Exception exception) {
         throw new Exception("Error en cambiarStatus Exception " + exception.getMessage());
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
      return changed;
   }
}
