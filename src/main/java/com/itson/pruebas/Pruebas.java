

package com.itson.pruebas;

import com.itson.dao.*;
import com.itson.dominio.Licencia;
import com.itson.dominio.Pago;
import com.itson.dominio.Persona;
import com.itson.dominio.TipoLicencia;
import com.itson.dominio.TipoTramite;
import static com.itson.dominio.Tramite_.persona;

import com.itson.interfaces.*;
import com.itson.presentacion.FrmPrincipal;
import java.util.GregorianCalendar;



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
        
        //int vigencia, Calendar fecha_emision, float costo,
        //TipoTramite tipo_tramite, Persona persona, Pago pago, 
        //TipoLicencia tipo_licencia
        em.getTransaction().begin();
//        Persona persona = new Persona("acavad", "a", "p", "s", 
//                new GregorianCalendar(2003, 11, 29), new Telefono("6461646"));
        


        
//        Placa placa = new Placa("ABC", new GregorianCalendar(),
//                0, TipoTramite.PLACAS, new Persona("acavad", "a", "p", "s", 
//                new GregorianCalendar(2003, 11, 29), new Telefono("6461646")), new Pago(100));
////        
//        em.persist(licencia);
//        em.persist(placa);
//        em.persist(persona);

//----------------------------------------------------------------------------------------------------------------------
            Persona persona1 = (Persona) em.createQuery("SELECT p FROM Persona p WHERE p.rfc=:rfc")
                    .setParameter("rfc", "SOEA031129H0").getSingleResult();
            Licencia licencia1 = new Licencia(2,
                    new GregorianCalendar(2022, 3, 15), 900,
                    TipoTramite.LICENCIA,
                    persona1, new Pago(900),
                    TipoLicencia.NORMAL);
            //----------------------------------------------------------------------------------------------------------------------
            Persona persona2 = (Persona) em.createQuery("SELECT p FROM Persona p WHERE p.rfc=:rfc")
                    .setParameter("rfc", "ROMJ030820A1").getSingleResult();
            Licencia licencia2 = new Licencia(1,
                    new GregorianCalendar(2020, 12, 12), 200,
                    TipoTramite.LICENCIA,
                    persona1, new Pago(200),
                    TipoLicencia.DISCAPACITADO);
            //----------------------------------------------------------------------------------------------------------------------
            Persona persona3 = (Persona) em.createQuery("SELECT p FROM Persona p WHERE p.rfc=:rfc")
                    .setParameter("rfc", "RAEM030303L8").getSingleResult();
            Licencia licencia3 = new Licencia(3,
                    new GregorianCalendar(2021, 11, 25), 1100,
                    TipoTramite.LICENCIA,
                    persona1, new Pago(1100),
                    TipoLicencia.NORMAL);
            //----------------------------------------------------------------------------------------------------------------------
            Persona persona4 = (Persona) em.createQuery("SELECT p FROM Persona p WHERE p.rfc=:rfc")
                    .setParameter("rfc", "SARI031113H2").getSingleResult();
            Licencia licencia4 = new Licencia(2,
                    new GregorianCalendar(2015, 5, 16), 900,
                    TipoTramite.LICENCIA,
                    persona1, new Pago(900),
                    TipoLicencia.NORMAL);
            //----------------------------------------------------------------------------------------------------------------------
            Persona persona5 = (Persona) em.createQuery("SELECT p FROM Persona p WHERE p.rfc=:rfc")
                    .setParameter("rfc", "SOTR760126P9").getSingleResult();
            Licencia licencia5 = new Licencia(3,
                    new GregorianCalendar(2021, 11, 25), 700,
                    TipoTramite.LICENCIA,
                    persona1, new Pago(700),
                    TipoLicencia.DISCAPACITADO);
            //----------------------------------------------------------------------------------------------------------------------
            Persona persona6 = (Persona) em.createQuery("SELECT p FROM Persona p WHERE p.rfc=:rfc")
                    .setParameter("rfc", "ESPC771112M1").getSingleResult();
            Licencia licencia6 = new Licencia(1,
                    new GregorianCalendar(2022, 1, 1), 200,
                    TipoTramite.LICENCIA,
                    persona1, new Pago(200),
                    TipoLicencia.DISCAPACITADO);
            //----------------------------------------------------------------------------------------------------------------------
            Persona persona7 = (Persona) em.createQuery("SELECT p FROM Persona p WHERE p.rfc=:rfc")
                    .setParameter("rfc", "ESPJ760514H5").getSingleResult();
            Licencia licencia7 = new Licencia(3,
                    new GregorianCalendar(2023, 2, 26), 1100,
                    TipoTramite.LICENCIA,
                    persona1, new Pago(1100),
                    TipoLicencia.NORMAL);
            //----------------------------------------------------------------------------------------------------------------------
            Persona persona8 = (Persona) em.createQuery("SELECT p FROM Persona p WHERE p.rfc=:rfc")
                    .setParameter("rfc", "ESAM990819M9").getSingleResult();
            Licencia licencia8 = new Licencia(2,
                    new GregorianCalendar(2021, 10, 29), 500,
                    TipoTramite.LICENCIA,
                    persona1, new Pago(500),
                    TipoLicencia.DISCAPACITADO);
            //----------------------------------------------------------------------------------------------------------------------
            Persona persona9 = (Persona) em.createQuery("SELECT p FROM Persona p WHERE p.rfc=:rfc")
                    .setParameter("rfc", "ESCJ361229J8").getSingleResult();
            Licencia licencia9 = new Licencia(1,
                    new GregorianCalendar(2019, 9, 9), 600,
                    TipoTramite.LICENCIA,
                    persona1, new Pago(600),
                    TipoLicencia.NORMAL);
            //----------------------------------------------------------------------------------------------------------------------
            Persona persona10 = (Persona) em.createQuery("SELECT p FROM Persona p WHERE p.rfc=:rfc")
                    .setParameter("rfc", "SOAA470903B5").getSingleResult();
            Licencia licencia10 = new Licencia(1,
                    new GregorianCalendar(2021, 5, 7), 200,
                    TipoTramite.LICENCIA,
                    persona1, new Pago(200),
                    TipoLicencia.DISCAPACITADO);

        em.getTransaction().commit();
        IPersonasDAO personaDAO = new PersonasDAO(generadorConexiones);
        ILicenciasDAO licenciaDAO = new LicenciasDAO(generadorConexiones);
        FrmPrincipal frmPrincipal = new FrmPrincipal(personaDAO, licenciaDAO);
        licenciaDAO.insertar(persona1, licencia1);
        licenciaDAO.insertar(persona2, licencia2);
        licenciaDAO.insertar(persona3, licencia3);
        licenciaDAO.insertar(persona4, licencia4);
        licenciaDAO.insertar(persona5, licencia5);
        licenciaDAO.insertar(persona6, licencia6);
        licenciaDAO.insertar(persona7, licencia7);
        licenciaDAO.insertar(persona8, licencia8);
        licenciaDAO.insertar(persona9, licencia9);
        licenciaDAO.insertar(persona10, licencia10);

        
        frmPrincipal.setVisible(true);
    }
}
