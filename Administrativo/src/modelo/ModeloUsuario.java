
package modelo;

/**
 *
 * @author Leonel
 */
public class ModeloUsuario {
    private Integer id_usuario;
    private String nombre_usuario;
    private Integer prioridad;
    private String contra;
    private String foto;
    private Integer estado;
            
    public ModeloUsuario(Integer id_usuario){
        this.id_usuario = id_usuario;
    }
    
    public ModeloUsuario(){
    }

    public ModeloUsuario(Integer id_usuario, String nombre_usuario, Integer prioridad, String contra, String foto, Integer estado) {
        this.nombre_usuario = nombre_usuario;
        this.prioridad = prioridad;
        this.contra = contra;
        this.foto = foto;
        this.estado = estado;
        this.id_usuario = id_usuario;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
    
    
    
    
    
}
