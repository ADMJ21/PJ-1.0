package POJOS;
// Generated 9/10/2024 09:47:58 PM by Hibernate Tools 4.3.1



/**
 * Prestamos generated by hbm2java
 */
public class Prestamos  implements java.io.Serializable {


     private Integer idPrestamos;
     private Cliente cliente;
     private Libros libros;
     private String fecha;
     private Boolean estado;

    public Prestamos() {
    }

    public Prestamos(Cliente cliente, Libros libros, String fecha, Boolean estado) {
       this.cliente = cliente;
       this.libros = libros;
       this.fecha = fecha;
       this.estado = estado;
    }
   
    public Integer getIdPrestamos() {
        return this.idPrestamos;
    }
    
    public void setIdPrestamos(Integer idPrestamos) {
        this.idPrestamos = idPrestamos;
    }
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Libros getLibros() {
        return this.libros;
    }
    
    public void setLibros(Libros libros) {
        this.libros = libros;
    }
    public String getFecha() {
        return this.fecha;
    }
    
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public Boolean getEstado() {
        return this.estado;
    }
    
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }




}


