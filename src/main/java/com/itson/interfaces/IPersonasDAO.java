
package com.itson.interfaces;

import com.itson.dominio.Persona;
import java.util.List;

/**
 *
 * @author 
 */
public interface IPersonasDAO {
    
    public void insertar();
    
    public Persona consultar(String rfc);
    
    public List<Persona> consultarLista(String rfc);
}
