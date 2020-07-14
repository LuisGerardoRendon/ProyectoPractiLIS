/**
 * Lista de contenido. 
 * > Paquete
 * > Clases o librerias ocupadas
 * > Métodos de creación
 * > Métodos de recuperación 
 */
package modelo;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Descripcion de la clase. La clase AsignacionDAOImplements tiene el propósito de comunicar la base
 * de datos con el controlador donde se quiera crear, modificar o elimnar entidades o atributos de
 * Asignacion
 *
 * @author Daniel Pale
 */
public class AsignacionDAOImplements implements AsignacionDAO {

   /**
    * Método para crear una Asignación en la base de datos
    *
    * @param asignacion Define el objeto Asignacion que se esta creando
    * @return Regresa true si la creación se realizo con éxito y de lo contrario regresa false
    * @throws Exception Arroja las posibles excepciones durante el proceso
    */
   @Override
   public boolean create(AsignacionVO asignacion) throws Exception {
      boolean created = false;
      Connection connection = null;
      Statement statement = null;
      ResultSet resultSet = null;
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
      } catch (SQLException exception) {
         throw new SQLException("Error en create SQLException " + exception.getMessage());
      } catch (NullPointerException exception) {
         throw new NullPointerException("Error en create NullPointerException " + exception.getMessage());
      } catch (ConnectException exception) {
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

   /**
    * Método que obtiene el atributo id de Asignación
    *
    * @param matricula Define la matricula del Estudiante relacionado con Asignacion
    * @param periodo Define el periodo del cual se quiere recuperar la Asingacion
    * @return Regresa el valor de id de Asignacion
    * @throws Exception Arroja las posibles excepciones durante el proceso
    */
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
         if (resultset.next()) {
            idAsignacion = resultset.getInt("idAsignacion");
         }
         statement.close();
         resultset.close();
         connection.close();
      } catch (SQLException exception) {
         throw new SQLException("Error en obtenerIdAsingacion SQLException " + exception.getMessage());
      } catch (NullPointerException exception) {
         throw new NullPointerException("Error en obtenerIdAsingacion NullPointerException " + exception.getMessage());
      } catch (ConnectException exception) {
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
