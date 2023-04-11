package com.itson.utils;

/**
 *
 * @author
 */
public class Busqueda {

    //Con esto va a buscar por nombre y fecha
    private String nombre;

    private Integer fechaNac;

    public Busqueda(String nombre, Integer fechaNac) {
        this.nombre = nombre;
        this.fechaNac = fechaNac;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Integer fechaNac) {
        this.fechaNac = fechaNac;
    }
}
