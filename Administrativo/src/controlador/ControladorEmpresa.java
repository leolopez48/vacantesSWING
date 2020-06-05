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
        ModeloEmpresa pro=null;
        this.sql="SELECT * FROM empresa AS pro INNER JOIN usuario as usu ON pro.id_empresa = usu.id_usuario where pro.id_empresa=?";
        try {
            Class.forName(bd.getDriver());
            this.con= DriverManager.getConnection(bd.getUrl(), bd.getUsuario(),bd.getContraseña());
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setInt(1, id_empresa);
            this.rs = this.pst.executeQuery();
            while(this.rs.next()){
                
                    pro = (new modelo.ModeloEmpresa(this.rs.getInt("id_empresa"),  
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
        return pro;  
    }
    
}
