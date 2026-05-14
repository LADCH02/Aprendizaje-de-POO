/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gymmanager10;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Lic Carmen
 */
public class ZonaEspera {
    
    private Queue<String> filaClientes = new LinkedList<>();
    private final int CAPACIDAD_MAXIMA = 5;
    
    public synchronized void agregarCliente(String cliente, String productorNombre) throws InterruptedException {
        
        while (filaClientes.size() == CAPACIDAD_MAXIMA) {
            System.out.println("[SALA LLENA] " + productorNombre + " esperando para dejar entrar a " + cliente);
            wait(); 
        }
        
        filaClientes.offer(cliente);
        System.out.println("[" + productorNombre + "] agregó a " + cliente + ". Fila actual: " + filaClientes.size());
        
        
        notifyAll();
    }
    
    public synchronized String atenderCliente(String entrenadorNombre) throws InterruptedException {
        
        while (filaClientes.isEmpty()) {
            System.out.println(" [SALA VACÍA] " + entrenadorNombre + " está esperando clientes...");
            wait(); 
        }
        
        String clienteAtendido = filaClientes.poll();
        System.out.println("[" + entrenadorNombre + "] está atendiendo a " + clienteAtendido + ". Fila restante: " + filaClientes.size());
        
        
        notifyAll();
        return clienteAtendido;
    }
    
}
