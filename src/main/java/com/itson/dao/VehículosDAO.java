package com.itson.dao;

import com.itson.dominio.Vehiculo;
import com.itson.interfaces.IVehículoDAO;
import javax.persistence.DiscriminatorValue;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexa Soto(236348) y Rosalía Perez (233505)
 */
public class VehículosDAO implements IVehículoDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.itson.agenciafiscal");
    EntityManager em = emf.createEntityManager();

    /**
     * Constructor por defecto
     */
    public VehículosDAO() {
    }
    
    /**
     * Método que se encarga de buscar un vehículo usando su número de serie
     * @param num_serie Identificador del vehículo
     * @return Regresa el vehículo encontrado, sino, regresará nulo
     */
    public Vehiculo buscarVehiculo(String num_serie){
        try{
            Vehiculo v = em.find(Vehiculo.class, num_serie);
            return v;
        }catch(NoResultException ex){
            JOptionPane.showMessageDialog(null, "No se encontró el vehículo");
            return null;
        }
    }
    
    /**
     * Método encargado de consultar el vehículo dependiendo de su número de serie
     * @param num_serie  Identificador del vehículo
     * @return Regresa el tipo de vehículo buscado
     */
    public String consultar(String num_serie){
        try{
            Vehiculo v = em.find(Vehiculo.class, num_serie);
            if(v !=null){
                return v.getClass().getAnnotation(DiscriminatorValue.class).value();
            }else{
                JOptionPane.showMessageDialog(null, "No se encontró el vehículo");
                return null;
            }
        }catch(NoResultException ex){
            return null;
        }
    }
    
}
