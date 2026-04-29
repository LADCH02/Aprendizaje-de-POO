/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gymmanager3;

/**
 *
 * @author FCFM
 */
public class EjercicioPersonalizado {
    protected String Objetivo;
    protected int duracion;
    private Ejercicio principal;
    
    public EjercicioPersonalizado(String Objetivo, int duracion, Ejercicio principal){
        this.Objetivo = Objetivo;
        this.duracion = duracion;
        this.principal = principal;
    }
    
    public void detalles(){
        System.out.println("-----Plan de entrenamiento-----");
        System.out.println("Duracion del entrenamiento: " + duracion);
        System.out.println("Detalles: \n" + principal.resumen());
    }
}
