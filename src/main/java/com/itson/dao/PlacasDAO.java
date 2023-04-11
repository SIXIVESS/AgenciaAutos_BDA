/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.dao;

import com.itson.dominio.Licencia;
import com.itson.dominio.Persona;
import com.itson.dominio.Placa;
import com.itson.dominio.Vehiculo;
import com.itson.interfaces.IPlacasDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class PlacasDAO implements IPlacasDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.itson.agenciafiscal");
    EntityManager em = emf.createEntityManager();

    //Ajustar la fecha del trámite 
    SimpleDateFormat fecha = new SimpleDateFormat("dd/mm/yy");
    Date actual = new Date();
    //Formatea una fecha a texto
    String formatoFecha = fecha.format(actual);
    
    public PlacasDAO() {
    }

    @Override
    public void insertar(String num_alfanumerico, Vehiculo vehiculo, Persona persona, float costo) {
        try {
            Date fechaDos = fecha.parse(formatoFecha);
            em.getTransaction().begin();

            Placa placa = new Placa(num_alfanumerico, vehiculo, fechaDos, costo, persona);

            em.persist(placa);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Se insertó la placa");
        } catch (ParseException ex) {
            Logger.getLogger(PlacasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Placa> consultar(String serie) {
        try {
            String codigoJPQL = "SELECT p FROM Placa p WHERE p.automovil.num_serie "
                    + "LIKE :num_serie";
            TypedQuery<Placa> query = em.createQuery(codigoJPQL, Placa.class);
            query.setParameter("num_serie", serie);

            return query.getResultList();
        } catch (PersistenceException ex) {
            em.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public Placa consultarPlaca(String placas) {
        
        return null;
    }

    @Override
    public void actualizar(String placas) {
        Placa placa = (Placa) this.consultar(placas);
        Date fechaDos = null;
        try {
            fechaDos = fecha.parse(formatoFecha);
        } catch (ParseException ex) {
            Logger.getLogger(PlacasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        placa.setFecha_recepcion(fechaDos);
    }

    
}
