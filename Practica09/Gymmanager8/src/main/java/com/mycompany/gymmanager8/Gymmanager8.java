/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gymmanager8;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Lic Carmen
 */
public class Gymmanager8 {

    public static void main(String[] args) {
        GymGestor gestor = new GymGestor();
        GestorArchivos archivos = new GestorArchivos();
        
       
        List<Ejercicio> guardados = archivos.cargarBinario();
        for (Ejercicio e : guardados) {
            gestor.agregarEjercicio(e);
        }

        Scanner sn = new Scanner(System.in);
        boolean salir = false;

        while(!salir) {
            System.out.println("\n===== GESTOR DE GIMNASIO (I/O) =====");
            System.out.println("1. Mostrar inventario");
            System.out.println("2. Importar datos desde CSV de prueba");
            System.out.println("3. Exportar reporte en formato JSON");
            System.out.println("4. Crear Backup de seguridad manual");
            System.out.println("5. Salir y Guardar");
            System.out.print("Elige una opción: ");
            
            int opcion = sn.nextInt();
            sn.nextLine(); 

            switch(opcion) {
                case 1:
                    gestor.mostrarTodo();
                    break;
                case 2:
                    System.out.print("Ruta del archivo CSV (ej. datos.csv): ");
                    String ruta = sn.nextLine();
                    archivos.importarDesdeCSV(ruta, gestor);
                    break;
                case 3:
                    archivos.exportarAJSON(gestor.getInventario());
                    break;
                case 4:
                    archivos.crearBackup();
                    break;
                case 5:
                    
                    archivos.guardarBinario(gestor.getInventario());
                    archivos.crearBackup();
                    salir = true;
                    System.out.println("¡Datos guardados. Hasta pronto!");
                    break;
            }
        }
    }
}
