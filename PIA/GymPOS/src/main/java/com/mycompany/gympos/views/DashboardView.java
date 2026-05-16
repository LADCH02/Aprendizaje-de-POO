/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gympos.views;

import com.mycompany.gympos.controllers.GestionClientesController;
import com.mycompany.gympos.controllers.ProcesadorPagosController;
import com.mycompany.gympos.exceptions.PagoInvalidoException;
import com.mycompany.gympos.models.Cliente;
import com.mycompany.gympos.utils.GeneradorReportes;

import javafx.scene.Scene;
import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;



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
        
        Button btnAgregar = new Button("Agregar Cliente");
        btnAgregar.setOnAction(e -> abrirFormularioNuevoCliente());

        
        Button btnEliminar = new Button("Eliminar Seleccionado");
        btnEliminar.setStyle("-fx-background-color: #e74c3c; -fx-text-fill: white;");
        btnEliminar.setOnAction(e -> {
            Cliente seleccionado = tablaClientes.getSelectionModel().getSelectedItem();
            if(seleccionado != null) {
                clientesController.eliminarCliente(seleccionado.getIdCliente());
                actualizarTabla();
            }
        });
        
        Button btnPagar = new Button("Procesar Pago (+Puntos)");
        btnPagar.setStyle("-fx-background-color: #f39c12; -fx-text-fill: white;");
        btnPagar.setOnAction(e -> procesarPagoCliente());

        Button btnReporte = new Button("Generar Reporte TXT (Hilo)");
        btnReporte.setStyle("-fx-background-color: #2ecc71; -fx-text-fill: white;");
        btnReporte.setOnAction(e -> new GeneradorReportes(clientesController.getListaClientes()).start());

        panelBotones.getChildren().addAll(btnAgregar, btnEliminar, btnReporte, btnPagar);
        panelPrincipal.setBottom(panelBotones);
    }

    private void abrirFormularioNuevoCliente() {
        Stage modal = new Stage();
        modal.setTitle("Registrar Nuevo Cliente");
        modal.initModality(Modality.APPLICATION_MODAL);

        VBox layout = new VBox(10);
        layout.setStyle("-fx-padding: 20px;");

        TextField txtId = new TextField();
        txtId.setPromptText("Ej. C-001");
        TextField txtNombre = new TextField();
        txtNombre.setPromptText("Nombre completo...");
        TextField txtTelefono = new TextField();
        txtTelefono.setPromptText("Teléfono...");

        Button btnGuardar = new Button("Guardar Cliente");
        btnGuardar.setOnAction(e -> {
            if (!txtId.getText().isEmpty() && !txtNombre.getText().isEmpty()) {
                Cliente nuevo = new Cliente(txtId.getText(), txtNombre.getText(), txtTelefono.getText());
                clientesController.agregarCliente(nuevo);
                actualizarTabla(); 
                modal.close(); 
            }
        });

        layout.getChildren().addAll(
            new Label("ID del Cliente:"), txtId, 
            new Label("Nombre:"), txtNombre, 
            new Label("Teléfono:"), txtTelefono, 
            btnGuardar
        );
        modal.setScene(new Scene(layout, 300, 280));
        modal.showAndWait();
    }
    
    
    private void procesarPagoCliente() {
        Cliente seleccionado = tablaClientes.getSelectionModel().getSelectedItem();
        
        if (seleccionado != null) {
            ProcesadorPagosController procesador = new ProcesadorPagosController();
            try {
                
                procesador.procesarPagoMembresia(seleccionado, 500.0, 350.0);
                
                
                clientesController.guardarDatos();
                
                
                actualizarTabla();
                
                
                Alert alertaExito = new Alert(Alert.AlertType.INFORMATION);
                alertaExito.setHeaderText("¡Pago Procesado!");
                alertaExito.setContentText("Se le sumaron 10 puntos a " + seleccionado.getNombre());
                alertaExito.show();
                
            } catch (PagoInvalidoException ex) {
                Alert alertaError = new Alert(Alert.AlertType.ERROR);
                alertaError.setHeaderText("Error en el Pago");
                alertaError.setContentText(ex.getMessage());
                alertaError.show();
            }
        } else {
            Alert alertaAviso = new Alert(Alert.AlertType.WARNING);
            alertaAviso.setContentText("Por favor, selecciona a un cliente de la tabla primero.");
            alertaAviso.show();
        }
    }
    
    
    
    
    private void actualizarTabla() {
        tablaClientes.setItems(FXCollections.observableArrayList(clientesController.getListaClientes()));
        tablaClientes.refresh();
    }

    public BorderPane getView() {
        return panelPrincipal;
    }
}
