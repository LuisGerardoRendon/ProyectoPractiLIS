/**
 * LISTA DE CONTENIDO:
 *    > Paquete de la clase
 *    > Clases y librerias importadas
 *    > Atributos de la clase
 *    > Constructores de la clase
 *    > Metodos getters
 *    > Metodos setters
 *    > Otros metodos
 */
package modelo;

import java.util.Objects;

/**
 * Esta clase contiene la definición de Encargado Proyecto, se definen sus metodos(Constructores,
 * getters, setters)
 *
 * @author Luis Gerardo Rendon
 */
public class EncargadoProyectoVO {

   private int idEncargadoProyecto;
   private String nombre;
   private String cargo;
   private String correoElectronico;

   /**
    * Constructor vacio de la clase
    */
   public EncargadoProyectoVO() {
   }

   /**
    * Constructor parametrizado de la clase
    *
    * @param idEncargadoProyecto Define el id del Encargado del proyecto
    * @param nombre Define el nombre del Encargado del Proyecto
    * @param cargo Define el cargo del Encargado del proyecto
    * @param correoElectronico Define el correo electronico del Encargado del proyecto
    */
   public EncargadoProyectoVO(int idEncargadoProyecto, String nombre, String cargo,
           String correoElectronico) {
      this.idEncargadoProyecto = idEncargadoProyecto;
      this.nombre = nombre;
      this.cargo = cargo;
      this.correoElectronico = correoElectronico;
   }

   /**
    * Constructor con 3 parametros
    *
    * @param nombre Define el nombre del Encargado del proyecto
    * @param cargo Define el cargo del Encargado del proyecto
    * @param correoElectronico Define el correo del Encargado del Proyecto
    */
   public EncargadoProyectoVO(String nombre, String cargo, String correoElectronico) {
      this.nombre = nombre;
      this.cargo = cargo;
      this.correoElectronico = correoElectronico;
   }

   /**
    * Metodo para obtener el idEncargadoProyecto
    *
    * @return Regresa el idEncargadoProyecto
    */
   public int getIdEncargadoProyecto() {
      return idEncargadoProyecto;
   }

   /**
    * Metodo para obtener el nombre del Encargado del proyecto
    *
    * @return Regresa el nombre del Encargado del Proyecto
    */
   public String getNombre() {
      return nombre;
   }

   /**
    * Metodo para obtener el cardo del Encargado del proyecto
    *
    * @return Regresa el cardo del Encargado del proyecto
    */
   public String getCargo() {
      return cargo;
   }

   /**
    * Metodo para obtener el correo electronico del Encargado del Proyecto
    *
    * @return Regresa el correo electronico
    */
   public String getCorreoElectronico() {
      return correoElectronico;
   }

   /**
    * Metodo para agregar el idEncargadoProyecto
    *
    * @param idEncargadoProyecto Define el idEncargadoProyecto
    */
   public void setIdEncargadoProyecto(int idEncargadoProyecto) {
      this.idEncargadoProyecto = idEncargadoProyecto;
   }

   /**
    * Metodo para agregar el nombre del Encargado del proyecto
    *
    * @param nombre Define el nombre del encargado del proyecto
    */
   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   /**
    * Metodo para agregar el cardo del Encargado del proyecto
    *
    * @param cargo Define el cargo
    */
   public void setCargo(String cargo) {
      this.cargo = cargo;
   }

   /**
    * Metodo para agregar el correo electronico del Encargado del proyecto
    *
    * @param correoElectronico Define el correo electronico
    */
   public void setCorreoElectronico(String correoElectronico) {
      this.correoElectronico = correoElectronico;
   }

   /**
    * Metodo que cumple la funcion de comparar objetos utilzando estructuras Hash
    *
    * @return Numero entero referente a la estructura del objeto
    */
   @Override
   public int hashCode() {
      int hash = 3;
      hash = 23 * hash + this.idEncargadoProyecto;
      hash = 23 * hash + Objects.hashCode(this.nombre);
      hash = 23 * hash + Objects.hashCode(this.cargo);
      hash = 23 * hash + Objects.hashCode(this.correoElectronico);
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
      final EncargadoProyectoVO other = (EncargadoProyectoVO) obj;
      if (this.idEncargadoProyecto != other.idEncargadoProyecto) {
         return false;
      }
      if (!Objects.equals(this.nombre, other.nombre)) {
         return false;
      }
      if (!Objects.equals(this.cargo, other.cargo)) {
         return false;
      }
      if (!Objects.equals(this.correoElectronico, other.correoElectronico)) {
         return false;
      }
      return true;
   }

   /**
    * Metodo para obtener la información completa del objeto
    *
    * @return Regresa la información completa del objeto
    */
   @Override
   public String toString() {
      return "EncargadoProyectoVO{" + "idEncargadoProyecto=" + idEncargadoProyecto + ", nombre=" + nombre + ", cargo=" + cargo + ", correoElectronico=" + correoElectronico + '}';
   }
}
