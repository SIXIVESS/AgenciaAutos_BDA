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
import javax.persistence.Table;

/**
 *
 * @author
 */
@Entity
@Table(name = "Licencia")
public class Licencia extends Tramite implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "estado", nullable = false)
    private boolean estado;

    @Column(name = "vigencia", nullable = false)
    private int vigencia;

    @Column(name = "Discapacidad", nullable = false)
    private boolean discapacidad;

    public Licencia() {
    }

    
    public Licencia(boolean estado, int vigencia, boolean discapacidad, Date fecha_emision, float costo, Persona persona) {
        super(fecha_emision, costo, persona);
        this.estado = estado;
        this.vigencia = vigencia;
        this.discapacidad = discapacidad;
    }

    public Licencia(Long id, boolean estado, int vigencia, boolean discapacidad, Date fecha_emision, float costo, Persona persona) {
        super(id, fecha_emision, costo, persona);
        this.id = id;
        this.estado = estado;
        this.vigencia = vigencia;
        this.discapacidad = discapacidad;
    }
    
    
    public int getVigencia() {
        return vigencia;
    }

    public void setVigencia(int vigencia) {
        this.vigencia = vigencia;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean isDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(boolean discapacidad) {
        this.discapacidad = discapacidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
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
        final Licencia other = (Licencia) obj;
        if (this.estado != other.estado) {
            return false;
        }
        if (this.vigencia != other.vigencia) {
            return false;
        }
        if (this.discapacidad != other.discapacidad) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Licencia{" + "id=" + id + ", estado=" + estado + ", vigencia=" + vigencia + ", discapacidad=" + discapacidad + '}';
    }

}
