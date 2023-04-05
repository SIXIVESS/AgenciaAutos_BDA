
package com.itson.interfaces;

import java.sql.SQLException;
import javax.persistence.EntityManager;

/**
 *
 * @author 
 */
public interface IConexionBD {
    EntityManager crearConexion() throws SQLException;
}
