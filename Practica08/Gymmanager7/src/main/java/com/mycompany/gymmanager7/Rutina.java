/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gymmanager7;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
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
    
    public void registrarEntrenamiento(double pesoCargado) throws GymException {
   
    try (PrintWriter escritor = new PrintWriter(new FileWriter("registro_errores.log", true))) {
        
        
        if (pesoCargado < 0) {
            String msg = "ERROR: Peso negativo detectado: " + pesoCargado;
            escritor.println(LocalDateTime.now() + " - " + msg); 
            throw new PesoInvalidoException("No puedes cargar peso negativo", pesoCargado);
        }
        
        if (pesoCargado > 500) {
            String msg = "ALERTA: Peso excesivo: " + pesoCargado + "kg";
            escritor.println(LocalDateTime.now() + " - " + msg); 
            throw new CapacidadExcedidaException("El peso excede el límite de seguridad.");
        }

        
        System.out.println("Registrando sesión con: " + pesoCargado + "kg");
        escritor.println(LocalDateTime.now() + " - ÉXITO: Registro de " + pesoCargado + "kg en rutina " + nombreRutina);

    } catch (IOException e) {
        System.err.println("Error de entrada/salida: " + e.getMessage());
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
