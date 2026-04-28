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
    
    
    public void progreso_peso(double pesoextra){
        pesoKg += pesoextra;
        System.out.println("En el ejercicio: " + nombre + "se obtuvo un nuevo peso de " + pesoKg);
    }
    
    public void fallo_muscular(int rpe){
        if(rpe > 8)
            System.out.println("En el ejercicio: " + nombre + " se encuentra apunto del fallo muscular con un RPE de " + rpe + "tenga cuidado puede tener una sobre carga nerviosa");
        else
            System.out.println("En el ejercicio: " + nombre + " se encuentra en un RPE optimo de " + rpe + " sin problema de tener una sobre carga");      
    }
    
    public void cambiar_parametros(int rpe, int series){
        this.rpe = rpe;
        this.series = series;
    }
    
    public String resumen(){
        return ("El grupo muscular es " + grupo_muscular + "\nEjercicio: " + nombre + "\nSeries: " + series + "\nRepeticiones: " + repeticiones + "\nEl peso maximo fue: " + pesoKg + "\nEl maximo RPE: " + rpe + "\nMuchas felicidades por su esfuerzo son unos maravillosos pesos los obtenidos vamos por mas");
    }
    
    
    public String getnombre(){
        return nombre;
    }
}

