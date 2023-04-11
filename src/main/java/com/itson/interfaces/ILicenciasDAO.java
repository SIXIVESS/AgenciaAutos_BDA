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

    //Registra los datos de la licencia
    public void insertar(String rfc, String nombre, String apellidoPaterno, String apellidoMaterno,
            String fechaNac, String telefono, float costo, int vigencia, boolean discapacidad)
            throws PersistenciaException;

    //Consulta a la persona por su rfc
    public boolean consultar(String rfc);
    
}
