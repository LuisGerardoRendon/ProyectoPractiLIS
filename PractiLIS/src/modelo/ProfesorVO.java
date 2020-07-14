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
 * Descripción de la clase: La clase ProfesorVO es la que almacena las caracteristicas (atributos) y
 * comportamientos (métodos) de las entidades de Profesor.
 *
 * @author Daniel Pale
 */
public class ProfesorVO {

   private String matricula;
   private String constrasenia;
   private String usuario;

   /**
    * Constructor vacío
    */
   public ProfesorVO() {
   }

   /**
    * Constructor parametrizado
    *
    * @param matricula Define la matricula del Profesor
    * @param constrasenia Define la constrasenia del Profesor
    * @param usuario Define el usuario del Profesor
    */
   public ProfesorVO(String matricula, String constrasenia, String usuario) {
      this.matricula = matricula;
      this.constrasenia = constrasenia;
      this.usuario = usuario;
   }

   /**
    * Metodo para obtener la matricula del Profesor
    *
    * @return Regresa la matricula del Profesor
    */
   public String getMatricula() {
      return matricula;
   }

   /**
    * Metodo para obtener la constrasenia del Profesor
    *
    * @return Regresa la constrasenia del Profesor
    */
   public String getConstrasenia() {
      return constrasenia;
   }

   /**
    * Metodo para obtener el usuario del Profesor
    *
    * @return Regresa el usuario del Profesor
    */
   public String getUsuario() {
      return usuario;
   }

   /**
    * Metodo para actualizar la matricua del Profesor
    *
    * @param matricula Define la matricula del Profesor
    */
   public void setMatricula(String matricula) {
      this.matricula = matricula;
   }

   /**
    * Metodo para actualizar la constrasenia del Profesor
    *
    * @param constrasenia Define la constrasenia del Profesor
    */
   public void setConstrasenia(String constrasenia) {
      this.constrasenia = constrasenia;
   }

   /**
    * Metodo para actualizar el usuario del Profesor
    *
    * @param usuario Define el usuario del Profesor
    */
   public void setUsuario(String usuario) {
      this.usuario = usuario;
   }

   /**
    * Método que cumple la función de comparar objetos utilizando estructuras hash
    *
    * @return Numero entero referente a la estructura del objeto
    */
   @Override
   public int hashCode() {
      int hash = 7;
      hash = 79 * hash + Objects.hashCode(this.matricula);
      hash = 79 * hash + Objects.hashCode(this.constrasenia);
      hash = 79 * hash + Objects.hashCode(this.usuario);
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
      final ProfesorVO other = (ProfesorVO) obj;
      if (!Objects.equals(this.matricula, other.matricula)) {
         return false;
      }
      if (!Objects.equals(this.constrasenia, other.constrasenia)) {
         return false;
      }
      if (!Objects.equals(this.usuario, other.usuario)) {
         return false;
      }
      return true;
   }

   /**
    * Metodo para obtener la información completa del objeto
    *
    * @return Regresa la información compelta del objeto
    */
   @Override
   public String toString() {
      return "ProfesorVO{" + "matricula=" + matricula + ", constrasenia=" + constrasenia
              + ", usuario=" + usuario + '}';
   }

}
