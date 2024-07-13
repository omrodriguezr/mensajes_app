/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajes_app;

import java.util.Scanner;

/**
 *
 * @author starlord
 */
public class MensajesService {
    
    public static void creaMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje");
        String mensaje = sc.nextLine();
        
        System.out.println("Escribe tu nombre");
        String nombre = sc.nextLine();
        
        Mensajes registro = new Mensajes();
        
        registro.setMensaje(mensaje);
        registro.setAutor_mensaje(nombre);
        
        MensajesDAO.crearMensajeDB(registro);
    }
    
    public static void listarMensajes(){
        MensajesDAO.leerMensajesDB();
    }
    
    public static void borrarMensaje(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Escribe el ID del mensaje a eliminar");
        int id_mensaje = sc.nextInt();
        
        MensajesDAO.borrarMensaje(id_mensaje);
        
    }
    
    public static void editarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe mensaje a actualizar");
        String mensaje = sc.nextLine();
        
        System.out.println("Escribe el ID a actualizar");
        int id_mensaje = sc.nextInt();
        
        Mensajes actualizacion = new Mensajes();
        actualizacion.setId_mensaje(id_mensaje);
        actualizacion.setMensaje(mensaje);
        
        MensajesDAO.actualizarMensaje(actualizacion);
    }
    
}
