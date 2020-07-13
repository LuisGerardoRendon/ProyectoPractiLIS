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
    * @param idProyecto
    * @param nombre
    * @param descripcion
    * @param capacidadEstudiantes
    * @param numEstudiantesAsignados
    * @param status
    * @param idOrganizacion
    * @param idEncargadoProyecto
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
    * Metodo getIdProyecto que regresa un int con el atributo de la id de Proyecto
    *
    * @return idProyecto
    */
   public int getIdProyecto() {
      return idProyecto;
   }

   /**
    * Metodo getNombre que regresa un String con el atributo del nombre de Proyecto
    *
    * @return nombre
    */
   public String getNombre() {
      return nombre;
   }

   /**
    * Metodo getDescripcion que regresa un String con el atributo de descripcion id de Proyecto
    *
    * @return descripcion
    */
   public String getDescripcion() {
      return descripcion;
   }

   /**
    * Metodo getCapacidadEstudiantes que regresa un int con el atributo de la capacidadEstudiantes
    * de Proyecto
    *
    * @return capacidadEstudiantes
    */
   public int getCapacidadEstudiantes() {
      return capacidadEstudiantes;
   }

   /**
    * Metodo getNumEstudiantesAsignados que regresa un int con el atributo de los
    * numEstudiantesAsignados de Proyecto
    *
    * @return numEstudiantesAsignados
    */
   public int getNumEstudiantesAsignados() {
      return numEstudiantesAsignados;
   }

   /**
    * Metodo getStatus que regresa un String con el atributo del status de Proyecto
    *
    * @return status
    */
   public String getStatus() {
      return status;
   }

   /**
    * Metodo getIdOrganizacion que regresa un int con el atributo de la id de la Organizacion
    * vinculadad con Proyecto
    *
    * @return idOrganizacion
    */
   public int getIdOrganizacion() {
      return idOrganizacion;
   }

   /**
    * Metodo getIdEncargadoProyecto que regresa un int con el atributo de la id de EncargadoProyecto
    * vinculado con Proyecto
    *
    * @return idProyecto
    */
   public int getIdEncargadoProyecto() {
      return idEncargadoProyecto;
   }

   /**
    * Metodo setIdProyecto que cambia el atributo del id de Proyecto
    *
    * @param idProyecto
    */
   public void setIdProyecto(int idProyecto) {
      this.idProyecto = idProyecto;
   }

   /**
    * Metodo setNombre que cambia el atributo del nombre de Proyecto
    *
    * @param nombre
    */
   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   /**
    * Metodo setDescripcion que cambia el atributo de la descripcion de Proyecto
    *
    * @param descripcion
    */
   public void setDescripcion(String descripcion) {
      this.descripcion = descripcion;
   }

   /**
    * Metodo setCapacidadEstudiantes que cambia el atributo de la capacidadEstudiantes de Proyecto
    *
    * @param capacidadEstudiantes
    */
   public void setCapacidadEstudiantes(int capacidadEstudiantes) {
      this.capacidadEstudiantes = capacidadEstudiantes;
   }

   /**
    * Metodo setNumEstudiantesAsignados que cambia el atributo del numEstudiantesAsignados de
    * Proyecto
    *
    * @param numEstudiantesAsignados
    */
   public void setNumEstudiantesAsignados(int numEstudiantesAsignados) {
      this.numEstudiantesAsignados = numEstudiantesAsignados;
   }

   /**
    * Metodo setStatus que cambia el atributo del status de Proyecto
    *
    * @param status
    */
   public void setStatus(String status) {
      this.status = status;
   }

   /**
    * Metodo setIdOrganizacion que cambia el atributo del id de Organizacion vinculada al Proyecto
    *
    * @param idOrganizacion
    */
   public void setIdOrganizacion(int idOrganizacion) {
      this.idOrganizacion = idOrganizacion;
   }

   /**
    * Metodo setIdEncargadoProyecto que cambia el atributo del id de EncargadoProyecto vinculado al
    * Proyecto
    *
    * @param idEncargadoProyecto
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
      final ProyectoVO other = (ProyectoVO) obj;
      return true;
   }

   /**
    *
    * @return
    */
   @Override
   public String toString() {
      return "ProyectoVO{" + "idProyecto=" + idProyecto + ", nombre=" + nombre + ", descripcion=" + descripcion + ", capacidadEstudiantes=" + capacidadEstudiantes + ", numEstudiantesAsignados=" + numEstudiantesAsignados + ", status=" + status + ", idOrganizacion=" + idOrganizacion + ", idEncargadoProyecto=" + idEncargadoProyecto + '}';
   }
}
