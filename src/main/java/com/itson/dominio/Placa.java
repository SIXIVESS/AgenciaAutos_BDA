
package com.itson.dominio;

import com.itson.utils.TipoTramite;
import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author 
 */
@Entity
public class Placa extends Tramite implements Serializable {

    @Column(name = "num_alfanumerico", nullable = true)
    private String num_alfanumerico;
    
    @Column(name = "fecha_recepcion", nullable = true)
    @Temporal(TemporalType.DATE)
    private Calendar fecha_recepcion;

    public Placa() {}
//
//    public Placa(String num_alfanumerico, Calendar fecha_emision, float costo, TipoTramite tipo, Persona persona, Pago pago) {
//        super(fecha_emision, costo, tipo, persona, pago);
//        this.num_alfanumerico = num_alfanumerico;
//        this.fecha_recepcion = null;
//    }

    public String getNum_alfanumerico() {
        return num_alfanumerico;
    }

    public void setNum_alfanumerico(String num_alfanumerico) {
        this.num_alfanumerico = num_alfanumerico;
    }

    public Calendar getFecha_recepcion() {
        return fecha_recepcion;
    }

    public void setFecha_recepcion(Calendar fecha_recepcion) {
        this.fecha_recepcion = fecha_recepcion;
    }
}
