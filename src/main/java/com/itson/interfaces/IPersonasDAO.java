
package com.itson.interfaces;

import com.itson.dominio.Persona;
import com.itson.utils.Busqueda;
import com.itson.utils.FormatoPaginas;
import java.util.List;

/**
 *
 * @author 
 */
public interface IPersonasDAO {
    public void insertar();
    public Persona consultar(String rfc);
    public List<Persona> consultarLista(String rfc);
    public List<Persona> consultarListaBusqueda(Busqueda busqueda, FormatoPaginas formato);
}
