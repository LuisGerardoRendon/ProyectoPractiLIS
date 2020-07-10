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
public class EncargadoProyectoVO {

   private int idEncargadoProyecto;
   private String nombre;
   private String cargo;
   private String correoElectronico;

   public EncargadoProyectoVO() {
   }

   public EncargadoProyectoVO(int idEncargadoProyecto, String nombre, String cargo, String correoElectronico) {
      this.idEncargadoProyecto = idEncargadoProyecto;
      this.nombre = nombre;
      this.cargo = cargo;
      this.correoElectronico = correoElectronico;
   }

   public EncargadoProyectoVO(String nombre, String cargo, String correoElectronico) {
      this.nombre = nombre;
      this.cargo = cargo;
      this.correoElectronico = correoElectronico;
   }

   public int getIdEncargadoProyecto() {
      return idEncargadoProyecto;
   }

   public String getNombre() {
      return nombre;
   }

   public String getCargo() {
      return cargo;
   }

   public String getCorreoElectronico() {
      return correoElectronico;
   }

   public void setIdEncargadoProyecto(int idEncargadoProyecto) {
      this.idEncargadoProyecto = idEncargadoProyecto;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public void setCargo(String cargo) {
      this.cargo = cargo;
   }

   public void setCorreoElectronico(String correoElectronico) {
      this.correoElectronico = correoElectronico;
   }

   @Override
   public int hashCode() {
      int hash = 3;
      hash = 23 * hash + this.idEncargadoProyecto;
      hash = 23 * hash + Objects.hashCode(this.nombre);
      hash = 23 * hash + Objects.hashCode(this.cargo);
      hash = 23 * hash + Objects.hashCode(this.correoElectronico);
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

   
   
   @Override
   public String toString() {
      return "EncargadoProyectoVO{" + "idEncargadoProyecto=" + idEncargadoProyecto + ", nombre=" + nombre + ", cargo=" + cargo + ", correoElectronico=" + correoElectronico + '}';
   }
}
