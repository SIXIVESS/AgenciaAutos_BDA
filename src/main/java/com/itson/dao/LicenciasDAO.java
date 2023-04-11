package com.itson.dao;

import com.itson.dominio.Licencia;
import com.itson.dominio.Persona;

import javax.persistence.EntityManager;

import com.itson.interfaces.ILicenciasDAO;
import excepciones.PersistenciaException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;

/**
 *
 * @author
 */
public class LicenciasDAO implements ILicenciasDAO {

//
//    private static final Logger LOG = Logger.getLogger(LicenciasDAO.class.getName());
//    private final IConexionBD generadorConexiones;
//
//    public LicenciasDAO(IConexionBD generadorConexiones) {
//        this.generadorConexiones = generadorConexiones;
//    }
//    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.itson.agenciafiscal");
    EntityManager em = emf.createEntityManager();

    //Ajustar la fecha del trámite 
    SimpleDateFormat fecha = new SimpleDateFormat("dd/mm/yy");
    Date actual = new Date();
    //Formatea una fecha a texto
    String formatoFecha = fecha.format(actual);

    @Override
    public void insertar(String rfc, String nombre, String apellidoPaterno, String apellidoMaterno, String fechaNac, String telefono, float costo, int vigencia, boolean discapacidad) throws PersistenciaException {
        try {
            Date fechaDos = fecha.parse(formatoFecha);
            em.getTransaction().begin();

            Persona per = new Persona(rfc, nombre, apellidoPaterno, apellidoMaterno, LocalDate.parse(fechaNac), telefono);

            Licencia lic = new Licencia(true, vigencia, discapacidad, fechaDos, costo, per);

            em.persist(lic);

            em.getTransaction().commit();

            JOptionPane.showMessageDialog(null, "Se ha insertado la licencia");

        } catch (ParseException ex) {
            Logger.getLogger(LicenciasDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
//    @Override
//    public Licencia insertar(Str) {
//        try {
////            EntityManager em = this.generadorConexiones.crearConexion();
//            em.getTransaction().begin();
//            licencia.setPersona(persona);
//            licencia.setTipo(TipoTramite.LICENCIA);
//            licencia.setFecha_emision(Calendar.getInstance());
//            licencia.setTipo_licencia(licencia.getTipo_licencia());
//            licencia.setCosto(licencia.getCosto());
//            licencia.setPersona(licencia.getPersona());
//            licencia.setTipo_licencia(licencia.getTipo_licencia());
//            licencia.setVigencia(licencia.getVigencia());
//
//            em.persist(licencia);
//
//            em.getTransaction().commit();
//            JOptionPane.showMessageDialog(null, "Se han insertado 20 personas con éxito");
//        } catch (PersistenceException ex) {
//            em.getTransaction().rollback();
//
//        }
//        return null;
//    }

    public void actualizar(Long idLicencia) {

        //Busca la licencia en la clase
        Licencia licencia = em.find(Licencia.class, idLicencia);
        //Si la licencia no es nulla y tiene un estado, se le actualiza
        if (licencia != null && licencia.isEstado()) {
            em.getTransaction().begin();
            licencia.setEstado(false);
            em.merge(licencia);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Se actualizó la licencia");

        }

    }

    @Override
    public boolean consultar(String rfc) {
//        try {
//            // Experto que sabe hacer consultas
//            CriteriaBuilder builder = em.getCriteriaBuilder();
//            // Consulta que se esta construyendo
//            CriteriaQuery<Licencia> criteria = builder.createQuery(Licencia.class);
//            Root<Licencia> root = criteria.from(Licencia.class);
//
//            Licencia licencia = (Licencia) criteria.select(root)
//                    .where(builder.equal(root.get("rfc"), rfc));
//            em.getTransaction().begin();
//
//            return true;
//        } catch (PersistenceException ex) {
//            em.getTransaction().rollback();
//        }
//        return false;

//Busca el rfc en la tabla de personas
        try {
            List<Licencia> licencia = em.createQuery("SELECT lic FROM licencia lic WHERE lic.personas.rfc=rfc",
                    Licencia.class).setParameter("rfc", rfc).getResultList();

            for (Licencia lic : licencia) {
                //Compara la licencia con la fecha actual
                if (lic.getFechaEmision().getTime() + TimeUnit.DAYS.toMillis(lic.getVigencia() * 365) > actual.getTime()) {
                    return true;
                } else {
                    actualizar(lic.getId());
                }
            }
            return false;

        } catch (PersistenceException ex) {
            em.getTransaction().rollback();

        }
        return false;
    }
    
//Constructor vacío
    public LicenciasDAO() {
    }

}
