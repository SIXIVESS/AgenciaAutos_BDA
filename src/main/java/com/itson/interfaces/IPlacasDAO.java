/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.itson.interfaces;

import com.itson.dominio.Persona;
import com.itson.dominio.Placa;
import com.itson.dominio.Vehiculo;
import excepciones.PersistenciaException;

/**
 *
 * @author
 */
public interface IPlacasDAO {

    public void insertar1(Vehiculo vehiculo, Persona persona, float costo) throws PersistenciaException;

    public void insertar2(String num_alfanumerico, Vehiculo vehiculo, Persona persona, float costo, boolean estado);

    public Placa consultarActiva(String serie);

    public Placa consultar(Long idPlaca);

    public void actualizar(String placas);
}
