/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gympos.models;
import java.io.Serializable;
/**
 *
 * @author Lic Carmen
 */
public class ClaseGrupal implements Serializable{
    private String nombreClase;
    private String instructor;
    private String horario;
    private int cupoMaximo;

    public ClaseGrupal(String nombreClase, String instructor, String horario, int cupoMaximo) {
        this.nombreClase = nombreClase;
        this.instructor = instructor;
        this.horario = horario;
        this.cupoMaximo = cupoMaximo;
    }
    
    public String getDetalles() {
        return nombreClase + " con " + instructor + " a las " + horario;
    }
}
