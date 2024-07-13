/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author starlord
 */
public class MensajesDAO {
    
    public static void crearMensajeDB(Mensajes mensaje){
        Conexion db_connect = new Conexion();
        
        try(Connection conexion = db_connect.get_connection()){            
            try{
               String query ="INSERT INTO mensajes (mensaje, autor_mensaje) VALUES (?,?)";
               PreparedStatement ps = conexion.prepareStatement(query);
               ps.setString(1, mensaje.getMensaje());
               ps.setString(2, mensaje.getAutor_mensaje());
               ps.executeUpdate();
               System.out.println("Mensaje creado");
            }catch(SQLException ex){
                System.out.println(ex);
            }
            
        }catch(SQLException e){
            System.out.println(e);
        }
    
    }
    
    public static void leerMensajesDB(){
        Conexion db_connect = new Conexion();
        
        ResultSet rs = null;
                
        try(Connection conexion = db_connect.get_connection()){            
            try{
               String query ="SELECT * FROM mensajes";
               PreparedStatement ps = conexion.prepareStatement(query);
               rs = ps.executeQuery();
               
               while(rs.next()){
                   System.out.println("ID: "+rs.getInt("id_mensaje"));
                   System.out.println("Mensaje: "+rs.getString("mensaje"));
                   System.out.println("Autor: "+rs.getString("autor_mensaje"));
                   System.out.println("Fecha: "+rs.getString("fecha_mensaje"));
                   System.out.println("");
               }
               
            }catch(SQLException ex){
                System.out.println(ex);
            }
            
        }catch(SQLException e){
            System.out.println("no se pudieron recuperar los mensajes");
            System.out.println(e);
        }
    
    }
    
    public static void borrarMensaje(int id_mensaje){
        Conexion db_connect = new Conexion();
        
        try(Connection conexion = db_connect.get_connection()){            
            try{
               String query ="DELETE FROM mensajes WHERE id_mensaje=?";
               PreparedStatement ps = conexion.prepareStatement(query);               
               ps.setInt(1, id_mensaje);               
               ps.executeUpdate();
               System.out.println("Mensaje eliminado");
            }catch(SQLException ex){
                System.out.println("no se pudo eliminar el registro");
                System.out.println(ex);                
            }            
        }catch(SQLException e){
            System.out.println("Error en la conexion a la BBDD");
            System.out.println(e);
        }
    }
    
    public static void actualizarMensaje(Mensajes mensaje){
        Conexion db_connect = new Conexion();
        
        try(Connection conexion = db_connect.get_connection()){            
            try{
               String query ="UPDATE mensajes SET mensaje = ? WHERE id_mensaje = ?";
               PreparedStatement ps = conexion.prepareStatement(query);
               ps.setString(1, mensaje.getMensaje());
               ps.setInt(2, mensaje.getId_mensaje());               
               ps.executeUpdate();
               System.out.println("Mensaje actualizado");
            }catch(SQLException ex){
                System.out.println("no se pudo actualizar el registro");
                System.out.println(ex);                
            }            
        }catch(SQLException e){
            System.out.println("Error en la conexion a la BBDD");
            System.out.println(e);
        }
    }
}
