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
 * @author Daniel Pale
 */
public class ProyectoDAOImplements implements ProyectoDAO {

   @Override
   public ObservableList<ProyectoVO> recuperarProyectos() throws Exception {
      String sql = "SELECT * FROM proyecto WHERE status='Sin asignar'";
      Connection con = null;
      Statement stm = null;
      ConexionBD cc = new ConexionBD();
      ResultSet rs = null;

      ObservableList<ProyectoVO> obs = FXCollections.observableArrayList();
      try {
         con = cc.conectarMySQL();
         stm = con.createStatement();
         rs = stm.executeQuery(sql);
         while (rs.next()) {
            int idProyecto = rs.getInt("idProyecto");
            String nombreProyecto = rs.getString("nombre");
            String descripcion = rs.getString("descripcion");
            int capacidadEstudiantes = rs.getInt("capacidadEstudiantes");
            int numEstudiantesAsignados = rs.getInt("numEstudiantesAsignados");
            String status = rs.getString("status");
            int idOrganizacion = rs.getInt("idOrganizacion");
            int idEncargadoProyecto = rs.getInt("idEncargadoProyecto");
            int cupo = (capacidadEstudiantes - numEstudiantesAsignados);
            if (cupo > 0) {
               ProyectoVO c = new ProyectoVO(idProyecto, nombreProyecto, descripcion,
                       capacidadEstudiantes, numEstudiantesAsignados, status, idOrganizacion,
                       idEncargadoProyecto);
               obs.add(c);
            }
         }
         con.close();
         stm.close();
         rs.close();
      } catch (SQLException e) {
         throw new SQLException("Error en recuperarProyectos SQLException " + e.getMessage());
      } catch (NullPointerException e) {
         throw new NullPointerException("Error en recuperarProyectos NullPointerException " + e.getMessage());
      }catch (ConnectException e) {
         throw new ConnectException("Error en recuperarProyectos ConnectException " + e.getMessage());
      } catch (Exception e) {
         throw new Exception("Error en recuperarProyectos Exception " + e.getMessage());
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
      return obs;
   }

   @Override
   public ProyectoVO recuperarProyectoEstudiante(String periodo, String matricula) throws Exception {
      String sql = crearSQLRecuperarProyectoEstudiante(periodo, matricula);
      ProyectoVO proyectoRecuperado = new ProyectoVO();
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
            String descripcion = rs.getString("descripcion");
            int capacidadEstudiantes = rs.getInt("capacidadEstudiantes");
            int numEstudiantesAsignados = rs.getInt("numEstudiantesAsignados");
            int idProyecto = rs.getInt("idProyecto");
            String status = rs.getString("status");
            int idOrganizacion = rs.getInt("idOrganizacion");
            int idEncargadoProyecto = rs.getInt("idEncargadoProyecto");
            proyectoRecuperado = new ProyectoVO(idProyecto, nombre, descripcion,
                    capacidadEstudiantes, numEstudiantesAsignados, status,
                    idOrganizacion, idEncargadoProyecto);

         }
         con.close();
         stm.close();
         rs.close();
      } catch (SQLException e) {
         throw new SQLException("Error en recuperarProyectoEstudiante SQLException " + e.getMessage());
      } catch (NullPointerException e) {
         throw new NullPointerException("Error en recuperarProyectoEstudiante NullPointerException " + e.getMessage());
      }catch (ConnectException e) {
         throw new ConnectException("Error en recuperarProyectoEstudiante ConnectException " + e.getMessage());
      } catch (Exception e) {
         throw new Exception("Error en recuperarProyectoEstudiante Exception " + e.getMessage());
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
      return proyectoRecuperado;
   }

   @Override
   public String crearSQLRecuperarProyectoEstudiante(String periodo, String matricula) {
      String sql;
      sql = "SELECT Proyecto.nombre, Proyecto.descripcion, ";
      sql += "Proyecto.capacidadEstudiantes, Proyecto.numEstudiantesAsignados, ";
      sql += "Proyecto.status, Proyecto.idOrganizacion, Proyecto.idEncargadoProyecto,";
      sql += " Proyecto.idProyecto";
      sql += " FROM Estudiante INNER JOIN Asignacion on Estudiante.matricula  = "
              + "Asignacion.matriculaEstudiante";
      sql += " INNER JOIN Proyecto on Asignacion.idProyecto = "
              + "Proyecto.idProyecto";
      sql += " WHERE Asignacion.periodo = '" + periodo + "'";
      sql += " AND Asignacion.matriculaEstudiante = '" + matricula + "';";
      System.out.println(sql);
      return sql;
   }

