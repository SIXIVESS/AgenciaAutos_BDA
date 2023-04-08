
package com.itson.dominio;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author 
 */
@Entity
public class Licencia extends Tramite implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "estado", nullable=true)
    private boolean estado;

    @Column(name = "vigencia", nullable = true)
    private int vigencia;
    
    @Column(name = "tipo_licencia", nullable = true)
    private TipoLicencia tipo_licencia;

    public Licencia() {}

    public Licencia(Long id, boolean estado, int vigencia, TipoLicencia tipo_licencia, Calendar fecha_emision, float costo, TipoTramite tipo, Persona persona) {
        super(fecha_emision, costo, tipo, persona);
        this.id = id;
        this.estado = estado;
        this.vigencia = vigencia;
        this.tipo_licencia = tipo_licencia;
    }

    public Licencia(boolean estado, int vigencia, TipoLicencia tipo_licencia, Calendar fecha_emision, float costo, TipoTramite tipo, Persona persona) {
        super(fecha_emision, costo, tipo, persona);
        this.estado = estado;
        this.vigencia = vigencia;
        this.tipo_licencia = tipo_licencia;
    }

    
//    public Licencia(int vigencia, Calendar fecha_emision, float costo,
//            TipoTramite tipo_tramite, Persona persona, Pago pago, TipoLicencia tipo_licencia) {
//        super(fecha_emision, costo, tipo_tramite, persona, pago);
//        this.vigencia = vigencia;
//        this.tipo_licencia = tipo_licencia;
//    }
//
//    public Licencia(int vigencia, TipoLicencia tipo_licencia) {
//        this.vigencia = vigencia;
//        this.tipo_licencia = tipo_licencia;
//    }
//
//    public Licencia(int vigencia, TipoLicencia tipo_licencia, Calendar fecha_emision, float costo, TipoTramite tipo, Persona persona) {
//        super(fecha_emision, costo, tipo, persona);
//        this.vigencia = vigencia;
//        this.tipo_licencia = tipo_licencia;
//    }

    
    public int getVigencia() {
        return vigencia;
    }

    public void setVigencia(int vigencia) {
        this.vigencia = vigencia;
    }

    public TipoLicencia getTipo_licencia() {
        return tipo_licencia;
    }

    public void setTipo_licencia(TipoLicencia tipo_licencia) {
        this.tipo_licencia = tipo_licencia;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return this.tipo_licencia == other.tipo_licencia;
    }

    @Override
    public String toString() {
        return "Licencia{" + "id=" + id + ", estado=" + estado + ", vigencia=" + vigencia + ", tipo_licencia=" + tipo_licencia + '}';
    }
    
    
}
