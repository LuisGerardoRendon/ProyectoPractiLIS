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
 * Esta clase contiene la definición de la clase estudiante, aqui se implementan sus
 * metodos(Constructores, getters, setters)
 *
 * @author Daniel Pale
 */
public class EstudianteVO {

   private String matricula;
   private String contrasenia;
   private String nombre;
   private String correo;
   private String status;

   /**
    * Constructor vacio de la clase
    */
   public EstudianteVO() {
      this.matricula = "null";
      this.contrasenia = "null";
      this.nombre = "null";
      this.correo = "null";
      this.status = "null";
   }

   /**
    * Constructor parametrizado de la clase
    *
    * @param matricula Define la matricula del estudiante
    * @param contrasenia Define la contrasenia del estudiante
    * @param nombre Define el nombre del estudiante
    * @param correoElectronico Define el correco electronico del estudiante
    * @param status Define el estatus del estudiante
    */
   public EstudianteVO(String matricula, String contrasenia, String nombre, String correoElectronico,
           String status) {
      this.matricula = matricula;
      this.contrasenia = contrasenia;
      this.nombre = nombre;
      this.correo = correoElectronico;
      this.status = status;
   }

   /**
    * Constructor con dos parametros de la clase
    *
    * @param nombre Define el nombre del estudiante
    * @param matricula Define la matricula del estudiante
    */
   public EstudianteVO(String nombre, String matricula) {
      this.nombre = nombre;
      this.matricula = matricula;
   }

   /**
    * Metodo para obtener la matricula del estudiante
    *
    * @return Regresa la matricula del estudiante
    */
   public String getMatricula() {
      return matricula;
   }

   /**
    * Metodo para obtener la contrasenia del estudiante
    *
    * @return Regresa la contrasenia del estudiante
    */
   public String getContrasenia() {
      return contrasenia;
   }

   /**
    * Metodo para obtener el nombre del estudiante
    *
    * @return Regresa el nombre del estudiante
    */
   public String getNombre() {
      return nombre;
   }

   /**
    * Metodo para obtener el correco electronico del estudiante
    *
    * @return Regresa el coorreco electonico
    */
   public String getCorreoElectronico() {
      return correo;
   }

   /**
    * Metodo para obtener el estatus del estudiante
    *
    * @return Regresa el estatus del estudiante
    */
   public String getStatus() {
      return status;
   }

   /**
    * Metodo para agregar la matricula del estudiante
    *
    * @param matricula Define la matricula del estudiante
    */
   public void setMatricula(String matricula) {
      this.matricula = matricula;
   }

   /**
    * Metodo para agregar la contrasenia del Estudiante
    *
    * @param contrasenia Define la contrasenia del estudiante
    */
   public void setContrasenia(String contrasenia) {
      this.contrasenia = contrasenia;
   }

   /**
    * Metodo para agregar el nombre del estudiante
    *
    * @param nombre Define el nombre del estudiante
    */
   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   /**
    * Metodo para agregar el correo electronico
    *
    * @param correoElectronico Define el correco electronico del estudiante
    */
   public void setCorreoElectronico(String correoElectronico) {
      this.correo = correoElectronico;
   }

   /**
    * Metodo para agregar el estatus del estudiante
    *
    * @param status Define el estatus del estudiante
    */
   public void setStatus(String status) {
      this.status = status;
   }

   /**
    * Metodo que cumple la funcion de comparar objetos utilzando estructuras Hash
    *
    * @return Numero entero referente a la estructura del objeto
    */
   @Override
   public int hashCode() {
      int hash = 3;
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
      if (obj == null) {
         return false;
      }
      if (getClass() != obj.getClass()) {
         return false;
      }
      final EstudianteVO other = (EstudianteVO) obj;
      if (!Objects.equals(this.matricula, other.matricula)) {
         return false;
      }
      if (!Objects.equals(this.contrasenia, other.contrasenia)) {
         return false;
      }
      if (!Objects.equals(this.nombre, other.nombre)) {
         return false;
      }
      if (!Objects.equals(this.correo, other.correo)) {
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
      return "EstudianteVO{" + "matricula=" + matricula + ", contrasenia=" + contrasenia
              + ", nombre=" + nombre + ", correo=" + correo + ", status="
              + status + '}';
   }

}
