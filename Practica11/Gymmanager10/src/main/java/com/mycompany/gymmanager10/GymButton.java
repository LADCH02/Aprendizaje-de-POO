/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gymmanager10;
import javafx.scene.control.Button;
/**
 *
 * @author Lic Carmen
 */
public class GymButton extends Button{
    public GymButton(String texto) {
        super(texto);
        this.getStyleClass().add("gym-button");
        this.setOnMouseEntered(e -> this.setStyle("-fx-background-color: #2ecc71; -fx-text-fill: white;"));
        this.setOnMouseExited(e -> this.setStyle(""));
    }
}
