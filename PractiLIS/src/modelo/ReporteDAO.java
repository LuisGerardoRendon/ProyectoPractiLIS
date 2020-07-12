/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javafx.collections.ObservableList;

/**
 *
 * @author ALDO
 */
public interface ReporteDAO {
   boolean create(ReporteVO reporte,int idExpediente) throws Exception;
   public String crearSQLRecuperarReportes(String periodo, String matricula)throws Exception;
   public ObservableList<ReporteVO> recuperarReportes(String periodo, 
           String matricula)throws Exception;
   
}
