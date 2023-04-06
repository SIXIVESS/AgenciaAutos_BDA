
package com.itson.dominio;

import java.io.Serializable;
import java.util.Calendar;
import static java.util.Calendar.getInstance;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author 
 */
@Entity
@Table(name = "Tramites")
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Tramite implements Serializable {

    @Id
    @Column(name = "folio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "fecha_emision", nullable = true)
    @Temporal(TemporalType.DATE)
    private Calendar fecha_emision;
    
    @Column(name = "costo", nullable = false)
    private float costo;
    
    @Column(name = "tipo", nullable = false)
    private TipoTramite tipo;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idPersona", nullable = false) // Llave foránea
    private Persona persona;
    
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idPago", nullable = true) // Llave foránea
    private Pago pago;

    public Tramite() {}

    public Tramite(Calendar fecha_emision, float costo, TipoTramite tipo, Persona persona, Pago pago) {
        this.fecha_emision = getInstance();
        this.costo = costo;
        this.tipo = tipo;
        this.persona = persona;
        this.pago = pago;
    }

    public Tramite(Calendar fecha_emision, float costo, TipoTramite tipo, Persona persona) {
        this.fecha_emision = getInstance();
        this.costo = costo;
        this.tipo = tipo;
        this.persona = persona;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(Calendar fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public TipoTramite getTipo() {
        return tipo;
    }

    public void setTipo(TipoTramite tipo) {
        this.tipo = tipo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tramite)) {
            return false;
        }
        Tramite other = (Tramite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itson.dominio.Tramite[ id=" + id + " ]";
    }
    
}
