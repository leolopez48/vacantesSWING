
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
        ModeloIdioma pro=null;
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
}
