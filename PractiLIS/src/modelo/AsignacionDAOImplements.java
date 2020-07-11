/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Daniel Pale
 */
public class AsignacionDAOImplements implements AsignacionDAO {

   @Override
   public boolean create(AsignacionVO asignacion) throws Exception {
      boolean created = false;
      Connection con = null;
      PreparedStatement ps = null;
      ResultSet rs = null;
      String sql = "INSERT INTO asignacion VALUES (?,?,?,?,?,?,?)";

      try {
         con = new ConexionBD().conectarMySQL();
         ps = con.prepareStatement(sql);
         ps.setString(1, asignacion.getPreriodo());
         ps.setInt(2, asignacion.getIdAsignacion());
         ps.setString(3, asignacion.getNrcCurso());
         ps.setFloat(4, asignacion.getProgreso());
         ps.setInt(5, asignacion.getIdProyecto());
         ps.setString(6, asignacion.getMatriculaProfesor());
         ps.setString(7, asignacion.getMatriculaEstudiante());
         rs = ps.executeQuery();
         created = true;
         ps.close();
         rs.close();
         con.close();
      } catch (SQLException e) {
         throw new Exception("Error en create SQLException " + e.getMessage());
      } catch (NullPointerException e) {
         throw new Exception("Error en create NullPointerException " + e.getMessage());
      } catch (Exception e) {
         throw new Exception("Error en create Exception " + e.getMessage());
      } finally {
         try {
            if (ps != null) {
               ps.close();
            }
         } catch (Exception e) {
         };
         try {
            if (con != null) {
               con.close();
            }
         } catch (Exception e) {
         };
      }
      return created;
   }
}
