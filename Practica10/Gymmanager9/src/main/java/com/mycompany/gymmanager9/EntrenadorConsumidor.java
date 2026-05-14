/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gymmanager9;

/**
 *
 * @author Lic Carmen
 */
public class EntrenadorConsumidor extends Thread{
    private ZonaEspera zonaEspera;
    private String nombreEntrenador;

    public EntrenadorConsumidor(ZonaEspera zonaEspera, String nombreEntrenador) {
        this.zonaEspera = zonaEspera;
        this.nombreEntrenador = nombreEntrenador;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 8; i++) {
                zonaEspera.atenderCliente(nombreEntrenador);
                Thread.sleep((long) (Math.random() * 1000 + 1000));
            }
        } catch (InterruptedException e) {
            System.err.println(nombreEntrenador + " terminó su turno.");
        }
    }
}
