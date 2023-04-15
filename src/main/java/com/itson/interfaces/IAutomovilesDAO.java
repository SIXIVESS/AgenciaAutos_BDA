/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.itson.interfaces;

import com.itson.dominio.Automovil;


/**
 *
 * @author
 */
public interface IAutomovilesDAO {

    public void insertar(Automovil auto);

    public Automovil consultar(String serie);

    public boolean existe(String serie);
}
