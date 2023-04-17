package com.itson.utils;

import com.itson.dominio.Licencia;

/**
 *
 * @author
 */
public class TipoVigencia {

    //Lista de los años disponibles
    String[] numVigencia = {
        "Un año",
        "Dos años",
        "Tres años"
    };

    /**
     * Constructor por defecto
     */
    public TipoVigencia() {
    }

    /**
     * Método que guarda el tipo de vigencia y si es discapacitado o no la persona.
     * Con esos datos asigna el costo correspondiente
     * @param discapacitado true si es discapacitado, false en caso contrario
     * @param numVigencia Vigencia solicitada
     * @return Regresa el costo
     */
    public int guardar(boolean discapacitado, String numVigencia) {
        int costo = 0;

        if (discapacitado == false && numVigencia.equals("Un año")) {
            costo = 600;
        } else if (discapacitado == true && numVigencia.equals("Un año")) {
            costo = 200;
        } else if (discapacitado == false && numVigencia.equals("Dos años")) {
            costo = 900;
        } else if (discapacitado == true && numVigencia.equals("Dos años")) {
            costo = 500;
        } else if (discapacitado == false && numVigencia.equals("Tres años")) {
            costo = 1100;
        } else if (discapacitado == true && numVigencia.equals("Tres años")) {
            costo = 700;
        }
        return costo;
    }

    /**
     * Método que obtiene las vigencias disponibles
     * @return Vigencias
     */
    public String[] obtenerVigencias() {
        return numVigencia;
    }
}
