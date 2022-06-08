package com.example;

import java.io.IOException;
import java.util.Timer;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;


public class BemVindo {

    Dados dados = new Dados();
    
    @FXML
    private BorderPane border;
    @FXML
    private Label bemVindoLabel;

    @FXML
    public void initialize() throws InterruptedException, IOException {
        
        Dados.raPuro = login.testa;

        bemVindoLabel.setText(String.format("Bem vindo, %s", Dados.user));
        makeTransition();
        Timer t = new java.util.Timer();
        t.schedule( 
        new java.util.TimerTask() {
            @Override
            public void run() {
                try {
                    
                    App.setRoot("menu");
                } catch (IOException error) {
                    System.out.println("conexao Resultado "+ error.getMessage());
                }
            }
        }, 
        3000 
);

    }

    public void makeTransition(){
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1500));
        fadeTransition.setNode(border);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0.5);

        FadeTransition fadeTransition2 = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1500));
        fadeTransition.setNode(border);
        fadeTransition.setFromValue(0.5);
        fadeTransition.setToValue(1);

        fadeTransition.play();
        fadeTransition2.play();
    }
}
