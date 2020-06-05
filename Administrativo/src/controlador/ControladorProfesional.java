
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.ModeloGenero;
import modelo.ModeloProfesional;
import modelo.ModeloUsuario;

/**
 *
 * @author Leonel
 */
public class ControladorProfesional {
        modelo.ModeloProfesional emp = new modelo.ModeloProfesional();
    Credenciales bd = new Credenciales();
    List<modelo.ModeloProfesional> data = new ArrayList<>();
    String sql="";
    PreparedStatement pst;
    ResultSet rs;
    Connection con;
    
    
    
    public List<modelo.ModeloProfesional> seleccionar() {
        this.sql="select * from profesional inner join usuario on profesional.id_usuario = usuario.id_usuario inner join genero on profesional.id_genero = genero.id_genero";
        try {
            Class.forName(bd.getDriver());
            this.con= DriverManager.getConnection(bd.getUrl(), bd.getUsuario(),bd.getContraseña());
            this.pst = this.con.prepareStatement(this.sql);
            this.rs = this.pst.executeQuery();
            while(this.rs.next()){
                data.add(new modelo.ModeloProfesional(this.rs.getInt("id_profesional"), 
                        this.rs.getInt("edad"), 
                        this.rs.getString("nombre_profesional"),
                        this.rs.getString("apellido_profesional"),
                        this.rs.getString("correo"),
                        this.rs.getInt("id_usuario"),
                        this.rs.getString("nombre_usuario"),
                        this.rs.getInt("prioridad"),
                        this.rs.getString("contra"),
                        this.rs.getString("foto_usuario"),
                        this.rs.getInt("estado"),
                        this.rs.getString("profesion"),
                        new ModeloGenero(this.rs.getInt("id_genero"),
                        this.rs.getString("genero"))
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
    }
    
    public modelo.ModeloProfesional seleccionarProfesional(Integer id_profesional) {
        ModeloProfesional pro=null;
        this.sql="select * from profesional inner join usuario on profesional.id_usuario = usuario.id_usuario "
                + "inner join genero on profesional.id_genero = genero.id_genero where profesional.id_profesional=?";
        try {
            Class.forName(bd.getDriver());
            this.con= DriverManager.getConnection(bd.getUrl(), bd.getUsuario(),bd.getContraseña());
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setInt(1, id_profesional);
            this.rs = this.pst.executeQuery();
            while(this.rs.next()){
                pro = new modelo.ModeloProfesional(this.rs.getInt("id_profesional"), 
                        this.rs.getInt("edad"), 
                        this.rs.getString("nombre_profesional"),
                        this.rs.getString("apellido_profesional"),
                        this.rs.getString("correo"),
                        this.rs.getInt("id_usuario"),
                        this.rs.getString("nombre_usuario"),
                        this.rs.getInt("prioridad"),
                        this.rs.getString("contra"),
                        this.rs.getString("foto_usuario"),
                        this.rs.getInt("estado"),
                        this.rs.getString("profesion"),
                        new ModeloGenero(this.rs.getInt("id_genero"),
                        this.rs.getString("genero"))
                );
            }
            this.con.close();
            this.rs.close();
            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return pro;  
    }
}
