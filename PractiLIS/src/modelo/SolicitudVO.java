/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Objects;

/**
 *
 * @author ALDO//
 */
public class SolicitudVO {
   private String periodo;
   private String fecha;
   private String idProyecto;
   private String matricula;

   public SolicitudVO() {
   }

   public SolicitudVO(String periodo, String fecha, String idProyecto, String matricula) {
      this.periodo = periodo;
      this.fecha = fecha;
      this.idProyecto = idProyecto;
      this.matricula = matricula;
   }

   public String getPeriodo() {
      return periodo;
   }

   public String getFecha() {
      return fecha;
   }

   public String getIdProyecto() {
      return idProyecto;
   }

   public String getMatricula() {
      return matricula;
   }

   public void setPeriodo(String periodo) {
      this.periodo = periodo;
   }

   public void setFecha(String fecha) {
      this.fecha = fecha;
   }

   public void setIdProyecto(String idProyecto) {
      this.idProyecto = idProyecto;
   }

   public void setMatricula(String matricula) {
      this.matricula = matricula;
   }

   @Override
   public int hashCode() {
      int hash = 7;
      hash = 71 * hash + Objects.hashCode(this.periodo);
      hash = 71 * hash + Objects.hashCode(this.fecha);
      hash = 71 * hash + Objects.hashCode(this.idProyecto);
      hash = 71 * hash + Objects.hashCode(this.matricula);
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
      final SolicitudVO other = (SolicitudVO) obj;
      return true;
   }

   @Override
   public String toString() {
      return "SolicitudVO{" + "periodo=" + periodo + ", fecha=" + fecha + ", idProyecto=" + idProyecto + ", matricula=" + matricula + '}';
   }
   
   
    
}
