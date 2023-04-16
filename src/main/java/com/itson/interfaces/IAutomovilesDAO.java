/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.itson.interfaces;

import com.itson.dominio.Automovil;
import com.itson.dominio.Persona;
import com.itson.utils.TipoAutomovil;


/**
 *
 * @author
 */
public interface IAutomovilesDAO {

    public void insertar(Automovil auto);
    
    public Automovil insertar2(String num_serie, String marca, String color, String modelo, String linea, Persona persona);

    public Automovil consultar(String serie);

    public boolean existe(String serie);
}
