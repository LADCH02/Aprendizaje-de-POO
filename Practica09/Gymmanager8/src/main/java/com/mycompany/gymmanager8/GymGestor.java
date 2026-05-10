/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gymmanager8;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author Lic Carmen
 */
public class GymGestor {
    private List<Ejercicio> inventario = new ArrayList<>();
    private Set<String> gruposMusculares = new HashSet<>();
    private Map<String, Ejercicio> mapaBusqueda = new HashMap<>();
    private Queue<Ejercicio> colaMantenimiento = new LinkedList<>();

    
    
    public void agregarEjercicio(Ejercicio e) {
        inventario.add(e);
        gruposMusculares.add(e.getGrupoMuscular());
        mapaBusqueda.put(e.getNombre().toLowerCase(), e);
    }

    public List<Ejercicio> getInventario() {
        return this.inventario;
    }
    
    public List<Ejercicio> filtrarAvanzado(String grupo, double minCalorias) {
        return inventario.stream()
                .filter(e -> e.getGrupoMuscular().equalsIgnoreCase(grupo))
                .filter(e -> e.calcularCalorias() >= minCalorias)
                .collect(Collectors.toList());
    }

    public void mostrarTodo() {
       
        Iterator<Ejercicio> it = inventario.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().resumen());
        }
    }
    
    
    public boolean eliminarEjercicio(String nombre) {
        String clave = nombre.toLowerCase(); 
        
        if (mapaBusqueda.containsKey(clave)) {
            
            Ejercicio ejercicioABorrar = mapaBusqueda.get(clave);
            
            mapaBusqueda.remove(clave);
            inventario.remove(ejercicioABorrar);
            colaMantenimiento.remove(ejercicioABorrar);
     
            System.out.println("Ejercicio '" + nombre + "' eliminado correctamente.");
            return true;
        } else {
            System.out.println("No se encontró el ejercicio '" + nombre + "' para eliminar.");
            return false;
        }
    }
    
    
    public boolean actualizarEjercicio(String nombreViejo, Ejercicio nuevoEjercicio) {
        String clave = nombreViejo.toLowerCase();
        
        if (mapaBusqueda.containsKey(clave)) {
          
            Ejercicio viejo = mapaBusqueda.get(clave);
            inventario.remove(viejo);
            mapaBusqueda.remove(clave);
            colaMantenimiento.remove(viejo);
            
           
            agregarEjercicio(nuevoEjercicio);
            
            System.out.println("El ejercicio '" + nombreViejo + "' ha sido actualizado con éxito.");
            return true;
        } else {
            System.out.println("Error al actualizar: No existe el ejercicio '" + nombreViejo + "'.");
            return false;
        }
    }
    
}
