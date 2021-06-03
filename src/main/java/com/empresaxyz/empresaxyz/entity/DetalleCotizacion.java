package com.empresaxyz.empresaxyz.entity;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.ManyToOne;
/**
 *
 * @author apuello
 */
@Entity
@Table( name = "detalleCotizacion" )
public class DetalleCotizacion{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Cotizacion cotizacion;
    private String observacion;
    @Temporal( TemporalType.DATE )
    private Date fecha;
    
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public void setCotizacion(Cotizacion cotizacion){
        this.cotizacion = cotizacion;
    }
    public String getObservacion(){
        return observacion;
    }
    public void setObservacion(String observacion){
        this.observacion = observacion;
    }
    public Date getFecha(){
        return fecha;
    }
    public void setFecha(Date fecha){
        this.fecha = fecha;
    }
}