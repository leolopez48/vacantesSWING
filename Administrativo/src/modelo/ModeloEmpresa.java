/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Roberto
 */
public class ModeloEmpresa {
     private Integer id_empresa;
     private String nombre_empresa;
     private String descripcion;
     private String foto;
     private ModeloUsuario usuario;

    public ModeloEmpresa(Integer id_empresa, String nombre_empresa, String descripcion,
                        Integer id_usuario, String nombre_usuario, Integer prioridad, String contra, String foto, Integer estado) {
         this.usuario = new ModeloUsuario(id_usuario, nombre_usuario, prioridad, contra, foto, estado);
        this.id_empresa = id_empresa;
        this.nombre_empresa = nombre_empresa;
        this.descripcion = descripcion;
        this.foto = foto;
     
    }

    public ModeloEmpresa() {
        
    }

    public Integer getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public ModeloUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(ModeloUsuario usuario) {
        this.usuario = usuario;
    }

     
     
}
