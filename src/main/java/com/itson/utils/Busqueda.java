package com.itson.utils;

/**
 *
 * @author 
 */
public class Busqueda {
    private String nombre;
    private String rfc;


public Busqueda (String rfc, String nombre){
this.rfc=rfc;
this.nombre=nombre;
}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }


}
