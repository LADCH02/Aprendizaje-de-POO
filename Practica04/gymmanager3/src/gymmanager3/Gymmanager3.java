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
        
        
        PesoLibre p1 = new PesoLibre("Press Militar", "Hombro", 4, 10, 40.0, 8);
        Maquina m1 = new Maquina("Extensiones", "Cuadriceps", 3, 15, 60.0, 9, 12);
        Cardio c1 = new Cardio("Pista","Cardiovascular", 2,3,5.0);
        
        
        Entrenamiento.agregarEjercicio(p1);
        Entrenamiento.agregarEjercicio(m1);
        Entrenamiento.agregarEjercicio(c1);
        
        Entrenamiento.mostrar_rutina();
        
        
        
    }  
}
