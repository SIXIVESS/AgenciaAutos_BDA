

package com.itson.pruebas;

import com.itson.dao.*;
import com.itson.dominio.*;
import com.itson.dominio.Persona;
import com.itson.dominio.TipoLicencia;
import com.itson.dominio.TipoTramite;

import com.itson.interfaces.*;
import com.itson.presentacion.FrmPrincipal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
        
        IPersonasDAO personaDAO = new PersonasDAO(generadorConexiones);
        ILicenciasDAO licenciaDAO = new LicenciasDAO(generadorConexiones);
        FrmPrincipal frmPrincipal = new FrmPrincipal(personaDAO, licenciaDAO);
        
        frmPrincipal.setVisible(true);
    }
}
