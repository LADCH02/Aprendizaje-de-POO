/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gymmanager9;

/**
 *
 * @author Lic Carmen
 */
public class Crossfit extends Ejercicio implements Equipable, Cronometrable {
    String intensidad;
    private int Estaciones;
    
    public Crossfit(String nombre, String grupo_muscular, int series, int repeticiones, int Estaciones){
        super(nombre,grupo_muscular,series,repeticiones);
        this.Estaciones = Estaciones;
    }
    
    @Override
    public void ejecutar(){
        System.out.println("Realizando el circuito de alta intensidad con  " + Estaciones + "estaciones ");
    }
    
    @Override
    public String evaluarIntensidad() {
        
        if(calcularCalorias() < 1200.0)
            intensidad = "Baja";
        else if(calcularCalorias() >= 1200 && calcularCalorias() < 2000)
            intensidad =  "Media";
        else if(calcularCalorias() >= 2000)
            intensidad = "Muy Alta";
        return intensidad;
    }
    
    @Override
    public double calcularCalorias(){
        return Estaciones * 300.0;
    }
    
    
    @Override
    public void iniciarCronometro(){
        System.out.println("Se incia el cronometro del circuito, gogo");
    }
    @Override
    public void detenerCronometro(){
        System.out.println("BEEP BEEP BEEP, se acabo el cicuito");
    }
    @Override
    public void prepararEquipo(){
        System.out.println("Sacando las cajas, cuerdas y pelotas para el circuito");
    }
    @Override
    public void limpiarEquipo(){
        System.out.println("Guardando todo el material y limpiando su base");
    }
}
