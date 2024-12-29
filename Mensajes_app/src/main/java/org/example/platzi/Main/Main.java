package org.example.platzi.Main;

import org.example.platzi.Services.MensajeService;
import org.example.platzi.conexion.Conexion;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //leer datos desde consola Scanner
        Scanner sc = new Scanner(System.in);

        int opcion = 0;
        do {
            System.out.println("------------------------------");
            System.out.println("Aplicación de Mensajes\n" +
                    " 1.Crear Mensaje\n 2.Listar Mensaje\n 3.Editar Mensaje\n" +
                    " 4.Eliminar Mensaje\n 5.Salir");
            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    MensajeService.crearMensaje();
                    break;
                case 2:
                    MensajeService.listarMensaje();
                    break;
                case 3:
                    MensajeService.borrarMensaje();
                    break;
                case 4:
                    MensajeService.editarMensaje();
                    break;
                case 5:
                    break;
                default:

                    break;
            }





        }while(opcion !=5);







        /*
        //validamos la conexión creando el objeto y con un try intentamos conectarnos
        Conexion conexion = new Conexion();
        try(Connection cnx = conexion.get_connection()){}
        catch (Exception e) {
            System.out.println(e)
        }*/



    }
}