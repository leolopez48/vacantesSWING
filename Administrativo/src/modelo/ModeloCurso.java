
package modelo;

/**
 *
 * @author Leonel
 */
public class ModeloCurso {
    private Integer id_curso;
    private String curso;
    private ModeloHabilidades id_habilidad;

    public ModeloCurso() {
    }

    public ModeloCurso(Integer id_curso, String curso, ModeloHabilidades id_habilidad) {
        this.id_curso = id_curso;
        this.curso = curso;
        this.id_habilidad = id_habilidad;
    }

    public Integer getId_curso() {
        return id_curso;
    }

    public void setId_curso(Integer id_curso) {
        this.id_curso = id_curso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public ModeloHabilidades getId_habilidad() {
        return id_habilidad;
    }

    public void setId_habilidad(ModeloHabilidades id_habilidad) {
        this.id_habilidad = id_habilidad;
    }
    
}
