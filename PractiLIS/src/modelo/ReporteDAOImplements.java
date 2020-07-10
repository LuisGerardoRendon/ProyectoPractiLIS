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
import java.sql.SQLException;

/**
 *
 * @author ALDO
 */
public class ReporteDAOImplements implements ReporteDAO{
   
   @Override
   public boolean create(ReporteVO reporte) throws Exception{
        boolean created =false;
        PreparedStatement ps = null;
        Connection con=null;
        
        try{
            con=null;
            ConexionBD cc=new ConexionBD();
            con=cc.conectarMySQL();
            
            String sql = "INSERT INTO reporte (numero,horasReportadas, fechaCarga, estado, reporte, "
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
            ps.setInt(8,1);
            
            ps.executeUpdate();
            created=true;
            con.close();
            ps.close();
            
        }catch(SQLException e){
            throw new Exception("Error en create SQLException " + e.getMessage());
        }catch(NullPointerException e){
            throw new Exception("Error en create NullPointerException " + e.getMessage());
        }catch (Exception e) {
         throw new Exception("Error en create Exception " + e.getMessage());
        }finally{
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
