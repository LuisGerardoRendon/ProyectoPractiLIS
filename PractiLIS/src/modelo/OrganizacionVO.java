/*
 * Lista de contenido. 
 * > Atributos de la clase line: 
 * > Constructores de la clase line: 
 * > Getters de la clase line: 
 * > Setters de la clase line: 
 * > Métodos de la clase line:
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
    * @param idOrganizacion
    * @param nombre
    * @param direccion
    * @param ciudad
    * @param estado
    * @param telefono
    * @param correoElectronico
    * @param sector
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
    * @param nombre
    * @param direccion
    * @param ciudad
    * @param estado
    * @param telefono
    * @param correoElectronico
    * @param sector
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
    * Metodo getIdOrganización que regresa un int con el atributo de la id de Organizacion
    *
    * @return idOrganizacion
    */
   public int getIdOrganizacion() {
      return idOrganizacion;
   }

   /**
    * Metodo getNombre que regresa un String con el atributo del nombre de Organizacion
    *
    * @return nombre
    */
   public String getNombre() {
      return nombre;
   }

   /**
    * Metodo getDireccion que regresa un String con el atributo de la direccion de Organizacion
    *
    * @return direccion
    */
   public String getDireccion() {
      return direccion;
   }

   /**
    * Metodo getCiudad que regresa un String con el atributo de la ciudad de Organizacion
    *
    * @return ciudad
    */
   public String getCiudad() {
      return ciudad;
   }

   /**
    * Metodo getEstado que regresa un String con el atributo del estado de Organizacion
    *
    * @return estado
    */
   public String getEstado() {
      return estado;
   }

   /**
    * Metodo getTelefono que regresa un String con el atributo del telefono de Organizacion
    *
    * @return telefono
    */
   public String getTelefono() {
      return telefono;
   }

   /**
    * Metodo getCorreoElectronico que regresa un String con el atributo del correo electronico de
    * Organizacion
    *
    * @return correoElectronico
    */
   public String getCorreoElectronico() {
      return correoElectronico;
   }

   /**
    * Metodo getSector que regresa un String con el atributo del sector de Organizacion
    *
    * @return sector
    */
   public String getSector() {
      return sector;
   }

   /**
    * Metodo setIdOrganizacion que cambia el atributo del id de Organizacion
    *
    * @param idOrganizacion
    */
   public void setIdOrganizacion(int idOrganizacion) {
      this.idOrganizacion = idOrganizacion;
   }

   /**
    * Metodo setIdOrganizacion que cambia el atributo del nombre de Organizacion
    *
    * @param nombre
    */
   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   /**
    * Metodo setDireccion que cambia el atributo de la direccion de Organizacion
    *
    * @param direccion
    */
   public void setDireccion(String direccion) {
      this.direccion = direccion;
   }

   /**
    * Metodo setCiudad que cambia el atributo de la ciudad de Organizacion
    *
    * @param ciudad
    */
   public void setCiudad(String ciudad) {
      this.ciudad = ciudad;
   }

   /**
    * Metodo setEstado que cambia el atributo del estado de Organizacion
    *
    * @param estado
    */
   public void setEstado(String estado) {
      this.estado = estado;
   }

   /**
    * Metodo setTelefono que cambia el atributo del telefono de Organizacion
    *
    * @param telefono
    */
   public void setTelefono(String telefono) {
      this.telefono = telefono;
   }

   /**
    * Metodo setCorreoElectronico que cambia el atributo del correoElectronico de Organizacion
    *
    * @param correoElectronico
    */
   public void setCorreoElectronico(String correoElectronico) {
      this.correoElectronico = correoElectronico;
   }

   /**
    * Metodo setSector que cambia el atributo del sector de Organizacion
    *
    * @param sector
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
    *
    * @param obj
    * @return
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
    *
    * @return
    */
   @Override
   public String toString() {
      return "OrganizacionVO{" + "idOrganizacion=" + idOrganizacion + ", nombre=" + nombre
              + ", direccion=" + direccion + ", ciudad=" + ciudad + ", estado=" + estado
              + ", telefono=" + telefono + ", correoElectronico=" + correoElectronico
              + ", sector=" + sector + '}';
   }
}
