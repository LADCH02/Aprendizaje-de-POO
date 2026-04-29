/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gymmanager3;

/**
 *
 * @author FCFM
 */
public class Cardio extends Ejercicio{
    private double distancia;
    
    public Cardio(String nombre, String grupo_muscular, int series, int repeticiones, double distancia){
        super(nombre,grupo_muscular,series,repeticiones);
        this.distancia = distancia;
    }
    
    
    public void recomendacion(){
        System.out.println("Se recomienda que la persona antes de empezar realice un calentamiento dinamico y al final se estire");
    }
    
    @Override
    public void ejecutar() {
        System.out.println("Corriendo/Pedaleando " + distancia+ "km de " + nombre);
    }
    
    
    @Override
    public void descansar() {
        System.out.println("Acuestate en el piso, viendo hacia arriba y respira lento por 2 minutos");
    }
    
    
}
