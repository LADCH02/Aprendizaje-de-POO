/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gympos.controllers;


import com.mycompany.gympos.exceptions.PagoInvalidoException;
import com.mycompany.gympos.models.Cliente;
/**
 *
 * @author Lic Carmen
 */
public class ProcesadorPagosController {
    public void procesarPagoMembresia(Cliente cliente, double montoPagado, double costoMembresia) throws PagoInvalidoException {
        if (montoPagado < costoMembresia) {
            throw new PagoInvalidoException("Fondos insuficientes. Faltan $" + (costoMembresia - montoPagado));
        }
        
        System.out.println("Pago aprobado por $" + montoPagado + " para " + cliente.getNombre());
        cliente.sumarPuntos(10); 
    }
}
