
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.ModeloHabilidades;
import modelo.ModeloIdioma;

/**
 *
 * @author Leonel
 */
public class ControladorIdioma {
    
    modelo.ModeloIdioma emp = new modelo.ModeloIdioma();
    Credenciales bd = new Credenciales();
    ArrayList<modelo.ModeloIdioma> data = new ArrayList<>();
    String sql="";
    PreparedStatement pst;
    ResultSet rs;
    Connection con;
    
    public ArrayList<modelo.ModeloIdioma> seleccionarIdiomas(Integer id_profesional) {
        this.sql="SELECT idioma.id_idioma, idioma.idioma, idioma.id_habilidad FROM habilidad inner join idioma on habilidad.id_habilidad = idioma.id_habilidad where habilidad.id_profesional=?";
        try {
            Class.forName(bd.getDriver());
            this.con= DriverManager.getConnection(bd.getUrl(), bd.getUsuario(),bd.getContraseña());
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setInt(1, id_profesional);
            this.rs = this.pst.executeQuery();
            while(this.rs.next()){
                data.add(new modelo.ModeloIdioma(this.rs.getInt("id_idioma"),
                        this.rs.getString("idioma"),
                        new ModeloHabilidades(this.rs.getInt("id_habilidad"))
                ));
            }
            this.con.close();
            this.rs.close();
            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return data;  
    }
    
    public void insertarIdioma(Integer id_usuario) {
        ModeloIdioma pro=null;
        this.sql="SELECT idioma.id_idioma, idioma.idioma, idioma.id_habilidad FROM habilidad inner join idioma on habilidad.id_habilidad = idioma.id_habilidad where habilidad.id_profesional=?";
        try {
            Class.forName(bd.getDriver());
            this.con= DriverManager.getConnection(bd.getUrl(), bd.getUsuario(),bd.getContraseña());
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setInt(1, id_usuario);
            this.rs = this.pst.executeQuery();
            while(this.rs.next()){
                data.add(new modelo.ModeloIdioma(this.rs.getInt("id_idioma"),
                        this.rs.getString("idioma"),
                        new ModeloHabilidades(this.rs.getInt("id_habilidad"))
                ));
            }
            this.con.close();
            this.rs.close();
            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
        
    public Integer ultimoIdIdioma() {
        Integer max = 0;
        this.sql="select id_idioma from idioma";
        try {
            Class.forName(bd.getDriver());
            this.con= DriverManager.getConnection(bd.getUrl(), bd.getUsuario(),bd.getContraseña());
            this.pst = this.con.prepareStatement(this.sql);
            this.rs = this.pst.executeQuery();
            while(this.rs.next()){
                max = this.rs.getInt("id_idioma");
            }
            this.con.close();
            this.rs.close();
            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            max = 0;
        }
        return max;
    }
    
    public Boolean insertarIdioma(Integer id_idioma, String idioma, Integer id_habilidad) {
        Boolean insertado=false;
        this.sql="insert into idioma (id_idioma, idioma, id_habilidad) values (?,?,?)";
        try {
            Class.forName(bd.getDriver());
            this.con= DriverManager.getConnection(bd.getUrl(), bd.getUsuario(),bd.getContraseña());
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setInt(1, id_idioma);
            this.pst.setString(2, idioma);
            this.pst.setInt(3, id_habilidad);
            this.pst.executeUpdate();
            this.con.close();
            insertado = true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return insertado;
    }
    
    public ModeloIdioma seleccionarIdioma(Integer id_idioma) {
        ModeloIdioma pro=null;
        this.sql="SELECT * FROM idioma where id_idioma=?";
        try {
            Class.forName(bd.getDriver());
            this.con= DriverManager.getConnection(bd.getUrl(), bd.getUsuario(),bd.getContraseña());
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setInt(1, id_idioma);
            this.rs = this.pst.executeQuery();
            while(this.rs.next()){
                data.add(new modelo.ModeloIdioma(this.rs.getInt("id_idioma"),
                        this.rs.getString("idioma"),
                        new ModeloHabilidades(this.rs.getInt("id_habilidad"))
                ));
            }
            this.con.close();
            this.rs.close();
            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return pro;  
    }
    
    public Boolean actualizarIdioma(Integer id_idioma, String idioma, Integer id_habilidad) {
        Boolean insertado=false;
        this.sql="update idioma set idioma=?, id_habilidad=? where id_idioma=?";
        try {
            Class.forName(bd.getDriver());
            this.con= DriverManager.getConnection(bd.getUrl(), bd.getUsuario(),bd.getContraseña());
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setString(1, idioma);
            this.pst.setInt(2, id_habilidad);
            this.pst.setInt(3, id_idioma);
            this.pst.executeUpdate();
            this.con.close();
            insertado = true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return insertado;
    }
}
