/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.utils;

/**
 *
 * @author 
 */
public class GeneracionPlacas {
    
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

    public char generarConsonante() {
        return generarRandomChar("BCDFGHJKLMNPQRSTVWXYZ");
    }

    public char generarVocal() {
        return generarRandomChar("AEIOU");
    }

    public char generarNumero() {
        return generarRandomChar("0123456789");
    }

    public char generarRandomChar(String str) {
        char caracteres[] = str.toCharArray();
        int index = (int) (Math.random() * caracteres.length);
        return caracteres[index];
    }
}
