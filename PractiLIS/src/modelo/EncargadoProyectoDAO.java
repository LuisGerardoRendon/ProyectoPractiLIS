/**
 * LISTA DE CONTENIDO:
 *    > Paquete de la clase
 *    > Clases y librerias importadas
 *    > Definición de metodos sin implemetar del EncargadoProyectoDAO
 */
package modelo;

/**
 * Esta Interface define los metodos correspondientes al EncargadoProyectoDAO
 *
 * @author Luis Gerardo Rendon
 */
public interface EncargadoProyectoDAO {

   EncargadoProyectoVO recuperarEncargadoProyecto(ProyectoVO proyectoVO)throws Exception;

}
