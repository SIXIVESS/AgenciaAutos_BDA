/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.dao;

import java.time.LocalDate;

/**
 *
 * @author Alexa Soto(236348) y Rosalía Perez (233505)
 */
public class ReportesDAO {
    private LocalDate inicio, fin;
    private String nombre, tipo, fechaEmision, costo;

    /**
     * Constructor que inicializan los parámetros que se utilizarán para la búsqueda
     * @param inicio Periodo en que inició el reporte
     * @param fin Periodo en que terminó el reporte
     * @param nombre Nombre de la persona
     * @param tipo Tipo de trámite
     */
    public ReportesDAO(LocalDate inicio, LocalDate fin, String nombre, String tipo) {
        this.inicio = inicio;
        this.fin = fin;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    /**
     * Constructor que inicializa los valores para el reporte
     * @param nombre Nombre de la persona
     * @param tipo Tipo de trámite
     * @param fechaEmision Fecha en que se hizo el trámite
     * @param costo Costo del trámite
     */
    public ReportesDAO(String nombre, String tipo, String fechaEmision, String costo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.fechaEmision = fechaEmision;
        this.costo = costo;
    }

    /**
     * ´Regresa el inicio del periodo
     * @return Inicio del periodo
     */
    public LocalDate getInicio() {
        return inicio;
    }

    /**
     * Asigna el inicio del periodo
     * @param inicio Inicio del periodo
     */
    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    /**
     * Regresa el fin del periodo
     * @return Fin del periodo
     */
    public LocalDate getFin() {
        return fin;
    }

    /**
     * Asigna el fin del periodo
     * @param fin fin del periodo
     */
    public void setFin(LocalDate fin) {
        this.fin = fin;
    }

    /**
     * Regresa el nombre de la persona
     * @return Nombre de la persona
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna el nombre de la persona
     * @param nombre Nombre de la persona
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Regresa el tipo de trámite
     * @return Tipo de trámite
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Asigna el tipo de trámite
     * @param tipo Tipo de trámite
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Regresa la fecha en la que se realizó el trámite
     * @return Fecha en la que se realizó el trámite
     */
    public String getFechaEmision() {
        return fechaEmision;
    }

    /**
     * Asigna la fecha en la que se realizó el trámite
     * @param fechaExpedicion Fecha en la que se realizó el trámite
     */
    public void setFechaEmision(String fechaExpedicion) {
        this.fechaEmision = fechaExpedicion;
    }

    /**
     * Regresa el costo del trámite
     * @return Costo del trámite
     */
    public String getCosto() {
        return costo;
    }
/**
 * Asigna el costo del trámite
 * @param costo costo del trámite
 */
    public void setCosto(String costo) {
        this.costo = costo;
    }
    
    
    
}
