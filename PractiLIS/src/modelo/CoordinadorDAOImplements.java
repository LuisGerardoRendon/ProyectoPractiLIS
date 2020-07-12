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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 * @version 1.1, 11/jul/2020
 */
public class CoordinadorDAOImplements implements CoordinadorDAO {

   @Override
   public boolean login(String usuario, String contrasenia) throws Exception {
      String sql = crearSQLrecuperarCoordinador(usuario, contrasenia);
      boolean encontrado = false;
      Connection con = null;
      Statement stm = null;
      ConexionBD cc = new ConexionBD();
      ResultSet rs = null;

      try {
         con = cc.conectarMySQL();
         stm = con.createStatement();
         rs = stm.executeQuery(sql);
         if (rs.next()) {
            encontrado = true;
         }

      } catch (SQLException e) {
         throw new Exception("Error en Login SQLException " + e.getMessage());
      } catch (NullPointerException e) {
         throw new Exception("Error en Login NullPointerException " + e.getMessage());
      } catch (Exception e) {
         throw new Exception("Error en Login Exception " + e.getMessage());
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
      return encontrado;

   }

   @Override
   public String crearSQLrecuperarCoordinador(String usuario, String contrasenia) {
      String sql = "SELECT * FROM coordinador WHERE usuario "
              + "= '" + usuario + "'" + "AND contrasenia = '" + contrasenia + "';";

      return sql;
   }

}
