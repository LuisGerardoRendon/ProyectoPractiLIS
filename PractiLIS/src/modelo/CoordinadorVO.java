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
 * Esta clase contiene la definición de la clase Coordinador, aquí se implementan sus, 
 * constructores, getters y setters de la clase
 * @author Luis Gerardo Rendon
 */
public class CoordinadorVO {

   private String usuario;
   private String contraseña;

   /**
    * Constructor vacio de la clase
    */
   public CoordinadorVO() {
   }

   /**
    * Constructor Parametrizado de la clase
    *
    * @param usuario Define el usuario de la clase
    * @param contraseña Define la contrasenia del Coordinador
    */
   public CoordinadorVO(String usuario, String contraseña) {
      this.usuario = usuario;
      this.contraseña = contraseña;
   }

   /**
    * Constructor con solo la contraseña del Usuario
    *
    * @param contraseña Define la contrasenia del cordinador
    */
   public CoordinadorVO(String contraseña) {
      this.contraseña = contraseña;
      this.usuario = "null";
   }

   /**
    * Metodo para obtener el usuario del Coordinador
    *
    * @return Regresa el Usuario del Coordinador
    */
   public String getUsuario() {
      return usuario;
   }

   /**
    * Metodo para obtener la contrasenia del Coordinador
    *
    * @return Regresa la contrasenia del Coordinador
    */
   public String getContraseña() {
      return contraseña;
   }

   /**
    * Metodo para agregar el usuario de el Coordinador
    *
    * @param usuario Define el usuario de la clase
    */
   public void setUsuario(String usuario) {
      this.usuario = usuario;
   }

   /**
    * Metodo para agregar la contrasenia del coordinador
    *
    * @param contraseña Define la contrasenia del coordinador
    */
   public void setContraseña(String contraseña) {
      this.contraseña = contraseña;
   }

   /**
    * Metodo que cumple la funcion de comparar objetos utilzando estructuras Hash
    *
    * @return Numero entero referente a la estructura del objeto
    */
   @Override
   public int hashCode() {
      int hash = 5;
      hash = 97 * hash + Objects.hashCode(this.usuario);
      hash = 97 * hash + Objects.hashCode(this.contraseña);
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
      final CoordinadorVO other = (CoordinadorVO) obj;
      if (!Objects.equals(this.usuario, other.usuario)) {
         return false;
      }
      if (!Objects.equals(this.contraseña, other.contraseña)) {
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
      return "Coordinador{" + "usuario=" + usuario + ", contrase\u00f1a=" + contraseña + '}';
   }

}
