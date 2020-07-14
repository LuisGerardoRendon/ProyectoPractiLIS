/**
 * Lista de contenido. 
 * > Atributos de la clase
 * > Constructores de la clase
 * > Getters de la clase
 * > Setters de la clase
 * > Métodos de la clase
 */
package modelo;

import java.util.Objects;

/**
 * Descripción de la clase: La clase OrganizacionVO es la que almacena las caracteristicas
 * (atributos) y comportamientos (métodos) de las entidades de Organizacion.
 *
 * @author Luis Gerardo Rendon Martínez.
 */
public class OrganizacionVO {

   private int idOrganizacion;
   private String nombre;
   private String direccion;
   private String ciudad;
   private String estado;
   private String telefono;
   private String correoElectronico;
   private String sector;

   /**
    * Constructor vacío
    */
   public OrganizacionVO() {
   }

   /**
    * Constructor parametrizado
    *
    * @param idOrganizacion Define el idOrganización de la Organizacion
    * @param nombre Define el nombre de la Organizacion
    * @param direccion Define la direccion de la Organizacion
    * @param ciudad Define la ciudad de la Organizacion
    * @param estado Define el estado de la Organizacion
    * @param telefono Define el telefono de la Organizacion
    * @param correoElectronico Define el correoElectronico de la Organizacion
    * @param sector Define el sector de la Organizacion
    */
   public OrganizacionVO(int idOrganizacion, String nombre, String direccion, String ciudad,
           String estado, String telefono, String correoElectronico, String sector) {
      this.idOrganizacion = idOrganizacion;
      this.nombre = nombre;
      this.direccion = direccion;
      this.ciudad = ciudad;
      this.estado = estado;
      this.telefono = telefono;
      this.correoElectronico = correoElectronico;
      this.sector = sector;
   }

   /**
    * Constructor parametrizado sin idOrganizacion
    *
    * @param nombre Define el nombre de la Organizacion
    * @param direccion Define la direccion de la Organizacion
    * @param ciudad Define la ciudad de la Organizacion
    * @param estado Define el estado de la Organizacion
    * @param telefono Define el telefono de la Organizacion
    * @param correoElectronico Define el correoElectronico de la Organizacion
    * @param sector Define el sector de la Organizacion
    */
   public OrganizacionVO(String nombre, String direccion, String ciudad, String estado,
           String telefono, String correoElectronico, String sector) {
      this.nombre = nombre;
      this.direccion = direccion;
      this.ciudad = ciudad;
      this.estado = estado;
      this.telefono = telefono;
      this.correoElectronico = correoElectronico;
      this.sector = sector;
      this.idOrganizacion = 0;
   }

   /**
    * Metodo para obtener el idOrganizacion de Organizacion
    *
    * @return Regresa el id de Organizacion
    */
   public int getIdOrganizacion() {
      return idOrganizacion;
   }

   /**
    * Metodo para obtener el nombre de Organizacion
    *
    * @return Regresa el nombre de Organizacion
    */
   public String getNombre() {
      return nombre;
   }

   /**
    * Metodo para obtener la direccion de Organizacion
    *
    * @return Regresa la direccion de Organizacion
    */
   public String getDireccion() {
      return direccion;
   }

   /**
    * Metodo para obtener la ciudad de Organizacion
    *
    * @return Regresa la ciudad de Organizacion
    */
   public String getCiudad() {
      return ciudad;
   }

   /**
    * Metodo para obtener el estado de Organizacion
    *
    * @return Regresa el estado de Organizacion
    */
   public String getEstado() {
      return estado;
   }

   /**
    * Metodo para obtener el telefono de Organizacion
    *
    * @return Regresa el telefono de Organizacion
    */
   public String getTelefono() {
      return telefono;
   }

   /**
    * Metodo para obtener el correoElectronico de Organizacion
    *
    * @return Regresa el correoElectronico de Organizacion
    */
   public String getCorreoElectronico() {
      return correoElectronico;
   }

