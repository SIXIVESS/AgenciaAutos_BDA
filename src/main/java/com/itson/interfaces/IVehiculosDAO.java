package com.itson.interfaces;

import com.itson.dominio.Vehiculo;

/**
 *
 * @author Alexa Soto(236348) y Rosalía Perez (233505)
 */
public interface IVehiculosDAO {
    
    /**
     * Método que busca un vehículo por su número de serie
     * @param serie Número de serie
     * @return Vehículo
     */
    public Vehiculo buscar (String serie);
    
    /**
     * Método que consulta un vehículo por su número de serie
     * @param serie Número de serie
     * @return Vehículo consultado
     */
    public String consultar(String serie);
   
    
}
