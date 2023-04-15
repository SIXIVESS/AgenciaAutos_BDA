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
 * @author Alexa Soto(236348) y Rosalía Perez (233505)
 */
public class LicenciasDAO implements ILicenciasDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.itson.agenciafiscal");
    EntityManager em = emf.createEntityManager();

    //Ajustar la fecha del trámite 
    SimpleDateFormat fecha = new SimpleDateFormat("dd/mm/yy");
    Date actual = new Date();
    //Formatea una fecha a texto
    String formatoFecha = fecha.format(actual);

  /**
   * Constructor por defecto
   */
    public LicenciasDAO() {}
    
    
    /**
     * Método que se encarga de registrar una licencia
     * @param rfc Cadena de carácteres que identifican a una persona
     * @param nombre Nombre de la persona
     * @param apellidoPaterno Apellido paterno de la persona
     * @param apellidoMaterno Apellido materno de la persona
     * @param fechaNac Fecha de nacimiento de la persona
     * @param telefono Teléfono de la persona
     * @param costo Costo de la licencia
     * @param vigencia Vigencia de la licencia
     * @param discapacidad Representa si la persona tiene discapacidad o no
     * @throws PersistenciaException Lanza una excepción en caso de que ocurra un error
     */
    @Override
    public void insertar(String rfc, String nombre, String apellidoPaterno, 
            String apellidoMaterno, String fechaNac, String telefono, float costo, 
            int vigencia, boolean discapacidad) throws PersistenciaException {
        
        try {
            Date fechaDos = fecha.parse(formatoFecha);
            em.getTransaction().begin();

            Persona per = new Persona(rfc, nombre, apellidoPaterno, apellidoMaterno, LocalDate.parse(fechaNac), telefono);
            Licencia lic = new Licencia(true, vigencia, discapacidad, fechaDos, costo, per);

            em.persist(lic);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Se ha insertado la licencia");

        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo insertar la licencia", 
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(LicenciasDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    /**
     * Método que actualiza el estado de la licencia
     * @param idLicencia Identificador que se le otorga a la licencia que se le cambiará el estado
     */
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
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo actualizar la licencia", 
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Método que se encarga de consutlar una licencia usando el RFC del dueño de la licencia
     * @param rfc Cadena de carácteres que identifican a una persona
     * @return Regresa verdadero si la licencia buscada está vigente, en otro caso regresará falso
     */
    @Override
    public boolean consultar(String rfc){

//Busca el rfc en la tabla de personas
        try {
            List<Licencia> licencia = em.createQuery("SELECT lic FROM Licencia lic WHERE lic.persona.rfc LIKE :rfc",
                    Licencia.class).setParameter("rfc", rfc).getResultList();

            for (Licencia lic : licencia) {
                //Compara la licencia con la fecha actual
                if (lic.getFechaEmision().getTime() + TimeUnit.DAYS.toMillis(lic.getVigencia() * 365) > actual.getTime()) {
                    return true;
                } else {
                    actualizar(lic.getId());
                    JOptionPane.showMessageDialog(null, "No hay licencia vigente");
                }
            }
            return false;
        } catch (PersistenceException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo actualizar la licencia", 
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            em.getTransaction().rollback();
        }
        return false;
    }
}
