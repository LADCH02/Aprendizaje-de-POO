/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gymmanager9;

/**
 *
 * @author Lic Carmen
 */
public class LimpiezaTask implements Runnable{
    private String maquina;

    public LimpiezaTask(String maquina) {
        this.maquina = maquina;
    }

    @Override
    public void run() {
        System.out.println("[LIMPIEZA] Desinfectando " + maquina + " - Realizado por " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("[LIMPIEZA FIN] " + maquina + " lista para usarse.");
    }
}
