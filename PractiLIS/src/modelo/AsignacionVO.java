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
import java.util.Objects;

/**
 *
 * @author ALDO
 */
public class AsignacionVO {

   private int idAsignacion;
   private String periodo;
   private String nrcCurso;
   private float progreso;
   private int idProyecto;
   private String matriculaProfesor;
   private String matriculaEstudiante;

   public AsignacionVO() {

   }

   public AsignacionVO(int idAsignacion, String periodo, String nrcCurso, float progreso, int idProyecto, String matriculaProfesor, String matriculaEstudiante) {
      this.idAsignacion = idAsignacion;
      this.periodo = periodo;
      this.nrcCurso = nrcCurso;
      this.progreso = progreso;
      this.idProyecto = idProyecto;
      this.matriculaProfesor = matriculaProfesor;
      this.matriculaEstudiante = matriculaEstudiante;
   }

   public AsignacionVO(String periodo, String nrcCurso, float progreso, int idProyecto, String matriculaProfesor, String matriculaEstudiante) {
      this.periodo = periodo;
      this.nrcCurso = nrcCurso;
      this.progreso = progreso;
      this.idProyecto = idProyecto;
      this.matriculaProfesor = matriculaProfesor;
      this.matriculaEstudiante = matriculaEstudiante;
      this.idAsignacion = 0;
   }
   
   public AsignacionVO(String periodo, float progreso, int idProyecto, String matriculaEstudiante){
      this.periodo = periodo;
      this.progreso = progreso;
      this.idProyecto = idProyecto;
      this.matriculaEstudiante = matriculaEstudiante;
   }

   public int getIdAsignacion() {
      return idAsignacion;
   }

   public String getPeriodo() {
      return periodo;
   }

   public String getNrcCurso() {
      return nrcCurso;
   }

   public float getProgreso() {
      return progreso;
   }

   public int getIdProyecto() {
      return idProyecto;
   }

   public String getMatriculaProfesor() {
      return matriculaProfesor;
   }

   public String getMatriculaEstudiante() {
      return matriculaEstudiante;
   }

   public void setIdAsignacion(int idAsignacion) {
      this.idAsignacion = idAsignacion;
   }

   public void setPeriodo(String periodo) {
      this.periodo = periodo;
   }

   public void setNrcCurso(String nrcCurso) {
      this.nrcCurso = nrcCurso;
   }

   public void setProgreso(float progreso) {
      this.progreso = progreso;
   }

   public void setIdProyecto(int idProyecto) {
      this.idProyecto = idProyecto;
   }

   public void setMatriculaProfesor(String matriculaProfesor) {
      this.matriculaProfesor = matriculaProfesor;
   }

   public void setMatriculaEstudiante(String matriculaEstudiante) {
      this.matriculaEstudiante = matriculaEstudiante;
   }

   @Override
   public int hashCode() {
      int hash = 7;
      hash = 29 * hash + this.idAsignacion;
      hash = 29 * hash + Objects.hashCode(this.periodo);
      hash = 29 * hash + Objects.hashCode(this.nrcCurso);
      hash = 29 * hash + Float.floatToIntBits(this.progreso);
      hash = 29 * hash + this.idProyecto;
      hash = 29 * hash + Objects.hashCode(this.matriculaProfesor);
      hash = 29 * hash + Objects.hashCode(this.matriculaEstudiante);
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
      final AsignacionVO other = (AsignacionVO) obj;
      if (this.idAsignacion != other.idAsignacion) {
         return false;
      }
      if (Float.floatToIntBits(this.progreso) != Float.floatToIntBits(other.progreso)) {
         return false;
      }
      if (this.idProyecto != other.idProyecto) {
         return false;
      }
      if (!Objects.equals(this.periodo, other.periodo)) {
         return false;
      }
      if (!Objects.equals(this.nrcCurso, other.nrcCurso)) {
         return false;
      }
      if (!Objects.equals(this.matriculaProfesor, other.matriculaProfesor)) {
         return false;
      }
      if (!Objects.equals(this.matriculaEstudiante, other.matriculaEstudiante)) {
         return false;
      }
      return true;
   }
   

   @Override
   public String toString() {
      return "AsignacionVO{" + "idAsignacion=" + idAsignacion + ", periodo=" + periodo + ", nrcCurso=" + nrcCurso + ", progreso=" + progreso + ", idProyecto=" + idProyecto + ", matriculaProfesor=" + matriculaProfesor + ", matriculaEstudiante=" + matriculaEstudiante + '}';
   }
   

}
