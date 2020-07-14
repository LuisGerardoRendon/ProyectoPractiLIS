/**
 * LISTA DE CONTENIDO:
 *    > Paquete de la clase
 *    > Clases y librerias importadas
 *    > Definición de metodos sin implemetar del ReportaDAO
 */
package modelo;

/**
 * Esta Interface define los metodos correspondientes al CoordinadorDAO
 *
 * @author Luis Gerardo Rendon
 */
public interface CoordinadorDAO {

   public boolean login(String usuario, String contrasenia) throws Exception;

   public String crearSQLrecuperarCoordinador(String usuario, String contrasenia);
}
