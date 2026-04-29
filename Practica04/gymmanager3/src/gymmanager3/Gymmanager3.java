/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gymmanager3;

/**
 *
 * @author FCFM
 */
public class Gymmanager3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Rutina Entrenamiento = new Rutina("Dia de pierna");
        
        
        
        
        System.out.println("Buscando un ejercicio en particular");
        Entrenamiento.buscarEjercicio("Sentadilla");
        
        
        Entrenamiento.mostrar_rutina();
        
        
        // Practica 3
        
        
    }  
}
