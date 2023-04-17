package com.itson.dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Alexa Soto(236348) y Rosalía Perez (233505)
 */
@Entity
@Table(name = "Tramites")
//@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.JOINED)
public class Tramite implements Serializable {

    /**
     * Identificador de un trámite
     */
    @Id
    @Column(name = "folio", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Fecha en la que se realizó el trámite
     */
    @Column(name = "fecha_emision", nullable = false)
    private Date fechaEmision;

    /**
     * Costo del trámite
     */
    @Column(name = "costo", nullable = false)
    private float costo;

    /**
     * RFC de la persona
     */
    @ManyToOne
    @JoinColumn(name = "rfc_personas", referencedColumnName = "RFC", nullable = false) // Llave foránea
    private Persona persona;

    /**
     * Constructor por defecto
     */
    public Tramite() {
    }

    /**
     * Constructor que asigna parámetros a una placa
     *
     * @param id Identificador de un trámite
     * @param fechaEmision Fecha en la que se realizó el trámite
     * @param costo Costo del trámite
     * @param persona RFC de la persona
     */
    public Tramite(Long id, Date fechaEmision, float costo, Persona persona) {
        this.id = id;
        this.fechaEmision = fechaEmision;
        this.costo = costo;
        this.persona = persona;
    }

    /**
     *
     * Constructor que asigna parámetros a una placa
     *
     * @param fechaEmision Fecha en la que se realizó el trámite
     * @param costo Costo del trámite
     * @param persona RFC de la persona
     */
    public Tramite(Date fechaEmision, float costo, Persona persona) {
        this.fechaEmision = fechaEmision;
        this.costo = costo;
        this.persona = persona;
    }

    /**
     * Regresa el identificador de un trámite
     * @return Identificador de un trámite
     */
    public Long getId() {
        return id;
    }

    /**
     * Asigna un identificador al trámite realizado
     * @param id Identificador de un trámite
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Regresa la fecha en la que se realizó el trámite
     * @return  Fecha en la que se realizó el trámite
     */
    public Date getFechaEmision() {
        return fechaEmision;
    }

    /**
     * Asigna una fecha al trámite
     * @param fechaEmision  Fecha en la que se realizó el trámite
     */
    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    /**
     * Regresa el costo del trámite
     * @return Costo del trámite
     */
    public float getCosto() {
        return costo;
    }

    /**
     * Asigna el costo del trámite
     * @param costo Costo del trámite
     */
    public void setCosto(float costo) {
        this.costo = costo;
    }

    /**
     * Regresa el RFC de la persona
     * @return RFC de la persona
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Se le asigna un trámite a una persona por su RFC
     * @param persona RFC de la persona
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Método que calcula el hashcode de la identificación de un trámite
     *
     * @return Hashcode del identificador
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Compara un trámite con otro objeto
     *
     * @param obj Objeto a comparar
     * @return Regresa falso si la comparación con otro objeto no es igual,
     * sino, regresará verdadero en caso de ser igual
     */
    @Override
    public boolean equals(Object obj) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(obj instanceof Tramite)) {
            return false;
        }
        Tramite other = (Tramite) obj;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Cadena de texto con el id del trámite
     *
     * @return Cadena de texto con los parámetros de la placa
     */
    @Override
    public String toString() {
        return "com.itson.dominio.Tramite[ id=" + id + " ]";
    }

}
