/**
 * LISTA DE CONTENIDO:
 *    > Paquete de la clase
 *    > Clases y librerias importadas
 *    > Definición de metodos sin implementar de el ExpedienteDAO
 */
package modelo;

/**
 * Esta Interface define los metodos correspondientes a el ExpedienteDAO
 *
 * @author Aldo Ulises Colorado Díaz
 */
public interface ExpedienteDAO {

   public boolean create(ExpedienteVO expediente) throws Exception;

   public ExpedienteVO obtenerExpedienteEstudiante(String matricula) throws Exception;

   public String crearSQLRecuperarExpedienteEstudiante(String matricula);

}
