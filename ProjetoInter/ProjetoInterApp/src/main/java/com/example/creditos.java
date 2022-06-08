package com.example;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class creditos {

    @FXML
    private Button fechar;

    @FXML
    private BorderPane parent;

    @FXML
    private Button voltar;

    Dados dados = new Dados();
    
    @FXML
    void irVoltar(ActionEvent event) throws IOException {
        App.setRoot("menu");

    }

    @FXML
    void sair(ActionEvent event) {
        System.exit(0);

    }

    @FXML
    void initialize() throws IOException{
        dados = new Dados(parent);
        
        switch (Dados.modoEsc) {
            case 0:
                dados.setNight();
                break;
            case 1:
                dados.setLight();
                break;
        
            default:
                break;
        }
        
    }
    
    

}
