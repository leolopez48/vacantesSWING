
package modelo;

/**
 *
 * @author Leonel
 */
public class ModeloUsuario {
    private int id_usuario;
    private String nombre_usuario;
    private int prioridad;
    private String contra; 
            
    public ModeloUsuario(){
        
    }

    public ModeloUsuario(int id_usuario, String nombre_usuario, int prioridad, String contra) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.prioridad = prioridad;
        this.contra = contra;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
    
    
    
    
    
}
