/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gymmanager9;

/**
 *
 * @author Lic Carmen
 */
public class PesoLibre extends EjercicioFuerza implements Equipable {
    public PesoLibre(String nombre, String grupo, int s, int r, double p, int rpe){
        super(nombre,grupo,s,r,p,rpe);
    }
    
    public void recomendacion(){
        System.out.println("Se recomienda que en ejercicios libres se antepone el peso maximo con buena ejecucion y un numero de repetciones entre 1-6 de 4 series");
    }
    
    public void prepararLevantamiento(boolean requiereSpotter) {
        if (requiereSpotter) {
            System.out.println("Solicitando a un compañero para cuidar el levantamiento de " + nombre);
        } else {
            System.out.println("Levantamiento de " + nombre + " en solitario, asegurando ganchos.");
        }
    }

    
    public void prepararLevantamiento(String tipoAgarre) {
        System.out.println("Preparando el ejercicio " + nombre + " con un agarre tipo: " + tipoAgarre);
    }

   
    public void prepararLevantamiento(boolean usarCinturon, int discosPorLado) {
        String cinturon = usarCinturon ? "con cinturón lumbar" : "sin cinturón";
        System.out.println("Preparando levantamiento " + cinturon + " y colocando " + discosPorLado + " discos por lado.");
    }
    
    @Override
    public void prepararEquipo(){
        System.out.println("Coloque los discos en la barra, asegurando barra con seguros para el ejercicio: " + nombre);
    }
    
    @Override
    public void limpiarEquipo(){
        System.out.println("Retire los discos de la barra y los seguros en el ejercicio " + nombre + " y acomodelos en su respectivo lugar");
    }
    @Override
    public double calcularCalorias() {
        return (series * repeticiones) + (pesoKg * 0.5);
    }

    @Override
    public String evaluarIntensidad() {
        if (pesoKg > 50.0 || rpe >= 8) {
            return "Alta";
        } else if (pesoKg > 20.0) {
            return "Media";
        } else {
            return "Baja";
        }
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
