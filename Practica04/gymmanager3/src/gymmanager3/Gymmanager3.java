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
        
        Ejercicio e1 = new Ejercicio("Sentadilla","Pierna completa",4,10,100.0,7);
        Ejercicio e2 = new Ejercicio("Peso muerto", "Pierna trasera",4,10,70.0,8);
        Ejercicio e3 = new Ejercicio("Sentadilla isometrica", "Tendones",4,1,20.0,8);
        Ejercicio e4 = new Ejercicio("Extension de cuadricep", "Cuadricep",4,10,80.0,7);
        Ejercicio e5 = new Ejercicio("Curl femoral", "Femorales",4,10,70.0,7);
        
        
        e1.fallo_muscular(8);
        e2.progreso_peso(20);
        
        
        Entrenamiento.agregarEjercicio(e1);
        Entrenamiento.agregarEjercicio(e2);
        Entrenamiento.agregarEjercicio(e3);
        Entrenamiento.agregarEjercicio(e4);
        Entrenamiento.agregarEjercicio(e5);
        
        System.out.println("Buscando un ejercicio en particular");
        Entrenamiento.buscarEjercicio("Sentadilla");
        
        
        Entrenamiento.mostrar_rutina();
        
        
        // Practica 3
        
        System.out.println("--- Prueba de nombre---");
        e1.setNombre("X");
        
        System.out.println("----Prueba de peso----");
        e1.setPesoKg(-1.0);
        
        System.out.println("----Prueba de composicion----");
        EjercicioPersonalizado Rutina1 = new EjercicioPersonalizado("El objetivo de este ejercicio fortalecer el rango de movimiento, tambien la fuerza de empuje de las piernas.", 20,e1);
        Rutina1.detalles();
    }  
}
