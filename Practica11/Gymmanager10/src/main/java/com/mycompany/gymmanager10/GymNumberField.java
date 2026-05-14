/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gymmanager10;
import javafx.scene.control.TextField;
/**
 *
 * @author Lic Carmen
 */
public class GymNumberField extends TextField{
    public GymNumberField() {
        super();
        this.setPromptText("Solo números (ej. 50.5)");
        
       
        this.textProperty().addListener((observable, valorViejo, valorNuevo) -> {
            if (!valorNuevo.matches("\\d*(\\.\\d*)?")) {
                this.setText(valorViejo); 
            }
        });

       
        this.focusedProperty().addListener((obs, viejo, nuevo) -> {
            if (nuevo) this.setStyle("-fx-border-color: #3498db; -fx-border-width: 2px;");
            else this.setStyle("");
        });
    }
}
