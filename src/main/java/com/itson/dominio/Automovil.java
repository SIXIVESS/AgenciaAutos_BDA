/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.dominio;

import com.itson.utils.TipoAutomovil;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
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
@Table(name = "Automovil")
@DiscriminatorValue("Automovil")
public class Automovil extends Vehiculo implements Serializable {

    /**
     * Constructor por defecto
     */
    public Automovil() {
    }

    /**
     * Constructor que hereda de vehículo
     * @param num_serie Número de serie del vehículo
     * @param marca Marca del vehículo
     * @param color Color del vehículo
     * @param modelo Modelo del vehículo
     * @param linea Línea del auto
     * @param persona Dueño del vehículo
     */
    public Automovil(String num_serie, String marca, String color, String modelo, String linea, Persona persona) {
        super(num_serie, marca, color, modelo, linea, persona);
    }

}
