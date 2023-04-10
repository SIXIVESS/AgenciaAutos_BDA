package com.itson.utils;

import com.itson.dominio.Licencia;
import javax.swing.JOptionPane;

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

    public TipoVigencia() {
    }

    private void guardar(boolean discapacitado, String numVigencia) {
        Licencia licencia = new Licencia();


            if (discapacitado == false && numVigencia.equals("Un año")) {
                licencia.setVigencia(1);
                licencia.setCosto(600);
            } else if (discapacitado == true && numVigencia.equals("Un año")) {
                licencia.setVigencia(1);
                licencia.setCosto(200);
            } else if (discapacitado == false && numVigencia.equals("Dos años")) {
            licencia.setVigencia(2);
            licencia.setCosto(900);
        } else if (discapacitado == true && numVigencia.equals("Dos años")) {
            licencia.setVigencia(2);
            licencia.setCosto(500);
        } else if(discapacitado == false && numVigencia.equals("Tres años")) {
            licencia.setVigencia(3);
            licencia.setCosto(1100);
        } else if (discapacitado == true && numVigencia.equals("Tres años"))  {
            licencia.setVigencia(3);
            licencia.setCosto(700);
        }
    }
    
    public String [] obtenerVigencias(){
        return numVigencia;
    }
}
