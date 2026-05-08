/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gymmanager6;

import java.util.ArrayList;

/**
 *
 * @author Lic Carmen
 */
public class Rutina {
    public String nombreRutina;
    public ArrayList<Ejercicio> listaEjercicios;
    
    public Rutina(String nombreRutina){
        this.nombreRutina = nombreRutina;
        this.listaEjercicios = new ArrayList<>();
    }
    
    public void  agregarEjercicio(Ejercicio e){
        listaEjercicios.add(e);
    }
    
    public void buscarEjercicio(String busqueda){
        for(Ejercicio e: listaEjercicios)
        {
            if(e.getNombre().equals(busqueda))
                System.out.println("El ejercicio fue encontrado " + e.resumen());
            else
                System.out.println("El ejericio no fue encontrado, puede agregarlo con la funcion agregar");
                
        }
    }
    
    
    public void IniciarEntrenamiento(){
        
        System.out.println("----- INICIANDO ENTRENAMIENTO " + nombreRutina + " ------");
        
        for(Ejercicio e: listaEjercicios){
            
            System.out.println("Comenzamos con el siguiente ejercicio " + e.getNombre());
            
            if(e instanceof Equipable)
                ((Equipable) e).prepararEquipo();
            
            if(e instanceof Cronometrable)
                ((Cronometrable) e).iniciarCronometro();
            
            if(e instanceof Equipable)
                ((Equipable) e).limpiarEquipo();
            
            if(e instanceof Cronometrable)
                ((Cronometrable) e).detenerCronometro();
                
            
            e.descansar();
            
        }
    }
    
    public void mostrar_rutina(){
        System.out.println("---- " + nombreRutina + "----");
        for(Ejercicio e: listaEjercicios)
        {
            System.out.println("\n" + e.resumen() + "\n");
            e.ejecutar();
            e.descansar();
        }
    }
}
