/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Objects;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Daniel Pale
 */
public class EstudianteVO {

   private String matricula;
   private String contrasenia;
   private String nombre;
   private String correo;
   private String status;

   public EstudianteVO() {
      this.matricula = "null";// porque puede ser Asignado, Sin Asignar, Aprobado
      this.contrasenia = "null";
      this.nombre = "null";
      this.correo = "null";
      this.status = "null";
   }
   
   public EstudianteVO(String matricula, String contrasenia, String nombre, String correoElectronico, 
           String status) { // Se cambio el status a string porque puede ser Asignado, Sin Asignar, Aprobado
      this.matricula = matricula;
      this.contrasenia = contrasenia;
      this.nombre = nombre;
      this.correo = correoElectronico;
      this.status = status;
   }
   public EstudianteVO(String nombre, String matricula){
      this.nombre = nombre;
      this.matricula = matricula;
      
   }

   public String getMatricula() {
      return matricula;
   }

   public String getContrasenia() {
      return contrasenia;
   }

   public String getNombre() {
      return nombre;
   }

   public String getCorreoElectronico() {
      return correo;
   }

   public String getStatus() {
      return status;
   }

   public void setMatricula(String matricula) {
      this.matricula = matricula;
   }

   public void setContrasenia(String contrasenia) {
      this.contrasenia = contrasenia;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public void setCorreoElectronico(String correoElectronico) {
      this.correo = correoElectronico;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   @Override
   public int hashCode() {
      int hash = 3;
      return hash;
   }

   @Override
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }
      if (getClass() != obj.getClass()) {
         return false;
      }
      final EstudianteVO other = (EstudianteVO) obj;
      if (!Objects.equals(this.matricula, other.matricula)) {
         return false;
      }
      if (!Objects.equals(this.contrasenia, other.contrasenia)) {
         return false;
      }
      if (!Objects.equals(this.nombre, other.nombre)) {
         return false;
      }
      if (!Objects.equals(this.correo, other.correo)) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "EstudianteVO{" + "matricula=" + matricula + ", contrasenia=" + contrasenia + 
              ", nombre=" + nombre + ", correo=" + correo + ", status=" + 
              status + '}';
   }
   
   /*public ObservableList<EstudianteVO> obtenerEstudiantes() {
      Estudiante_DAO_Implements estudianteDAOImp = new Estudiante_DAO_Implements();
      ObservableList<EstudianteVO> obs = FXCollections.observableArrayList();
      obs = estudianteDAOImp.recuperarEstudiante();
      return obs;
   }

   public ObservableList<ProyectoVO> obtenerProyectosSolicitados() {
      Estudiante_DAO_Implements estudianteDAOImp = new Estudiante_DAO_Implements();
      ObservableList<ProyectoVO> obs = FXCollections.observableArrayList();
      obs = estudianteDAOImp.recuperarProyectosSeleccionado(matricula);
      return obs;
   }

   public ObservableList<SolicitudVO> obtenerSolicitudes() {
      Estudiante_DAO_Implements estudianteDAOImp = new Estudiante_DAO_Implements();
      ObservableList<SolicitudVO> obs = FXCollections.observableArrayList();
      obs = estudianteDAOImp.recuperarSolicitudes(matricula);
      return obs;
   }
*/
}
