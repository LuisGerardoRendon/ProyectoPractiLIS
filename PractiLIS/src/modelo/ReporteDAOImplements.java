/**
 * LISTA DE CONTENIDO:
 *    > Paquete de la clase
 *    > Clases y librerias importadas
 *    > Metodo create
 *    > Metodo recuperar
 *    > Metodos creación de sql's
 */
package modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Descripcion de la clase. La clase ReporteDAOImplements tiene el propósito de comunicar la base de
 * datos con el controlador donde se quiera crear, modificar o eliminar entidades o atributos de
 * Reporte
 *
 * @author Aldo Colorado
 */
public class ReporteDAOImplements implements ReporteDAO {

   /**
    * Metodo para crear un reporte en la base de datos
    *
    * @param reporte Define el objeto reporte que se esta creando
    * @param idExpediente Define el idExpediente que se relacioará con el Reporte
    * @return Regresa un valor booleano para determinar el exito o fallo en la creación
    * @throws Exception Arroja las excepciones que pudieran presentarse durante el proceso
    */
   @Override
   public boolean create(ReporteVO reporte, int idExpediente) throws Exception {
      boolean created = false;
      PreparedStatement prepareStatement = null;
      Connection connection = null;

      try {
         connection = null;
         ConexionBD conexion = new ConexionBD();
         connection = conexion.conectarMySQL();

         String sql = "INSERT INTO reporte (numero,horasReportadas, fechaCarga, estado, reporte,"
                 + "fechaInicio, fechaFin, idExpediente) VALUES (?, ?, ?, ?, ?, ?,?,?)";
         prepareStatement = connection.prepareStatement(sql);

         prepareStatement.setInt(1, 0);
         prepareStatement.setInt(2, reporte.getHorasReportadas());
         prepareStatement.setString(3, reporte.getFechaCarga());
         prepareStatement.setString(4, reporte.getEstado());
         FileInputStream archivo = new FileInputStream(reporte.getReporte());
         prepareStatement.setBlob(5, archivo);
         prepareStatement.setString(6, reporte.getFechaInicio());
         prepareStatement.setString(7, reporte.getFechaFin());
         prepareStatement.setInt(8, idExpediente);

         prepareStatement.executeUpdate();
         created = true;
         connection.close();
         prepareStatement.close();

      } catch (SQLException exception) {
         throw new SQLException("Error en create SQLException " + exception.getMessage());
      } catch (NullPointerException exception) {
         throw new NullPointerException("Error en create NullPointerException "
                 + exception.getMessage());
      } catch (ConnectException exception) {
         throw new ConnectException("Error en create ConnectException "
                 + exception.getMessage());
      } catch (Exception exception) {
         throw new Exception("Error en create Exception " + exception.getMessage());
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
      return created;
   }

   /**
    * Metodo para recuperar reportes desde la base de datos
    *
    * @param periodo Define el periodo correspondiente de los reportes a recuperar
    * @param matricula Define la matricula del estudiante del que se recuperarán los reportes
    * @return Regresa una lista de los reportes recuperados
    * @throws Exception Arroja las posibles excepciones durante el proceso
    */
   @Override
   public ObservableList<ReporteVO> recuperarReportesDeEstudiante(String periodo, String matricula)
           throws Exception {
      String sql = crearSQLRecuperarReportesDeEstudiante(periodo, matricula);
      ObservableList<ReporteVO> reportesRecuperados = FXCollections.observableArrayList();
      Connection connection = null;
      Statement statement = null;
      ConexionBD conexion = new ConexionBD();
      ResultSet resultset = null;
      try {
         connection = conexion.conectarMySQL();
         statement = connection.createStatement();
         resultset = statement.executeQuery(sql);
         while (resultset.next()) {
            int numero = resultset.getInt("numero");
            int horasReportadas = resultset.getInt("horasReportadas");
            String fechaCarga = resultset.getString("fechaCarga");
            ReporteVO reporteRecuperado = new ReporteVO(numero, horasReportadas, fechaCarga);
            reportesRecuperados.add(reporteRecuperado);
         }
         int contador = 1;
         for (ReporteVO tab : reportesRecuperados) {
            tab.setNumero(contador);
            contador++;
         }

         connection.close();
         statement.close();
         resultset.close();
      } catch (SQLException exception) {
         throw new SQLException("Error en recuperarReportes SQLException "
                 + exception.getMessage());
      } catch (NullPointerException exception) {
         throw new NullPointerException("Error en recuperarReportes NullPointerException "
                 + exception.getMessage());
      } catch (ConnectException exception) {
         throw new ConnectException("Error en recuperarReportes ConnectException "
                 + exception.getMessage());
      } catch (Exception exception) {
         throw new Exception("Error en recuperarReportes Exception "
                 + exception.getMessage());
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
      return reportesRecuperados;
   }

   /**
    * Metodo para la creación de la sentencia sql recuperarReportes
    *
    * @param periodo Define el periodo del que se recuperan los reportes
    * @param matricula Define la matricula del alumno del que se recuperan los reports
    * @return Regresa una cadena del sentencia
    * @throws Exception Arroja las posibles excepciones durante el proceso
    */
   @Override
   public String crearSQLRecuperarReportesDeEstudiante(String periodo, String matricula)
           throws Exception {
      String sql = "SELECT Reporte.numero,Reporte.horasReportadas,"
              + "Reporte.fechaCarga, Reporte.Estado,Reporte.reporte,"
              + " Reporte.fechaInicio, Reporte.fechaFin";
      sql += " FROM Estudiante INNER JOIN Asignacion on Estudiante.matricula "
              + "= Asignacion.matriculaEstudiante";
      sql += " INNER JOIN Expediente on Asignacion.idAsignacion = "
              + "Expediente.idAsignacion ";
      sql += " INNER JOIN Reporte on Expediente.idExpediente = "
              + "Reporte.idExpediente ";
      sql += " WHERE Asignacion.periodo = " + "'" + periodo + "'";
      sql += " AND Asignacion.matriculaEstudiante =" + "'" + matricula + "';";
      System.out.println(sql);
      return sql;
   }

}
