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
   public ObservableList<ProyectoVO> recuperarProyectosSinAsignar() throws Exception {
      String sql = "SELECT * FROM proyecto WHERE status='Sin asignar'";
      Connection connection = null;
      Statement statement = null;
      ConexionBD conexion = new ConexionBD();
      ResultSet resultset = null;

      ObservableList<ProyectoVO> proyectosRecuperadosList = FXCollections.observableArrayList();
      try {
         connection = conexion.conectarMySQL();
         statement = connection.createStatement();
         resultset = statement.executeQuery(sql);
         while (resultset.next()) {
            int idProyecto = resultset.getInt("idProyecto");
            String nombreProyecto = resultset.getString("nombre");
            String descripcion = resultset.getString("descripcion");
            int capacidadEstudiantes = resultset.getInt("capacidadEstudiantes");
            int numEstudiantesAsignados = resultset.getInt("numEstudiantesAsignados");
            String status = resultset.getString("status");
            int idOrganizacion = resultset.getInt("idOrganizacion");
            int idEncargadoProyecto = resultset.getInt("idEncargadoProyecto");
            int cupo = (capacidadEstudiantes - numEstudiantesAsignados);
            if (cupo > 0) {
               ProyectoVO proyectoRecuperado = new ProyectoVO(idProyecto, nombreProyecto, descripcion,
                       capacidadEstudiantes, numEstudiantesAsignados, status, idOrganizacion,
                       idEncargadoProyecto);
               proyectosRecuperadosList.add(proyectoRecuperado);
            }
         }
         connection.close();
         statement.close();
         resultset.close();
      } catch (SQLException exception) {
         throw new SQLException("Error en recuperarProyectos SQLException " + exception.getMessage());
      } catch (NullPointerException exception) {
         throw new NullPointerException("Error en recuperarProyectos NullPointerException " + exception.getMessage());
      }catch (ConnectException exception) {
         throw new ConnectException("Error en recuperarProyectos ConnectException " + exception.getMessage());
      } catch (Exception exception) {
         throw new Exception("Error en recuperarProyectos Exception " + exception.getMessage());
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
      return proyectosRecuperadosList;
   }

   @Override
   public ProyectoVO recuperarProyectoEstudiante(String periodo, String matricula) throws Exception {
      String sql = crearSQLRecuperarProyectoEstudiante(periodo, matricula);
      ProyectoVO proyectoRecuperado = new ProyectoVO();
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
            String descripcion = resultset.getString("descripcion");
            int capacidadEstudiantes = resultset.getInt("capacidadEstudiantes");
            int numEstudiantesAsignados = resultset.getInt("numEstudiantesAsignados");
            int idProyecto = resultset.getInt("idProyecto");
            String status = resultset.getString("status");
            int idOrganizacion = resultset.getInt("idOrganizacion");
            int idEncargadoProyecto = resultset.getInt("idEncargadoProyecto");
            proyectoRecuperado = new ProyectoVO(idProyecto, nombre, descripcion,
                    capacidadEstudiantes, numEstudiantesAsignados, status,
                    idOrganizacion, idEncargadoProyecto);

         }
         connection.close();
         statement.close();
         resultset.close();
      } catch (SQLException exception) {
         throw new SQLException("Error en recuperarProyectoEstudiante SQLException " + exception.getMessage());
      } catch (NullPointerException exception) {
         throw new NullPointerException("Error en recuperarProyectoEstudiante NullPointerException " + exception.getMessage());
      }catch (ConnectException exception) {
         throw new ConnectException("Error en recuperarProyectoEstudiante ConnectException " + exception.getMessage());
      } catch (Exception exception) {
         throw new Exception("Error en recuperarProyectoEstudiante Exception " + exception.getMessage());
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
      Connection connection = null;
      PreparedStatement prepareStatement = null;
      ResultSet resultset = null;
      String sql = "SELECT p.nombre, p.descripcion, p.capacidadEstudiantes, "
              + "p.numEstudiantesAsignados, p.idProyecto, p.status, p.idOrganizacion,"
              + " p.idEncargadoProyecto FROM proyecto p INNER JOIN solicitud s ON "
              + "s.idProyecto=p.idProyecto WHERE matricula= ? AND s.periodo = 'Ene 2020-Ago 2020'";

      ObservableList<ProyectoVO> proyectosSolicitadosList = FXCollections.observableArrayList();

      try {
         connection = new ConexionBD().conectarMySQL();
         prepareStatement = connection.prepareStatement(sql);
         prepareStatement.setString(1, matricula);
         resultset = prepareStatement.executeQuery();
         while (resultset.next()) {
            int idProyecto = resultset.getInt("idProyecto");
            String nombreProyecto = resultset.getString("nombre");
            String descripcion = resultset.getString("descripcion");
            int capacidadEstudiantes = resultset.getInt("capacidadEstudiantes");
            int numEstudiantesAsignados = resultset.getInt("numEstudiantesAsignados");
            String status = resultset.getString("status");
            int idOrganizacion = resultset.getInt("idOrganizacion");
            int idEncargadoProyecto = resultset.getInt("idEncargadoProyecto");
            int cupo = (capacidadEstudiantes - numEstudiantesAsignados);
            if (cupo > 0) {
               ProyectoVO c = new ProyectoVO(idProyecto, nombreProyecto, descripcion,
                       capacidadEstudiantes, numEstudiantesAsignados, status, idOrganizacion,
                       idEncargadoProyecto);
               proyectosSolicitadosList.add(c);
            }
         }
         prepareStatement.close();
         resultset.close();
         connection.close();
      } catch (SQLException exception) {
         throw new SQLException("Error en recuperarProyectosSolicitados SQLException " + exception.getMessage());
      } catch (NullPointerException exception) {
         throw new NullPointerException("Error en recuperarProyectosSolicitados NullPointerException " + exception.getMessage());
      }catch (ConnectException exception) {
         throw new ConnectException("Error en recuperarProyectosSolicitados ConnectException " + exception.getMessage());
      } catch (Exception exception) {
         throw new Exception("Error en recuperarProyectosSolicitados Exception " + exception.getMessage());
      } finally {
         try {
            if (prepareStatement != null) {
               prepareStatement.close();
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
      return proyectosSolicitadosList;
   }

   @Override
   public boolean cambiarEstudiantesAsignados(int idProyecto, int numEstudiantesAsignado, 
           String status) throws Exception {
      boolean changed = false;
      Connection connection = null;
      Statement statement = null;
      String sql = "UPDATE proyecto SET status='" + status + "', numEstudiantesAsignados="
              +numEstudiantesAsignado+"  WHERE idProyecto='" + idProyecto + "'";

      try {
         connection = new ConexionBD().conectarMySQL();
         statement = connection.createStatement();
         statement.execute(sql);
         changed = true;
         statement.close();
         connection.close();
      } catch (SQLException exception) {
         throw new SQLException("Error en cambiarEstudiantesAsignados SQLException " + exception.getMessage());
      } catch (NullPointerException exception) {
         throw new NullPointerException("Error en cambiarEstudiantesAsignados NullPointerException " + exception.getMessage());
      }catch (ConnectException exception) {
         throw new ConnectException("Error en cambiarEstudiantesAsignados ConnectException " + exception.getMessage());
      } catch (Exception exception) {
         throw new Exception("Error en cambiarEstudiantesAsignados Exception " + exception.getMessage());
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
