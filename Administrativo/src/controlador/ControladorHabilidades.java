
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.ModeloHabilidades;
import modelo.ModeloProfesional;

/**
 *
 * @author Leonel
 */
public class ControladorHabilidades {
    
    modelo.ModeloHabilidades emp = new modelo.ModeloHabilidades();
    Credenciales bd = new Credenciales();
    ArrayList<modelo.ModeloHabilidades> data = new ArrayList<>();
    String sql="";
    PreparedStatement pst;
    ResultSet rs;
    Connection con;
    
    public ArrayList<modelo.ModeloHabilidades> seleccionarIdiomas(Integer id_profesional) {
        ModeloHabilidades pro=null;
        this.sql="SELECT * FROM habilidad inner join profesional on habilidad.id_profesional = profesional.id_profesional where profesional.id_profesional=?";
        try {
            Class.forName(bd.getDriver());
            this.con= DriverManager.getConnection(bd.getUrl(), bd.getUsuario(),bd.getContraseña());
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setInt(1, id_profesional);
            this.rs = this.pst.executeQuery();
            while(this.rs.next()){
                data.add(new modelo.ModeloHabilidades(this.rs.getInt("id_habilidad"),
                        this.rs.getString("descripcion"),
                        new ModeloProfesional(this.rs.getInt("id_profesional"), 
                        this.rs.getInt("edad"), 
                        this.rs.getString("nombre_profesional"),
                        this.rs.getString("apellido_profesional"),
                        this.rs.getString("correo"))
                ));
            }
            this.con.close();
            this.rs.close();
            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return data;  
    }
    
}
