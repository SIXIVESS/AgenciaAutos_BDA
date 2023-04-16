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
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Alexa Soto(236348) y Rosalía Perez (233505)
 */
@Entity
@Table(name = "Personas")
public class Persona implements Serializable {

    /**
     * RFC de una persona
     */
    @Id
    @Column(name = "RFC")
    private String rfc;

    /**
     * Nombres de la persona
     */
    @Column(name = "nombres", nullable = false)
    private String nombres;

    /**
     * Apellido paterno de la persona
     */
    @Column(name = "ap_paterno", nullable = false)
    private String ap_paterno;

    /**
     * Apellido materno de la persona
     */
    @Column(name = "ap_materno", nullable = false)
    private String ap_materno;

    /**
     * Fecha de nacimiento de la persona
     */
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fecha_nacimiento;

    /**
     * Teléfono de la persona
     */
    @Column(name = "telefono", nullable = false)
    private String telefono;

    /**
     * Lista de trámites realizados por una persona
     */
    @OneToMany(mappedBy = "persona", cascade = {CascadeType.REMOVE}) // Nombre del atributo de la otra clase
    private List<Tramite> tramites;
    /**
     * Lista de vehículos de una persona
     */
    @OneToMany(mappedBy = "persona", cascade = {CascadeType.REMOVE}) // Nombre del atributo de la otra clase
    private List<Vehiculo> vehiculos;

    /**
     * Constructor por defecto
     */
    public Persona() {
    }

    /**
     * Constructor que asigna parámetros a una persona
     *
     * @param rfc RFC de una persona
     * @param nombres Nombres de la persona
     * @param ap_paterno Apellido paterno de la persona
     * @param ap_materno Apellido materno de la persona
     * @param fecha_nacimiento Fecha de nacimiento de la persona
     * @param telefono Teléfono de la persona
     * @param tramites Lista de trámites realizados por una persona
     */
    public Persona(String rfc, String nombres, String ap_paterno, String ap_materno, LocalDate fecha_nacimiento, String telefono, List<Tramite> tramites) {
        this.rfc = rfc;
        this.nombres = nombres;
        this.ap_paterno = ap_paterno;
        this.ap_materno = ap_materno;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.tramites = tramites;
    }

    /**
     * Constructor que asigna parámetros a una persona
     *
     * @param rfc RFC de una persona
     * @param nombres Nombres de la persona
     * @param ap_paterno Apellido paterno de la persona
     * @param ap_materno Apellido materno de la persona
     * @param fecha_nacimiento Fecha de nacimiento de la persona
     * @param telefono Teléfono de la persona
     */
    public Persona(String rfc, String nombres, String ap_paterno, String ap_materno, LocalDate fecha_nacimiento, String telefono) {
        this.rfc = rfc;
        this.nombres = nombres;
        this.ap_paterno = ap_paterno;
        this.ap_materno = ap_materno;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
    }

    /**
     * Regresa el RFC de una persona
     *
     * @return RFC de una persona
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Asigna un RFC a una persona
     *
     * @param rfc RFC de una persona
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * Regresa un nombre o varios de una persona
     *
     * @return Nombre de la persona
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Asigna el nombres de la persona
     *
     * @param nombres Nombre de la persona
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Regresa el apellido paterno de la persona
     *
     * @return Apellido de la persona
     */
    public String getAp_paterno() {
        return ap_paterno;
    }

    /**
     * Asigna el apellido paterno de la persona
     *
     * @param ap_paterno Apellido de la persona
     */
    public void setAp_paterno(String ap_paterno) {
        this.ap_paterno = ap_paterno;
    }

    /**
     * Regresa el apellido materno de la persona
     *
     * @return Apellido de la persona
     */
    public String getAp_materno() {
        return ap_materno;
    }

    /**
     * Asigna el apellido materno de la persona
     *
     * @param ap_materno Apellido de la persona
     */
    public void setAp_materno(String ap_materno) {
        this.ap_materno = ap_materno;
    }

    /**
     * Regresa la fecha de nacimiento de la persona
     *
     * @return Fecha de nacimiento de la persona
     */
    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    /**
     * Asigna la fecha de nacimiento de la persona
     *
     * @param fecha_nacimiento Fecha de nacimiento de la persona
     */
    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    /**
     * Regresa el teléfono de la persona
     *
     * @return Teléfono de la persona
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Asigna un teléfono a la persona
     *
     * @param telefono Teléfono de la persona
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Regresa la lista de los tramites realizados por la persona
     *
     * @return Lista de los tramites realizados por la persona
     */
    public List<Tramite> getTramites() {
        return tramites;
    }

    /**
     * Asigna la lista de los tramites realizados por la persona
     *
     * @param tramites Lista de los tramites realizados por la persona
     */
    public void setTramites(List<Tramite> tramites) {
        this.tramites = tramites;
    }

    /**
     * Regresa la lista de los vehículos obtenidos por la persona
     *
     * @return Lista de los vehículos registrados por la persona
     */
    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    /**
     * Asigna la lista de los vehículos registrados por la persona
     *
     * @param vehiculos Lista de los vehículos registrados por la persona
     */
    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    /**
     * Método que calcula el hashcode del RFC de una persona
     *
     * @return Hashcode del RFC de una persona
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.rfc);
        return hash;
    }

    /**
     * Compara un RFC con otro objeto
     *
     * @param obj Objeto a comparar
     * @return Regresa falso si la comparación con otro objeto no es igual,
     * sino, regresará verdadero en caso de ser igual
     */
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

    /**
     * Cadena de texto con los parámetros de persona
     *
     * @return Cadena de texto con los parámetros de persona
     */
    @Override
    public String toString() {
        return "Persona{" + "rfc=" + rfc + ", nombres=" + nombres + ", ap_paterno=" + ap_paterno + ", ap_materno=" + ap_materno + ", fecha_nacimiento=" + fecha_nacimiento + ", telefono=" + telefono + '}';
    }

}
