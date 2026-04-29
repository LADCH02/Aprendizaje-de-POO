/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gymmanager3;

/**
 *
 * @author FCFM
 */
public class Maquina extends EjercicioFuerza{
    private int numero;
    public Maquina(String nombre, String grupo, int s, int r, double p, int rpe, int numero){
        super(nombre,grupo,s,r,p,rpe);
        this.numero = numero;
    }
    
    public void recomendacion(){
        System.out.println("Se recomienda que en ejercicios asistidos el numero de repeticones aumente.");
    }
    
    
    @Override
    public void ejecutar() {
        System.out.println("[MAQUINA #" + numero+ "] para el ejercicio " + nombre + " intrucciones en la maquina");
    }
    
    
    @Override
    public void descansar() {
        System.out.println("Descansa bajando de la maquina asistida.");
    }
}
