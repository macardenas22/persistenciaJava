package org.example.platzi.Services;

import org.example.platzi.DAO.MensajeDAO;
import org.example.platzi.Model.Mensaje;

import java.sql.SQLException;
import java.util.Scanner;

public class MensajeService {

//metodos para el menu para conectarse a la capa dao

    public static void crearMensaje() throws SQLException {
        Scanner sc = new Scanner(System.in); //lee datos en pantalla con el objeto y como parametro lo que obtiene del teclado

        System.out.println("Escribe tu Mensaje :");
        String mensaje =sc.nextLine();//Toma el mensaje y lo almacena en la variable mensaje
        System.out.println("Ingresa Tu nombre :");
        String nombre = sc.nextLine();
        //Crea objeto para enviar a la capa DAo la información de un registro con Mensaje y autor al metodo crearMensajeDB
        Mensaje registro = new Mensaje();
        registro.setMensaje(mensaje);
        registro.setAutor_mensaje(nombre);
        MensajeDAO.crearMensajeBD(registro);
    }

    public static void listarMensaje(){
        MensajeDAO.leerMensajeBD();
    }

    public static void borrarMensaje(){
        //solicitamos y leemos el id de registro a borrar
        Scanner sc = new Scanner(System.in);//ingreso por teclado del id
        System.out.println("ingreso el id del mensaje a borrar");
        int id_msj = sc.nextInt();//almacena id por teclado
        MensajeDAO.borrarMensajeBD(id_msj);


    }

    public static void editarMensaje(){
        //solicitamos y leemos el id de registro a borrar
        Scanner sc = new Scanner(System.in);//ingreso por teclado
        System.out.println("Escribe tu nuevo mensaje");
        String msj = sc.nextLine();//almacena mensaje

        System.out.println("ingreso el id del mensaje a borrar");
        int id_msj = sc.nextInt();//almacena id por teclado

        //crea objeto para almacenar dato en objetos
        Mensaje actualizacion = new Mensaje();
        actualizacion.setId_mensaje(id_msj);
        actualizacion.setMensaje(msj);
        //envia a capa Dao
        MensajeDAO.actualizarMensajeBD(actualizacion);
    }


}
