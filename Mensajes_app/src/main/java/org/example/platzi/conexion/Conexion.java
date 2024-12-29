package org.example.platzi.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    //creamos un metodo que devuelve un objeto tipo connection llamado get_connection, para conectarse a la base de datos
    public Connection get_connection() {
        //creamos un objeto de tipo Conennction llamado conexbd de valor null
        Connection conexbd = null;
        try{
            //la clase drivemanager trae la conexion con BD con parametro url, base datos , usuario, pass
            conexbd = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app","root","1234");
            // validamos conexion a la bd si es diferente de null
            if (conexbd != null){
                System.out.println("get Conection");
            }
        }catch (SQLException e){ //refleja error si no hya conexion
            System.out.println(e);
        }
        return conexbd;
    }


}
