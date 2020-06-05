/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Leonel
 */
public class ModeloGenero {
    public Integer id_genero;
    public String genero;

    public ModeloGenero() {
    }

    public ModeloGenero(Integer id_genero, String genero) {
        this.id_genero = id_genero;
        this.genero = genero;
    }

    public Integer getId_genero() {
        return id_genero;
    }

    public void setId_genero(Integer id_genero) {
        this.id_genero = id_genero;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    } 
    
}
