/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gymmanager4;

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
    
    public void configurarMaquina(int nivelAsiento) {
        System.out.println("Ajustando el asiento de la máquina al nivel " + nivelAsiento);
    }

   
    public void configurarMaquina(int nivelAsiento, double pesoExtra) {
        System.out.println("Asiento en nivel " + nivelAsiento + " y pin de peso ajustado con " + pesoExtra + " kg extra.");
        this.pesoKg += pesoExtra;
    }

    
    public void configurarMaquina(String accesorio) {
        System.out.println("Instalando el accesorio: " + accesorio + " en la máquina #" + numero);
    }
    
    @Override
    public double calcularCalorias() {
        return (series * repeticiones) + (pesoKg * 0.5);
    }

    @Override
    public String evaluarIntensidad() {
        if (pesoKg > 80.0 || rpe >= 8) {
            return "Alta";
        } else if (pesoKg > 50.0) {
            return "Media";
        } else {
            return "Baja";
        }
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
