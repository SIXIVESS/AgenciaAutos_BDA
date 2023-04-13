/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 
 */
public class TramitesDAO {
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.itson.agenciafiscal");
    EntityManager em = emf.createEntityManager();

    public TramitesDAO() {
    }
    
    
}
