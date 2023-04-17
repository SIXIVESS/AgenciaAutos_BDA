/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.itson.utils;

/**
 *
 * @author Alexa Soto(236348) y Rosalía Perez (233505)
 */
public class TipoAutomovil {

    /**
     * Constructor por defecto
     */
    public TipoAutomovil() {
    }

    /**
     * Método que regresa el costo de la placa dependiendo de si el auto registrado es nuevo o usado
     * @param tipoAuto Auto nuevo o usado
     * @return El costo del trámite
     */
    public double costoAuto(String tipoAuto) {
        double costo;
        if (tipoAuto.equals("Nuevo")) {
            return costo = 1500;
        } else {
            return costo = 1000;
        }
    }
}
