/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Paq_Base_Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Flia Navarro Moreno
 */
public class Conexion_DB {

    private static String bd="sistema_ventas", user="postgres",pass="123456", url="jdbc:postgresql://192.168.0.106:5432/"+bd;
    private static Connection conn;
    
public static Connection geConnection(){
    try{
        Class.forName("org.postgresql.Driver");
        conn=DriverManager.getConnection(url,user,pass);
    }   catch (Exception e) {
           JOptionPane.showMessageDialog(null, "error"+e.getMessage());
        }
        return conn;
}
}
