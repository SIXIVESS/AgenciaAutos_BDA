/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.utils;

/**
 *
 * @author Alexa Soto(236348) y Rosalía Perez (233505)
 */
public class GeneracionPlacas {
    
    /**
     * Método que genera una placa aleatoria
     * @return Placa generada
     */
    public String generarPlaca() {

        char placa[] = new char[7];
        placa[0] = generarConsonante();
        placa[1] = generarConsonante();
        placa[2] = generarVocal();
        placa[3] = '-';
        placa[4] = generarNumero();
        placa[5] = generarNumero();
        placa[6] = generarNumero();

        return String.valueOf(placa);
    }

    /**
     * Método que genera una consonante
     * @return Consonante generada
     */
    public char generarConsonante() {
        return generarRandomChar("BCDFGHJKLMNPQRSTVWXYZ");
    }

    /**
     * Método que genera la primer vocal
     * @return Primer vocal
     */
    public char generarVocal() {
        return generarRandomChar("AEIOU");
    }

    /**
     * Método que genera un número
     * @return Número
     */
    public char generarNumero() {
        return generarRandomChar("0123456789");
    }

    /**
     * Método que genera un char aleatorio
     * @param str
     * @return 
     */
    public char generarRandomChar(String str) {
        char caracteres[] = str.toCharArray();
        int index = (int) (Math.random() * caracteres.length);
        return caracteres[index];
    }
}
