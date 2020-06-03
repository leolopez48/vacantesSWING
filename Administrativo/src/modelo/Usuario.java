
package modelo;

/**
 *
 * @author Leonel
 */
public class Usuario {
    private int id_usuario;
    private String nombre_usuario;
    private int prioridad;
    private String contra; 
            
    public Usuario(){
        
    }

    public Usuario(int id_usuario, String nombre_usuario, int prioridad, String contra) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.prioridad = prioridad;
        this.contra = contra;
    }
    
    
    
}
