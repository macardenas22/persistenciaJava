package org.example.platzi.DAO;

import org.example.platzi.Model.Mensaje;
import org.example.platzi.conexion.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MensajeDAO {
    //4 metodos sin return

    public static void crearMensajeBD(Mensaje mensaje) throws SQLException { //recibe un objeto
        Conexion db_connect =new Conexion(); //objeto conexion para acceder a la base de datos
        try (Connection conexion = db_connect.get_connection()){ //objeto conexion para atar el metodo para conexion bd con db_connect
            PreparedStatement ps = null;
            try{
                String query ="INSERT INTO mensajes (mensaje, autor_mensaje) VALUES (?,?)";
                ps =conexion.prepareStatement(query);//preparar consulta enviando el parametro query
                // como hay dos parametros del query (?) usamos las caracteristicas de tipo dato-campo
                // posición (izq a dere, clase.getCampo)
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutor_mensaje());
                ps.executeUpdate();//actualiza info en la bd
                System.out.println("Mensaje Creado Correctamente");
            }
            catch(SQLException ex){
                System.out.println(ex);
            }

        }catch (SQLException e){ //excepción sql
            System.out.println(e);
        }


    }
    public static void leerMensajeBD(){
        Conexion db_connect =new Conexion(); //objeto conexion para acceder a la base de datos
        PreparedStatement ps = null; //permite preparar la sentencia
        ResultSet rs =null; //trae los datos en fila para procesarlo

        //valida conexión a BD
        try (Connection conexion = db_connect.get_connection()){
            String query = "SELECT * FROM mensajes";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery(); //ejecuta la consulta no tiene transacción solo trae info
            //con el while se genere mientras tenga datos los traiga con el metodo next() cada registro
            //cada getter obtenido de la tabla debe traer el tipo y nombre de campo tal cual esta en BD
            while (rs.next()){
                System.out.println("ID: "+rs.getInt("id_mensaje"));
                System.out.println("Mensaje: "+rs.getString("mensaje"));
                System.out.println("Autor: " + rs.getString("autor_mensaje"));
                System.out.println("Fecha: " + rs.getString("fecha_mensaje"));
                System.out.println("");
            }
        } catch (SQLException e) {
            System.out.println(e + "No se logro obtener mensaje");
        }


    }

    public static void borrarMensajeBD(int id_mensaje){
        Conexion db_connect =new Conexion(); //objeto conexion para acceder a la base de datos
        PreparedStatement ps = null; //permite preparar la sentencia
        //valida conexión a BD
        try (Connection conexion = db_connect.get_connection()){
            String query = "DELETE FROM mensajes WHERE id_mensaje =? "; //Query con 1 criterio
            ps = conexion.prepareStatement(query);
            ps.setInt(1,id_mensaje);//relaciona criterio ? con posición y nombre campo bd
            ps.executeUpdate(); //Delete por ser opración de tx de la BD
            System.out.println("El registro fue borrado");



        } catch (SQLException e) {
                System.out.println(e);
                System.out.println("No se logro obtener registros");
            }




    }

    public static void actualizarMensajeBD(Mensaje mensaje){ //recibe como parametro un objeto
        Conexion db_connect =new Conexion(); //objeto conexion para acceder a la base de datos

        try (Connection conexion = db_connect.get_connection()){
            PreparedStatement ps = null; //permite preparar la sentencia

            try{
                String query = "UPDATE mensajes SET mensaje = ? WHERE id_mensaje = ?";
                ps = conexion.prepareStatement(query);
                ps.setString(1,mensaje.getMensaje());
                ps.setInt(2,mensaje.getId_mensaje());
                ps.executeUpdate();
                System.out.println("Mensaje Actualizado Correctamente");
            } catch (Exception ex) {
                System.out.println("No se pudo actualizar el mensaje");
            }



        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
