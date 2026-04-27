/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gymmanager;

/**
 *
 * @author luis
 */
public class Ejercicio {
    String nombre;
    String grupo_muscular;
    int series;
    int repeticiones;
    double pesoKg;
    int rpe;
    
    
    public Ejercicio(String nombre, String grupo_muscular, int series, int repeticiones, double pesokg, int rpe){
        this.nombre = nombre;
        this.grupo_muscular = grupo_muscular;
        this.series = series;
        this.repeticiones = repeticiones;
        this.pesoKg = pesokg;
        this.rpe = rpe;
    }
    
    public Ejercicio(String nombre, String grupo_muscular){
        this.nombre = nombre;
        this.grupo_muscular = grupo_muscular;
        this.series = 3;
        this.repeticiones = 10;
        this.pesoKg = 0.0;
        this.rpe = 0;
    }
    
    
       public Ejercicio(){
        this.nombre = "Ejercicio generico";
        this.grupo_muscular = "Cuerpo completo";
    }
    
    // 1) progreso de peso, 2) fallo muscular o cerca del fallo muscular, 3) Cambiar rep y ser, 4) obtener resumen , 5) obtener el nombre;
       
    
}
