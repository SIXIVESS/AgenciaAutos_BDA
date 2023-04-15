package com.itson.dao;

import com.itson.dominio.Persona;

import com.itson.interfaces.IPersonasDAO;
import com.itson.utils.Busqueda;
import com.itson.utils.FormatoPaginas;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.swing.JOptionPane;

/**
 *
 * @author
 */
public class PersonasDAO implements IPersonasDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.itson.agenciafiscal");
    EntityManager em = emf.createEntityManager();

    public PersonasDAO() {
    }

    @Override
    public void insertar() {
        try {
            em.getTransaction().begin();

            Persona persona1 = new Persona("SOEA031129H0", "Alexa María", "Soto", "Esquer", LocalDate.of(2003, 11, 29), "6471220381");
            Persona persona2 = new Persona("ROMJ030820A1", "José Ángel", "Romero", "Montiel", LocalDate.of(2003, 8, 20), "6471055623");
            Persona persona3 = new Persona("RAEM030303L8", "Magda Paola", "Rámirez", "Escalante", LocalDate.of(2003, 3, 3), "6688293570");
            Persona persona4 = new Persona("SARI031113H2", "Ignacio Alejandro", "Saijas", "Ruiz", LocalDate.of(2003, 11, 13), "6471369445");
            Persona persona5 = new Persona("SOTR760126P9", "Raúl", "Soto", "Torres", LocalDate.of(1976, 1, 26), "6474820426");
            Persona persona6 = new Persona("ESPC771112M1", "Concepción", "Esquer", "Pacheco", LocalDate.of(1977, 11, 12), "6471241569");
            Persona persona7 = new Persona("ESPJ760514H5", "Juan Carlos", "Esquer", "Pacheco", LocalDate.of(1999, 8, 19), ("6023322661"));
            Persona persona8 = new Persona("ESAM990819M9", "Mariana", "Esquer", "Andrade", LocalDate.of(2003, 11, 29), ("6442040238"));
            Persona persona9 = new Persona("ESCJ361229J8", "José David", "Esquer", "Castro", LocalDate.of(1936, 12, 29), ("6474264278"));
            Persona persona10 = new Persona("SOAA470903B5", "Alonso", "Soto", "Ayala", LocalDate.of(1947, 9, 3), ("6471261845"));
            Persona persona11 = new Persona("SAQJ030314H8", "Jorge Luis", "Sanchez", "Quezada", LocalDate.of(2003, 3, 14), ("6441171436"));
            Persona persona12 = new Persona("MAGM020226D3", "Misael", "Márquez", "Gaxiola", LocalDate.of(2002, 2, 26), ("6442590977"));
            Persona persona13 = new Persona("LOLM030525E2", "Marcos Anselmo", "López", "Lugardo", LocalDate.of(2003, 5, 25), ("3324253380"));
            Persona persona14 = new Persona("GAMG020813G4", "Gael", "Gaxiola", "Maldonado", LocalDate.of(2002, 8, 13), ("6441953838"));
            Persona persona15 = new Persona("PEAR030224A7", "Rosalía", "Pérez", "Acuña", LocalDate.of(2003, 2, 24), ("6442331575"));
            Persona persona16 = new Persona("LUSF020730F3", "Fernando ", "Luque", "Steward", LocalDate.of(2002, 7, 30), ("6442463614"));
            Persona persona17 = new Persona("PEIM020810J1", "Marlon", "Pereo", "Iriqui", LocalDate.of(2002, 8, 10), ("6442490437"));
            Persona persona18 = new Persona("VALI050225A1", "Isabella", "Valdéz", "López", LocalDate.of(2005, 2, 25), ("6441547653"));
            Persona persona19 = new Persona("ROPI030901D4", "Ingrid", "Rosas", "Palacios", LocalDate.of(2003, 9, 1), ("2291748899"));
            Persona persona20 = new Persona("NAHA031007H8", "Adriana Guadalupe", "Naal", "Huchin", LocalDate.of(2003, 10, 7), ("9961018583"));

            em.persist(persona1);
            em.persist(persona2);
            em.persist(persona3);
            em.persist(persona4);
            em.persist(persona5);
            em.persist(persona6);
            em.persist(persona7);
            em.persist(persona8);
            em.persist(persona9);
            em.persist(persona10);
            em.persist(persona11);
            em.persist(persona12);
            em.persist(persona13);
            em.persist(persona14);
            em.persist(persona15);
            em.persist(persona16);
            em.persist(persona17);
            em.persist(persona18);
            em.persist(persona19);
            em.persist(persona20);

            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Se han insertado 20 personas con éxito");
        } catch (PersistenceException ex) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public Persona consultar(String rfc) {
        try {
            //Busca el rfc en la clase persona
            return em.find(Persona.class, rfc);
        } catch (PersistenceException ex) {
            JOptionPane.showMessageDialog(null, "Error al consultar a la persona");
            return null;
        }
    }

    @Override
    public List<Persona> consultarLista(String rfc) {
        try {
            String codigoJPQL = "SELECT p FROM Persona p WHERE p.rfc LIKE :rfc";
            TypedQuery<Persona> query = em.createQuery(codigoJPQL, Persona.class);
            query.setParameter("rfc", rfc);

            return query.getResultList();
        } catch (PersistenceException ex) {
            em.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public List<Persona> consultarListaBusqueda(Busqueda busqueda, FormatoPaginas formato) throws NoResultException {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Persona> crit = builder.createQuery(Persona.class);
        Root<Persona> root = crit.from(Persona.class);
        List<Predicate> filtros = new LinkedList<>();
//Validadores de nombre
        if (busqueda.getNombre() != null && busqueda.getNombre().isEmpty()) {
            filtros.add(builder.like(
                    builder.concat(
                            builder.concat(root.get("nombres"), root.get("ap_paterno")),
                            root.get("ap_materno")), "%" + busqueda.getNombre() + "%"));
        }
//Validadores de fecha de nacimiento
        if (busqueda.getFechaNac() != null && !busqueda.getFechaNac().equals(0)) {
            filtros.add(builder.equal(builder.function("year",
                    Integer.class, root.get("fecha_nacimiento")),
                    busqueda.getFechaNac()));
        }
        try {
            crit = crit.select(root).where(builder.or(filtros.toArray(new Predicate[0])));
            TypedQuery<Persona> query;
            if (formato != null) {
                query = em.createQuery(crit).setMaxResults(formato.getElementosPerPag());
            } else {
                query = em.createQuery(crit);
            }
            List<Persona> persona = query.getResultList();
            return persona;
        } catch (NoResultException ex) {
            return null;
        }

    }


 
}
