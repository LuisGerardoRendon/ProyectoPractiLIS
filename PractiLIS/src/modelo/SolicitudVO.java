/**
 * Lista de contenido. 
 * > Atributos de la clase  
 * > Constructores de la clase  
 * > Getters de la clase  
 * > Setters de la clase  
 * > Métodos de la clase 
 */
package modelo;

import java.util.Objects;

/**
 * Descripción de la clase: La clase SolicitudVO es la que almacena las caracteristicas (atributos)
 * y comportamientos (métodos) de las entidades de Solicitud.
 *
 * @author Aldo Ulises Colorado Díaz
 */
public class SolicitudVO {

   private String periodo;
   private String fecha;
   private int idProyecto;
   private String matricula;

   /**
    * Constructor vacío
    */
   public SolicitudVO() {
   }

   /**
    * Constructor parametrizado
    *
    * @param periodo Define el periodo de la Solicitud
    * @param fecha Define la fecha de la Solicitud
    * @param idProyecto Define el id de Proyecto relacionado con Solicitud
    * @param matricula Define la matricula de Estudiante relacionada con Solicitud
    */
   public SolicitudVO(String periodo, String fecha, int idProyecto, String matricula) {
      this.periodo = periodo;
      this.fecha = fecha;
      this.idProyecto = idProyecto;
      this.matricula = matricula;
   }

   /**
    * Metodo para obtener el periodo de Solicitud
    *
    * @return Regresa el periodo de Solicitud
    */
   public String getPeriodo() {
      return periodo;
   }

   /**
    * Metodo para obtener la fecha de Solicitud
    *
    * @return Regresa la fecha de Solicitud
    */
   public String getFecha() {
      return fecha;
   }

   /**
    * Metodo para obtener el id de Proyecto relacionado con Solicitud
    *
    * @return Regresa el id de Proyecto relacionado con Solicitud
    */
   public int getIdProyecto() {
      return idProyecto;
   }

   /**
    * Metodo para obtener la matricula de Estudiante relacionada con Solicitud
    *
    * @return Regresa la matricula de Estudiante relacionada con Solicitud
    */
   public String getMatricula() {
      return matricula;
   }

   /**
    * Metodo para modificar el periodo de Solicitud
    *
    * @param periodo Define el periodo de Solicitud
    */
   public void setPeriodo(String periodo) {
      this.periodo = periodo;
   }

   /**
    * Metodo para modificar la fecha de Solicitud
    *
    * @param fecha Define la fecha de Solicitud
    */
   public void setFecha(String fecha) {
      this.fecha = fecha;
   }

   /**
    * Metodo para modificar el id de Proyecto relacionado con Solicitud
    *
    * @param idProyecto Define el id de Proyecto relacionado con Solicitud
    */
   public void setIdProyecto(int idProyecto) {
      this.idProyecto = idProyecto;
   }

   /**
    * Metodo para modificar la matricula de Estudiante relacionada con Solicitud
    *
    * @param matricula Define la matricula de Estudiante relacionada con Solicitud
    */
   public void setMatricula(String matricula) {
      this.matricula = matricula;
   }

   /**
    * Método que cumple la función de comparar objetos utilizando estructuras hash
    *
    * @return Numero entero referente a la estructura del objeto
    */
   @Override
   public int hashCode() {
      int hash = 7;
      hash = 71 * hash + Objects.hashCode(this.periodo);
      hash = 71 * hash + Objects.hashCode(this.fecha);
      hash = 71 * hash + Objects.hashCode(this.idProyecto);
      hash = 71 * hash + Objects.hashCode(this.matricula);
      return hash;
   }

   /**
    * Metodo para evitar que un objeto se repita
    *
    * @param obj Objeto que sera comparado
    * @return Indica si el objeto ya existe o no
    */
   @Override
   public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      }
      if (obj == null) {
         return false;
      }
      if (getClass() != obj.getClass()) {
         return false;
      }
      final SolicitudVO other = (SolicitudVO) obj;
      return true;
   }

   /**
    * Metodo para obtener la información completa del objeto
    *
    * @return Regresa la información compelta del objeto
    */
   @Override
   public String toString() {
      return "SolicitudVO{" + "periodo=" + periodo + ", fecha=" + fecha + ", idProyecto="
              + idProyecto + ", matricula=" + matricula + '}';
   }

}
