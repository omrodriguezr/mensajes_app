/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mensajes_app;

import java.sql.Connection;

/**
 *
 * @author starlord
 */
public class Mensajes_app {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        Conexion conexion = new Conexion();
        try(Connection cnx = conexion.get_connection()){
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
