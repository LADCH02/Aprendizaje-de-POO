/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gymmanager8;



import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lic Carmen
 */
public class GestorArchivos {
    private static final String DIRECTORIO_DATOS = "datos_gimnasio";
    private static final String ARCHIVO_BINARIO = DIRECTORIO_DATOS + "/inventario.dat";
    
    public GestorArchivos() {
        
        File directorio = new File(DIRECTORIO_DATOS);
        if (!directorio.exists()) {
            directorio.mkdirs();
        }
    }
    
    
    public void guardarBinario(List<Ejercicio> inventario) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_BINARIO))) {
            oos.writeObject(inventario);
            System.out.println("Datos guardados correctamente en binario.");
        } catch (IOException e) {
            System.err.println("Error al guardar: " + e.getMessage());
        }
    }
    
    
    @SuppressWarnings("unchecked")
    public List<Ejercicio> cargarBinario() {
        File archivo = new File(ARCHIVO_BINARIO);
        if (!archivo.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            System.out.println("Datos previos cargados correctamente.");
            return (List<Ejercicio>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar datos: " + e.getMessage());
            return new ArrayList<>();
        }
    }
    
    
    
    
}
