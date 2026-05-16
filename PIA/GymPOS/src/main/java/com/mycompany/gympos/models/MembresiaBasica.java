/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gympos.models;

/**
 *
 * @author Lic Carmen
 */
public class MembresiaBasica extends Membresia{
    public MembresiaBasica() {
        super(350.0, 30); // Comentario 350 representa el costo y 30 los dias
    }

    @Override
    public String obtenerBeneficios() {
        return "Acceso a zona de pesas y cardio.";
    }
}
