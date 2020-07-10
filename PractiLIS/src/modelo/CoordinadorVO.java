/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Objects;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 * @version 1.1, 09/jul/2020
 */
public class CoordinadorVO {

   private String usuario;
   private String contraseña;

   public CoordinadorVO() {

   }

   public CoordinadorVO(String usuario, String contraseña) {
      this.usuario = usuario;
      this.contraseña = contraseña;
   }

   public CoordinadorVO(String contraseña) {
      this.contraseña = contraseña;
      this.usuario = "null";
   }

   public String getUsuario() {
      return usuario;
   }

   public String getContraseña() {
      return contraseña;
   }

   public void setUsuario(String usuario) {
      this.usuario = usuario;
   }

   public void setContraseña(String contraseña) {
      this.contraseña = contraseña;
   }

   @Override
   public int hashCode() {
      int hash = 5;
      hash = 97 * hash + Objects.hashCode(this.usuario);
      hash = 97 * hash + Objects.hashCode(this.contraseña);
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
      final CoordinadorVO other = (CoordinadorVO) obj;
      if (!Objects.equals(this.usuario, other.usuario)) {
         return false;
      }
      if (!Objects.equals(this.contraseña, other.contraseña)) {
         return false;
      }
      return true;
   }

   
   @Override
   public String toString() {
      return "Coordinador{" + "usuario=" + usuario + ", contrase\u00f1a=" + contraseña + '}';
   }

}
