/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.dao;

import com.itson.dominio.Licencia;
import com.itson.dominio.Persona;
import com.itson.interfaces.IConexionBD;
import com.itson.interfaces.ILicencias;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author alexa
 */
public class LicenciasDAO implements ILicencias{
    
    private final IConexionBD generadorConexiones;
    
    public LicenciasDAO(IConexionBD generadorConexiones) {
        this.generadorConexiones = generadorConexiones;
    }

    @Override
    public Licencia consultar(String rfc) {
        
        
        return null;
    }
}
