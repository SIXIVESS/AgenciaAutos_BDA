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
 * @author 
 */
public class AutomovilesDAO implements IAutomovilesDAO{

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.itson.agenciafiscal");
    EntityManager em = emf.createEntityManager();

    public AutomovilesDAO() {}
    
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

    @Override
    public void insertarAuto(Automovil auto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Automovil consultar(String serie) {
         try {
            //Busca el numero de serie en la clase Automovil
            return em.find(Automovil.class, serie);
        } catch (PersistenceException ex) {
            em.getTransaction().rollback();
        }
        return null;
    }
    
}
