/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.dominio;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author alexa
 */
@Entity
@Table(name = "Personas")
public class Persona implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "rfc", nullable = false)
    private String rfc;
    
    @Column(name = "nombres", nullable = false)
    private String nombres;
    
    @Column(name = "ap_paterno", nullable = false)
    private String ap_paterno;
    
    @Column(name = "ap_materno", nullable = true)
    private String ap_materno;
    
    @Column(name = "fecha_nacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fecha_nacimiento;
    
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idTelefono", nullable = false) // Llave foránea
    private Telefono telefono;

    @OneToMany(mappedBy = "persona", 
            cascade = { CascadeType.REMOVE, CascadeType.PERSIST }) // Nombre del atributo de la otra clase
    private List<Tramite> tramites;
    
    public Persona() {}

    public Persona(String rfc, String nombres, String ap_paterno, String ap_materno, Calendar fecha_nacimiento, Telefono telefono) {
        this.rfc = rfc;
        this.nombres = nombres;
        this.ap_paterno = ap_paterno;
        this.ap_materno = ap_materno;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
    }

    public Persona(String rfc, String nombres, String ap_paterno, String ap_materno, Calendar fecha_nacimiento, Telefono telefono, List<Tramite> tramites) {
        this.rfc = rfc;
        this.nombres = nombres;
        this.ap_paterno = ap_paterno;
        this.ap_materno = ap_materno;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.tramites = tramites;
    }

    public Persona(String rfc) {
        this.rfc = rfc;
    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getAp_paterno() {
        return ap_paterno;
    }

    public void setAp_paterno(String ap_paterno) {
        this.ap_paterno = ap_paterno;
    }

    public String getAp_materno() {
        return ap_materno;
    }

    public void setAp_materno(String ap_materno) {
        this.ap_materno = ap_materno;
    }

    public Calendar getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Calendar fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public void setTelefono(Telefono telefono) {
        this.telefono = telefono;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    public List<Tramite> getTramites() {
        return tramites;
    }

    public void setTramites(List<Tramite> tramites) {
        this.tramites = tramites;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itson.dominio.Personas[ id=" + id + " ]";
    }
    
}
