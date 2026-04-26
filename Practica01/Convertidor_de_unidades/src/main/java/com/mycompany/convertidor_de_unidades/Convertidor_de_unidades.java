/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.convertidor_de_unidades;
import java.util.Scanner;

/**
 *
 * @author luis
 */
public class Convertidor_de_unidades {

    public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in);
        System.out.println("Convertidor de unidades basicas\n");
        System.out.println("-------MENU------\n");
        System.out.println("1)Metro\n2)Kilo\n3)Litro\n4)Horas\n5)Salir\nOpcion: ");
        int opcion = leer.nextInt();
        while(opcion != 5)
        {
            switch(opcion)
            {
                case 1:
                    System.out.println("Ingrese el numero de metros a convertir a cm,km");
                    break;
                case 2:
                    System.out.println("Ingrese el numero de kilos a convertir a gr,toneladas");
                    break;
                case 3:
                    System.out.println("Ingrese el numero de litros a convertir a ml");
                    break;
                case 4:
                    System.out.println("Ingrese el numero de horas a convertir segundos, minutos");
                    break;
                default: System.out.println("Opcion no  valida");
            }
        }
        
    }
}
