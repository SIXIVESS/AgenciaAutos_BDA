package com.itson.dao;

import com.itson.dominio.Licencia;
import com.itson.dominio.Pago;
import com.itson.dominio.Persona;
import com.itson.dominio.TipoLicencia;
import com.itson.dominio.TipoTramite;
import static com.itson.dominio.Tramite_.persona;
import com.itson.interfaces.IConexionBD;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.itson.interfaces.ILicenciasDAO;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author
 */
public class LicenciasDAO implements ILicenciasDAO {

    private static final Logger LOG = Logger.getLogger(LicenciasDAO.class.getName());
    private final IConexionBD generadorConexiones;

    public LicenciasDAO(IConexionBD generadorConexiones) {
        this.generadorConexiones = generadorConexiones;
    }

    @Override
    public Licencia insertar(Persona persona, Licencia licencia) {
        try {
            EntityManager em = this.generadorConexiones.crearConexion();
            em.getTransaction().begin();
            licencia.setPersona(persona);
            licencia.setTipo(TipoTramite.LICENCIA);
            licencia.setFecha_emision(Calendar.getInstance());
            licencia.setTipo_licencia(licencia.getTipo_licencia());
            licencia.setCosto(licencia.getCosto());
            licencia.setPersona(licencia.getPersona());
            licencia.setTipo_licencia(licencia.getTipo_licencia());
            licencia.setVigencia(licencia.getVigencia());

            em.persist(licencia);

            em.getTransaction().commit();
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
        }
        return null;
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
