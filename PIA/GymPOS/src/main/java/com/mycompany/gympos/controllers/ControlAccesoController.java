/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gympos.controllers;
import com.mycompany.gympos.exceptions.MembresiaVencidaException;
import com.mycompany.gympos.models.Cliente;
/**
 *
 * @author Lic Carmen
 */
public class ControlAccesoController {
    public void registrarEntrada(Cliente cliente) throws MembresiaVencidaException {
        if (cliente.getMembresia() == null) {
            throw new MembresiaVencidaException("El cliente no tiene una membresía asignada.");
        }
        
        if (!cliente.getMembresia().isActiva()) {
            throw new MembresiaVencidaException("ACCESO DENEGADO: La membresía de " + cliente.getNombre() + " está vencida.");
        }
        
        System.out.println("ACCESO CONCEDIDO: Bienvenido " + cliente.getNombre());
    }
}
