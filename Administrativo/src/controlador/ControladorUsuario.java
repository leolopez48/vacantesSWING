/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.ModeloUsuario;

/**
 *
 * @author Leonel
 */
public class ControladorUsuario {
    modelo.ModeloProfesional emp = new modelo.ModeloProfesional();
    Credenciales bd = new Credenciales();
    List<modelo.ModeloUsuario> data = new ArrayList<>();
    String sql="";
    PreparedStatement pst;
    ResultSet rs;
    Connection con;
    
    /*public List<modelo.ModeloUsuario> seleccionarUsuario() {
        this.sql="SELECT * FROM profesional AS pro INNER JOIN usuario as usu ON pro.id_usuario = usu.id_usuario";
        try {
            Class.forName(bd.getDriver());
            this.con= DriverManager.getConnection(bd.getUrl(), bd.getUsuario(),bd.getContraseña());
            this.pst = this.con.prepareStatement(this.sql);
            this.rs = this.pst.executeQuery();
            while(this.rs.next()){
                data.add(new modelo.ModeloUsuario(this.rs.getInt("id_usuario"), 
                        this.rs.getString("nombre_usuario"),
                        this.rs.getInt("prioridad"),
                        this.rs.getString("foto"),
                        this.rs.getString("contra"),
                        this.rs.getInt("estado"),
                        this.rs.getInt("id_profesional"), 
                        this.rs.getInt("edad"), 
                        this.rs.getString("nombre_profesional"),
                        this.rs.getString("apellido_profesional"),
                        this.rs.getString("correo")
                ));
                
                        //this.rs.getDouble("salario"), 
                        //new Departamentos(this.rs.getInt("idDepartamento"))));
            }
            this.con.close();
            this.rs.close();
            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return this.data;  
    }*/
}