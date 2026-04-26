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
        int opcion;
        float numero1, numero2;
        Scanner leer = new Scanner(System.in);
        System.out.println("Convertidor de unidades basicas\n");
        System.out.println("-------MENU------\n");
        System.out.println("1)Metro\n2)Kilo\n3)Litro\n4)Horas\n5)Salir\nOpcion: ");
        opcion = leer.nextInt();
        
        
        while(opcion != 5)
        {
            switch(opcion)
            {
                case 1:
                    System.out.println("Ingrese el numero de metros a convertir a cm,km");
                    float metros = leer.nextFloat();
                    numero1 = metros * 100;
                    numero2 = metros / 1000;
                    System.out.println("El numero de metros es " + metros + " El numero de Km es " + numero2 + " El numero de cm es " + numero1);
                    break;
                case 2:
                    System.out.println("Ingrese el numero de kilos a convertir a gr,toneladas");
                    float kilos = leer.nextFloat();
                    numero1 = kilos * 1000;
                    numero2 = kilos / 1000;
                    System.out.println("El numero de kilos es " + kilos + " El numero de gr es " + numero1 + " El numero de toneladas es " + numero2);
                    break;
                case 3:
                    System.out.println("Ingrese el numero de litros a convertir a ml");
                    float litros = leer.nextFloat();
                    numero1 = litros * 1000;
                    System.out.println("El numero de litros es " + litros + " El numero de ml es " + numero1);
                    break;
                case 4:
                    System.out.println("Ingrese el numero de horas a convertir segundos, minutos");
                    float horas = leer.nextFloat();
                    numero1 = horas * 60;
                    numero2 = horas * 3600;
                    System.out.println("El numero de horas es" + horas + " El numero de minutos es " + numero1 + " El numero de segundos es" + numero2);
                    break;
                default: System.out.println("Opcion no  valida");
            }
            
            System.out.println("-------MENU------\n");
            System.out.println("1)Metro\n2)Kilo\n3)Litro\n4)Horas\n5)Salir\nOpcion: ");
            opcion = leer.nextInt();
            
        }
        leer.close();
        
    }
}
