/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gymmanager9;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Lic Carmen
 */
public class Gymmanager9 {

    public static void main(String[] args) {
        System.out.println("===== ABRIENDO GIMNASIO (HORA PICO) =====\n");

        ZonaEspera salaEspera = new ZonaEspera();

       
        Thread recepcion1 = new Thread(new RecepcionProductor(salaEspera, "Recepción A"));
        Thread recepcion2 = new Thread(new RecepcionProductor(salaEspera, "Recepción B"));
        
        EntrenadorConsumidor entrenador1 = new EntrenadorConsumidor(salaEspera, "Entrenador Carlos");
        EntrenadorConsumidor entrenador2 = new EntrenadorConsumidor(salaEspera, "Entrenadora Ana");

        
        recepcion1.start();
        recepcion2.start();
        entrenador1.start();
        entrenador2.start();

        
        ExecutorService personalLimpieza = Executors.newFixedThreadPool(2);
        String[] maquinasALimpiar = {"Press Banca", "Sentadilla Libre", "Trotadora 1", "Trotadora 2"};
        
        System.out.println("\n Mandando a limpiar máquinas en segundo plano..\n");
        for (String maquina : maquinasALimpiar) {
            personalLimpieza.execute(new LimpiezaTask(maquina));
        }
        
        
        personalLimpieza.shutdown();
    }
}
