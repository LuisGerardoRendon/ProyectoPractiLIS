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
 * Descripción de la clase: La clase ProyectoVO es la que almacena las caracteristicas (atributos) y
 * comportamientos (métodos) de las entidades de Proyecto.
 *
 * @author Aldo Ulises Colorado Diaz
 */
public class ProyectoVO {

   private int idProyecto;
   private String nombre;
   private String descripcion;
   private int capacidadEstudiantes;
   private int numEstudiantesAsignados;
   private String status;
   private int idOrganizacion;
   private int idEncargadoProyecto;

   /**
    * Constructor vacío
    */
   public ProyectoVO() {
   }

   /**
    * Constructor parametrizado
    *
    * @param idProyecto Define el idProyecto de la Proyecto
    * @param nombre Define el nombre de la Proyecto
    * @param descripcion Define la descripcion de la Proyecto
    * @param capacidadEstudiantes Define la capacidadEstudiantes de la Proyecto
    * @param numEstudiantesAsignados Define el numEstudiantesAsignados de la Proyecto
    * @param status Define el status de la Proyecto
    * @param idOrganizacion Define el idOrganización de la Organizacion relacionada con Proyecto
    * @param idEncargadoProyecto Define el idEncargadoProyecto del EncargadoProyecto relacionado con
    * Proyecto
    */
   public ProyectoVO(int idProyecto, String nombre, String descripcion, int capacidadEstudiantes,
           int numEstudiantesAsignados, String status, int idOrganizacion, int idEncargadoProyecto) {
      this.idProyecto = idProyecto;
      this.nombre = nombre;
      this.descripcion = descripcion;
      this.capacidadEstudiantes = capacidadEstudiantes;
      this.numEstudiantesAsignados = numEstudiantesAsignados;
      this.status = status;
      this.idOrganizacion = idOrganizacion;
      this.idEncargadoProyecto = idEncargadoProyecto;
   }

   /**
    * Metodo para obtener el idProyecto de Proyecto
    *
    * @return Regresa el id de Proyecto
    */
   public int getIdProyecto() {
      return idProyecto;
   }

   /**
    * Metodo para obtener el nombre de Proyecto
    *
    * @return Regresa el nombre de Proyecto
    */
   public String getNombre() {
      return nombre;
   }

   /**
    * Metodo para obtener la descripcion de Proyecto
    *
    * @return Regresa la descripcion de Proyecto
    */
   public String getDescripcion() {
      return descripcion;
   }

   /**
    * Metodo para obtener la capacidadEstudiantes de Proyecto
    *
    * @return Regresa la capacidadEstudiantes de Proyecto
    */
   public int getCapacidadEstudiantes() {
      return capacidadEstudiantes;
   }

   /**
    * Metodo para obtener el numEstudiantesAsignados de Proyecto
    *
    * @return Regresa el numEstudiantesAsignados de Proyecto
    */
   public int getNumEstudiantesAsignados() {
      return numEstudiantesAsignados;
   }

   /**
    * Metodo para obtener el status de Proyecto
    *
    * @return Regresa el status de Proyecto
    */
   public String getStatus() {
      return status;
   }

   /**
    * Metodo para obtener el idOrganizacion de la Organizacion relacionado con Proyecto
    *
    * @return Regresa el idOrganizacion de la Organizacion relacionado con Proyecto
    */
   public int getIdOrganizacion() {
      return idOrganizacion;
   }

   /**
    * Metodo para obtener el idEncargadoProyecto del EncargadoProyecto relacionado con Proyecto
    *
    * @return Regresa el idEncargadoProyecto del EncargadoProyecto relacionado con Proyecto
    */
   public int getIdEncargadoProyecto() {
      return idEncargadoProyecto;
   }

   /**
    * Metodo para modificar el idProyecto al Proyecto
    *
    * @param idProyecto Define el idProyecto de Proyecto
    */
   public void setIdProyecto(int idProyecto) {
      this.idProyecto = idProyecto;
   }

   /**
    * Metodo para modificar el nombre al Proyecto
    *
    * @param nombre Define el nombre de Proyecto
    */
   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   /**
    * Metodo para modificar la descripcion al Proyecto
    *
    * @param descripcion Define la descripcion de Proyecto
    */
   public void setDescripcion(String descripcion) {
      this.descripcion = descripcion;
   }

   /**
    * Metodo para modificar la capacidadEstudiantes al Proyecto
    *
    * @param capacidadEstudiantes Define la capacidadEstudiantes de Proyecto
    */
   public void setCapacidadEstudiantes(int capacidadEstudiantes) {
      this.capacidadEstudiantes = capacidadEstudiantes;
   }

   /**
    * Metodo para modificar el numEstudiantesAsignados a Proyecto
    *
    * @param numEstudiantesAsignados Define el numEstudiantesAsignados de Proyecto
    */
   public void setNumEstudiantesAsignados(int numEstudiantesAsignados) {
      this.numEstudiantesAsignados = numEstudiantesAsignados;
   }

   /**
    * Metodo para modificar el status a Proyecto
    *
    * @param status Define el status de Proyecto
    */
   public void setStatus(String status) {
      this.status = status;
   }

   /**
    * Metodo para modificar el idOrganizacion de la Organizacion realcionada con Proyecto
    *
    * @param idOrganizacion Define el idOrganizacion de la Organizacion realcionada con Proyecto
    */
   public void setIdOrganizacion(int idOrganizacion) {
      this.idOrganizacion = idOrganizacion;
   }

   /**
    * Metodo para modificar el idEncargadoProyecto del EncargadoProyecto relacionado con Proyecto
    *
    * @param idEncargadoProyecto Define el idEncargadoProyecto relacionado con Proyecto
    */
   public void setIdEncargadoProyecto(int idEncargadoProyecto) {
      this.idEncargadoProyecto = idEncargadoProyecto;
   }

   /**
    * Método que cumple la función de comparar objetos utilizando estructuras hash
    *
    * @return Numero entero referente a la estructura del objeto
    */
   @Override
   public int hashCode() {
      int hash = 3;
      hash = 29 * hash + this.idProyecto;
      hash = 29 * hash + Objects.hashCode(this.nombre);
      hash = 29 * hash + Objects.hashCode(this.descripcion);
      hash = 29 * hash + this.capacidadEstudiantes;
      hash = 29 * hash + this.numEstudiantesAsignados;
      hash = 29 * hash + Objects.hashCode(this.status);
      hash = 29 * hash + this.idOrganizacion;
      hash = 29 * hash + this.idEncargadoProyecto;
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
      final ProyectoVO other = (ProyectoVO) obj;
      return true;
   }

   /**
    * Metodo para obtener la información completa del objeto
    *
    * @return Regresa la información compelta del objeto
    */
   @Override
   public String toString() {
      return "ProyectoVO{" + "idProyecto=" + idProyecto + ", nombre=" + nombre + ", descripcion="
              + descripcion + ", capacidadEstudiantes=" + capacidadEstudiantes
              + ", numEstudiantesAsignados=" + numEstudiantesAsignados + ", status="
              + status + ", idOrganizacion=" + idOrganizacion + ", idEncargadoProyecto="
              + idEncargadoProyecto + '}';
   }
}
