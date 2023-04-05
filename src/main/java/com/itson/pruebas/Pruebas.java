

package com.itson.pruebas;

import com.itson.dao.*;

import com.itson.interfaces.*;
import com.itson.presentacion.FrmPrincipal;

import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author 
 */
public class Pruebas {

    private static final Logger LOG = Logger.getLogger(Pruebas.class.getName());

    public static void main(String[] args) {
        IConexionBD generadorConexiones = new ConexionBD();
        EntityManagerFactory managerFactory
                = Persistence.createEntityManagerFactory("org.itson.agenciafiscal");
        EntityManager em = managerFactory.createEntityManager();
        
        IPersonasDAO personaDAO = new PersonasDAO(generadorConexiones);
        ILicenciasDAO licenciaDAO = new LicenciasDAO(generadorConexiones);
        FrmPrincipal frmPrincipal = new FrmPrincipal(personaDAO, licenciaDAO);
        
        frmPrincipal.setVisible(true);
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
    }
}
