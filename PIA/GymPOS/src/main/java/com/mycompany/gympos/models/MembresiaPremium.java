/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gympos.models;

/**
 *
 * @author Lic Carmen
 */
public class MembresiaPremium extends Membresia{
    public MembresiaPremium() {
        super(600.0, 30);
    }

    @Override
    public String obtenerBeneficios() {
        return "Acceso total, alberca, spa y clases grupales incluidas.";
    }
}
