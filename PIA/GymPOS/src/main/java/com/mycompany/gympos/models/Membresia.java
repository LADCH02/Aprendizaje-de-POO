/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gympos.models;
import java.io.Serializable;
import java.time.LocalDate;
/**
 *
 * @author Lic Carmen
 */
public abstract class Membresia implements Serializable{
    protected double costo;
    protected LocalDate fechaInicio;
    protected LocalDate fechaVencimiento;
    protected boolean activa;

    public Membresia(double costo, int diasDuracion) {
        this.costo = costo;
        this.fechaInicio = LocalDate.now();
        this.fechaVencimiento = LocalDate.now().plusDays(diasDuracion);
        this.activa = true;
    }

    
    public abstract String obtenerBeneficios();

   
    public double getCosto() { return costo; }
    public LocalDate getFechaVencimiento() { return fechaVencimiento; }
    public boolean isActiva() { return activa; }
    
    
    public void renovar(int diasExtra) {
        this.fechaVencimiento = this.fechaVencimiento.plusDays(diasExtra);
        this.activa = true;
    }
}
