/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.itson.interfaces;

import com.itson.dominio.Persona;
import com.itson.dominio.Placa;
import com.itson.dominio.Vehiculo;
import java.util.List;

/**
 *
 * @author 
 */
public interface IPlacasDAO {
    
    public void insertar(String num_alfanumerico, Vehiculo vehiculo, Persona persona, float costo);
    
    public List<Placa> consultar(String placas);
    
    public Placa consultarPlaca(String placas);
    
    public void actualizar(String placas);
}
