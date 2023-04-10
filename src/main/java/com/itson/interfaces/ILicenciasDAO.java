
package com.itson.interfaces;

import com.itson.dominio.Licencia;
import com.itson.dominio.Persona;
import com.itson.dominio.Tramite;
import excepciones.PersistenciaException;

/**
 *
 * @author 
 */
public interface ILicenciasDAO {
    
    public void insertar(String rfc, String nombre,  String apellidoPaterno, String apellidoMaterno, 
            String fechaNac,  String telefono, double costo, int vigencia, boolean discapacidad) 
            throws PersistenciaException;

    public Licencia consultar(Integer idPersona);
    
//    public Licencia insertar(Persona persona, Licencia licencia);
    
}
