
package com.itson.dominio;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author 
 */
@Entity
@DiscriminatorValue(value = "Licencia")
public class Licencia extends Tramite implements Serializable {

    @Column(name = "vigencia", nullable = false)
    private int vigencia;
    
    @Column(name = "tipo_licencia", nullable = false)
    private TipoLicencia tipo_licencia;

    public Licencia() {}

    public Licencia(int vigencia, Calendar fecha_emision, float costo,
            TipoTramite tipo_tramite, Persona persona, Pago pago, TipoLicencia tipo_licencia) {
        super(fecha_emision, costo, tipo_tramite, persona, pago);
        this.vigencia = vigencia;
        this.tipo_licencia = tipo_licencia;
    }

    public Licencia(int vigencia, TipoLicencia tipo_licencia) {
        this.vigencia = vigencia;
        this.tipo_licencia = tipo_licencia;
    }

    public Licencia(int vigencia, TipoLicencia tipo_licencia, Calendar fecha_emision, float costo, TipoTramite tipo, Persona persona) {
        super(fecha_emision, costo, tipo, persona);
        this.vigencia = vigencia;
        this.tipo_licencia = tipo_licencia;
    }

    
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
}
