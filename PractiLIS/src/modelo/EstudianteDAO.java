/**
 * LISTA DE CONTENIDO:
 *    > Paquete de la clase
 *    > Clases y librerias importadas
 *    > Definición de metodos sin implementar de el EstudianteDAO
 */
package modelo;

import javafx.collections.ObservableList;

/**
 * Esta Interface define los metodos correspondientes a la EstudianteDAO
 *
 * @author Luis Gerardo Rendon Martínez
 */
public interface EstudianteDAO {

   public EstudianteVO recuperarEstudiante(String matricula, String contrasenia) throws Exception;

   public ObservableList<EstudianteVO> recuperarEstudiantesSinAsignar() throws Exception;

   public boolean cambiarStatusAsignado(String matricula) throws Exception;

   public String crearSQLestaRegistrado(String matricula, String contrasenia);

}
