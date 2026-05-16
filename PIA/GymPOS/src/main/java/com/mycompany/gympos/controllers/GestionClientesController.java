/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gympos.controllers;
import com.mycompany.gympos.models.Cliente;
import com.mycompany.gympos.utils.PersistenciaDatos;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Lic Carmen
 */
public class GestionClientesController {
    private List<Cliente> listaClientes;
    private final String RUTA_ARCHIVO = "clientes.dat";

    public GestionClientesController() {
        try {
            
            listaClientes = PersistenciaDatos.cargarClientes(RUTA_ARCHIVO);
        } catch (Exception e) {
            listaClientes = new ArrayList<>();
        }
    }

    public void agregarCliente(Cliente cliente) {
        listaClientes.add(cliente);
        guardarCambios();
    }

    public Cliente buscarCliente(String idCliente) {
        for (Cliente c : listaClientes) {
            if (c.getIdCliente().equals(idCliente)) {
                return c;
            }
        }
        return null; 
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

   
    private void guardarCambios() {
        try {
            PersistenciaDatos.guardarClientes(listaClientes, RUTA_ARCHIVO);
        } catch (IOException e) {
            System.err.println("Error al guardar: " + e.getMessage());
        }
    }
}
