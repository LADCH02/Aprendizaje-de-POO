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
    
    public void crearBackup() {
        try {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            Path origen = Paths.get(ARCHIVO_BINARIO);
            Path destino = Paths.get(DIRECTORIO_DATOS + "/backup_" + timestamp + ".dat");

            if (Files.exists(origen)) {
                Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Backup de seguridad creado: backup_" + timestamp + ".dat");
            }
        } catch (IOException e) {
            System.err.println("Error al crear backup: " + e.getMessage());
        }
    }
    
    
    public void importarDesdeCSV(String rutaCSV, GymGestor gestor) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaCSV))) {
            String linea;
            br.readLine(); 
            
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                
                if (datos[0].equalsIgnoreCase("Cardio")) {
                    gestor.agregarEjercicio(new Cardio(datos[1], datos[2], Integer.parseInt(datos[3]), Integer.parseInt(datos[4]), Double.parseDouble(datos[5])));
                }
               
            }
            System.out.println("Datos importados desde CSV.");
        } catch (Exception e) {
            System.err.println("Error leyendo CSV: " + e.getMessage());
        }
    }   
        
    public void exportarAJSON(List<Ejercicio> inventario) {
        String rutaJSON = DIRECTORIO_DATOS + "/reporte_ejercicios.json";
        try (PrintWriter pw = new PrintWriter(new FileWriter(rutaJSON))) {
            StringBuilder sb = new StringBuilder();
            sb.append("[\n");
            for (int i = 0; i < inventario.size(); i++) {
                Ejercicio e = inventario.get(i);
                sb.append("  {\n");
                sb.append("    \"nombre\": \"").append(e.getNombre()).append("\",\n");
                sb.append("    \"grupoMuscular\": \"").append(e.getGrupoMuscular()).append("\",\n");
                sb.append("    \"caloriasQuemadas\": ").append(e.calcularCalorias()).append("\n");
                sb.append("  }");
                if (i < inventario.size() - 1) sb.append(",");
                sb.append("\n");
            }
            sb.append("]\n");
            pw.write(sb.toString());
            System.out.println("Exportación a JSON completada en: " + rutaJSON);
        } catch (IOException e) {
            System.err.println("Error al exportar: " + e.getMessage());
        }
    } 
}

