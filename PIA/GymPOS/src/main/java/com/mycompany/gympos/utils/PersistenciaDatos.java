/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gympos.utils;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.gympos.models.Cliente;

/**
 *
 * @author Lic Carmen
 */
public class PersistenciaDatos {
  public static void guardarClientes(List<Cliente> clientes, String rutaArchivo) throws IOException {
        
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            oos.writeObject(clientes);
            System.out.println("Datos de clientes guardados exitosamente.");
        }
    }

    
    @SuppressWarnings("unchecked")
    public static List<Cliente> cargarClientes(String rutaArchivo) throws IOException, ClassNotFoundException {
        File archivo = new File(rutaArchivo);
        
        
        if (!archivo.exists()) {
            System.out.println("Archivo no encontrado. Se creará una base de datos nueva.");
            return new ArrayList<>(); 
        }
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            System.out.println("Datos cargados correctamente.");
            return (List<Cliente>) ois.readObject();
        } 
    }
}
