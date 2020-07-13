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
 * @author ALDO
 */
public class ExpedienteDAOImplements implements ExpedienteDAO {

   @Override
   public ExpedienteVO obtenerExpediente(String matricula) throws Exception {
      String sql = crearSQLRecuperarExpedienteEstudiante(matricula);
      ExpedienteVO expedienteRecuperado = new ExpedienteVO();
      Connection con = null;
      Statement stm = null;
      ConexionBD cc = new ConexionBD();
      ResultSet rs = null;
      try {
         con = cc.conectarMySQL();
         stm = con.createStatement();
         rs = stm.executeQuery(sql);
         if (rs.next()) {
            int idExpediente = rs.getInt("idExpediente");

            expedienteRecuperado = new ExpedienteVO(idExpediente);

         }
         con.close();
         stm.close();
         rs.close();
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
      return expedienteRecuperado;
   }

   @Override
   public String crearSQLRecuperarExpedienteEstudiante(String matricula) {
      String sql;
      sql = "SELECT idExpediente FROM Expediente INNER JOIN "
              + "Asignacion ON Expediente.idAsignacion=Asignacion.idAsignacion "
              + "INNER JOIN Estudiante ON Asignacion.matriculaEstudiante=Estudiante.matricula "
              + "WHERE matricula= '" + matricula + "';";
      System.out.println(sql);
      return sql;
   }

   @Override
   public boolean create(ExpedienteVO expediente) throws Exception {
      boolean created = false;
      Connection con = null;
      Statement stm = null;
      String sql = "INSERT INTO expediente VALUES (null, '" + expediente.getIdAsignacion() + "')";
      System.out.println(sql);
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
}
