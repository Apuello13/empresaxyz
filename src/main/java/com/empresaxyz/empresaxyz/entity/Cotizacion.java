package com.empresaxyz.empresaxyz.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.List;

/**
 *
 * @author apuello
 */
@Entity
@Table(name = "cotizacion")
public class Cotizacion implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @ManyToOne
    private Vendedor vendedor;
    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Productos producto;
    @OneToMany(mappedBy = "cotizacion")
    private List<DetalleCotizacion> detalle;
    private String estado;
    @Temporal( TemporalType.DATE )
    private Date created;
    @Temporal( TemporalType.DATE )
    private Date fechaContratacion;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }
    public String getTitulo() {
            return titulo;
    }

    public void setTitulo(String titulo) {
            this.titulo = titulo;
    }
    public String getDescription() {
            return description;
    }
    public void setDescription(String description) {
            this.description = description;
    }
    public void setProducto(Productos producto){
        this.producto = producto;
    }
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    public List<DetalleCotizacion> getDetalle(){
        return detalle;
    }
}
