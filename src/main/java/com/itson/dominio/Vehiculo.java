/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.dominio;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Alexa Soto(236348) y Rosalía Perez (233505)
 */
@Entity
@Table(name = "Vehiculo")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_vehiculo")
public class Vehiculo implements Serializable {

    /**
     * Número de serie del vehículo
     */
    @Id
    @Column(name = "num_serie", nullable = false)
    private String num_serie;

    /**
     * Marca del vehículo
     */
    @Column(name = "marca", nullable = false)
    private String marca;

    /**
     * Color del vehículo
     */
    @Column(name = "color", nullable = false)
    private String color;

    /**
     * Modelo del vehículo
     */
    @Column(name = "modelo", nullable = false)
    private String modelo;

    /**
     * Línea del vehículo
     */
    @Column(name = "linea", nullable = false)
    private String linea;

    /**
     * Rfc de la persona dueña del vehículo
     */
    @ManyToOne
    @JoinColumn(name = "rfc", referencedColumnName = "rfc", nullable = false)
    private Persona persona;

    /**
     * Placas que ha tenido un vehículo
     */
    @OneToMany(mappedBy = "vehiculo") // Nombre del atributo de la otra clase
    private List<Placa> placas;

    /**
     * Constructor por defecto
     */
    public Vehiculo() {
    }

    /**
     * Constructor que asigna parámetros a un vehículo
     *
     * @param num_serie Número de serie del vehículo
     * @param marca Marca del vehículo
     * @param color Color del vehículo
     * @param modelo Modelo del vehículo
     * @param linea Línea del auto
     * @param persona Dueño del vehículo
     */
    public Vehiculo(String num_serie, String marca, String color, String modelo, String linea, Persona persona) {
        this.num_serie = num_serie;
        this.marca = marca;
        this.color = color;
        this.modelo = modelo;
        this.linea = linea;
        this.persona = persona;
    }

    /**
     * Constructor que asigna parámetros a un vehículo
     *
     * @param marca Marca del vehículo
     * @param color Color del vehículo
     * @param modelo Modelo del vehículo
     * @param linea Línea del auto
     * @param persona Dueño del vehículo
     */
    public Vehiculo(String marca, String color, String modelo, String linea, Persona persona) {
        this.marca = marca;
        this.color = color;
        this.modelo = modelo;
        this.linea = linea;
        this.persona = persona;
    }

    /**
     * Regresa el número de serie del vehículo
     *
     * @return Número de serie
     */
    public String getNum_serie() {
        return num_serie;
    }

    /**
     * Asigna un número de serie al vehículo
     *
     * @param num_serie Numero de serie
     */
    public void setNum_serie(String num_serie) {
        this.num_serie = num_serie;
    }

    /**
     * Regresa la marca del vehículo
     *
     * @return Marca del vehículo
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Asigna la marca de un vehículo
     *
     * @param marca Marca del vehículo
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Regresa el color del vehículo
     *
     * @return Color del vehículo
     */
    public String getColor() {
        return color;
    }

    /**
     * Asigna el color del vehículo
     *
     * @param color Color del vehículo
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Regresa el modelo del vehículo
     *
     * @return Modelo del vehículo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Asigna el modelo a un vehículo
     *
     * @param modelo Modelo del vehículo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Regresa la línea del vehículo
     *
     * @return Línea del vehículo
     */
    public String getLinea() {
        return linea;
    }

    /**
     * Asigna la línea a un vehículo
     *
     * @param linea Línea del vehículo
     */
    public void setLinea(String linea) {
        this.linea = linea;
    }

    /**
     * Regresa al dueño del vehículo
     *
     * @return Dueño del vehículo
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Asigna un dueño a un vehículo
     *
     * @param persona Dueño del vehículo
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Regresa una lista de las placas que un vehículo ha tenido
     *
     * @return Lista de placas
     */
    public List<Placa> getPlacas() {
        return placas;
    }

    /**
     * Asigna una lista de placas a un vehículo
     *
     * @param placas Lista de placas
     */
    public void setPlacas(List<Placa> placas) {
        this.placas = placas;
    }

    /**
     * Hashcode de el número de serie de un vehículo
     *
     * @return Hashcode
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.num_serie);
        return hash;
    }

    /**
     * Compara los objetos
     *
     * @param obj Objeto que se va a comparar
     * @return Regresa verdadero si los objetos son iguales, sino, regresará
     * falso
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehiculo other = (Vehiculo) obj;
        return Objects.equals(this.num_serie, other.num_serie);
    }

}
