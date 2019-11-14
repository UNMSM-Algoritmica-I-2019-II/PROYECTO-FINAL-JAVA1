/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dbconected;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Gonzalo
 */
public class basedatos {

    public static String url = "jdbc:oracle:thin:@localhost:1521:XE";
    public static String usuario = "gonzalo";
    public static String contraseña = "admin";
    public static String clase = "oracle.jdbc.OracleDriver";

    public static Connection conectar() {
        Connection conexion = null;

        try {
            Class.forName(clase);
            conexion = (Connection) DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("conexion establecida");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return conexion;
    }
    
    public static void main(String [] args){
        conectar();
    }

}
