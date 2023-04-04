/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.dominio;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author alexa
 */
@Entity
@DiscriminatorValue(value = "Licencia")
public class Licencia extends Tramite implements Serializable {

    @Column(name = "vigencia", nullable = true)
    @Temporal(TemporalType.DATE)
    private Calendar vigencia;

    public Licencia() {}

    public Licencia(Calendar vigencia, Calendar fecha_emision, float costo,
            TipoTramite tipo, Persona persona, Pago pago) {
        super(fecha_emision, costo, tipo, persona, pago);
        this.vigencia = vigencia;
    }
    
    public Calendar getVigencia() {
        return vigencia;
    }

    public void setVigencia(Calendar vigencia) {
        this.vigencia = vigencia;
    }

}
