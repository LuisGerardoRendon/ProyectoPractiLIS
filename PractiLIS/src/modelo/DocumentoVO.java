/**
 * LISTA DE CONTENIDO:
 *    > Paquete de la clase
 *    > Clases y librerias importadas
 *    > Atributos de la clase
 *    > Constructores de la clase
 *    > Metodos getters
 *    > Metodos setters
 *    > Otros metodos
 */
package modelo;

import java.util.Objects;

/**
 * Metodo que define la clase Documento, aqui se implementa sus metodos (Constructores, getters,
 * setters)
 *
 * @author Daniel Pale
 */
public class DocumentoVO {

   private String fechaDeAlmacen;
   private String documento;
   private String nombreDocumento;
   private int idExpediente;

   /**
    * Constructro vacio de la clase
    */
   public DocumentoVO() {
   }

   /**
    * Constructor parametrizado de la clase Documento
    *
    * @param fechaDeAlmacen Define la fecha en que se almaceno el Documento
    * @param documento Define el archivo del Documento
    * @param nombreDocumento Define el nombre del Documento
    * @param idExpediente Define el idExpediente relacionado al Documento
    */
   public DocumentoVO(String fechaDeAlmacen, String documento, String nombreDocumento,
           int idExpediente) {
      this.fechaDeAlmacen = fechaDeAlmacen;
      this.documento = documento;
      this.nombreDocumento = nombreDocumento;
      this.idExpediente = idExpediente;
   }

   /**
    * Constructor parametrizado sin el nombre del documento
    *
    * @param fechaDeAlmacen Define la fecha en que se almaceno el Documento
    * @param documento Define el archivo del Documento
    * @param idExpediente Define el idExpediente relacionado al Documento
    */
   public DocumentoVO(String fechaDeAlmacen, String documento, int idExpediente) {
      this.fechaDeAlmacen = fechaDeAlmacen;
      this.documento = documento;
      this.nombreDocumento = "null";
      this.idExpediente = idExpediente;
   }

   /**
    * Metodo para obtener la fecha de almacen del documento
    *
    * @return Regresa la fecha de almacen del Documento
    */
   public String getFechaDeAlmacen() {
      return fechaDeAlmacen;
   }

   /**
    * Metodo para obtener el archivo del documento
    *
    * @return Regresa el documento
    */
   public String getDocumento() {
      return documento;
   }

   /**
    * Metodo para obtener el nombre del documento
    *
    * @return Regresa el nombre del documento
    */
   public String getNombreDocumento() {
      return nombreDocumento;
   }

   /**
    * Metodo para obtener el idExpediente relacionado con el documento
    *
    * @return Regresa el idExpediente del documento
    */
   public int getIdExpediente() {
      return idExpediente;
   }

   /**
    * Método para agregar la fecha de almacen del documento
    *
    * @param fechaDeAlmacen Define la fecha en que se almaceno el Documento
    */
   public void setFechaDeAlmacen(String fechaDeAlmacen) {
      this.fechaDeAlmacen = fechaDeAlmacen;
   }

   /**
    * Define el archivo del Documento
    *
    * @param documento Define el documento de la clase
    */
   public void setDocumento(String documento) {
      this.documento = documento;
   }

   /**
    * Define el nombre del Documento
    *
    * @param nombreDocumento Define el nombre del documento
    */
   public void setNombreDocumento(String nombreDocumento) {
      this.nombreDocumento = nombreDocumento;
   }

   /**
    * Define el idExpediente relacionado al Documento
    *
    * @param idExpediente Define el nombre del expediente
    */
   public void setIdExpediente(int idExpediente) {
      this.idExpediente = idExpediente;
   }

   /**
    * Metodo que cumple la funcion de comparar objetos utilzando estructuras Hash
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

   /**
    * Metodo para obtener la información completa del objeto
    *
    * @return Regresa la información completa del objeto
    */
   @Override
   public String toString() {
      return "DocumentoVO{" + "fechaDeAlmacen=" + fechaDeAlmacen + ", "
              + "documento=" + documento + ", nombreDocumento=" + nombreDocumento + ", "
              + "idExpediente=" + idExpediente + '}';
   }

}
