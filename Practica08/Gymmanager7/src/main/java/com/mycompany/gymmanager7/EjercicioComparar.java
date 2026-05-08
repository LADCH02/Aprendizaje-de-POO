/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gymmanager7;

import java.util.Comparator;

/**
 *
 * @author Lic Carmen
 */
public class EjercicioComparar {
    public static Comparator<Ejercicio> porCalorias = (e1, e2) -> 
        Double.compare(e2.calcularCalorias(), e1.calcularCalorias());

    public static Comparator<Ejercicio> porGrupoMuscular = (e1, e2) -> 
        e1.getGrupoMuscular().compareTo(e2.getGrupoMuscular());
}
