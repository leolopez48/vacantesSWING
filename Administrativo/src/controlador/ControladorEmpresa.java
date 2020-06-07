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
import modelo.ModeloEmpresa;
import modelo.ModeloProfesional;

/**
 *
 * @author Roberto
 */
public class ControladorEmpresa {
     modelo.ModeloEmpresa emp = new modelo.ModeloEmpresa();
    Credenciales bd = new Credenciales();
    List<modelo.ModeloEmpresa> data = new ArrayList<>();
    String sql="";
    PreparedStatement pst;
    ResultSet rs;
    Connection con;
    
    public List<modelo.ModeloEmpresa> seleccionar() {
        this.sql="select * from empresa inner join usuario on empresa.id_usuario = usuario.id_usuario";
        try {
            Class.forName(bd.getDriver());
            this.con= DriverManager.getConnection(bd.getUrl(), bd.getUsuario(),bd.getContraseña());
            this.pst = this.con.prepareStatement(this.sql);
            this.rs = this.pst.executeQuery();
            while(this.rs.next()){
                data.add(new modelo.ModeloEmpresa(this.rs.getInt("id_empresa"),  
                        this.rs.getString("nombre_empresa"),
                        this.rs.getString("descripcion"),
                        this.rs.getInt("id_usuario"),
                        this.rs.getString("nombre_usuario"),
                        this.rs.getInt("prioridad"),
                        this.rs.getString("contra"),
                        this.rs.getString("foto_usuario"),
                        this.rs.getInt("estado")
                        
                ));
                        
            }
            this.con.close();
            this.rs.close();
            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return this.data;  
    }
    
    public modelo.ModeloEmpresa seleccionarEmpresa(Integer id_empresa) {
        ModeloEmpresa emp=null;
        this.sql="SELECT * FROM empresa AS pro INNER JOIN usuario as usu ON pro.id_empresa = usu.id_usuario where pro.id_empresa=?";
        try {
            Class.forName(bd.getDriver());
            this.con= DriverManager.getConnection(bd.getUrl(), bd.getUsuario(),bd.getContraseña());
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setInt(1, id_empresa);
            this.rs = this.pst.executeQuery();
            while(this.rs.next()){
                
                    emp = (new modelo.ModeloEmpresa(this.rs.getInt("id_empresa"),  
                        this.rs.getString("nombre_empresa"),
                        this.rs.getString("descripcion"),
                        this.rs.getInt("id_usuario"),
                        this.rs.getString("nombre_usuario"),
                        this.rs.getInt("prioridad"),
                        this.rs.getString("contra"),
                        this.rs.getString("foto_usuario"),
                        this.rs.getInt("estado")
                    ));
            }
            this.con.close();
            this.rs.close();
            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return emp;  
    }
    
    
    public Integer actualizarEmpresa(String nombre_empresa, String descripcion, Integer id_usuario){
                                                          
        Integer fila=0;
        this.sql = "UPDATE empresa as emp inner join usuario as usu on emp.id_empresa = usu.id_usuario set emp.nombre_empresa= ? ,emp.descripcion=? where usu.id_usuario = ?";
        try {
            Class.forName(bd.getDriver());
            this.con= DriverManager.getConnection(bd.getUrl(), bd.getUsuario(),bd.getContraseña());
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setString(1, nombre_empresa);
            this.pst.setString(2, descripcion);
            this.pst.setInt(3, id_usuario);
            fila = this.pst.executeUpdate();
            this.con.close();
            //this.rs.close();
            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, sql, 0);
        }
        return fila;
    }
    
    public Integer insertarEmpresa(Integer id_empresa, String nombre_empresa, String descripcion, Integer id_usuario){
                                                          
        Integer fila=0;
        this.sql = "insert into empresa (id_empresa, nombre_empresa, descripcion, id_usuario) values(?,?,?,?)";
        try {
            Class.forName(bd.getDriver());
            this.con= DriverManager.getConnection(bd.getUrl(), bd.getUsuario(),bd.getContraseña());
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setInt(1, id_empresa);
            this.pst.setString(2, nombre_empresa);
            this.pst.setString(3, descripcion);
            this.pst.setInt(4, id_usuario);
            fila = this.pst.executeUpdate();
            this.con.close();
            //this.rs.close();
            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, sql, 0);
        }
        return fila;
    }
    
    public Integer ultimoIdEmpresa() {
        Integer max = 0;
        this.sql="select id_empresa from empresa";
        try {
            Class.forName(bd.getDriver());
            this.con= DriverManager.getConnection(bd.getUrl(), bd.getUsuario(),bd.getContraseña());
            this.pst = this.con.prepareStatement(this.sql);
            this.rs = this.pst.executeQuery();
            while(this.rs.next()){
                max = this.rs.getInt("id_empresa");
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
