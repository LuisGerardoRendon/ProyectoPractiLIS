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
 * Esta clase contiene la definición de la clase AsignacionVO, en ella
 * se declaran sus constructores ,metodos getters, setters, asi como el toString de la clase.
 * @author Luis Gerardo Rendon
 */
public class AsignacionVO {

   private int idAsignacion;
   private String periodo;
   private String nrcCurso;
   private float progreso;
   private int idProyecto;
   private String matriculaProfesor;
   private String matriculaEstudiante;

   /**
    * Constructor vacio de la clase
    */
   public AsignacionVO() {
   }

   /**
    * Constructor parametrizado de la clase
    *
    * @param idAsignacion Define el idAsignacion de la Asignación
    * @param periodo Define el periodo de la Asignacion
    * @param nrcCurso Define el nrc del curso relacionado a la asignación
    * @param progreso Define el progreso de la Asignación
    * @param idProyecto Define el id del proyecto relacionado
    * @param matriculaProfesor Define la matricula del profesor relacionado
    * @param matriculaEstudiante Define la matricula de el estudiante de la Asignación
    */
   public AsignacionVO(int idAsignacion, String periodo, String nrcCurso, float progreso,
           int idProyecto, String matriculaProfesor, String matriculaEstudiante) {
      this.idAsignacion = idAsignacion;
      this.periodo = periodo;
      this.nrcCurso = nrcCurso;
      this.progreso = progreso;
      this.idProyecto = idProyecto;
      this.matriculaProfesor = matriculaProfesor;
      this.matriculaEstudiante = matriculaEstudiante;
   }

   /**
    * Constructor de la clase son el id de la asignación
    *
    * @param periodo Define el idAsignacion de la Asignación
    * @param nrcCurso Define el nrc del curso relacionado a la asignación
    * @param progreso Define el progreso de la Asignación
    * @param idProyecto Define el id del proyecto relacionado
    * @param matriculaProfesor Define la matricula del profesor relacionado
    * @param matriculaEstudiante Define la matricula de el estudiante de la Asignación
    */
   public AsignacionVO(String periodo, String nrcCurso, float progreso, int idProyecto, String matriculaProfesor, String matriculaEstudiante) {
      this.periodo = periodo;
      this.nrcCurso = nrcCurso;
      this.progreso = progreso;
      this.idProyecto = idProyecto;
      this.matriculaProfesor = matriculaProfesor;
      this.matriculaEstudiante = matriculaEstudiante;
      this.idAsignacion = 0;
   }

   /**
    * Metodo constructor de la clase con 4 parametros
    *
    * @param periodo Define el idAsignacion de la Asignación
    * @param progreso Define el progreso de la Asignación
    * @param idProyecto Define el id del proyecto relacionado
    * @param matriculaEstudiante Define la matricula de el estudiante de la Asignación
    */
   public AsignacionVO(String periodo, float progreso, int idProyecto, String matriculaEstudiante) {
      this.periodo = periodo;
      this.progreso = progreso;
      this.idProyecto = idProyecto;
      this.matriculaEstudiante = matriculaEstudiante;
   }

   /**
    * Metodo para obtener el idAsignación de la Asignación
    *
    * @return Regresa el id de la asignación
    */
   public int getIdAsignacion() {
      return idAsignacion;
   }

   /**
    * Metodo para obtener el periodo de la asignación
    *
    * @return Regresa el periodo de la asignación
    */
   public String getPeriodo() {
      return periodo;
   }

   /**
    * Metodo para obtener el NrcCurso relacionado con la asignación
    *
    * @return Regresa el NrcCurso
    */
   public String getNrcCurso() {
      return nrcCurso;
   }

   /**
    * Metodo para obtener el Progreso de la asignación
    *
    * @return Regresa el progreso de la asignación
    */
   public float getProgreso() {
      return progreso;
   }

   /**
    * Metodo para ontener el idProyecto relacionado con la asignación
    *
    * @return Regresa el idProyecto de la asignación
    */
   public int getIdProyecto() {
      return idProyecto;
   }

   /**
    * Metodo para obtener la matriculaProfesor relacionado con la asignación
    *
    * @return Regresa la amtricula del profesor de la Asignación
    */
   public String getMatriculaProfesor() {
      return matriculaProfesor;
   }

   /**
    * Metodo para obtener la matricula del estudiante del que se realizo la asignación
    *
    * @return Regresa la matricula del estudiante de la Asignación
    */
   public String getMatriculaEstudiante() {
      return matriculaEstudiante;
   }

   /**
    * Metodo para agregar el idAsignación a la Asignación
    *
    * @param idAsignacion Define el idAsignacion de la Asignación
    */
   public void setIdAsignacion(int idAsignacion) {
      this.idAsignacion = idAsignacion;
   }

   /**
    * Metodo para agregar el periodo a la Asignación
    *
    * @param periodo Define el idAsignacion de la Asignación
    */
   public void setPeriodo(String periodo) {
      this.periodo = periodo;
   }

   /**
    * Metoro para agregar el nrcCurso relacionado con la Asignación
    *
    * @param nrcCurso Define el nrc del curso relacionado a la asignación
    */
   public void setNrcCurso(String nrcCurso) {
      this.nrcCurso = nrcCurso;
   }

   /**
    * Metodo para agreagar el progreso de la Asignación
    *
    * @param progreso Define el progreso de la Asignación
    */
   public void setProgreso(float progreso) {
      this.progreso = progreso;
   }

   /**
    * Metodo para agregar el idProyecto relacionado con la Asignación
    *
    * @param idProyecto Define el id del proyecto relacionado
    */
   public void setIdProyecto(int idProyecto) {
      this.idProyecto = idProyecto;
   }

   /**
    * Metodo para agregar la matriculaProfesor de la Asignación
    *
    * @param matriculaProfesor Define la matricula del profesor relacionado
    */
   public void setMatriculaProfesor(String matriculaProfesor) {
      this.matriculaProfesor = matriculaProfesor;
   }

   /**
    * Metodo para agregar la matriculaEstudiante relacionada con la Asignación
    *
    * @param matriculaEstudiante Define la matricula de el estudiante de la Asignación
    */
   public void setMatriculaEstudiante(String matriculaEstudiante) {
      this.matriculaEstudiante = matriculaEstudiante;
   }

   /**
    * Metodo que cumple la funcion de comparar objetos utilzando estructuras Hash
    *
    * @return Numero entero referente a la estructura del objeto
    */
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

   /**
    * Metodo para obtener la información completa del objeto
    *
    * @return Regresa la información compelta del objeto
    */
   @Override
   public String toString() {
      return "AsignacionVO{" + "idAsignacion=" + idAsignacion + ", periodo=" + periodo + ", "
              + "nrcCurso=" + nrcCurso + ", progreso=" + progreso + ", idProyecto=" + idProyecto
              + ", matriculaProfesor=" + matriculaProfesor + ", matriculaEstudiante="
              + matriculaEstudiante + '}';
   }

}
