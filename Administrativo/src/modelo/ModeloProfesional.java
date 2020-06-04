
package modelo;

/**
 *
 * @author Leonel
 */
public class ModeloProfesional {
    private int id_profesional;
    private int edad;
    private String nombre_profesional;
    private String apellido_profesional;
    private String correo;
    private int id_usuario;

    public ModeloProfesional(int id_profesional, int edad, String nombre_profesional, String apellido_profesional, String correo, int id_usuario) {
        this.id_profesional = id_profesional;
        this.edad = edad;
        this.nombre_profesional = nombre_profesional;
        this.apellido_profesional = apellido_profesional;
        this.correo = correo;
        this.id_usuario = id_usuario;
    }

    public ModeloProfesional() {
    }

    public int getId_profesional() {
        return id_profesional;
    }

    public void setId_profesional(int id_profesional) {
        this.id_profesional = id_profesional;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre_profesional() {
        return nombre_profesional;
    }

    public void setNombre_profesional(String nombre_profesional) {
        this.nombre_profesional = nombre_profesional;
    }

    public String getApellido_profesional() {
        return apellido_profesional;
    }

    public void setApellido_profesional(String apellido_profesional) {
        this.apellido_profesional = apellido_profesional;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
}
