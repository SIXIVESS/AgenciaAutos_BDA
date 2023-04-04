/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.itson.interfaces;

import com.itson.dominio.Persona;
import java.util.List;

/**
 *
 * @author alexa
 */
public interface IPersonasDAO {
    
    public void insertar();
    
    public Persona consultar(String rfc);
    
    public List<Persona> consultarLista(String rfc);
}
