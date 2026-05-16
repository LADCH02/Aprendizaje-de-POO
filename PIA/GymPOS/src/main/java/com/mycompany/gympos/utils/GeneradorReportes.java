/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gympos.utils;

import com.mycompany.gympos.models.Cliente;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Lic Carmen
 */
public class GeneradorReportes extends Thread {
    private List<Cliente> clientes;

    public GeneradorReportes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public void run() {
        System.out.println("Generando reporte en segundo plano...");
        try {
            
            Thread.sleep(3000); 
            
            
            try (FileWriter writer = new FileWriter("Reporte_Gimnasio.txt")) {
                writer.write("=== REPORTE DE CLIENTES GYMPOS ===\n");
                for (Cliente c : clientes) {
                    String tipoMem = (c.getMembresia() != null) ? "Activa" : "Sin Membresía";
                    writer.write("ID: " + c.getIdCliente() + " | Nombre: " + c.getNombre() + " | Puntos: " + c.getPuntosRecompensa() + " | Estado: " + tipoMem + "\n");
                }
                System.out.println("¡Reporte TXT generado exitosamente! (Revisa tu carpeta del proyecto)");
            }
            
        } catch (InterruptedException | IOException e) {
            System.err.println("Error en la generación del reporte: " + e.getMessage());
        }
    }
}
