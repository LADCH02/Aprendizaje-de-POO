/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gymmanager10;

import java.time.LocalDateTime;

/**
 *
 * @author Lic Carmen
 */
public class PesoInvalidoException extends GymException{
    private double valorErroneo;
    private final LocalDateTime horaDelError; 
    private final String codigoInterno; //
    
    public PesoInvalidoException(String mensaje, double valor){
        super(mensaje);
        this.valorErroneo = valor;
        this.horaDelError = LocalDateTime.now();
        this.codigoInterno = "GYM-ERR-101";
    }
    
    public double getvalorErroneo(){
        return valorErroneo;
    }
    
    public LocalDateTime getHoraDelError() { return horaDelError; }
    public String getCodigoInterno() { return codigoInterno; }
    
}
