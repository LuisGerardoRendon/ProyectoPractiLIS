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
 * @author Sammy Guergachi <sguergachi at gmail.com>
 * @version 1.1, 09/jul/2020
 */
public class EstudianteDAOImplements implements EstudianteDAO {

   @Override
   public ObservableList<EstudianteVO> recuperaNombreMatricula() throws Exception {
      Connection con = null;
      Statement stm = null;
      ResultSet rs = null;
      String sql = "SELECT matricula, nombre FROM estudiante WHERE status='Sin asignar'";

      ObservableList<EstudianteVO> estudiantesRecuperadosList = FXCollections.observableArrayList();

      try {
         con = new ConexionBD().conectarMySQL();
         stm = con.createStatement();
         rs = stm.executeQuery(sql);
         while (rs.next()) {
            String matricula = rs.getString("matricula");
            String nombre = rs.getString("nombre");
            
            EstudianteVO e = new EstudianteVO(nombre, matricula);
            estudiantesRecuperadosList.add(e);
         }
         stm.close();
         rs.close();
         con.close();
      } catch (SQLException e) {
         System.out.println("ERROR. Clase Producto_DAO_Imp, metodo ReadAll");
         e.printStackTrace();
      }
      return estudiantesRecuperadosList;
   }

   @Override
   public EstudianteVO recuperarEstudiante(String matricula, String contrasenia) throws Exception {
      EstudianteVO estudianteRecuperado = null;
      String sql = crearSQLestaRegistrado(matricula, contrasenia);
      Connection con = null;
      Statement stm = null;
      ConexionBD cc = new ConexionBD();
      ResultSet rs = null;
      try {
         con = cc.conectarMySQL();
         stm = con.createStatement();
         rs = stm.executeQuery(sql);
         if (rs.next()) {
            String nombre = rs.getString("nombre");
            String correoElectronico = rs.getString("correoElectronico");
            String status = rs.getString("status");
            estudianteRecuperado = new EstudianteVO(matricula, contrasenia, nombre, correoElectronico, status);
         }
         con.close();
         stm.close();
         rs.close();
      } catch (SQLException e) {
         System.out.println("ERROR EN EJECUTAR CONSULTA:  ");
         e.printStackTrace();

      }

      return estudianteRecuperado;
   }

   @Override
   public String crearSQLestaRegistrado(String matricula, String contrasenia) {
      String sql = "SELECT * FROM Estudiante WHERE matricula = '" + matricula;
      sql += "' AND contrasenia = '" + contrasenia + "';";
      return sql;
   }

}
