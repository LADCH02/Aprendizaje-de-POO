/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gymmanager9;

import java.io.Serializable;

/**
 *
 * @author Lic Carmen
 */
public abstract class Ejercicio implements EvaluacionFisica, Comparable<Ejercicio>, Serializable {
    protected String nombre;
    protected String grupo_muscular;
    protected int series;
    protected int repeticiones;
    
    
    public Ejercicio(String nombre, String grupo_muscular, int series, int repeticiones){
        setNombre(nombre);
        this.grupo_muscular = grupo_muscular;
        this.series = series;
        this.repeticiones = repeticiones;
    }
    
    public Ejercicio(String nombre, String grupo_muscular){
        setNombre(nombre);
        this.grupo_muscular = grupo_muscular;
        this.series = 3;
        this.repeticiones = 10;
    }
    
    
    public Ejercicio(){
        setNombre("Ejercicio generico");
        this.grupo_muscular = "Cuerpo completo";
    }
    
    
    public abstract void ejecutar();
    
    
    public void descansar() {
        System.out.println("Descansando 90 segundos entre series de " + nombre);
    }
    
    
    public void setNombre(String nombre){
        if(nombre != null && nombre.trim().length() >= 3)
            this.nombre = nombre;
        else
            System.out.println("El nombre es muy corto no es valido " + nombre);
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    
    public String getGrupoMuscular(){
        return this.grupo_muscular;
    }
    
    
    
    
    public final void generarReporteEntrenamiento(){
        System.out.println("====== REPORTE DE ENTRENAMIENTO ======");
        System.out.println(resumen()); 
        ejecutar();                   
        System.out.println("Calorías estimadas: " + calcularCalorias());
        descansar();                  
        System.out.println("======================================");
    }
    
    public void fallo_muscular(int rpe){
        if(rpe > 8)
            System.out.println("En el ejercicio: " + nombre + " se encuentra apunto del fallo muscular con un RPE de " + rpe + "tenga cuidado puede tener una sobre carga nerviosa");
        else
            System.out.println("En el ejercicio: " + nombre + " se encuentra en un RPE optimo de " + rpe + " sin problema de tener una sobre carga");      
    }
   
    public String resumen(){
        return ("El grupo muscular es " + grupo_muscular + "\nEjercicio: " + nombre + "\nSeries: " + series + "\nRepeticiones: " + repeticiones + "\nMuchas felicidades por su esfuerzo son unos maravillosos pesos los obtenidos vamos por mas");
    }
    
    
    @Override
    public int compareTo(Ejercicio otro) {
        return this.nombre.compareTo(otro.nombre);
    }
    
    @Override
    public String toString(){
        return String.format("Ejercicio: %s | Musculo: %s | Carga: (%dx%d)",nombre,grupo_muscular,series,repeticiones);
    }
}
