/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Paq_Base_Datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Operaciones_BD {
    
    public java.sql.Connection conn;
    Statement st;
    
    public ResultSet Consultar(String sql) throws SQLException{
        conn= Conexion_DB.geConnection();
        st = conn.createStatement();
        ResultSet resultado = st.executeQuery(sql);
        return resultado;
    }
    
    public PreparedStatement Actualizar(String sql) throws SQLException{
        conn= Conexion_DB.geConnection();
        st = conn.createStatement();
        PreparedStatement st = conn.prepareCall(sql);
        return st;
    }
    
    public PreparedStatement Ingresar(String sql) throws SQLException{
        conn= Conexion_DB.geConnection();
        st = conn.createStatement();
        PreparedStatement st = conn.prepareCall(sql);
        return st;
    }
    
    public Statement Eliminar(String sql) throws SQLException{
        conn= Conexion_DB.geConnection();
        st = conn.createStatement();
        return st;
    }
            
}
