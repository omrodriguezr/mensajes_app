/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.util.Scanner;

/**
 *
 * @author starlord
 */
public class Mensajes_app {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int opcion=0;
        
        do {
            System.out.println("------------------------");
            System.out.println("Aplicacion de mensajes");
            System.out.println("1. Crear mensaje");
            System.out.println("2. Listar mensajes");
            System.out.println("3. Editar mensaje");
            System.out.println("4. Eliminar mensaje");
            System.out.println("5. Salir");
            
            //leemos la opcion del usuario
            opcion = sc.nextInt();
            
            switch (opcion){
                case 1:
                    MensajesService.creaMensaje();
                    break;
                case 2:
                    MensajesService.listarMensajes();
                    break;
                case 3:
                    MensajesService.editarMensaje();
                    break;
                case 4:
                    MensajesService.borrarMensaje();
                    break;
                default:
                    break;    
            }
            
        }while(opcion != 5);
                
    }
}
