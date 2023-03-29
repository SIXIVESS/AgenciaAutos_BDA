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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author alexa
 */
@Entity
@DiscriminatorValue(value = "Placa")
public class Placa extends Tramite implements Serializable {

    @Column(name = "num_alfanumerico", nullable = false)
    private String num_alfanumerico;
    
    @Column(name = "fecha_recepcion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fecha_recepcion;

    public Placa() {}

    public Placa(String num_alfanumerico, Calendar fecha_recepcion, Calendar fecha_emision, float costo, TipoTramite tipo, Persona persona, Pago pago) {
        super(fecha_emision, costo, tipo, persona, pago);
        this.num_alfanumerico = num_alfanumerico;
        this.fecha_recepcion = fecha_recepcion;
    }
    
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
