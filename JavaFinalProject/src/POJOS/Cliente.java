package POJOS;
// Generated 9/10/2024 09:47:58 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Cliente generated by hbm2java
 */
public class Cliente  implements java.io.Serializable {


     private Integer idCliente;
     private String nombreCliente;
     private String telefonoCliente;
     private String emailCliente;
     private Integer edad;
     private Boolean estados;
     private Set<Prestamos> prestamoses = new HashSet<Prestamos>(0);

    public Cliente() {
    }

    public Cliente(Integer idCliente, String nombreCliente, String telefonoCliente, String emailCliente, Integer edad, Boolean estados, Set<Prestamos> prestamoses) {
       this.idCliente = idCliente;
       this.nombreCliente = nombreCliente;
       this.telefonoCliente = telefonoCliente;
       this.emailCliente = emailCliente;
       this.edad = edad;
       this.estados = estados;
       this.prestamoses = prestamoses;
    }
   
    public Integer getIdCliente() {
        return this.idCliente;
    }
    
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
    public String getNombreCliente() {
        return this.nombreCliente;
    }
    
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    public String getTelefonoCliente() {
        return this.telefonoCliente;
    }
    
    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }
    public String getEmailCliente() {
        return this.emailCliente;
    }
    
    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }
    public Integer getEdad() {
        return this.edad;
    }
    
    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    public Boolean getEstados() {
        return this.estados;
    }
    
    public void setEstados(Boolean estados) {
        this.estados = estados;
    }
    public Set<Prestamos> getPrestamoses() {
        return this.prestamoses;
    }
    
    public void setPrestamoses(Set<Prestamos> prestamoses) {
        this.prestamoses = prestamoses;
    }




}


