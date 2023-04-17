package com.itson.utils;

/**
 *
 * @author
 */
public class Busqueda {

    //Con esto va a buscar por nombre y fecha
    private String nombre;
    private Integer fechaNac;

    /**
     * Constructor que inicializa los atributos al valor de sus parámetros
     * @param nombre Nombre por el que se buscará
     * @param fechaNac Año por el que se buscará
     */
    public Busqueda(String nombre, Integer fechaNac) {
        this.nombre = nombre;
        this.fechaNac = fechaNac;
    }

    /**
     * Método que regresa el nombre que se buscará
     * @return nombre que se buscó
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que setea el nombre que se buscará
     * @param nombre nombre que se busca
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que regresa el año de nacimiento que se buscará
     * @return Año de nacimiento
     */
    public Integer getFechaNac() {
        return fechaNac;
    }

    /**
     * Método que setea el año de nacimiento que se buscará
     * @param fechaNac Año de nacimiento que se buscó
     */
    public void setFechaNac(Integer fechaNac) {
        this.fechaNac = fechaNac;
    }
}
