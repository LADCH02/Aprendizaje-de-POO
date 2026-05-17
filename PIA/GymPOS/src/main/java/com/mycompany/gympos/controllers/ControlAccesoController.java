/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gympos.controllers;
import com.mycompany.gympos.exceptions.MembresiaVencidaException;
import com.mycompany.gympos.models.Cliente;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author Lic Carmen
 */
public class ControlAccesoController {
    
    private final String ARCHIVO_LOG = "registro_accesos.txt";
    
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    public void registrarEntrada(Cliente cliente) throws MembresiaVencidaException {
        if (cliente.getMembresia() == null) {
            throw new MembresiaVencidaException("El cliente no tiene una membresía asignada.");
        }
        
        if (!cliente.getMembresia().isActiva()) {
            throw new MembresiaVencidaException("ACCESO DENEGADO: La membresía de " + cliente.getNombre() + " está vencida.");
        }
        
        
        String fechaHora = LocalDateTime.now().format(formatter);
        String mensaje = "[ENTRADA] " + fechaHora + " - " + cliente.getNombre() + " (ID: " + cliente.getIdCliente() + ")\n";
        
        guardarEnLog(mensaje);
        
        System.out.println("ACCESO CONCEDIDO: Bienvenido " + cliente.getNombre());
    }
    
    public void registrarSalida(Cliente cliente) {
        String fechaHora = LocalDateTime.now().format(formatter);
        String mensaje = "[ SALIDA] " + fechaHora + " - " + cliente.getNombre() + " (ID: " + cliente.getIdCliente() + ")\n";
        
        guardarEnLog(mensaje);
        System.out.print(mensaje);
    }
    
    private void guardarEnLog(String mensaje) {
        try (FileWriter fw = new FileWriter(ARCHIVO_LOG, true)) {
            fw.write(mensaje);
        } catch (IOException e) {
            System.err.println("Error al guardar el log de acceso: " + e.getMessage());
        }
    }
    
}
