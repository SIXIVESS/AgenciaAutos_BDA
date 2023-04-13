/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.itson.interfaces;

import com.itson.dao.ReportesDAO;
import com.itson.dominio.Tramite;
import com.itson.utils.FormatoPaginas;
import java.util.List;

/**
 *
 * @author
 */
public interface ITramitesDAO {
    
    public List<Tramite>consultaTramite (String rfc, FormatoPaginas formato);
    public List <Tramite> buscar (ReportesDAO reporte, FormatoPaginas formato);
    
}
