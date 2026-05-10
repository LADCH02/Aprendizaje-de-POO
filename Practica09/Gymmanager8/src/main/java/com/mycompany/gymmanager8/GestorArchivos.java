/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gymmanager8;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
    
}
