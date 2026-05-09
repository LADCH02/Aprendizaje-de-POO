/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gymmanager7;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Lic Carmen
 */
public class Gymmanager7 {

    public static void main(String[] args) {
        GymGestor gestor = new GymGestor();
        
        
        for(int i=1; i<=5; i++) {
            gestor.agregarEjercicio(new Cardio("Carrera " + i, "Cardio", 1, 1, 5.0 + i));
            gestor.agregarEjercicio(new PesoLibre("Sentadilla " + i, "Pierna", 4, 10, 50.0 + i, 8));
            gestor.agregarEjercicio(new Maquina("Prensa " + i, "Pierna", 3, 12, 100.0, 7, i));
        }

        
        Scanner sn = new Scanner(System.in);
        boolean salir = false;

        while(!salir) {
            System.out.println("\n===== GESTOR DE GIMNASIO AVANZADO =====");
            System.out.println("1. Mostrar inventario completo (Read)");
            System.out.println("2. Búsqueda avanzada con Streams (Filter)");
            System.out.println("3. Eliminar un ejercicio (Delete)");
            System.out.println("4. Actualizar un ejercicio (Update)");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            
            int opcion = sn.nextInt();
            sn.nextLine(); 
           
            switch(opcion) {
                case 1:
                    System.out.println("\n--- INVENTARIO ---");
                    gestor.mostrarTodo();
                    break;
                    
                case 2:
                    System.out.print("\nGrupo muscular a buscar (ej. Pierna, Cardio): ");
                    String grupo = sn.nextLine();
                    System.out.print("Mínimo de calorías a quemar: ");
                    double minCalorias = sn.nextDouble();
                    
                    List<Ejercicio> filtrados = gestor.filtrarAvanzado(grupo, minCalorias);
                    System.out.println("\nResultados encontrados: " + filtrados.size());
                    
                    filtrados.forEach(e -> System.out.println("- " + e.getNombre() + " | Calorías: " + e.calcularCalorias()));
                    break;
                    
                case 3:
                    System.out.print("\nEscribe el nombre EXACTO del ejercicio a eliminar (ej. Carrera 2): ");
                    String nombreBorrar = sn.nextLine();
                    gestor.eliminarEjercicio(nombreBorrar);
                    break;
                    
                case 4:
                    System.out.print("\nEscribe el nombre EXACTO del ejercicio a actualizar: ");
                    String nombreViejo = sn.nextLine();
                    
                   
                    System.out.println("Generando actualización...");
                    Ejercicio ejercicioNuevo = new Cardio(nombreViejo + " V2", "Cardio", 2, 5, 8.0);
                    
                    gestor.actualizarEjercicio(nombreViejo, ejercicioNuevo);
                    break;
                    
                case 5:
                    salir = true;
                    System.out.println("¡Gracias por usar GymManager!");
                    break;
                    
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
        sn.close();
    }
}
