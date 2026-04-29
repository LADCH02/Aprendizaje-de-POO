/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gymmanager3;

/**
 *
 * @author FCFM
 */
public class PesoLibre extends EjercicioFuerza{
    
    public PesoLibre(String nombre, String grupo, int s, int r, double p, int rpe){
        super(nombre,grupo,s,r,p,rpe);
    }
    
    public void recomendacion(){
        System.out.println("Se recomienda que en ejercicios libres se antepone el peso maximo con buena ejecucion y un numero de repetciones entre 1-6 de 4 series");
    }
    
   
    @Override
    public void ejecutar() {
        System.out.println("[PESO LIBRE] Estabilizando y levantando " + pesoKg + "kg en " + nombre);
    }

    @Override
    public void descansar() {
        System.out.println("Dejando las pesas en el piso. Descanso activo.");
    }
    
}
