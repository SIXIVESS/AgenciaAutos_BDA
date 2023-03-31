/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.itson.interfaces;

import java.sql.SQLException;
import javax.persistence.EntityManager;

/**
 *
 * @author alexa
 */
public interface IConexionBD {
    EntityManager crearConexion() throws SQLException;
}
