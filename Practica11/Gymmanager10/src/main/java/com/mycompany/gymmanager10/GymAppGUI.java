/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gymmanager10;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
/**
 *
 * @author Lic Carmen
 */
public class GymAppGUI extends Application {
    private GymGestor gestor = new GymGestor(); 
    private ObservableList<Ejercicio> datosTabla; 
    private TableView<Ejercicio> tablaEjercicios = new TableView<>();

    @Override
    public void start(Stage primaryStage) {
        
        gestor.agregarEjercicio(new Cardio("Cinta de correr", "Cardio", 1, 1, 5.0));
        gestor.agregarEjercicio(new PesoLibre("Sentadilla", "Pierna", 4, 10, 60.0, 8));
        datosTabla = FXCollections.observableArrayList(gestor.getInventario());


        MenuBar barraMenu = new MenuBar();
        Menu menuArchivo = new Menu("Archivo");
        MenuItem itemSalir = new MenuItem("Salir");
        itemSalir.setOnAction(e -> primaryStage.close());
        menuArchivo.getItems().add(itemSalir);

        Menu menuAyuda = new Menu("Ayuda");
        MenuItem itemAcerca = new MenuItem("Acerca de GymManager");
        menuAyuda.getItems().add(itemAcerca);
        barraMenu.getMenus().addAll(menuArchivo, menuAyuda);


        Label titulo = new Label("Gestor de Gimnasio - Inventario");
        titulo.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        TextField txtBusqueda = new TextField();
        txtBusqueda.setPromptText("Búsqueda interactiva (ej. Pierna)...");


        TableColumn<Ejercicio, String> colNombre = new TableColumn<>("Nombre");
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        TableColumn<Ejercicio, String> colGrupo = new TableColumn<>("Grupo Muscular");
        colGrupo.setCellValueFactory(new PropertyValueFactory<>("grupoMuscular"));

        tablaEjercicios.getColumns().setAll(colNombre, colGrupo); 


        FilteredList<Ejercicio> filteredData = new FilteredList<>(datosTabla, p -> true);
        txtBusqueda.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(ejercicio -> {
                if (newValue == null || newValue.isEmpty()) return true;
                String lowerCaseFilter = newValue.toLowerCase();
                return ejercicio.getNombre().toLowerCase().contains(lowerCaseFilter) ||
                       ejercicio.getGrupoMuscular().toLowerCase().contains(lowerCaseFilter);
            });
        });
        SortedList<Ejercicio> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tablaEjercicios.comparatorProperty());
        tablaEjercicios.setItems(sortedData);


        GymButton btnAgregar = new GymButton("Agregar Nuevo");
        btnAgregar.setOnAction(e -> abrirModalAgregar(primaryStage));

        GymButton btnEliminar = new GymButton("Eliminar Seleccionado");
        btnEliminar.setStyle("-fx-background-color: #e74c3c; -fx-text-fill: white;");
        btnEliminar.setOnAction(e -> {
            Ejercicio seleccionado = tablaEjercicios.getSelectionModel().getSelectedItem();
            if (seleccionado != null) {
                datosTabla.remove(seleccionado);
                gestor.eliminarEjercicio(seleccionado.getNombre());
            } else {

                System.out.println("Selecciona un ejercicio para eliminar");
            }
        });



        javafx.scene.layout.HBox cajaBotones = new javafx.scene.layout.HBox(10);
        cajaBotones.getChildren().addAll(btnAgregar, btnEliminar);


        VBox layout = new VBox(15); 
        layout.getChildren().addAll(barraMenu, titulo, txtBusqueda, tablaEjercicios, cajaBotones);


        Scene scene = new Scene(layout, 650, 500);


        try {
            scene.getStylesheets().add(getClass().getResource("estilos.css").toExternalForm());
        } catch (Exception ex) {
            System.out.println("No se encontró estilos.css, se usará el estilo por defecto.");
        }

        primaryStage.setTitle("Gym Manager Pro - V11.0");
        primaryStage.setScene(scene);
        primaryStage.show();  
    }

    
    
    
   
    
    
}
