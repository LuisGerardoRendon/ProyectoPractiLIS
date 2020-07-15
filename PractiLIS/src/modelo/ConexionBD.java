/**
 * LISTA DE CONTENIDOS:
 *    > Paquete de la clase
 *    > Clases o librerias utilizadas
 *    > Declaración de atributos
 *    > Metodo conectarMySql
 */
package modelo;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Esta clase es la encargada de definir el todos los elementos que se necesitan para hacer la
 * conexion a la base de datos como : El controlador jdbc, el nombre de la base de datos, el host,
 * el puerto, el nombre de usuario y su contraseña, para despues poder realizar una conexión exitosa.
 * @author Luis Gerardo Rendon Martinez
 */

public class ConexionBD {

   // Librería de MySQL
   public String driver = "com.mysql.jdbc.Driver";

   // Nombre de la base de datos
   public String database = "practilis2";

   // Host
   public String hostname = "localhost";

   // Puerto
   public String port = "3306";

   // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
   public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";

   // Nombre de usuario
   public String username = "root";

   // Clave de usuario
   public String password = "123456";

   /**
    * Metodo que hace la conexión entre java y el controlador de base de datos MySQL
    *
    * @return Regresa un objeto Connection en caso de exito
    * @throws Exception Lanza las posibles excepciones dadas en el proceso
    */
   public Connection conectarMySQL() throws Exception {
      Connection conn = null;

      try {
         Class.forName(driver);
         conn = DriverManager.getConnection(url, username, password);

      } catch (SQLException e) {
         throw new SQLException("Error en recuperarReportes SQLException " + e.getMessage());
      } catch (NullPointerException e) {
         throw new NullPointerException("Error en recuperarReportes NullPointerException " + 
                 e.getMessage());
      } catch (Exception e) {
         throw new Exception("Error en recuperarReportes Exception " + e.getMessage());
      }

      return conn;
   }

}
