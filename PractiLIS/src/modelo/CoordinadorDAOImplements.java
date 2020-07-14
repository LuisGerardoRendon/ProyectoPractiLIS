/**
 * LISTA DE CONTENIDO:
 *    > Paquete de la clase
 *    > Clases y librerias importadas
 *    > Metodo login
 *    > Metodos creación de sql's
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
 * Descripcion de la clase. La clase CoordinadorDAOImplements tiene el propósito de comunicar la
 * base de datos con el controlador donde se quiera crear, modificar o elimnar entidades o atributos
 * de Coordinador
 *
 * @author Luis Gerardo Rendon
 */
public class CoordinadorDAOImplements implements CoordinadorDAO {

   /**
    * Metodo para verificar que un usuario y su contraseña existan dentro de la base de datos
    *
    * @param matricula Define la matricula con la que esta identificado el coordinador
    * @param contrasenia Define la contraseña dado por el coordinador
    * @return Regresa un valor booleano para determinar si coinciden los datos del usuario
    * @throws Exception Arroja las posibles excepciones durante el proceso
    */
   @Override
   public boolean login(String matricula, String contrasenia) throws Exception {
      String sql = crearSQLrecuperarCoordinador(matricula, contrasenia);
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
         throw new NullPointerException("Error en login NullPointerException "
                 + exception.getMessage());
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

   /**
    * Metodo para la creación de la sql de recuperarCoordinador
    *
    * @param matricula Define la matricula del coordinador
    * @param contrasenia Define la contrasenia del coordinador
    * @return Regresa la cadena de la sentencia
    */
   @Override
   public String crearSQLrecuperarCoordinador(String matricula, String contrasenia) {
      String sql = "SELECT * FROM coordinador WHERE usuario "
              + "= '" + matricula + "'" + "AND contrasenia = '" + contrasenia + "';";

      return sql;
   }

}
