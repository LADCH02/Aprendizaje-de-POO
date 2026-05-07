/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gymmanager5;

/**
 *
 * @author Lic Carmen
 */
public class Crossfit extends Ejercicio implements Equipable, Cronometrable {
    
    public Crossfit(String nombre, String grupo_muscular, int series, int repeticiones){
        super(nombre,grupo_muscular,series,repeticiones);
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
