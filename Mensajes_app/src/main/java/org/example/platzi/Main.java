package org.example.platzi;

import org.example.platzi.conexion.Conexion;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        //validamos la conexión creando el objeto y con un try intentamos conectarnos
        Conexion conexion = new Conexion();

        try(Connection cnx = conexion.get_connection()){} 
        catch (Exception e) {
            System.out.println(e);
        }


    }
}