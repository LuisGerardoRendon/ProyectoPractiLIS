/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
      Connection con = null;
      Statement stm = null;
      ConexionBD cc = new ConexionBD();
      ResultSet rs = null;
      try {
         con = cc.conectarMySQL();
         stm = con.createStatement();
         rs = stm.executeQuery(sql);
         if (rs.next()) {
            String nombre = rs.getString("nombre");
            String correoElectronico = rs.getString("correo");
            String status = rs.getString("status");
            estudianteRecuperado = new EstudianteVO(matricula, contrasenia, nombre, correoElectronico, status);
         }
         con.close();
         stm.close();
         rs.close();
      } catch (SQLException e) {
         throw new SQLException("Error en recuperarEstudiante SQLException " + e.getMessage());
      } catch (NullPointerException e) {
         throw new NullPointerException("Error en recuperarEstudiante NullPointerException " + e.getMessage());
      }catch (ConnectException e) {
         throw new ConnectException("Error en recuperarEstudiante ConnectException " + e.getMessage());
      } catch (Exception e) {
         throw new Exception("Error en recuperarEstudiante Exception " + e.getMessage());
      } finally {
         try {
            if (stm != null) {
               stm.close();
            }
         } catch (Exception e) {
         };
         try {
            if (con != null) {
               con.close();
            }
         } catch (Exception e) {
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
      Connection con = null;
      Statement stm = null;
      ResultSet rs = null;
      String sql = "SELECT * FROM estudiante WHERE status='Sin asignar'";

      ObservableList<EstudianteVO> estudiantes = FXCollections.observableArrayList();

      try {
         con = new ConexionBD().conectarMySQL();
         stm = con.createStatement();
         rs = stm.executeQuery(sql);
         while (rs.next()) {
            String matricula = rs.getString("matricula");
            String contrasenia = rs.getString("contrasenia");
            String nombre = rs.getString("nombre");
            String correo = rs.getString("correo");
            String status = rs.getString("status");

            EstudianteVO e = new EstudianteVO(matricula, contrasenia, nombre, correo, status);
            estudiantes.add(e);
         }
         stm.close();
         rs.close();
         con.close();
      } catch (SQLException e) {
         throw new SQLException("Error en recuperarEstudiantes SQLException " + e.getMessage());
      } catch (NullPointerException e) {
         throw new NullPointerException("Error en recuperarEstudiantes NullPointerException " + e.getMessage());
      }catch (ConnectException e) {
         throw new ConnectException("Error en recuperarEstudiantes ConnectException " + e.getMessage());
      } catch (Exception e) {
         throw new Exception("Error en recuperarEstudiantes Exception " + e.getMessage());
      } finally {
         try {
            if (stm != null) {
               stm.close();
            }
         } catch (Exception e) {
         };
         try {
            if (con != null) {
               con.close();
            }
         } catch (Exception e) {
         };
      }
      return estudiantes;
   }

   @Override
   public boolean cambiarStatusAsignado(String matricula) throws Exception {
      boolean changed = false;
      Connection con = null;
      Statement stm = null;
      String sql = "UPDATE estudiante SET status='Asignado' WHERE matricula='" + matricula + "'";

      try {
         con = new ConexionBD().conectarMySQL();
         stm = con.createStatement();
         stm.execute(sql);
         changed = true;
         stm.close();
         con.close();
      } catch (SQLException e) {
         throw new SQLException("Error en cambiarStatus SQLException " + e.getMessage());
      } catch (NullPointerException e) {
         throw new NullPointerException("Error en cambiarStatus NullPointerException " + e.getMessage());
      }catch (ConnectException e) {
         throw new ConnectException("Error en cambiarStatus ConnectException " + e.getMessage());
      } catch (Exception e) {
         throw new Exception("Error en cambiarStatus Exception " + e.getMessage());
      } finally {
         try {
            if (stm != null) {
               stm.close();
            }
         } catch (Exception e) {
         };
         try {
            if (con != null) {
               con.close();
            }
         } catch (Exception e) {
         };
      }
      return changed;
   }
}
