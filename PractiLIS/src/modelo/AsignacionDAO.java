/**
 * LISTA DE CONTENIDO:
 *    > Paquete de la clase
 *    > Clases y librerias importadas
 *    > Definición de metodos sin implementar de el AsignacionDAO
 */
package modelo;

import javafx.collections.ObservableList;

/**
 * Esta Interface define los metodos correspondientes a la AsignacionDAO
 *
 * @author Daniel Pale
 */
public interface AsignacionDAO {

   public boolean create(AsignacionVO asignacion) throws Exception;

   public int obtenerIdAsingacion(String matricula, String periodo) throws Exception;
   
   public String obtenerFechaAsignacion(String periodo, String matricula)throws 
           Exception;
   
}
