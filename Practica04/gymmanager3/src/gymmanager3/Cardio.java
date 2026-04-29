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
    
    @Override
    public void ejecutar() {
        System.out.println("Corriendo/Pedaleando " + distancia+ "km de " + nombre);
    }
    
    
}
