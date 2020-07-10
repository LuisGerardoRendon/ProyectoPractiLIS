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
public class DocumentoVO {

   private String fechaDeAlmacen;
   private String documento;
   private String nombreDocumento;
   private int idExpediente;

   public DocumentoVO() {
   }

   public DocumentoVO(String fechaDeAlmacen, String documento, String nombreDocumento,
           int idExpediente) {
      this.fechaDeAlmacen = fechaDeAlmacen;
      this.documento = documento;
      this.nombreDocumento = nombreDocumento;
      this.idExpediente = idExpediente;
   }

   public DocumentoVO(String fechaDeAlmacen, String documento, int idExpediente) {
      this.fechaDeAlmacen = fechaDeAlmacen;
      this.documento = documento;
      this.nombreDocumento = "null";
      this.idExpediente = idExpediente;
   }

   public String getFechaDeAlmacen() {
      return fechaDeAlmacen;
   }

   public String getDocumento() {
      return documento;
   }

   public String getNombreDocumento() {
      return nombreDocumento;
   }

   public int getIdExpediente() {
      return idExpediente;
   }

   public void setFechaDeAlmacen(String fechaDeAlmacen) {
      this.fechaDeAlmacen = fechaDeAlmacen;
   }

   public void setDocumento(String documento) {
      this.documento = documento;
   }

   public void setNombreDocumento(String nombreDocumento) {
      this.nombreDocumento = nombreDocumento;
   }

   public void setIdExpediente(int idExpediente) {
      this.idExpediente = idExpediente;
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
      final DocumentoVO other = (DocumentoVO) obj;
      if (this.idExpediente != other.idExpediente) {
         return false;
      }
      if (!Objects.equals(this.fechaDeAlmacen, other.fechaDeAlmacen)) {
         return false;
      }
      if (!Objects.equals(this.documento, other.documento)) {
         return false;
      }
      if (!Objects.equals(this.nombreDocumento, other.nombreDocumento)) {
         return false;
      }
      return true;
   }
}
