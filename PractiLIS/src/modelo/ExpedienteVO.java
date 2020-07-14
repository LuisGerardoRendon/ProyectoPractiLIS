/**
 * Lista de contenido.
 * > Atributos de la clase
 * > Constructores de la clase
 * > Getters de la clase
 * > Setters de la clase
 * > Métodos de la clase
 */
package modelo;

/**
 * Descripción de la clase: La clase ExpedienteVO es la que almacena las caracteristicas (atributos)
 * y comportamientos (métodos) de las entidades de Expediente.
 *
 * @author Luis Gerardo Rendon Martínez
 */
public class ExpedienteVO {

   private int idExpediente;
   private int idAsignacion;

   /**
    * Constructor Vacío
    */
   public ExpedienteVO() {
   }

   /**
    * Construtor parametrizado, se utiliza principalmente para leer la información de la base de
    * datos.
    *
    * @param idExpediente Identificador Unico del expediente
    * @param idAsignacion Identidicador Unico de la Asigación relacionada al Expediente
    */
   public ExpedienteVO(int idExpediente, int idAsignacion) {
      this.idExpediente = idExpediente;
      this.idAsignacion = idAsignacion;
   }

   /**
    * Constructor parametricado, se utiliza principalmente para insertar informacion a la base de
    * datos
    *
    * @param idExpediente identidicador unico del expediente
    */
   public ExpedienteVO(int idExpediente) {
      this.idExpediente = idExpediente;
   }

   /**
    * Método para obtener el identificador unico del expediente
    *
    * @return el identificador unico del expediente
    */
   public int getIdExpediente() {
      return idExpediente;
   }

   /**
    * Método para obtener el identificacor unico de la Asignación relacionada al expediente
    *
    * @return identificacor unico de la Asignación relacionada al expediente
    */
   public int getIdAsignacion() {
      return idAsignacion;
   }

   /**
    * Metodo para enviar el identificador unico del expediente
    *
    * @param idExpediente El identificador unico del expediente
    */
   public void setIdExpediente(int idExpediente) {
      this.idExpediente = idExpediente;
   }

   /**
    * Método para enviar el identificacor unico de la Asignación relacionada al expediente
    *
    * @param idAsignacion identificacor unico de la Asignación relacionada al expediente
    */
   public void setIdAsignacion(int idAsignacion) {
      this.idAsignacion = idAsignacion;
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

   /**
    * Metodo para obtener la información completa del objeto
    *
    * @return Regresa la información compelta del objeto
    */
   @Override
   public String toString() {
      return "ExpedienteVO{" + "idExpediente=" + idExpediente + ", idAsignacion=" + idAsignacion + '}';
   }

}
