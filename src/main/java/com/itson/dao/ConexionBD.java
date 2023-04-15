
package com.itson.dao;

import com.itson.interfaces.IConexionBD;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 *  
 * @author Alexa Soto(236348) y Rosalía Perez (233505)
 */
public class ConexionBD implements IConexionBD {

    /**
     * Método que se encarga de crear una conexión hacia la base de datos
     * @return Regresa la conexión
     * @throws SQLException Imprime un error en caso de que la conexión con la base de datos no haya sido exitosa
     */
    @Override
    public EntityManager crearConexion() throws SQLException {
        EntityManagerFactory managerFactory
                = Persistence.createEntityManagerFactory("org.itson.agenciafiscal");
        EntityManager em = managerFactory.createEntityManager();
        
        return em;
    }
    
}
