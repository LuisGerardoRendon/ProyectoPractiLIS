/**
 * LISTA DE CONTENIDO:
 *    > Paquete de la clase
 *    > Clases y librerias importadas
 *    > Metodo recuperarEncargadoProyecto
 */
package modelo;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Descripcion de la clase. La clase EncargadoProyectoDAOImplements tiene el propósito de 
 * comunicar la base de datos con el controlador donde se quiera 
 * crear, modificar o elimnar entidades o atributos de EncargadoProyecto
 * 
 * @author Luis Gerardo Rendon
 */
public class EncargadoProyectoDAOImplements implements EncargadoProyectoDAO {

   /**
    * Metodo para recuperar el encargado de un proyecto
    *
    * @param proyectoVO Objeto que define el proyecto del que se recupera el encargado
    * @return Regresa un objeto de tipo EncargadoProyecto
    * @throws Exception arroja las posibles excepciones durante el proceso
    */
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
