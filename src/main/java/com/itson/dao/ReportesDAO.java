/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.dao;

import java.time.LocalDate;

/**
 *
 * @author 
 */
public class ReportesDAO {
    private LocalDate inicio, fin;
    private String nombre, tipo, fechaExpedicion, costo;

    public ReportesDAO(LocalDate inicio, LocalDate fin, String nombre, String tipo) {
        this.inicio = inicio;
        this.fin = fin;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public ReportesDAO(String nombre, String tipo, String fechaExpedicion, String costo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.fechaExpedicion = fechaExpedicion;
        this.costo = costo;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public LocalDate getFin() {
        return fin;
    }

    public void setFin(LocalDate fin) {
        this.fin = fin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(String fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }
    
    
    
}
