
package com.itson.dao;

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
        EntityManager em = managerFactory.createEntityManager();
        
        return em;
    }
    
}
