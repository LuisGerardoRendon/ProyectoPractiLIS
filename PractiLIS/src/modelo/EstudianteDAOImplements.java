/**
 * Lista de contenido. 
 * > Paquete
 * > Clases o librerias ocupadas
 * > Métodos de recuperación
 * > Métodos de actualización
 * > Métodos de sentencias sql
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
 * Descripcion de la clase. La clase EstudianteDAOImplements tiene el propósito de comunicar la base
 * de datos con el controlador donde se quiera crear, modificar o elimnar entidades o atributos de
 * Estudiante
 * 
 * @author Luis Gerardo Rendon Martínez
 */
public class EstudianteDAOImplements implements EstudianteDAO {

   /**
    * Método que recupera un Estudiante de la base de datos
    *
    * @param matricula Define la matricula del Estudiante
    * @param contrasenia Define la contrasenia del Estudiante
    * @return Regresa al Estudiante
    * @throws Exception Arroja las posibles excepciones durante el proceso
    */
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
      } catch (ConnectException exception) {
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

   /**
    * Método que recupera todos los Estudiantes que tengan el status "Sin asignar"
    *
    * @return Regresa una lista con todos los Estudiantes con el status "Sin asignar"
    * @throws Exception Arroja las posibles excepciones durante el proceso
    */
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
      } catch (ConnectException exception) {
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

   /**
    * Método que cambia el status de un Estudiante
    *
    * @param matricula Define la matricula del Estudiante
    * @return Regresa true si la ejecución del método fue éxitosamente, de lo contrario regresa
    * false
    * @throws Exception Arroja las posibles excepciones durante el proceso
    */
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
      } catch (ConnectException exception) {
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

   /**
    * Metodo que crea una sentencia de sql para validar si un Estudiante está registrado en la base
    * de datos
    *
    * @param matricula Define la matricula del Estudiante
    * @param contrasenia Define la contrasenia del Estudiante
    * @return Regresa un String con la sentencia de sql
    */
   @Override
   public String crearSQLestaRegistrado(String matricula, String contrasenia) {
      String sql = "SELECT * FROM Estudiante WHERE matricula = '" + matricula;
      sql += "' AND contrasenia = '" + contrasenia + "';";
      return sql;
   }
}
