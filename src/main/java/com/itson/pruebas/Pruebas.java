

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
 * @author Alexa Soto(236348) y Rosalía Perez (233505)
 */
public class Pruebas {

//    private static final Logger LOG = Logger.getLogger(Pruebas.class.getName());

    public static void main(String[] args) {
        new FrmPrincipal().setVisible(true);
//        IConexionBD generadorConexiones = new ConexionBD();
//        EntityManagerFactory managerFactory
//                = Persistence.createEntityManagerFactory("org.itson.agenciafiscal");
//        EntityManager em = managerFactory.createEntityManager();
//        
//        //int vigencia, Calendar fecha_emision, float costo,
//        //TipoTramite tipo_tramite, Persona persona, Pago pago, 
//        //TipoLicencia tipo_licencia
//        em.getTransaction().begin();
////        Persona persona = new Persona("acavad", "a", "p", "s", 
////                new GregorianCalendar(2003, 11, 29), new Telefono("6461646"));
//        
//
//
//        
////        Placa placa = new Placa("ABC", new GregorianCalendar(),
////                0, TipoTramite.PLACAS, new Persona("acavad", "a", "p", "s", 
////                new GregorianCalendar(2003, 11, 29), new Telefono("6461646")), new Pago(100));
//////        
////        em.persist(licencia);
////        em.persist(placa);
////        em.persist(persona);
//
//
//
//        em.getTransaction().commit();
//        IPersonasDAO personaDAO = new PersonasDAO(generadorConexiones);
//        ILicenciasDAO licenciaDAO = new LicenciasDAO(generadorConexiones);
//        FrmPrincipal frmPrincipal = new FrmPrincipal(personaDAO, licenciaDAO);
//    
      
    }
}
