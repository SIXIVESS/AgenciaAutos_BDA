/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.dao;

import com.itson.dominio.Automovil;
import com.itson.dominio.Persona;
import com.itson.interfaces.IAutomovilesDAO;
import com.itson.utils.TipoAutomovil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

/**
 * 
 * @author Alexa Soto(236348) y Rosalía Perez (233505)
 */
public class AutomovilesDAO implements IAutomovilesDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.itson.agenciafiscal");
    EntityManager em = emf.createEntityManager();

    /**
     * Constructor por defecto
     */
    public AutomovilesDAO() {
    }

    /**
     * Método que inserta un automóvil
     *
     * @param tipo Tipo de automóvil
     * @param serie Serie del automóvil para ser identificado
     * @param marca Marca del automóvil
     * @param modelo Modelo del automóvil
     * @param color Color del automóvil
     * @param linea Línea del automóvil
     * @return Regresa el automóvil que se registró
     */
    @Override
    public Automovil insertar(TipoAutomovil tipo, String serie, String marca, String modelo,
            String color, String linea) {
        em.getTransaction().begin();

        Automovil auto = new Automovil(linea, TipoAutomovil.NUEVO, serie, marca,
                color, modelo);

        em.persist(auto);
        em.getTransaction().commit();
        JOptionPane.showMessageDialog(null, "Se ha insertado el auto");
        return auto;
    }

    /**
     * Método encargado de consultar el automóvil usando su número de serie
     *
     * @param serie Número de serie que identifica al automóvil
     * @return Regresa nulo en caso de que no encuentre al automóvil
     */
    @Override
    public Automovil consultar(String serie) {
        try {
            //Busca el numero de serie en la clase Automovil
            return em.find(Automovil.class, serie);
        } catch (PersistenceException ex) {
            JOptionPane.showMessageDialog(null, "Error al consultar el auto");
            em.getTransaction().rollback();
        }
        return null;
    }

    /**
     * Método encargado de revisar la existencia del automóvil
     *
     * @param serie Número de serie que identifica al automóvil
     * @return Regresa nulo en caso de que el automóvil no exista
     */
    public boolean existe(String serie) {
        boolean existencia = false;

        try {
            Automovil auto = em.find(Automovil.class, serie);
            if (auto != null) {
                existencia = true;
            }
        } catch (Exception ex) {

        }
        return existencia;
    }
}
