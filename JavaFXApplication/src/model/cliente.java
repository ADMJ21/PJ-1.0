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
public class cliente {
    private Integer idCliente;
     private String nombreCliente;
     private String telefonoCliente;
     private String emailCliente;
     private Integer edad;

     
     public cliente(Integer idCliente, String nombreCliente, String telefonoCliente, String emailCliente, Integer edad) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.telefonoCliente = telefonoCliente;
        this.emailCliente = emailCliente;
        this.edad = edad;
    }
    /**
     * @return the idCliente
     */
    public Integer getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the nombreCliente
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     * @param nombreCliente the nombreCliente to set
     */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    /**
     * @return the telefonoCliente
     */
    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    /**
     * @param telefonoCliente the telefonoCliente to set
     */
    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    /**
     * @return the emailCliente
     */
    public String getEmailCliente() {
        return emailCliente;
    }

    /**
     * @param emailCliente the emailCliente to set
     */
    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    /**
     * @return the edad
     */
    public Integer getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(Integer edad) {
        this.edad = edad;
    }
     
}