   /**
    * Metodo para obtener el sector de Organizacion
    *
    * @return Regresa el sector de Organizacion
    */
   public String getSector() {
      return sector;
   }

   /**
    * Metodo para modificar el idOrganizacion a la Organizacion
    *
    * @param idOrganizacion Define el idOrganizacion de la Organizacion
    */
   public void setIdOrganizacion(int idOrganizacion) {
      this.idOrganizacion = idOrganizacion;
   }

   /**
    * Metodo para modificar el nombre a la Organizacion
    *
    * @param nombre Define el nombre de la Organizacion
    */
   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   /**
    * Metodo para modificar la direccion a la Organizacion
    *
    * @param direccion Define la direccion de la Organizacion
    */
   public void setDireccion(String direccion) {
      this.direccion = direccion;
   }

   /**
    * Metodo para modificar la ciudad a la Organizacion
    *
    * @param ciudad Define la ciudad de la Organizacion
    */
   public void setCiudad(String ciudad) {
      this.ciudad = ciudad;
   }

   /**
    * Metodo para modificar el estado a la Organizacion
    *
    * @param estado Define el estado de la Organizacion
    */
   public void setEstado(String estado) {
      this.estado = estado;
   }

   /**
    * Metodo para modificar el telefono a la Organizacion
    *
    * @param telefono Define el telefono de la Organizacion
    */
   public void setTelefono(String telefono) {
      this.telefono = telefono;
   }

   /**
    * Metodo para modificar el correoElectronico a la Organizacion
    *
    * @param correoElectronico Define el correoElectronico de la Organizacion
    */
   public void setCorreoElectronico(String correoElectronico) {
      this.correoElectronico = correoElectronico;
   }

   /**
    * Metodo para modificar el sector a la Organizacion
    *
    * @param sector Define el sector de la Organizacion
    */
   public void setSector(String sector) {
      this.sector = sector;
   }

   /**
    * Método que cumple la función de comparar objetos utilizando estructuras hash
    *
    * @return Numero entero referente a la estructura del objeto
    */
   @Override
   public int hashCode() {
      int hash = 7;
      hash = 67 * hash + this.idOrganizacion;
      hash = 67 * hash + Objects.hashCode(this.nombre);
      hash = 67 * hash + Objects.hashCode(this.direccion);
      hash = 67 * hash + Objects.hashCode(this.ciudad);
      hash = 67 * hash + Objects.hashCode(this.estado);
      hash = 67 * hash + Objects.hashCode(this.telefono);
      hash = 67 * hash + Objects.hashCode(this.correoElectronico);
      hash = 67 * hash + Objects.hashCode(this.sector);
      return hash;
   }

   /**
    * Metodo para evitar que un objeto se repita
    *
    * @param obj Objeto que sera comparado
    * @return Indicasi el objeto ya existe o no
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
      final OrganizacionVO other = (OrganizacionVO) obj;
      if (this.idOrganizacion != other.idOrganizacion) {
         return false;
      }
      if (!Objects.equals(this.nombre, other.nombre)) {
         return false;
      }
      if (!Objects.equals(this.direccion, other.direccion)) {
         return false;
      }
      if (!Objects.equals(this.ciudad, other.ciudad)) {
         return false;
      }
      if (!Objects.equals(this.estado, other.estado)) {
         return false;
      }
      if (!Objects.equals(this.telefono, other.telefono)) {
         return false;
      }
      if (!Objects.equals(this.correoElectronico, other.correoElectronico)) {
         return false;
      }
      if (!Objects.equals(this.sector, other.sector)) {
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
      return "OrganizacionVO{" + "idOrganizacion=" + idOrganizacion + ", nombre=" + nombre
              + ", direccion=" + direccion + ", ciudad=" + ciudad + ", estado=" + estado
              + ", telefono=" + telefono + ", correoElectronico=" + correoElectronico
              + ", sector=" + sector + '}';
   }
}
