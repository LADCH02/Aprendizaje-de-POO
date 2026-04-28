/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gymmanager;
import java.util.ArrayList;

/**
 *
 * @author FCFM
 */
public class Rutina {
    public String nombreRutina;
    public ArrayList<Ejercicio> listaEjercicios;
    
    public Rutina(String nombreRutina, Ejercicio e){
        this.nombreRutina = nombreRutina;
        this.listaEjercicios = new ArrayList<>();
    }
    
    public void  agregarEjercicio(Ejercicio e){
        listaEjercicios.add(e);
    }
    
    public void buscarEjercicio(String busqueda){
        for(Ejercicio e: listaEjercicios)
        {
            if(e.nombre.equals(busqueda))
                System.out.println("El ejercicio fue encontrado " + e.resumen());
            else
                System.out.println("El ejericio no fue encontrado, puede agregarlo con la funcion agregar");
                
        }
    }
    
    public void mostrar_rutina(){
        System.out.println("---- " + nombreRutina + "----");
        for(Ejercicio e: listaEjercicios)
        {
            System.out.println("\n" + e.resumen() + "\n");
        }
    }
}
