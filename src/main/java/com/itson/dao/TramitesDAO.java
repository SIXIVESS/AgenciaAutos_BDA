/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.dao;

import com.itson.dominio.Tramite;
import com.itson.interfaces.ITramitesDAO;
import com.itson.utils.FormatoPaginas;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Alexa Soto(236348) y Rosalía Perez (233505)
 */
public class TramitesDAO implements ITramitesDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.itson.agenciafiscal");
    EntityManager em = emf.createEntityManager();

    /**
     * Constructor por defecto
     */
    public TramitesDAO() {
    }

    /**
     * Método que se encarga de buscar los trámites mediante filtros.
     * @param reporte Filtros para buscar el reporte
     * @param formato Formato para la tabla
     * @return Lista de trámites
     */
    @Override
    public List<Tramite> buscar(ReportesDAO reporte, FormatoPaginas formato) {
        CriteriaBuilder crit = em.getCriteriaBuilder();
        CriteriaQuery<Tramite> query = crit.createQuery(Tramite.class);
        Root<Tramite> root = query.from(Tramite.class);
        List<Predicate> filtro = new ArrayList<>();

        try {
            if (filtro.isEmpty()) {
                query.select(root);
            } else {
                query.where(crit.and(filtro.toArray(new Predicate[0])));
            }

            if (reporte.getNombre() != null && !reporte.getNombre().isEmpty()) {
                filtro.add(crit.like(crit.lower(root.get("persona").get("nombres")),
                        "%" + reporte.getNombre() + "%"));
            }
            if (reporte.getInicio() != null && reporte.getFin() != null) {
                Date inicio = Date.from(reporte.getInicio().atStartOfDay(ZoneId.systemDefault()).toInstant());
                Date fin = Date.from(reporte.getFin().atStartOfDay(ZoneId.systemDefault()).toInstant());
                filtro.add(crit.between(root.get("fechaEmision"), inicio, fin));
            }
                TypedQuery<Tramite> tq;
                if (formato != null) {
                    tq = em.createQuery(query).setMaxResults(formato.getElementosPerPag());
                } else {
                    tq = em.createQuery(query);
                }
                return tq.getResultList();   
        } catch (NoResultException ex) {
            return null;
        }

    }
    
    /**
     * Método que se encarga de consultar los trámites realizados por las personas
     * @param rfc Cadena de carácteres que identifican a una persona
     * @param formato Formato para la tabla de trámites
     * @return Regresa una lista de todos los trámites realizados por la persona buscada
     */
    @Override
        public List<Tramite> consultaTramite(String rfc, FormatoPaginas formato){
            try{
                String sql = "SELECT tr FROM Tramite tr WHERE tr.persona.rfc = : rfc";
                  TypedQuery<Tramite> tq = em.createQuery(sql, Tramite.class);
                  tq.setParameter("rfc", rfc);
                  tq.setMaxResults(formato.getElementosPerPag());
                  return tq.getResultList();
            }catch(NoResultException ex){
                return null;
            }
            
        }


}
