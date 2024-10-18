/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Angel
 */
public class libro {
    private Integer idLibros;
    private String nombre;
    private String genero;
    private String categoria;

    public libro(Integer idLibros, String nombre, String genero, String categoria) {
        this.idLibros = idLibros;
        this.nombre = nombre;
        this.genero = genero;
        this.categoria = categoria;
    }

    /**
     * @return the idLibros
     */
    public Integer getIdLibros() {
        return idLibros;
    }

    /**
     * @param idLibros the idLibros to set
     */
    public void setIdLibros(Integer idLibros) {
        this.idLibros = idLibros;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
     
}
