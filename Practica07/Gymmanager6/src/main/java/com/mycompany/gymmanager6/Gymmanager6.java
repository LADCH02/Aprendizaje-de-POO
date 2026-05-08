/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gymmanager6;

/**
 *
 * @author Lic Carmen
 */
public class Gymmanager6 {

    public static void main(String[] args) {
        Rutina miRutina = new Rutina("Entrenamiento de Potencia");

        double[] pesosDePrueba = {100.0, -50.0, 600.0};

        for (double p : pesosDePrueba) {
            try {
                System.out.println("\nIntentando registrar peso: " + p);
                miRutina.registrarEntrenamiento(p);
                System.out.println("¡Registro exitoso!");
                
            } catch (PesoInvalidoException e) {
                System.err.println("--- DIAGNÓSTICO TÉCNICO ---");
                System.err.println("CÓDIGO: " + e.getCodigoInterno());
                System.err.println("MENSAJE: " + e.getMessage());
                System.err.println("VALOR RECHAZADO: " + e.getvalorErroneo() + "kg");
                System.err.println("TIMESTAMP: " + e.getHoraDelError());
                System.err.println("---------------------------");
                
                
            } catch (CapacidadExcedidaException e) {
                System.err.println("[ALERTA DE SEGURIDAD] " + e.getMessage());
                
            } catch (GymException e) {
                System.err.println("[ERROR GENERAL] " + e.getMessage());
            } finally {
                System.out.println("Finalizando intento de registro.");
            }
        }
    }
}
