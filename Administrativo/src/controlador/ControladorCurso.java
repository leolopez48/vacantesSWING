
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.ModeloCurso;
import modelo.ModeloHabilidades;

/**
 *
 * @author Leonel
 */
public class ControladorCurso {
    
    Credenciales bd = new Credenciales();
    ArrayList<ModeloCurso> data = new ArrayList<>();
    String sql="";
    PreparedStatement pst;
    ResultSet rs;
    Connection con;
    
    public ArrayList<ModeloCurso> seleccionarCurso(Integer id_profesional) {
        this.sql="SELECT * FROM curso as cur inner join habilidad as hab on cur.id_habilidad = hab.id_habilidad where hab.id_profesional=?";
        try {
            Class.forName(bd.getDriver());
            this.con= DriverManager.getConnection(bd.getUrl(), bd.getUsuario(),bd.getContraseña());
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setInt(1, id_profesional);
            this.rs = this.pst.executeQuery();
            while(this.rs.next()){
                data.add(new modelo.ModeloCurso(this.rs.getInt("id_curso"),
                        this.rs.getString("curso"),
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
    
    public Boolean insertarCurso(Integer id_curso, String curso, Integer id_habilidad) {
        Boolean insertado=false;
        this.sql="insert into curso (id_curso, curso, id_habilidad) values (?,?,?)";
        try {
            Class.forName(bd.getDriver());
            this.con= DriverManager.getConnection(bd.getUrl(), bd.getUsuario(),bd.getContraseña());
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setInt(1, id_curso);
            this.pst.setString(2, curso);
            this.pst.setInt(3, id_habilidad);
            this.pst.executeUpdate();
            this.con.close();
            insertado = true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return insertado;
    }
    
        public Boolean actualizarCurso(Integer id_curso, String curso, Integer id_habilidad) {
        Boolean insertado=false;
        this.sql="update curso set curso=?, id_habilidad=? where id_curso=?";
        try {
            Class.forName(bd.getDriver());
            this.con= DriverManager.getConnection(bd.getUrl(), bd.getUsuario(),bd.getContraseña());
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setString(1, curso);
            this.pst.setInt(2, id_habilidad);
            this.pst.setInt(3, id_curso);
            this.pst.executeUpdate();
            this.con.close();
            insertado = true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return insertado;
    }
        
    public Integer ultimoIdCurso() {
        Integer max = 0;
        this.sql="select id_curso from curso";
        try {
            Class.forName(bd.getDriver());
            this.con= DriverManager.getConnection(bd.getUrl(), bd.getUsuario(),bd.getContraseña());
            this.pst = this.con.prepareStatement(this.sql);
            this.rs = this.pst.executeQuery();
            while(this.rs.next()){
                max = this.rs.getInt("id_curso");
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