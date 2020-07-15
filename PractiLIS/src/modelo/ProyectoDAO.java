/**
 * LISTA DE CONTENIDO:
 *    > Paquete de la clase
 *    > Clases y librerias importadas
 *    > Definición de metodos sin implementar de el ProyectoDAO
 */
package modelo;

import javafx.collections.ObservableList;

/**
 * Esta Interface define los metodos correspondientes a el ProyectoDAO
 *
 * @author Daniel Pale Parra
 */
public interface ProyectoDAO {

   public ProyectoVO recuperarProyectoEstudiante(String periodo, String matricula) throws Exception;

   public ObservableList<ProyectoVO> recuperarProyectosSinAsignar() throws Exception;

   public ObservableList<ProyectoVO> recuperarProyectosSolicitados(String matricula) throws Exception;

   public boolean cambiarEstudiantesAsignados(int idProyecto, int numEstudiantesAsignado,
           String status) throws Exception;

   public String crearSQLRecuperarProyectoEstudiante(String periodo, String matricula);
}
