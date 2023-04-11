
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
    @Temporal(TemporalType.DATE)
    private Date fecha_recepcion;
    
    @ManyToOne
    @JoinColumn(name = "num_serie_auto", referencedColumnName = "num_serie",
            nullable = false) // Llave foránea
    private Vehiculo vehiculo;

    public Placa() {}

    public Placa(String num_alfanumerico, Vehiculo vehiculo) {
        this.num_alfanumerico = num_alfanumerico;
        this.vehiculo = vehiculo;
    }

    public Placa(String num_alfanumerico, Date fecha_recepcion, Vehiculo vehiculo) {
        this.num_alfanumerico = num_alfanumerico;
        this.fecha_recepcion = fecha_recepcion;
        this.vehiculo = vehiculo;
    }

    public Placa(String num_alfanumerico, Vehiculo vehiculo, Date fechaEmision, float costo, Persona persona) {
        super(fechaEmision, costo, persona);
        this.num_alfanumerico = num_alfanumerico;
        this.vehiculo = vehiculo;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.num_alfanumerico);
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
        return Objects.equals(this.num_alfanumerico, other.num_alfanumerico);
    }
    
    
}
