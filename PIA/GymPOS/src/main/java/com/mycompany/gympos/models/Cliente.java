/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gympos.models;
import java.io.Serializable;
/**
 *
 * @author Lic Carmen
 */
public class Cliente implements Serializable{
    private String idCliente;
    private String nombre;
    private String telefono;
    private Membresia membresia; 
    private int puntosRecompensa; 

    public Cliente(String idCliente, String nombre, String telefono) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.telefono = telefono;
        this.puntosRecompensa = 0;
    }

    
    public void sumarPuntos(int puntos) {
        this.puntosRecompensa += puntos;
    }

    
    public String getIdCliente() { return idCliente; }
    public String getNombre() { return nombre; }
    public Membresia getMembresia() { return membresia; }
    public void setMembresia(Membresia membresia) { this.membresia = membresia; }
    public int getPuntosRecompensa() { return puntosRecompensa; }
}
