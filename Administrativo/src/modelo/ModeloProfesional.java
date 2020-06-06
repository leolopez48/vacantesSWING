
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Leonel
 */
public class ModeloProfesional {
    private Integer id_profesional;
    private Integer edad;
    private String nombre_profesional;
    private String apellido_profesional;
    private String correo;
    private String foto;
    private String profesion;
    private ModeloUsuario usuario;
    private ModeloGenero genero;
    private ArrayList<ModeloHabilidades> habilidades= new ArrayList<>();

    public ModeloProfesional(Integer id_profesional, Integer edad, String nombre_profesional, String apellido_profesional, 
                            String correo, Integer id_usuario, String nombre_usuario, Integer prioridad, String contra, 
                            String foto, Integer estado, String profesion, ModeloGenero genero) {
        this.usuario = new ModeloUsuario(id_usuario, nombre_usuario, prioridad, contra, foto, estado);
        this.id_profesional = id_profesional;
        this.edad = edad;
        this.nombre_profesional = nombre_profesional;
        this.apellido_profesional = apellido_profesional;
        this.correo = correo;
        this.profesion = profesion;
        this.genero = genero;
    }
    
    public ModeloProfesional(Integer id_profesional, Integer edad, String nombre_profesional, String apellido_profesional, 
                            String correo, Integer id_usuario, String nombre_usuario, Integer prioridad, String contra, 
                            String foto, Integer estado, String profesion, ArrayList<ModeloHabilidades> habilidades, ModeloGenero genero) {
        this.usuario = new ModeloUsuario(id_usuario, nombre_usuario, prioridad, contra, foto, estado);
        this.id_profesional = id_profesional;
        this.edad = edad;
        this.nombre_profesional = nombre_profesional;
        this.apellido_profesional = apellido_profesional;
        this.correo = correo;
        this.profesion = profesion;
        this.habilidades = habilidades;
        this.genero = genero;
    }

    public ModeloProfesional(Integer id_profesional, Integer edad, String nombre_profesional, String apellido_profesional, String correo) {
        this.id_profesional = id_profesional;
        this.edad = edad;
        this.nombre_profesional = nombre_profesional;
        this.apellido_profesional = apellido_profesional;
        this.correo = correo;

    }

    public ModeloProfesional(Integer id_profesional) {
        this.id_profesional = id_profesional;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public ModeloProfesional() {
    }

    public Integer getId_profesional() {
        return id_profesional;
    }

    public void setId_profesional(int id_profesional) {
        this.id_profesional = id_profesional;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
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

    public ModeloUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(ModeloUsuario usuario) {
        this.usuario = usuario;
    }

    public ArrayList<ModeloHabilidades> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ArrayList<ModeloHabilidades> habilidades) {
        this.habilidades = habilidades;
    }

    public ModeloGenero getGenero() {
        return genero;
    }

    public void setGenero(ModeloGenero genero) {
        this.genero = genero;
    }
    
}
