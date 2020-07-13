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
    * @param matricula
    * @param constrasenia
    * @param usuario
    */
   public ProfesorVO(String matricula, String constrasenia, String usuario) {
      this.matricula = matricula;
      this.constrasenia = constrasenia;
      this.usuario = usuario;
   }

   /**
    * Metodo getMatricula que regresa un String con el atributo de la matricula de Profesor
    *
    * @return matricula
    */
   public String getMatricula() {
      return matricula;
   }

   /**
    * Metodo getConstrasenia que regresa un String con el atributo de la constrasenia de Profesor
    *
    * @return constrasenia
    */
   public String getConstrasenia() {
      return constrasenia;
   }

    /**
    * Metodo getUsuario que regresa un String con el atributo de la usuario de Profesor
    *
    * @return usuario
    */
   public String getUsuario() {
      return usuario;
   }

   /**
    * Metodo setMatricula que cambia el atributo de la matricula de Profesor
    *
    * @param matricula
    */
   public void setMatricula(String matricula) {
      this.matricula = matricula;
   }

   /**
    * Metodo setConstrasenia que cambia el atributo de la constrasenia de Profesor
    *
    * @param constrasenia
    */
   public void setConstrasenia(String constrasenia) {
      this.constrasenia = constrasenia;
   }

   /**
    * Metodo setUsuario que cambia el atributo del usuario de Profesor
    *
    * @param usuario
    */
   public void setUsuario(String usuario) {
      this.usuario = usuario;
   }

   /**
    *Método que cumple la función de comparar objetos utilizando estructuras hash
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
    * 
    * @return 
    */
   @Override
   public String toString() {
      return "ProfesorVO{" + "matricula=" + matricula + ", constrasenia=" + constrasenia + ", usuario=" + usuario + '}';
   }

}
