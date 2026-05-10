/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gymmanager8;

import java.io.File;

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
}
