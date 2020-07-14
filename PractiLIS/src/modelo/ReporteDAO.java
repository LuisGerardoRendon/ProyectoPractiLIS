/**
 * LISTA DE CONTENIDO:
 *    > Paquete de la clase
 *    > Clases y librerias importadas
 *    > Definición de metodos sin implementar de el ReporteDAO
 */
package modelo;

import javafx.collections.ObservableList;

/**
 * Esta Interface define los metodos correspondientes a el ReporteDAO
 *
 * @author Aldo Colorado
 */
public interface ReporteDAO {

   boolean create(ReporteVO reporte, int idExpediente) throws Exception;

   public String crearSQLRecuperarReportesDeEstudiante(String periodo, String matricula) 
           throws Exception;

   public ObservableList<ReporteVO> recuperarReportesDeEstudiante(String periodo,
           String matricula) throws Exception;

}
