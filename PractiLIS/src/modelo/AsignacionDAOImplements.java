/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Daniel Pale
 */
public class AsignacionDAOImplements implements AsignacionDAO {

   @Override
   public boolean create(AsignacionVO asignacion) throws Exception {
      boolean created = false;
      Connection con = null;
      Statement stm = null;
      ResultSet rs = null;
      String sql = "INSERT INTO asignacion VALUES (null,'" + asignacion.getPeriodo() + "',null,"
              + asignacion.getProgreso() + "," + asignacion.getIdProyecto() + ",null,'"
              + asignacion.getMatriculaEstudiante() + "')";
      try {
         con = new ConexionBD().conectarMySQL();
         stm = con.createStatement();
         stm.execute(sql);
         created = true;
         stm.close();
         con.close();
      } catch (SQLException e) {
         throw new Exception("Error en create SQLException " + e.getMessage());
      } catch (NullPointerException e) {
         throw new Exception("Error en create NullPointerException " + e.getMessage());
      } catch (Exception e) {
         throw new Exception("Error en create Exception " + e.getMessage());
      } finally {
         try {
            if (stm != null) {
               stm.close();
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

   @Override
   public int obtenerIdAsingacion(String matricula, String periodo) throws Exception {
      int idAsignacion = 0;
      Connection con = null;
      Statement stm = null;
      ResultSet rs = null;
      String sql = "SELECT idAsignacion FROM asignacion WHERE matriculaEstudiante = '"
              + matricula + "' AND periodo = '" + periodo + "'";
      System.out.println(sql);
      try {
         con = new ConexionBD().conectarMySQL();
         stm = con.createStatement();
         rs = stm.executeQuery(sql);
         if(rs.next()){
            idAsignacion = rs.getInt("idAsignacion");
         }
         stm.close();
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
            if (stm != null) {
               stm.close();
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
      return idAsignacion;
   }
}
