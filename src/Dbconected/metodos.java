/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dbconected;

import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;

/**
 *
 * @author Gonzalo
 */
public class metodos {
    

    public static basedatos conexion = new basedatos();
    
    static Connection conn=null;
    static Statement st=null;
    static ResultSet rs=null;
    public static PreparedStatement sentencia_preparada;
    public static ResultSet resultado;
    public static int resultado_numero;

    public static String buscarNombre(String usuario) {

        String busqueda_nombre = null;
        Connection coneccion = null;
        try {
            coneccion = basedatos.conectar();
            String sentencia_buscar = ("SELECT nombre,apellidos FROM EMPLEADOS WHERE usuario = '" + usuario + "'");
            sentencia_preparada = coneccion.prepareStatement(sentencia_buscar);
            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()) {
                String nombre = resultado.getString("nombre");
                String apellidos = resultado.getString("apellidos");
                busqueda_nombre = (nombre + " " + apellidos);
            }
            coneccion.close();

        } catch (SQLException e) {
            System.out.println(e);
        }

        return busqueda_nombre;
    }
    
    public static String buscarUsuarioRegistrado(String usuario, String contraseña){
        String busqueda_usuario = null;
        Connection coneccion2 = null;
        
        
        try {
            coneccion2 = basedatos.conectar();
            String sentencia_buscar_usuario = ("SELECT usuario,contraseña FROM empleados WHERE usuario = '"+ usuario +"' and contraseña ='"+ contraseña + "'" );
            sentencia_preparada = coneccion2.prepareStatement(sentencia_buscar_usuario);
            resultado = sentencia_preparada.executeQuery();
            if(resultado.next()){
                busqueda_usuario = "usuario encontrado";
            }
            else{
                busqueda_usuario = "usuario no encontrado";
            }
            coneccion2.close();
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return busqueda_usuario;
        
        
    }
    
    
    

}
