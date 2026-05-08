/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gymmanager7;

import java.time.LocalDateTime;

/**
 *
 * @author Lic Carmen
 */
public class GymException extends Exception{
    private LocalDateTime times;
    
    public GymException(String mensaje){
        super(mensaje);
        this.times = LocalDateTime.now();
    }
    
    public LocalDateTime gettimes(){
        return times;
    }
}
