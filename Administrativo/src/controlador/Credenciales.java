package controlador;

/**
 *
 * @author CAMPOS
 */
public class Credenciales {
    private String driver;
    private String url;
    private String usuario;
    private String contraseña;

    public Credenciales() {
        this.driver = "com.mysql.jdbc.Driver";
        this.url ="jdbc:mysql://localhost:3306/vacante";
        this.usuario = "root";
        this.contraseña = "";
    }

    public String getDriver() {
        return driver;
    }

    public String getUrl() {
        return url;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }
    
    
    
}
