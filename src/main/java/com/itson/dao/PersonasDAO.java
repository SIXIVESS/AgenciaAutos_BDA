package com.itson.dao;

import com.itson.dominio.Persona;
import com.itson.dominio.Telefono;
import com.itson.interfaces.IConexionBD;
import com.itson.interfaces.IPersonasDAO;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.JOptionPane;

/**
 *
 * @author
 */
public class PersonasDAO implements IPersonasDAO {

    private static final Logger LOG = Logger.getLogger(PersonasDAO.class.getName());
    private final IConexionBD generadorConexiones;

    public PersonasDAO(IConexionBD generadorConexiones) {
        this.generadorConexiones = generadorConexiones;
    }

    public PersonasDAO() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insertar() {
//        EntityManagerFactory managerFactory
//                = Persistence.createEntityManagerFactory("org.itson.agenciafiscal");
        try {
            EntityManager em = this.generadorConexiones.crearConexion();
            em.getTransaction().begin();

            Persona persona1 = new Persona("SOEA031129H0",
                    "Alexa María", "Soto", "Esquer",
                    new GregorianCalendar(2003, 11, 29),
                    new Telefono("6471220381"));
            Persona persona2 = new Persona("ROMJ030820A1",
                    "José Ángel", "Romero", "Montiel",
                    new GregorianCalendar(2003, 8, 20),
                    new Telefono("6471055623"));
            Persona persona3 = new Persona("RAEM030303L8",
                    "Magda Paola", "Rámirez", "Escalante",
                    new GregorianCalendar(2003, 3, 3),
                    new Telefono("6688293570"));
            Persona persona4 = new Persona("SARI031113H2",
                    "Ignacio Alejandro", "Saijas", "Ruiz",
                    new GregorianCalendar(2003, 11, 13),
                    new Telefono("6471369445"));
            Persona persona5 = new Persona("SOTR760126P9",
                    "Raúl", "Soto", "Torres",
                    new GregorianCalendar(1976, 1, 26),
                    new Telefono("6474820426"));
            Persona persona6 = new Persona("ESPC771112M1",
                    "Concepción", "Esquer", "Pacheco",
                    new GregorianCalendar(1977, 11, 12),
                    new Telefono("6471241569"));
            Persona persona7 = new Persona("ESPJ760514H5",
                    "Juan Carlos", "Esquer", "Pacheco",
                    new GregorianCalendar(1999, 8, 19),
                    new Telefono("6023322661"));
            Persona persona8 = new Persona("ESAM990819M9",
                    "Mariana", "Esquer", "Andrade",
                    new GregorianCalendar(2003, 11, 29),
                    new Telefono("6442040238"));
            Persona persona9 = new Persona("ESCJ361229J8",
                    "José David", "Esquer", "Castro",
                    new GregorianCalendar(1936, 12, 29),
                    new Telefono("6474264278"));
            Persona persona10 = new Persona("SOAA470903B5",
                    "Alonso", "Soto", "Ayala",
                    new GregorianCalendar(1947, 9, 3),
                    new Telefono("6471261845"));
//----------------------------------------------------------------------------------------------------------------------
            Persona persona11 = new Persona("SAQJ030314H8",
                    "Jorge Luis", "Sanchez", "Quezada",
                    new GregorianCalendar(2003, 3, 14),
                    new Telefono("6441171436"));
            Persona persona12 = new Persona("MAGM020226D3",
                    "Misael", "Márquez", "Gaxiola",
                    new GregorianCalendar(2002, 2, 26),
                    new Telefono("6442590977"));
            Persona persona13 = new Persona("LOLM030525E2",
                    "Marcos Anselmo", "López", "Lugardo",
                    new GregorianCalendar(2003, 5, 25),
                    new Telefono("3324253380"));
            Persona persona14 = new Persona("GAMG020813G4",
                    "Gael", "Gaxiola", "Maldonado",
                    new GregorianCalendar(2002, 8, 13),
                    new Telefono("6441953838"));
            Persona persona15 = new Persona("PEAR030224A7",
                    "Rosalía", "Pérez", "Acuña",
                    new GregorianCalendar(2003, 2, 24),
                    new Telefono("6442331575"));
            Persona persona16 = new Persona("LUSF020730F3",
                    "Fernando ", "Luque", "Steward",
                    new GregorianCalendar(2002, 7, 30),
                    new Telefono("6442463614"));
            Persona persona17 = new Persona("PEIM020810J1",
                    "Marlon", "Pereo", "Iriqui",
                    new GregorianCalendar(2002, 8, 10),
                    new Telefono("6442490437"));
            Persona persona18 = new Persona("DUPJ020921R3",
                    "Jose Roberto", "Duran", "Padilla",
                    new GregorianCalendar(2002, 9, 21),
                    new Telefono("6441182216"));
            Persona persona19 = new Persona("ROPI030901D4",
                    "Ingrid", "Rosas", "Palacios",
                    new GregorianCalendar(2003, 9, 1),
                    new Telefono("2291748899"));
            Persona persona20 = new Persona("NAHA031007H8",
                    "Adriana Guadalupe", "Naal", "Huchin",
                    new GregorianCalendar(2003, 10, 7),
                    new Telefono("9961018583"));

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
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
        }

    }

    @Override
    public Persona consultar(String rfc) {
//        EntityManagerFactory managerFactory
//                = Persistence.createEntityManagerFactory("org.itson.pruebasjpa");
//        EntityManager em = managerFactory.createEntityManager();
        try {
            EntityManager em = this.generadorConexiones.crearConexion();
            // Experto que sabe hacer consultas
            CriteriaBuilder builder = em.getCriteriaBuilder();
            // Consulta que se esta construyendo
            CriteriaQuery<Persona> criteria = builder.createQuery(Persona.class);
            Root<Persona> root = criteria.from(Persona.class);

            Persona persona = (Persona) criteria.select(root)
                    .where(builder.equal(root.get("rfc"), rfc));
            em.getTransaction().begin();

            return persona;
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Persona> consultarLista(String rfc) {
        try {
            EntityManager em = this.generadorConexiones.crearConexion();
            String codigoJPQL = "SELECT p FROM Persona p WHERE p.rfc LIKE :rfc";
            TypedQuery<Persona> query = em.createQuery(codigoJPQL, Persona.class);
            query.setParameter("rfc", rfc);

            return query.getResultList();
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
        }
        return null;
    }
}
