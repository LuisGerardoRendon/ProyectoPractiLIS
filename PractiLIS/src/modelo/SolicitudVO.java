/*
 * Lista de contenido. 
 * > Atributos de la clase line: 
 * > Constructores de la clase line: 
 * > Getters de la clase line: 
 * > Setters de la clase line: 
 * > Métodos de la clase line:
 */
package modelo;

import java.util.Objects;

/**
 * Descripción de la clase: La clase SolicitudVO es la que almacena las caracteristicas
 * (atributos) y comportamientos (métodos) de las entidades de Solicitud.
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
    * @param periodo
    * @param fecha
    * @param idProyecto
    * @param matricula 
    */
   public SolicitudVO(String periodo, String fecha, int idProyecto, String matricula) {
      this.periodo = periodo;
      this.fecha = fecha;
      this.idProyecto = idProyecto;
      this.matricula = matricula;
   }

    /**
    * Metodo getPeriodo que regresa un String con el atributo del periodo de Solicitud
    *
    * @return periodo
    */
   public String getPeriodo() {
      return periodo;
   }

   /**
    * Metodo getFecha que regresa un String con el atributo de la fecha de Solicitud
    *
    * @return fecha
    */
   public String getFecha() {
      return fecha;
   }

   /**
    * Metodo getIdProyecto que regresa un int con el atributo del id de Proyecto vinculado 
    * con Solicitud
    *
    * @return idProyecto
    */
   public int getIdProyecto() {
      return idProyecto;
   }

   /**
    * Metodo getMatricula que regresa un String con el atributo de la matricula de estudiante
    * vinculada con Solicitud
    *
    * @return matricula
    */
   public String getMatricula() {
      return matricula;
   }

   /**
    * Metodo setPeriodo que cambia el atributo del periodo de Solicitud
    *
    * @param periodo
    */
   public void setPeriodo(String periodo) {
      this.periodo = periodo;
   }

   /**
    * Metodo setFecha que cambia el atributo de la fecha de Solicitud
    *
    * @param fecha
    */
   public void setFecha(String fecha) {
      this.fecha = fecha;
   }

   /**
    * Metodo setIdProyecto que cambia el atributo del id de Proyecto vinculado con Solicitud
    *
    * @param idProyecto
    */
   public void setIdProyecto(int idProyecto) {
      this.idProyecto = idProyecto;
   }

   /**
    * Metodo setMatricula que cambia el atributo de la matricula de Estudiante vinculado con
    * Solicitud
    *
    * @param matricula
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
    * 
    * @param obj
    * @return 
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
    * 
    * @return 
    */
   @Override
   public String toString() {
      return "SolicitudVO{" + "periodo=" + periodo + ", fecha=" + fecha + ", idProyecto=" + idProyecto + ", matricula=" + matricula + '}';
   }
   
   
    
}
