
package modelo;

/**
 *
 * @author Leonel
 */
public class ModeloHabilidades {
    private Integer id_habilidad;
    private String descripcion;
    private ModeloProfesional id_profesional;

    public ModeloHabilidades(Integer id_habilidad) {
        this.id_habilidad = id_habilidad;
    }

    public ModeloHabilidades() {
    }

    public ModeloHabilidades(Integer id_habilidad, String descripcion, ModeloProfesional id_profesional) {
        this.id_habilidad = id_habilidad;
        this.descripcion = descripcion;
        this.id_profesional = id_profesional;
    }

    public Integer getId_habilidad() {
        return id_habilidad;
    }

    public void setId_habilidad(Integer id_habilidad) {
        this.id_habilidad = id_habilidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ModeloProfesional getId_profesional() {
        return id_profesional;
    }

    public void setId_profesional(ModeloProfesional id_profesional) {
        this.id_profesional = id_profesional;
    }
    
}
