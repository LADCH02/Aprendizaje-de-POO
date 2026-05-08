/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gymmanager6;

/**
 *
 * @author Lic Carmen
 */
public class PesoInvalidoException extends GymException{
    private double valorErroneo;
    
    public PesoInvalidoException(String mensaje, double valor){
        super(mensaje);
        this.valorErroneo = valor;
    }
    
    public double getvalorErroneo(){
        return valorErroneo;
    }
    
}
