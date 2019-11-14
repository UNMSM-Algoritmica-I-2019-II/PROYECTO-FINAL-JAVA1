/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dbconected;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Gonzalo
 */
public class metodos {

    public static basedatos conexion = new basedatos();

    public static PreparedStatement sentencia_preparada;
    public static ResultSet resultado;
    public static int resultado_numero;

    public static String buscarNombre(String usuario) {

        String busqueda_nombre = null;
        Connection conexion = null;
        try {
            conexion = basedatos.conectar();
            String sentencia_buscar = ("SELECT nombre,apellidos FROM EMPLEADOS WHERE usuario = '" + usuario + "'");
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar);
            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()) {
                String nombre = resultado.getString("nombre");
                String apellidos = resultado.getString("apellidos");
                busqueda_nombre = (nombre + " " + apellidos);
            }
            conexion.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return busqueda_nombre;
    }
    
    public static String buscarUsuarioRegistrado(String usuario, String contraseña){
        String busqueda_usuario = null;
        Connection conexion = null;
        
        
        try {
            conexion = basedatos.conectar();
            String sentencia_buscar_usuario = ("SELECT usuario,contraseña FROM empleados WHERE usuario = '"+ usuario +"' and contraseña ='"+ contraseña + "'" );
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar_usuario);
            resultado = sentencia_preparada.executeQuery();
            if(resultado.next()){
                busqueda_usuario = "usuario encontrado";
            }
            else{
                busqueda_usuario = "usuario no encontrado";
            }
            conexion.close();
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return busqueda_usuario;
        
        
    }

}
