
package modelo;

/**
 *
 * @author Leonel
 */
public class ModeloIdioma {
    private Integer id_idioma;
    private String idioma;
    private ModeloHabilidades id_habilidad;

    public ModeloIdioma() {
    }

    public ModeloIdioma(Integer id_idioma, String idioma, ModeloHabilidades id_habilidad) {
        this.id_idioma = id_idioma;
        this.idioma = idioma;
        this.id_habilidad = id_habilidad;
    }

    public Integer getId_idioma() {
        return id_idioma;
    }

    public void setId_idioma(Integer id_idioma) {
        this.id_idioma = id_idioma;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public ModeloHabilidades getId_habilidades() {
        return id_habilidad;
    }

    public void setId_habilidades(ModeloProfesional id_habiilidad) {
        this.id_habilidad = id_habilidad;
    }


    
    
}
