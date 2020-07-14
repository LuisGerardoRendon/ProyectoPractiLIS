/**
 * Lista de contenido. 
 * > Atributos de la clase  
 * > Constructores de la clase  
 * > Getters de la clase 
 * > Setters de la clase  
 * > Métodos de la clase 
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
    * @param horasReportadas Define las horasReportadas de Reporte
    * @param fechaCarga Define la fechaCarga de Reporte
    * @param estado Define el estado de Reporte
    * @param reporte Define el reporte de Reporte
    * @param fechaInicio Define la fechaInicio de Reporte
    * @param fechaFin Define la fechaFin de Reporte
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
    * Constructor con 3 parámetros con la intención de mostrar atributos relevantes en tablas.
    *
    * @param numero Define el numero de Reporte
    * @param horasReportadas Define las horasReportadas de Reporte
    * @param fechaCarga Define la fechaCarga de Reporte
    */
   public ReporteVO(int numero, int horasReportadas, String fechaCarga) {
      this.numero = numero;
      this.horasReportadas = horasReportadas;
      this.fechaCarga = fechaCarga;
   }

   /**
    * Metodo para obtener el numero de Reporte
    *
    * @return Regresa el numero de Reporte
    */
   public int getNumero() {
      return numero;
   }

   /**
    * Metodo para obtener las horasReportadas de Reporte
    *
    * @return Regresa las horasReportadas de Reporte
    */
   public int getHorasReportadas() {
      return horasReportadas;
   }

   /**
    * Metodo para obtener la fechaCarga de Reporte
    *
    * @return Regresa la fechaCarga de Reporte
    */
   public String getFechaCarga() {
      return fechaCarga;
   }

   /**
    * Metodo para obtener el estado de Reporte
    *
    * @return Regresa el estado de Reporte
    */
   public String getEstado() {
      return estado;
   }

   /**
    * Metodo para obtener el reporte (un documento) de Reporte
    *
    * @return Regresa el reporte (un documento) de Reporte
    */
   public File getReporte() {
      return reporte;
   }

   /**
    * Metodo para obtener la fechaInicio de Reporte
    *
    * @return Regresa la fechaInicio de Reporte
    */
   public String getFechaInicio() {
      return fechaInicio;
   }

   /**
    * Metodo para obtener la fechaFin de Reporte
    *
    * @return Regresa la fechaFin de Reporte
    */
   public String getFechaFin() {
      return fechaFin;
   }

   /**
    * Metodo para obtener el id de Expediente que está relacionado con Reporte
    *
    * @return Regresa el id de Expediente que está relacionado con Reporte
    */
   public int getIdExpediente() {
      return idExpediente;
   }

   /**
    * Metodo para modificar el numero de Reporte
    *
    * @param numero Define el numero de Reporte
    */
   public void setNumero(int numero) {
      this.numero = numero;
   }

   /**
    * Metodo para modificar las horasReportadas de Reporte
    *
    * @param horasReportadas Define las horasReportadas de Reporte
    */
   public void setHorasReportadas(int horasReportadas) {
      this.horasReportadas = horasReportadas;
   }

   /**
    * Metodo para modificar la fechaCarga de Reporte
    *
    * @param fechaCarga Define la fechaCarga de Reporte
    */
   public void setFechaCarga(String fechaCarga) {
      this.fechaCarga = fechaCarga;
   }

   /**
    * Metodo para modificar el estado de Reporte
    *
    * @param estado Define el estado de Reporte
    */
   public void setEstado(String estado) {
      this.estado = estado;
   }

   /**
    * Metodo para modificar el reporte de Reporte
    *
    * @param reporte Define el reporte de Reporte
    */
   public void setReporte(File reporte) {
      this.reporte = reporte;
   }

   /**
    * Metodo para modificar la fechaInicio de Reporte
    *
    * @param fechaInicio Define la fechaInicio de Reporte
    */
   public void setFechaInicio(String fechaInicio) {
      this.fechaInicio = fechaInicio;
   }

   /**
    * Metodo para modificar la fechaFin de Reporte
    *
    * @param fechaFin Define la fechaFin de Reporte
    */
   public void setFechaFin(String fechaFin) {
      this.fechaFin = fechaFin;
   }

   /**
    * Metodo para modificar el id de Expediente relacionado con Reporte
    *
    * @param idExpediente Define el Expediente relacionado con Reporte
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
    * Metodo para evitar que un objeto se repita
    *
    * @param obj Objeto que sera comparado
    * @return Indica si el objeto ya existe o no
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
    * Metodo para obtener la información completa del objeto
    *
    * @return Regresa la información compelta del objeto
    */
   @Override
   public String toString() {
      return "ReporteVO{" + "numero=" + numero + ", horasReportadas=" + horasReportadas
              + ", fechaCarga=" + fechaCarga + ", estado=" + estado + ", reporte=" + reporte
              + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", idExpediente="
              + idExpediente + '}';
   }
}
