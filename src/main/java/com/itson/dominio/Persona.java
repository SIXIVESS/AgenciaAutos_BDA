package com.itson.dominio;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
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
 * @author
 */
@Entity
@Table(name = "Personas")
public class Persona implements Serializable {

//    @Id
//    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
    @Id
    @Column(name = "RFC")
    private String rfc;

    @Column(name = "nombres", nullable = false)
    private String nombres;

    @Column(name = "ap_paterno", nullable = false)
    private String ap_paterno;

    @Column(name = "ap_materno", nullable = false)
    private String ap_materno;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fecha_nacimiento;

//    @OneToOne(cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "idTelefono", nullable = false) // Llave foránea
    @Column(name = "telefono", nullable = false)
    private String telefono;

    @OneToMany(mappedBy = "persona", cascade = {CascadeType.REMOVE}) // Nombre del atributo de la otra clase
    private List<Tramite> tramites;

    public Persona() {
    }

    public Persona(String rfc, String nombres, String ap_paterno, String ap_materno, LocalDate fecha_nacimiento, String telefono, List<Tramite> tramites) {

        this.rfc = rfc;
        this.nombres = nombres;
        this.ap_paterno = ap_paterno;
        this.ap_materno = ap_materno;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.tramites = tramites;
    }

    public Persona(String rfc, String nombres, String ap_paterno, String ap_materno, LocalDate fecha_nacimiento, String telefono) {

        this.rfc = rfc;
        this.nombres = nombres;
        this.ap_paterno = ap_paterno;
        this.ap_materno = ap_materno;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
    }

    public Persona(String rfc) {
        this.rfc = rfc;
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
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

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (id != null ? id.hashCode() : 0);
//        return hash;
//    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.rfc);
        return hash;
    }

    public List<Tramite> getTramites() {
        return tramites;
    }

    public void setTramites(List<Tramite> tramites) {
        this.tramites = tramites;
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
        final Persona other = (Persona) obj;
        return Objects.equals(this.rfc, other.rfc);
    }

    @Override
    public String toString() {
        return "Persona{" + "rfc=" + rfc + ", nombres=" + nombres + ", ap_paterno=" + ap_paterno + ", ap_materno=" + ap_materno + ", fecha_nacimiento=" + fecha_nacimiento + ", telefono=" + telefono + '}';
    }

 
}
