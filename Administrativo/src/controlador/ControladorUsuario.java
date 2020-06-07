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
import javax.swing.JOptionPane;
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
    
    public Integer deshabilitarUsuario(Integer id_usuario, Integer estado) {
        Integer fila =0;
        this.sql="update usuario set estado = ? where id_usuario=?";
        try {
            Class.forName(bd.getDriver());
            this.con= DriverManager.getConnection(bd.getUrl(), bd.getUsuario(),bd.getContraseña());
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setInt(1, estado);
            this.pst.setInt(2, id_usuario);
            fila = this.pst.executeUpdate();
            this.con.close();
            //this.rs.close();
            return fila;
            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return fila; 
    }
    
    public Integer actualizarProfesional(String usuario, Integer prioridad, String contra, String foto_usuario, 
                Integer estado, Integer id){
        Integer fila=0;
        this.sql = "UPDATE usuario set nombre_usuario=?, prioridad=?, contra=?, foto_usuario=?, estado=? where id_usuario = ?";
        try {
            Class.forName(bd.getDriver());
            this.con= DriverManager.getConnection(bd.getUrl(), bd.getUsuario(),bd.getContraseña());
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setString(1, usuario);
            this.pst.setInt(2, prioridad);
            this.pst.setString(3, contra);
            this.pst.setString(4, foto_usuario);
            this.pst.setInt(5, estado);
            this.pst.setInt(6, id);
            fila = this.pst.executeUpdate();
            this.con.close();
            //this.rs.close();
            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return fila;
    }
    
    public Integer InsertarProfesional(String usuario, Integer prioridad, String contra, String foto_usuario, 
                Integer estado, Integer id){
        Integer fila=0;
        this.sql = "insert into usuario (id_usuario, nombre_usuario, prioridad, contra, foto_usuario, estado) values(?,?,?,?,?,?)";
        try {
            Class.forName(bd.getDriver());
            this.con= DriverManager.getConnection(bd.getUrl(), bd.getUsuario(),bd.getContraseña());
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setInt(1, id);
            this.pst.setString(2, usuario);
            this.pst.setInt(3, prioridad);
            this.pst.setString(4, contra);
            this.pst.setString(5, foto_usuario);
            this.pst.setInt(6, estado);
            
            fila = this.pst.executeUpdate();
            this.con.close();
            //this.rs.close();
            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return fila;
    }
    
    public Integer ultimoIdUsuario() {
        Integer max = 0;
        this.sql="select id_usuario from usuario";
        try {
            Class.forName(bd.getDriver());
            this.con= DriverManager.getConnection(bd.getUrl(), bd.getUsuario(),bd.getContraseña());
            this.pst = this.con.prepareStatement(this.sql);
            this.rs = this.pst.executeQuery();
            while(this.rs.next()){
                max = this.rs.getInt("id_usuario");
            }
            this.con.close();
            this.rs.close();
            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            max = 0;
        }
        return max;
    }
}
