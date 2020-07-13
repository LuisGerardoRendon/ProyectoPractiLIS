/*
 * Lista de contenido. 
 * > Atributos de la clase line: 
 * > Constructores de la clase line: 
 * > Getters de la clase line: 
 * > Setters de la clase line: 
 * > Métodos de la clase line:
 */
package modelo;

import java.io.File;
import java.util.Objects;

/**
 * Descripción de la clase: La clase ReporteVO es la que almacena las caracteristicas (atributos) y
 * comportamientos (métodos) de las entidades de Reporte.
 *
 * @author Daniel Pale Parra
 */
public class ReporteVO {

   private int numero;
   private int horasReportadas;
   private String fechaCarga;
   private String estado;
   private File reporte;
   private String fechaInicio;
   private String fechaFin;
   private int idExpediente;

   /**
    * Constructor vacío
    */
   public ReporteVO() {
   }

   /**
    * Constructor parametrizado
    *
    * @param horasReportadas
    * @param fechaCarga
    * @param estado
    * @param reporte
    * @param fechaInicio
    * @param fechaFin
    */
   public ReporteVO(int horasReportadas, String fechaCarga, String estado, File reporte,
           String fechaInicio, String fechaFin) {
      this.horasReportadas = horasReportadas;
      this.fechaCarga = fechaCarga;
      this.estado = estado;
      this.reporte = reporte;
      this.fechaInicio = fechaInicio;
      this.fechaFin = fechaFin;
   }

   /**
    *
    * @param numero
    * @param horasReportadas
    * @param fechaCarga
    */
   public ReporteVO(int numero, int horasReportadas, String fechaCarga) {
      this.numero = numero;
      this.horasReportadas = horasReportadas;
      this.fechaCarga = fechaCarga;
   }

   /**
    * Metodo getNumero que regresa un int con el atributo de numero de Reporte
    *
    * @return numero
    */
   public int getNumero() {
      return numero;
   }

   /**
    * Metodo getHorasReportadas que regresa un int con el atributo de horasReportadas de Reporte
    *
    * @return horasReportadas
    */
   public int getHorasReportadas() {
      return horasReportadas;
   }

   /**
    * Metodo getFechaCarga que regresa un String con el atributo de la fechaCarga de Reporte
    *
    * @return fechaCarga
    */
   public String getFechaCarga() {
      return fechaCarga;
   }

   /**
    * Metodo getEstado que regresa un String con el atributo del estado de Reporte
    *
    * @return estado
    */
   public String getEstado() {
      return estado;
   }

   /**
    * Metodo getReporte que regresa un File con el atributo del reporte subido de Reporte
    *
    * @return reporte
    */
   public File getReporte() {
      return reporte;
   }

   /**
    * Metodo getFechaInicio que regresa un String con el atributo de fechaInicio de Reporte
    *
    * @return fechaInicio
    */
   public String getFechaInicio() {
      return fechaInicio;
   }

   /**
    * Metodo getFechaFin que regresa un String con el atributo de fechaFin de Reporte
    *
    * @return fechaFin
    */
   public String getFechaFin() {
      return fechaFin;
   }

   /**
    * Metodo getIdExpediente que regresa un int con el atributo del id de Expediente vinculado con
    * Reporte
    *
    * @return idExpediente
    */
   public int getIdExpediente() {
      return idExpediente;
   }

   /**
    * Metodo setNumero que cambia el atributo del numero de Reporte
    *
    * @param numero
    */
   public void setNumero(int numero) {
      this.numero = numero;
   }

   /**
    * Metodo setHorasReportadas que cambia el atributo de horasReportadas de Reporte
    *
    * @param horasReportadas
    */
   public void setHorasReportadas(int horasReportadas) {
      this.horasReportadas = horasReportadas;
   }

   /**
    * Metodo setFechaCarga que cambia el atributo de la fechaCarga de Reporte
    *
    * @param fechaCarga
    */
   public void setFechaCarga(String fechaCarga) {
      this.fechaCarga = fechaCarga;
   }

   /**
    * Metodo setEstado que cambia el atributo del estado de Reporte
    *
    * @param estado
    */
   public void setEstado(String estado) {
      this.estado = estado;
   }

   /**
    * Metodo setReporte que cambia el atributo del reporte subido de Reporte
    *
    * @param reporte
    */
   public void setReporte(File reporte) {
      this.reporte = reporte;
   }

   /**
    * Metodo setFechaInicio que cambia el atributo de la fechaInicio de Reporte
    *
    * @param fechaInicio
    */
   public void setFechaInicio(String fechaInicio) {
      this.fechaInicio = fechaInicio;
   }

   /**
    * Metodo setFechaFin que cambia el atributo de la fechaFin de Reporte
    *
    * @param fechaFin
    */
   public void setFechaFin(String fechaFin) {
      this.fechaFin = fechaFin;
   }

   /**
    * Metodo setIdExpediente que cambia el atributo del id de Expediente vinculado con Reporte
    *
    * @param idExpediente
    */
   public void setIdExpediente(int idExpediente) {
      this.idExpediente = idExpediente;
   }

   /**
    * Método que cumple la función de comparar objetos utilizando estructuras hash
    *
    * @return Numero entero referente a la estructura del objeto
    */
   @Override
   public int hashCode() {
      int hash = 7;
      return hash;
   }

   /**
    *
    * @param obj
    * @return
    */
   @Override
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }
      if (getClass() != obj.getClass()) {
         return false;
      }
      final ReporteVO other = (ReporteVO) obj;
      if (this.numero != other.numero) {
         return false;
      }
      if (this.horasReportadas != other.horasReportadas) {
         return false;
      }
      if (!Objects.equals(this.fechaCarga, other.fechaCarga)) {
         return false;
      }
      if (!Objects.equals(this.estado, other.estado)) {
         return false;
      }
      if (!Objects.equals(this.reporte, other.reporte)) {
         return false;
      }
      if (!Objects.equals(this.fechaInicio, other.fechaInicio)) {
         return false;
      }
      if (!Objects.equals(this.fechaFin, other.fechaFin)) {
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
      return "ReporteVO{" + "numero=" + numero + ", horasReportadas=" + horasReportadas + ", fechaCarga=" + fechaCarga + ", estado=" + estado + ", reporte=" + reporte + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", idExpediente=" + idExpediente + '}';
   }
}
