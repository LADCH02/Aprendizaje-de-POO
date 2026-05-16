/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gympos.views;
import com.mycompany.gympos.controllers.GestionClientesController;
import com.mycompany.gympos.models.Cliente;
import com.mycompany.gympos.utils.GeneradorReportes;
import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;



/**
 *
 * @author Lic Carmen
 */



public class DashboardView {
    private BorderPane panelPrincipal;
    private GestionClientesController clientesController;
    private TableView<Cliente> tablaClientes;

    public DashboardView() {
        clientesController = new GestionClientesController();
        panelPrincipal = new BorderPane();
        inicializarComponentes();
    }

    private void inicializarComponentes() {
      
        Label lblTitulo = new Label("GymPOS - Panel de Control Principal");
        lblTitulo.setStyle("-fx-font-size: 22px; -fx-font-weight: bold; -fx-padding: 15px;");
        panelPrincipal.setTop(lblTitulo);

       
        tablaClientes = new TableView<>();
        
        TableColumn<Cliente, String> colId = new TableColumn<>("ID Cliente");
        colId.setCellValueFactory(new PropertyValueFactory<>("idCliente"));
        
        TableColumn<Cliente, String> colNombre = new TableColumn<>("Nombre Completo");
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        
        TableColumn<Cliente, Integer> colPuntos = new TableColumn<>("Puntos Recompensa");
        colPuntos.setCellValueFactory(new PropertyValueFactory<>("puntosRecompensa"));
        
        tablaClientes.getColumns().addAll(colId, colNombre, colPuntos);
        actualizarTabla(); 
        panelPrincipal.setCenter(tablaClientes);

        
        HBox panelBotones = new HBox(15);
        panelBotones.setStyle("-fx-padding: 15px; -fx-alignment: center;");
        
        Button btnAgregar = new Button("Agregar Cliente Rápido");
        btnAgregar.setOnAction(e -> {
            
            String idAleatorio = "C-" + (int)(Math.random() * 1000);
            clientesController.agregarCliente(new Cliente(idAleatorio, "Cliente Nuevo", "555-0000"));
            actualizarTabla();
        });

        
        Button btnEliminar = new Button("Eliminar Seleccionado");
        btnEliminar.setStyle("-fx-background-color: #e74c3c; -fx-text-fill: white;");
        btnEliminar.setOnAction(e -> {
            Cliente seleccionado = tablaClientes.getSelectionModel().getSelectedItem();
            if(seleccionado != null) {
                clientesController.eliminarCliente(seleccionado.getIdCliente());
                actualizarTabla();
            }
        });

        Button btnReporte = new Button("Generar Reporte TXT (Hilo)");
        btnReporte.setStyle("-fx-background-color: #2ecc71; -fx-text-fill: white;");
        btnReporte.setOnAction(e -> {
            
            GeneradorReportes hilo = new GeneradorReportes(clientesController.getListaClientes());
            hilo.start(); 
        });

        panelBotones.getChildren().addAll(btnAgregar, btnEliminar, btnReporte);
        panelPrincipal.setBottom(panelBotones);
    }

    private void actualizarTabla() {
        tablaClientes.setItems(FXCollections.observableArrayList(clientesController.getListaClientes()));
    }

    public BorderPane getView() {
        return panelPrincipal;
    }
}
