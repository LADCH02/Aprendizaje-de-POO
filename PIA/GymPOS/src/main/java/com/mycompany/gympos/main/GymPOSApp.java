/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gympos.main;
import com.mycompany.gympos.views.DashboardView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author Lic Carmen
 */
public class GymPOSApp extends Application{
  @Override
    public void start(Stage primaryStage) {
        
        DashboardView dashboard = new DashboardView();
        
       
        Scene scene = new Scene(dashboard.getView(), 700, 500);
        
        primaryStage.setTitle("GymPOS - Sistema Integral de Gimnasio");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }  
}
