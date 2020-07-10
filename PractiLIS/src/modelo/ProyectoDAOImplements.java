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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Daniel Pale
 */
public class ProyectoDAOImplements implements ProyectoDAO{

   @Override
   public ObservableList<ProyectoVO> recuperarProyecto() throws Exception {
      String sql = "SELECT * FROM proyecto WHERE status='Sin asignar'";
      Connection con = null;
      Statement stm = null;
      ConexionBD cc = new ConexionBD();
      ResultSet rs = null;

      ObservableList<ProyectoVO> obs = FXCollections.observableArrayList();
      try {
         con = cc.conectarMySQL();
         stm = con.createStatement();
         rs = stm.executeQuery(sql);
         while (rs.next()) {
            int idProyecto = rs.getInt("idProyecto");
            String nombreProyecto = rs.getString("nombre");
            String descripcion = rs.getString("descripcion");
            int capacidadEstudiantes = rs.getInt("capacidadEstudiantes");
            int numEstudiantesAsignados = rs.getInt("numEstudiantesAsignados");
            String status = rs.getString("status");
            int idOrganizacion = rs.getInt("idOrganizacion");
            int idEncargadoProyecto = rs.getInt("idEncargadoProyecto");

            ProyectoVO c = new ProyectoVO(idProyecto,nombreProyecto, descripcion, 
                    capacidadEstudiantes, numEstudiantesAsignados, status, idOrganizacion, 
                    idEncargadoProyecto);
            obs.add(c);
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
      return obs;
   }
}
