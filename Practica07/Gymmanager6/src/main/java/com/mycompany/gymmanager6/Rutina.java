/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gymmanager6;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
    
    public void registrarEntrenamiento(double pesoCargado) throws GymException{
        if (pesoCargado < 0){
            throw new PesoInvalidoException("No puedes cargar pesos negativos",pesoCargado);
        }
        
        if(pesoCargado > 500){
            throw new CapacidadExcedidaException("El peso excede el limite de seguridad del gym");
        }
        
        
        try(PrintWriter log = new PrintWriter(new FileWriter("resgistro-errores.log",true))){
            System.out.println("Registrando sesión con: " + pesoCargado + "kg");
        }catch(IOException e){
            System.err.println("Error fatal al escribir el archivo de log: " + e.getMessage());
        }
            
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
