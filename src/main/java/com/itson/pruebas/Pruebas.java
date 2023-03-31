

package com.itson.pruebas;

import com.itson.dao.PersonasDAO;
import com.itson.dominio.Licencia;
import com.itson.dominio.Pago;
import com.itson.dominio.Persona;
import com.itson.dominio.Placa;
import com.itson.dominio.Telefono;
import com.itson.dominio.TipoTramite;
import com.itson.dominio.Tramite;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author 
 */
public class Pruebas {

    public static void main(String[] args) {
        EntityManagerFactory managerFactory
                = Persistence.createEntityManagerFactory("org.itson.agenciafiscal");
        EntityManager em = managerFactory.createEntityManager();
        
        PersonasDAO p = new PersonasDAO();
        
        
        
//        TypedQuery<Persona> query = em.createQuery(criteria);

//        List<Persona> personas = query.getResultList();
//        for (Persona v : personas) {
//            System.out.println(v.getNombres());
//        }
//        DateFormat dateFormat = new SimpleDateFormat("DD, MM, yyyy");
//        
//        Persona persona1 = new Persona("SOEA031129H0",
//                "Alexa María", "Soto", "Esquer",
//                new GregorianCalendar(2003, 11, 29),
//                new Telefono("6471220381"));
//        
//        Pago pago = new Pago(100);
//        //String num_alfanumerico, Calendar fecha_recepcion, 
//        //Calendar fecha_emision, float costo, TipoTramite tipo, 
//        //Persona persona, Pago pago
//        Placa placa = new Placa("ABC-123", new GregorianCalendar(2023, 3, 28),
//        new GregorianCalendar(2022, 3, 28), 100, TipoTramite.PLACAS, persona1,
//        pago);
//        
//        em.persist(placa);
        em.getTransaction().commit();
    }
}
