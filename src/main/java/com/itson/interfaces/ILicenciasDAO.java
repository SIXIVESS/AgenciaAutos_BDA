/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.itson.interfaces;

import com.itson.dominio.Licencia;

/**
 *
 * @author alexa
 */
public interface ILicenciasDAO {
    
    public Licencia consultar(Integer idPersona);
}
