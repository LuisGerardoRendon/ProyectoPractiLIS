/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Objects;

/**
 *
 * @author ALDO
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
   
   private int cupo;

   public ProyectoVO() {
   }

   public ProyectoVO(int idProyecto, String nombre, String descripcion, int capacidadEstudiantes, int numEstudiantesAsignados, String status, int idOrganizacion, int idEncargadoProyecto) {
      this.idProyecto = idProyecto;
      this.nombre = nombre;
      this.descripcion = descripcion;
      this.capacidadEstudiantes = capacidadEstudiantes;
      this.numEstudiantesAsignados = numEstudiantesAsignados;
      this.status = status;
      this.idOrganizacion = idOrganizacion;
      this.idEncargadoProyecto = idEncargadoProyecto;
   }

   public int getIdProyecto() {
      return idProyecto;
   }

   public String getNombre() {
      return nombre;
   }

   public String getDescripcion() {
      return descripcion;
   }

   public int getCapacidadEstudiantes() {
      return capacidadEstudiantes;
   }

   public int getNumEstudiantesAsignados() {
      return numEstudiantesAsignados;
   }

   public String getStatus() {
      return status;
   }

   public int getIdOrganizacion() {
      return idOrganizacion;
   }

   public int getIdEncargadoProyecto() {
      return idEncargadoProyecto;
   }

   public void setIdProyecto(int idProyecto) {
      this.idProyecto = idProyecto;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public void setDescripcion(String descripcion) {
      this.descripcion = descripcion;
   }

   public void setCapacidadEstudiantes(int capacidadEstudiantes) {
      this.capacidadEstudiantes = capacidadEstudiantes;
   }

   public void setNumEstudiantesAsignados(int numEstudiantesAsignados) {
      this.numEstudiantesAsignados = numEstudiantesAsignados;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   public void setIdOrganizacion(int idOrganizacion) {
      this.idOrganizacion = idOrganizacion;
   }

   public void setIdEncargadoProyecto(int idEncargadoProyecto) {
      this.idEncargadoProyecto = idEncargadoProyecto;
   }

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

   @Override
   public String toString() {
      return "ProyectoVO{" + "idProyecto=" + idProyecto + ", nombre=" + nombre + ", descripcion=" + descripcion + ", capacidadEstudiantes=" + capacidadEstudiantes + ", numEstudiantesAsignados=" + numEstudiantesAsignados + ", status=" + status + ", idOrganizacion=" + idOrganizacion + ", idEncargadoProyecto=" + idEncargadoProyecto + '}';
   }
   
   
}
