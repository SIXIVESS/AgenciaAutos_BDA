
package com.itson.interfaces;

import com.itson.dominio.Licencia;
import com.itson.dominio.Persona;
import com.itson.dominio.Tramite;

/**
 *
 * @author 
 */
public interface ILicenciasDAO {
    
    public Licencia consultar(Integer idPersona);
    
    public Licencia insertar(Persona persona, Licencia licencia);
}
