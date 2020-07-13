/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 * @version 1.1, 09/jul/2020
 */
public class EncargadoProyectoDAOImplements implements EncargadoProyectoDAO {

   @Override
   public EncargadoProyectoVO recuperarEncargadoProyecto(ProyectoVO proyectoVO) throws Exception {
      int idProyecto = proyectoVO.getIdProyecto();
      String sql = "SELECT * FROM EncargadoProyecto WHERE idEncargadoProyecto = "
              + proyectoVO.getIdEncargadoProyecto();
      EncargadoProyectoVO encargadoProyectoRecuperdo = new EncargadoProyectoVO();
      Connection con = null;
      Statement stm = null;
      ConexionBD cc = new ConexionBD();
      ResultSet rs = null;
      try {
         con = cc.conectarMySQL();
         stm = con.createStatement();
         rs = stm.executeQuery(sql);
         rs.next();
         int idEncargado = rs.getInt("idEncargadoProyecto");
         String nombre = rs.getString("nombre");
         String cargo = rs.getString("cargo");
         String correoElectronico = rs.getString("correoElectronico");
         encargadoProyectoRecuperdo = new EncargadoProyectoVO(idEncargado,
                 nombre, cargo, correoElectronico);
         con.close();
         stm.close();
         rs.close();
      } catch (SQLException e) {
         throw new SQLException("Error en recuperarEncargadoProyecto SQLException " + e.getMessage());
      } catch (NullPointerException e) {
         throw new NullPointerException("Error en recuperarEncargadoProyecto NullPointerException " 
                 + e.getMessage());
      } catch (ConnectException e) {
         throw new ConnectException("Error en recuperarEncargadoProyecto ConnectException " 
                 + e.getMessage());
      } catch (Exception e) {
         throw new Exception("Error en recuperarEncargadoProyecto Exception " + e.getMessage());
      } finally {
         try {
            if (stm != null) {
               stm.close();
            }
         } catch (Exception e) {
         };
         try {
            if (rs != null) {
               rs.close();
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
      return encargadoProyectoRecuperdo;
   }

   @Override
   public boolean registrarEncargadoProyecto(EncargadoProyectoVO encargado) throws Exception {
      boolean registrado = false;
      String nombre = encargado.getNombre();
      String cargo = encargado.getCargo();
      String correoElectronico = encargado.getCorreoElectronico();
      String sql = "INSERT INTO EncargadoProyecto VALUES (";
      sql += "'" + nombre + "',";
      sql += "'" + cargo + "',";
      sql += "'" + correoElectronico + "',";
      sql += "null);";

      Statement stm = null;
      Connection con = null;
      ConexionBD cc = new ConexionBD();
      try {
         con = cc.conectarMySQL();
         stm = con.createStatement();
         stm.execute(sql);
         registrado = true;
         con.close();
         stm.close();
      }catch (SQLException e) {
         throw new SQLException("Error en registrarEncargadoProyecto SQLException " + e.getMessage());
      } catch (NullPointerException e) {
         throw new NullPointerException("Error en registrarEncargadoProyecto NullPointerException " + e.getMessage());
      }catch (ConnectException e) {
         throw new ConnectException("Error en registrarEncargadoProyecto ConnectException " + e.getMessage());
      } catch (Exception e) {
         throw new Exception("Error en registrarEncargadoProyecto Exception " + e.getMessage());
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
      return registrado;
   }
}
