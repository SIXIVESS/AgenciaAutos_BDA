package com.itson.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Alexa Soto(236348) y Rosalía Perez (233505)
 */
@Entity
@Table(name = "Licencia")
public class Licencia extends Tramite implements Serializable {

    /**
     * Identificador de una licencia
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Estado de la licencia
     */
    @Column(name = "estado", nullable = false)
    private boolean estado;

    /**
     * Vigencia de la licencia
     */
    @Column(name = "vigencia", nullable = false)
    private int vigencia;

    /**
     * Muestra si una persona es discapacitado o no
     */
    @Column(name = "Discapacidad", nullable = false)
    private boolean discapacidad;

    /**
     * Constructor por defecto
     */
    public Licencia() {
    }

    /**
     * Constructor que asigna parámetros a una licencia
     *
     * @param estado Estado de la licencia, indica si está vigente o no
     * @param vigencia Vigencia de la licencia
     * @param discapacidad Muestra si una persona es discapacitado o no
     * @param fecha_emision Fecha en la que se sacó la licencia
     * @param costo Costo de la licencia
     * @param persona Propietario de la licencia
     */
    public Licencia(boolean estado, int vigencia, boolean discapacidad, Date fecha_emision, float costo, Persona persona) {
        super(fecha_emision, costo, persona);
        this.estado = estado;
        this.vigencia = vigencia;
        this.discapacidad = discapacidad;
    }

    /**
     * Constructor que asigna parámetros a una licencia
     *
     * @param id Identificador de la licencia
     * @param estado Estado de la licencia, indica si está vigente o no
     * @param vigencia Vigencia de la licencia
     * @param discapacidad Muestra si una persona es discapacitado o no
     * @param fecha_emision Fecha en la que se sacó la licencia
     * @param costo Costo de la licencia
     * @param persona Propietario de la licencia
     */
    public Licencia(Long id, boolean estado, int vigencia, boolean discapacidad, Date fecha_emision, float costo, Persona persona) {
        super(id, fecha_emision, costo, persona);
        this.id = id;
        this.estado = estado;
        this.vigencia = vigencia;
        this.discapacidad = discapacidad;
    }

    /**
     * Regresa la fecha en la que se vencerá una licencia
     *
     * @return Fecha de vigencia
     */
    public int getVigencia() {
        return vigencia;
    }

    /**
     * Asigna una fecha de vigencia a una licencia
     *
     * @param vigencia Vigencia de la licencia
     */
    public void setVigencia(int vigencia) {
        this.vigencia = vigencia;
    }

    /**
     * Regresa el estado de la licencia, si está vigente o no
     *
     * @return Estado de la licencia
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * Asigna un estado a una licencia
     *
     * @param estado Estado de la licencia
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * Indica si la persona que solicita la licencia cuenta con alguna
     * discapacidad
     *
     * @return Discapacidad
     */
    public boolean isDiscapacidad() {
        return discapacidad;
    }

    /**
     * Asigna la discapacidad a una licencia en caso de que el solicitante sea
     * discapacitado
     *
     * @param discapacidad Muestra si una persona es discapacitado o no
     */
    public void setDiscapacidad(boolean discapacidad) {
        this.discapacidad = discapacidad;
    }

    /**
     * Método que calcula el hashcode de la identificación de una licencia
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
     * Compara una licencia con otro objeto
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
        final Licencia other = (Licencia) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * Cadena de texto con los parámetros de licencia
     *
     * @return Cadena de texto con los parámetros de licencia
     */
    @Override
    public String toString() {
        return "Licencia{" + "id=" + id + ", estado=" + estado + ", vigencia=" + vigencia + ", discapacidad=" + discapacidad + '}';
    }

}
