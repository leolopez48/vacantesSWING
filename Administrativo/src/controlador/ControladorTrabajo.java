
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
public class ControladorTrabajo {
    Credenciales bd = new Credenciales();
    List<modelo.ModeloTrabajo> data = new ArrayList<>();
    String sql="";
    PreparedStatement pst;
    ResultSet rs;
    Connection con;
    
    public List<modelo.ModeloTrabajo> seleccionarTrabajo(Integer id_profesional) {
        this.sql="select * from ultimos_trabajos as trab "
                + "inner join habilidad as hab on trab.id_habilidad = hab.id_habilidad "
                + "inner join profesional as pro on hab.id_profesional = pro.id_profesional where pro.id_profesional=?";
        try{    
            Class.forName(bd.getDriver());
            this.con= DriverManager.getConnection(bd.getUrl(), bd.getUsuario(),bd.getContraseña());
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setInt(1, id_profesional);
            this.rs = this.pst.executeQuery();
            while(this.rs.next()){
                data.add(new modelo.ModeloTrabajo(this.rs.getInt("id_trabajos"), 
                            this.rs.getString("trabajo"), 
                            new ModeloHabilidades(this.rs.getInt("id_habilidad"),
                                this.rs.getString("descripcion"),
                                new ModeloProfesional(this.rs.getInt("id_profesional"), 
                                    this.rs.getInt("edad"), 
                                    this.rs.getString("nombre_profesional"),
                                    this.rs.getString("apellido_profesional"),
                                    this.rs.getString("correo")
                                )
                            )
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
