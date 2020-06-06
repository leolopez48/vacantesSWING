
package modelo;

/**
 *
 * @author Leonel
 */

public class ModeloTrabajo {
    private Integer id_trabajos;
    private String trabajo;
    private ModeloHabilidades habilidad;

    public ModeloTrabajo(Integer id_trabajos, String trabajo, ModeloHabilidades habilidad) {
        this.id_trabajos = id_trabajos;
        this.habilidad = habilidad;
        this.trabajo = trabajo;
    }

    public Integer getId_trabajos() {
        return id_trabajos;
    }

    public void setId_trabajos(Integer id_trabajos) {
        this.id_trabajos = id_trabajos;
    }

    public String getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }

    public ModeloHabilidades getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(ModeloHabilidades habilidad) {
        this.habilidad = habilidad;
    }
    
}
