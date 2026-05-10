/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gymmanager8;

/*
import com.mycompany.gymmanager6.Cronometrable;
import com.mycompany.gymmanager6.Ejercicio;
*/

/**
 *
 * @author Lic Carmen
 */
public class Cardio extends Ejercicio implements Cronometrable{
    private double distancia;
    
    public Cardio(String nombre, String grupo_muscular, int series, int repeticiones, double distancia){
        super(nombre,grupo_muscular,series,repeticiones);
        this.distancia = distancia;
    }
    
    
    public void recomendacion(){
        System.out.println("Se recomienda que la persona antes de empezar realice un calentamiento dinamico y al final se estire");
    }
    
    public void ajustarRutina(double distanciaExtra) {
        this.distancia += distanciaExtra;
    }
    
    
    public void ajustarRutina(double distanciaExtra, int seriesExtra) {
        this.distancia += distanciaExtra;
        this.series += seriesExtra;
    }
    
    public void ajustarRutina(String nuevaRecomendacion) {
        System.out.println("Nota extra para cardio: " + nuevaRecomendacion);
    }
    
    @Override
    public void iniciarCronometro(){
        System.out.println("Inicia el cronometro para la sesion de: " + nombre);
    }
    
    @Override
    public void detenerCronometro(){
        System.out.println("Deteniendo el cronometro, muchas felicidades fue una maravillosa sesion de " + nombre);
    }
    
    @Override
    public double calcularCalorias() {
        return distancia * 60.0; 
    }

    @Override
    public String evaluarIntensidad() {
        if (distancia > 5.0) {
            return "Alta";
        } else {
            return "Moderada";
        }
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
