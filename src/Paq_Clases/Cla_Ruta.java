/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paq_Clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Navarro
 */
public class Cla_Ruta {
    private String ruta;
    Paq_Base_Datos.Operaciones_BD operaciones = new Paq_Base_Datos.Operaciones_BD();

    public String getRuta() {
        try {
            String sql = "select direccion from valores";
            ResultSet rs= operaciones.Consultar(sql);
            while(rs.next()){
            ruta = rs.getString("direccion"); 
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    
    
}
