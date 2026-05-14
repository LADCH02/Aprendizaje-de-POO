/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gymmanager9;

/**
 *
 * @author Lic Carmen
 */
public class RecepcionProductor implements Runnable{
    private ZonaEspera zonaEspera;
    private String nombreRecepcion;

    public RecepcionProductor(ZonaEspera zonaEspera, String nombreRecepcion) {
        this.zonaEspera = zonaEspera;
        this.nombreRecepcion = nombreRecepcion;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 8; i++) {
                String cliente = "Cliente-" + i + " de " + nombreRecepcion;
                zonaEspera.agregarCliente(cliente, nombreRecepcion);
                Thread.sleep((long) (Math.random() * 1000 + 500));
            }
        } catch (InterruptedException e) {
            System.err.println(nombreRecepcion + " fue interrumpida.");
        }
    }
}
