/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 * @version 1.1, 09/jul/2020
 */
public class ExpedienteVO {

   private int idExpediente;
   private int idAsignacion;

   public ExpedienteVO(int idExpediente, int idAsignacion) {
      this.idExpediente = idExpediente;
      this.idAsignacion = idAsignacion;
   }

  
   public int getIdExpediente() {
      return idExpediente;
   }

   public int getIdAsignacion() {
      return idAsignacion;
   }

   public void setIdExpediente(int idExpediente) {
      this.idExpediente = idExpediente;
   }

   public void setIdAsignacion(int idAsignacion) {
      this.idAsignacion = idAsignacion;
   }
    @Override
   public int hashCode() {
      int hash = 7;
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
      final ExpedienteVO other = (ExpedienteVO) obj;
      if (this.idExpediente != other.idExpediente) {
         return false;
      }
      if (this.idAsignacion != other.idAsignacion) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "ExpedienteVO{" + "idExpediente=" + idExpediente + ", idAsignacion=" + idAsignacion + '}';
   }
   

}
