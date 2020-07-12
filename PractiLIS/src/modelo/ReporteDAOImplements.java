/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ALDO
 */
public class ReporteDAOImplements implements ReporteDAO {

   @Override
   public boolean create(ReporteVO reporte, int idExpediente) throws Exception {
      boolean created = false;
      PreparedStatement ps = null;
      Connection con = null;

      try {
         con = null;
         ConexionBD cc = new ConexionBD();
         con = cc.conectarMySQL();

         String sql = "INSERT INTO reporte (numero,horasReportadas, fechaCarga, estado, reporte,"
                 + "fechaInicio, fechaFin, idExpediente) VALUES (?, ?, ?, ?, ?, ?,?,?)";
         ps = con.prepareStatement(sql);

         ps.setInt(1, 0);
         ps.setInt(2, reporte.getHorasReportadas());
         ps.setString(3, reporte.getFechaCarga());
         ps.setString(4, reporte.getEstado());
         FileInputStream archivo = new FileInputStream(reporte.getReporte());
         ps.setBlob(5, archivo);
         ps.setString(6, reporte.getFechaInicio());
         ps.setString(7, reporte.getFechaFin());
         ps.setInt(8, idExpediente);

         ps.executeUpdate();
         created = true;
         con.close();
         ps.close();

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

   @Override
   public ObservableList<ReporteVO> recuperarReportes(String periodo, String matricula)
           throws Exception {
      String sql = crearSQLRecuperarReportes(periodo, matricula);
      ObservableList<ReporteVO> reportesRecuperados = FXCollections.observableArrayList();
      Connection con = null;
      Statement stm = null;
      ConexionBD cc = new ConexionBD();
      ResultSet rs = null;
      try {
         con = cc.conectarMySQL();
         stm = con.createStatement();
         rs = stm.executeQuery(sql);
         while (rs.next()) {
            int numero = rs.getInt("numero");
            int horasReportadas = rs.getInt("horasReportadas");
            String fechaCarga = rs.getString("fechaCarga");
            ReporteVO reporteRecuperado = new ReporteVO(numero, horasReportadas, fechaCarga);
            reportesRecuperados.add(reporteRecuperado);
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
      return reportesRecuperados;
   }

   @Override
   public String crearSQLRecuperarReportes(String periodo, String matricula) throws Exception {
      String sql = "SELECT Reporte.numero,Reporte.horasReportadas,"
              + "Reporte.fechaCarga, Reporte.Estado,Reporte.reporte,"
              + " Reporte.fechaInicio, Reporte.fechaFin";
      sql += " FROM Estudiante INNER JOIN Asignacion on Estudiante.matricula "
              + "= Asignacion.matriculaEstudiante";
      sql += " INNER JOIN Expediente on Asignacion.idAsignacion = "
              + "Expediente.idAsignacion ";
      sql += " INNER JOIN Reporte on Expediente.idExpediente = "
              + "Reporte.idExpediente ";
      sql += " WHERE Asignacion.periodo = " + "'" + periodo + "'";
      sql += " AND Asignacion.matriculaEstudiante =" + "'" + matricula + "';";
      System.out.println(sql);
      return sql;
   }

}
