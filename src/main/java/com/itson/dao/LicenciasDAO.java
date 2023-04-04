/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.dao;

import com.itson.dominio.Licencia;
import com.itson.dominio.Persona;
import com.itson.interfaces.IConexionBD;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.itson.interfaces.ILicenciasDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexa
 */
public class LicenciasDAO implements ILicenciasDAO{
    
    private static final Logger LOG = Logger.getLogger(LicenciasDAO.class.getName());
    private final IConexionBD generadorConexiones;
    
    public LicenciasDAO(IConexionBD generadorConexiones) {
        this.generadorConexiones = generadorConexiones;
    }

    
    @Override
    public Licencia consultar(Integer idPersona) {
        try {
            EntityManager em = this.generadorConexiones.crearConexion();
            // Experto que sabe hacer consultas
            CriteriaBuilder builder = em.getCriteriaBuilder();
            // Consulta que se esta construyendo
            CriteriaQuery<Licencia> criteria = builder.createQuery(Licencia.class);
            Root<Licencia> root = criteria.from(Licencia.class);

            Licencia licencia = (Licencia) criteria.select(root)
                    .where(builder.equal(root.get("idPersona"), idPersona));
            em.getTransaction().begin();

            return licencia;
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
        }
        return null;
    }
}
