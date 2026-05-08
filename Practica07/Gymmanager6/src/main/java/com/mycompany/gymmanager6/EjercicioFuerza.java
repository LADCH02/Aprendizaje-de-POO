/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gymmanager6;

/**
 *
 * @author Lic Carmen
 */
public abstract class EjercicioFuerza extends Ejercicio{
    protected double pesoKg;
    protected int rpe;
    
    public EjercicioFuerza(String nombre, String grupo_muscular, int series, int repeticiones, double pesoKg, int rpe){
        super(nombre, grupo_muscular, series, repeticiones);
        setPesoKg(pesoKg);
        this.rpe = rpe;
    }
    
    
    public void setPesoKg(double pesoKg){
        this.pesoKg = pesoKg;
    }
    
    
    public void progreso_peso(double pesoextra){
        pesoKg += pesoextra;
        System.out.println("En el ejercicio: " + nombre + "se obtuvo un nuevo peso de " + pesoKg);
    }
    
    public void cambiar_parametros(int rpe, int series){
        this.rpe = rpe;
        this.series = series;
    }
}
