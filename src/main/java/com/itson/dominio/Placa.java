
package com.itson.dominio;

import com.itson.utils.TipoTramite;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author 
 */
@Entity
public class Placa extends Tramite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     
    @Column(name = "num_alfanumerico", nullable = false)
    private String num_alfanumerico;
    
    @Column(name = "fecha_recepcion", nullable = true)
    private Date fecha_recepcion;
    
    @Column(name = "estado", nullable = false)
    private boolean estado;
    
    @ManyToOne
    @JoinColumn(name = "num_serie_auto", referencedColumnName = "num_serie") // Llave foránea
    private Vehiculo vehiculo;

    public Placa() {}

    public Placa(String num_alfanumerico, Vehiculo vehiculo, boolean estado) {
        this.num_alfanumerico = num_alfanumerico;
        this.vehiculo = vehiculo;
        this.estado = estado;
    }

    public Placa(String num_alfanumerico, Date fecha_recepcion, Vehiculo vehiculo, boolean estado) {
        this.num_alfanumerico = num_alfanumerico;
        this.fecha_recepcion = fecha_recepcion;
        this.vehiculo = vehiculo;
        this.estado = estado;
    }

    public Placa(String num_alfanumerico, Vehiculo vehiculo, Date fechaEmision, float costo, Persona persona, boolean estado) {
        super(fechaEmision, costo, persona);
        this.num_alfanumerico = num_alfanumerico;
        this.vehiculo = vehiculo;
        this.estado = estado;
    }

    public String getNum_alfanumerico() {
        return num_alfanumerico;
    }

    public void setNum_alfanumerico(String num_alfanumerico) {
        this.num_alfanumerico = num_alfanumerico;
    }

    public Date getFecha_recepcion() {
        return fecha_recepcion;
    }

    public void setFecha_recepcion(Date fecha_recepcion) {
        this.fecha_recepcion = fecha_recepcion;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Placa other = (Placa) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Placa{" + "id=" + id + ", num_alfanumerico=" + num_alfanumerico + ", fecha_recepcion=" + fecha_recepcion + ", estado=" + estado + ", vehiculo=" + vehiculo + '}';
    }
 
}
