/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Objects;

/**
 *
 * @author Daniel Pale
 */
public class ProfesorVO {

   private String matricula;
   private String constrasenia;
   private String usuario;

   public ProfesorVO() {
   }
   
   public ProfesorVO(String matricula, String constrasenia, String usuario) {
      this.matricula = matricula;
      this.constrasenia = constrasenia;
      this.usuario = usuario;
   }

   public String getMatricula() {
      return matricula;
   }

   public String getConstrasenia() {
      return constrasenia;
   }

   public String getUsuario() {
      return usuario;
   }

   public void setIdProfesor(String matricula) {
      this.matricula = matricula;
   }

   public void setConstrasenia(String constrasenia) {
      this.constrasenia = constrasenia;
   }

   public void setUsuario(String usuario) {
      this.usuario = usuario;
   }

   @Override
   public int hashCode() {
      int hash = 7;
      hash = 79 * hash + Objects.hashCode(this.matricula);
      hash = 79 * hash + Objects.hashCode(this.constrasenia);
      hash = 79 * hash + Objects.hashCode(this.usuario);
      return hash;
   }

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

   @Override
   public String toString() {
      return "ProfesorVO{" + "matricula=" + matricula + ", constrasenia=" + constrasenia + ", usuario=" + usuario + '}';
   }
   
  

  

   
}
