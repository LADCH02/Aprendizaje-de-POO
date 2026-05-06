/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gymmanager4;

/**
 *
 * @author FCFM
 */
public class Gymmanager4 {

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
        
        
        Ejercicio[] arrayEjercicios = new Ejercicio[3];
        arrayEjercicios[0] = p1;
        arrayEjercicios[1] = m1;
        arrayEjercicios[2] = c1;

       
        for (Ejercicio ej : arrayEjercicios) {
            ej.generarReporteEntrenamiento();             
            if (ej instanceof Maquina) {
                Maquina maquinaEspecifica = (Maquina) ej; 
                System.out.println(">>> ¡Aviso! Este ejercicio es en máquina. Recuerda limpiar el asiento.");
                maquinaEspecifica.recomendacion(); // Usando un método específico de la clase hija
            }
        }
    }
    
}
