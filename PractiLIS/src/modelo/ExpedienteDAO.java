/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author ALDO
 */
public interface ExpedienteDAO {
    public ExpedienteVO obtenerExpedienteEstudiante(String matricula) throws Exception;
    
    public String crearSQLRecuperarExpedienteEstudiante(String matricula);
    
    public boolean create(ExpedienteVO expediente) throws Exception; 
}