   @Override
   public ObservableList<ProyectoVO> recuperarProyectosSolicitados(String matricula) throws Exception {
      Connection con = null;
      PreparedStatement ps = null;
      ResultSet rs = null;
      String sql = "SELECT p.nombre, p.descripcion, p.capacidadEstudiantes, "
              + "p.numEstudiantesAsignados, p.idProyecto, p.status, p.idOrganizacion,"
              + " p.idEncargadoProyecto FROM proyecto p INNER JOIN solicitud s ON "
              + "s.idProyecto=p.idProyecto WHERE matricula= ? AND s.periodo = 'Ene 2020-Ago 2020'";

      ObservableList<ProyectoVO> proyectosSolicitados = FXCollections.observableArrayList();

      try {
         con = new ConexionBD().conectarMySQL();
         ps = con.prepareStatement(sql);
         ps.setString(1, matricula);
         rs = ps.executeQuery();
         while (rs.next()) {
            int idProyecto = rs.getInt("idProyecto");
            String nombreProyecto = rs.getString("nombre");
            String descripcion = rs.getString("descripcion");
            int capacidadEstudiantes = rs.getInt("capacidadEstudiantes");
            int numEstudiantesAsignados = rs.getInt("numEstudiantesAsignados");
            String status = rs.getString("status");
            int idOrganizacion = rs.getInt("idOrganizacion");
            int idEncargadoProyecto = rs.getInt("idEncargadoProyecto");
            int cupo = (capacidadEstudiantes - numEstudiantesAsignados);
            if (cupo > 0) {
               ProyectoVO c = new ProyectoVO(idProyecto, nombreProyecto, descripcion,
                       capacidadEstudiantes, numEstudiantesAsignados, status, idOrganizacion,
                       idEncargadoProyecto);
               proyectosSolicitados.add(c);
            }
         }
         ps.close();
         rs.close();
         con.close();
      } catch (SQLException e) {
         throw new SQLException("Error en recuperarProyectosSolicitados SQLException " + e.getMessage());
      } catch (NullPointerException e) {
         throw new NullPointerException("Error en recuperarProyectosSolicitados NullPointerException " + e.getMessage());
      }catch (ConnectException e) {
         throw new ConnectException("Error en recuperarProyectosSolicitados ConnectException " + e.getMessage());
      } catch (Exception e) {
         throw new Exception("Error en recuperarProyectosSolicitados Exception " + e.getMessage());
      } finally {
         try {
            if (ps != null) {
               ps.close();
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
      return proyectosSolicitados;
   }

   @Override
   public boolean cambiarEstudiantesAsignados(int idProyecto, int numEstudiantesAsignado, 
           String status) throws Exception {
      boolean changed = false;
      Connection con = null;
      Statement stm = null;
      String sql = "UPDATE proyecto SET status='" + status + "', numEstudiantesAsignados="
              +numEstudiantesAsignado+"  WHERE idProyecto='" + idProyecto + "'";

      try {
         con = new ConexionBD().conectarMySQL();
         stm = con.createStatement();
         stm.execute(sql);
         changed = true;
         stm.close();
         con.close();
      } catch (SQLException e) {
         throw new SQLException("Error en cambiarEstudiantesAsignados SQLException " + e.getMessage());
      } catch (NullPointerException e) {
         throw new NullPointerException("Error en cambiarEstudiantesAsignados NullPointerException " + e.getMessage());
      }catch (ConnectException e) {
         throw new ConnectException("Error en cambiarEstudiantesAsignados ConnectException " + e.getMessage());
      } catch (Exception e) {
         throw new Exception("Error en cambiarEstudiantesAsignados Exception " + e.getMessage());
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
