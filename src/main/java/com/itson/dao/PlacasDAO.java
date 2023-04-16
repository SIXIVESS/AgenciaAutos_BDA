/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.dao;

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
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import org.apache.commons.lang3.RandomStringUtils;
import javax.persistence.criteria.Root;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexa Soto(236348) y Rosalía Perez (233505)
 */
public class PlacasDAO implements IPlacasDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.itson.agenciafiscal");
    EntityManager em = emf.createEntityManager();

    //Ajustar la fecha del trámite 
    SimpleDateFormat fecha = new SimpleDateFormat("dd/mm/yy");
    Date actual = new Date();
    //Formatea una fecha a texto
    String formatoFecha = fecha.format(actual);

    /**
     * Constructor por defecto
     */
    public PlacasDAO() {
    }

    /**
     * Método que registra las placas
     *
     * @param vehiculo Vehículo al que le pertenece la placa
     * @param persona Propietario del vehículo
     * @param costo Costo del trámite
     */
    @Override
    public void insertar(Vehiculo vehiculo, Persona persona, float costo) throws PersistenceException {
        String num = RandomStringUtils.randomNumeric(3);
        String letras = RandomStringUtils.randomAlphabetic(3).toUpperCase();
        String random = num + "-" + letras;

        try {
            List<Placa> placas = em.createQuery("SELECT p FROM Placa p WHERE p.num_alfanumerico = :num_serie", Placa.class).setParameter("numeroPlaca", random).getResultList();
            Date fecha2 = fecha.parse(formatoFecha);
            //Validación
            if (placas.isEmpty()) {
                em.getTransaction().begin();
                Placa placa = new Placa(num, fecha2, true, vehiculo, fecha2, costo, persona);
                em.persist(placa);
                em.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Se insertó la placa");
            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Error al consultar la placa");
            em.getTransaction().rollback();
        }
    }


/**
 * Método que se encarga de consultar la placa mediante su número de serie
 *
 * @param serie Serie de carácteres que se le otorgan a un vehículo
 * @return Regresa la placa consultada
 */
@Override
public List<Placa> consultar(String serie) {
        try {
            String codigoJPQL = "SELECT p FROM Placa p WHERE p.automovil.num_serie "
                    + "LIKE :num_serie";
            TypedQuery

<Placa> query = em.createQuery(codigoJPQL, Placa.class  

);
            query.setParameter("num_serie", serie);

            return query.getResultList();
        } catch (PersistenceException ex) {
            JOptionPane.showMessageDialog(null, "Error al consultar la placa");
            em.getTransaction().rollback();
        }
        return null;
    }

    /**
     * Método que actualiza el estado de una placa
     *
     * @param numAlfa Serie de carácteres que se le otorgan a una placa
     * @throws PersistenceException Método que arroja una excepción en caso de
     * que ocurra un error
     */
    @Override
public 

void actualizar(String numAlfa) throws PersistenceException {
        TypedQuery<Placa> tq = em.createQuery("SELECT p FROM Placa p WHERE p.num_alfanumerico LIKE :num_alfanumerico",
                Placa.class  

);

        tq.setParameter("num_alfanumerico", numAlfa);
        Placa placas = tq.getSingleResult();
        try {
            Date fechaDos = fecha.parse(formatoFecha);
            if (placas != null && placas.isEstado()) {
                em.getTransaction().begin();
                placas.setEstado(false);
                placas.setFecha_recepcion(fechaDos);
                em.merge(placas);
                JOptionPane.showMessageDialog(null, "Se actualizó la placa");
                em.getTransaction().commit();
            }
        } catch (PersistenceException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la placa");
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Error");
            Logger

.getLogger(PlacasDAO.class  

.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método que se encarga de consultar las placas activas
     *
     * @param serie Serie de carácteres que se le otorgan a un vehículo
     * @return Regresa la placa activa en caso de que exista, sino regresará una
     * excepción
     */
    public Placa consultarActiva(String serie) {
        try {
            CriteriaBuilder crit = em.getCriteriaBuilder();
            CriteriaQuery

<Placa> consulta = crit.createQuery(Placa.class  

);
            Root

<Placa> root = consulta.from(Placa.class  

);
            Join<Placa, Vehiculo> join = root.join("vehiculo");
            Predicate pred = crit.and(crit.equal(root.get("Estado"), true),
                    crit.equal(join.get("Serie"), serie));
            consulta.where(pred);
            TypedQuery<Placa> query = em.createQuery(consulta);
            Placa placaActiva = query.getSingleResult();
            System.out.println(placaActiva);
            return placaActiva;

        } catch (NoResultException ex) {
            JOptionPane.showMessageDialog(null, "No se encontró placa activa",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
