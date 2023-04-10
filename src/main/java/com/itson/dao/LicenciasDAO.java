package com.itson.dao;

import com.itson.dominio.Licencia;
import com.itson.dominio.Persona;
import static com.itson.dominio.Persona_.fecha_nacimiento;
import com.itson.utils.TipoTramite;
import com.itson.interfaces.IConexionBD;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.itson.interfaces.ILicenciasDAO;
import excepciones.PersistenciaException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
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
    public void insertar(String rfc, String nombre, String apellidoPaterno, String apellidoMaterno, String fechaNac, String telefono, double costo, int vigencia, boolean discapacidad) throws PersistenciaException {
        try {
            Date fechaDos;
            fechaDos = fecha.parse(formatoFecha);
            em.getTransaction().begin();

            Persona per = new Persona(rfc, nombre, apellidoPaterno, apellidoMaterno, LocalDate.parse(fechaNac), telefono);

            Licencia lic = new Licencia(true, vigencia, discapacidad, fechaDos, vigencia, per);

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

    public void actualizar(Long id) {
        try {
            //Busca la licencia en la clase
            Licencia licencia = em.find(Licencia.class, id);
            //Si la licencia no es nulla y tiene un estado, se le actualiza
            if (licencia != null && licencia.isEstado()) {
                em.getTransaction().begin();
                licencia.setEstado(false);
                em.merge(licencia);
                em.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Se actualizó la licencia");

            }
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Se han insertado 20 personas con éxito");
        } catch (PersistenceException ex) {
            em.getTransaction().rollback();

        }
    }

    @Override
    public Licencia consultar(Integer idPersona) {
        try {
            // Experto que sabe hacer consultas
            CriteriaBuilder builder = em.getCriteriaBuilder();
            // Consulta que se esta construyendo
            CriteriaQuery<Licencia> criteria = builder.createQuery(Licencia.class);
            Root<Licencia> root = criteria.from(Licencia.class);

            Licencia licencia = (Licencia) criteria.select(root)
                    .where(builder.equal(root.get("idPersona"), idPersona));
            em.getTransaction().begin();

            return licencia;
        } catch (PersistenceException ex) {
            em.getTransaction().rollback();
        }
        return null;

    }
}
