/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.dominio;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author
 */
@Entity
@Table(name = "Vehiculo")
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehiculo implements Serializable {

    @Id
    @Column(name = "num_serie", nullable = false)
    private String num_serie;
    
    @Column(name = "marca", nullable = false)
    private String marca;
    
    @Column(name = "color", nullable = false)
    private String color;
    
    @Column(name = "modelo", nullable = false)
    private String modelo;
    
    @OneToMany(mappedBy = "vehiculo", cascade = {CascadeType.REMOVE}) // Nombre del atributo de la otra clase
    private List<Placa> placas;

    public Vehiculo() {}

    public Vehiculo(String num_serie, String marca, String color, String modelo) {
        this.num_serie = num_serie;
        this.marca = marca;
        this.color = color;
        this.modelo = modelo;
    }

    public Vehiculo(String num_serie, String marca, String color, String modelo, List<Placa> placas) {
        this.num_serie = num_serie;
        this.marca = marca;
        this.color = color;
        this.modelo = modelo;
        this.placas = placas;
    }

    public String getNum_serie() {
        return num_serie;
    }

    public void setNum_serie(String num_serie) {
        this.num_serie = num_serie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public List<Placa> getPlacas() {
        return placas;
    }

    public void setPlacas(List<Placa> placas) {
        this.placas = placas;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.num_serie);
        return hash;
    }

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
