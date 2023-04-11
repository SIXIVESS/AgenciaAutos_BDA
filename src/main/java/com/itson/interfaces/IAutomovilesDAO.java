/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.itson.interfaces;

import com.itson.dominio.Automovil;
import com.itson.utils.TipoAutomovil;
import java.util.List;

/**
 *
 * @author 
 */
public interface IAutomovilesDAO {
    
    public Automovil insertar(TipoAutomovil tipo, String serie, String marca, String modelo, 
            String color, String linea);
    
    public void insertarAuto(Automovil auto);
    
    public Automovil consultar(String serie);
}
