
package com.itson.pruebas;

import com.itson.interfaces.IConexionBD;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 
 */
public class ConexionBD implements IConexionBD {

    @Override
    public EntityManager crearConexion() throws SQLException {
        EntityManagerFactory managerFactory
                = Persistence.createEntityManagerFactory("org.itson.agenciafiscal");
        EntityManager entityManager = managerFactory.createEntityManager();
        return entityManager;
    }
}
