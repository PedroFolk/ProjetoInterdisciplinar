package com.example;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class escolha {

    @FXML
    private Button dificil;

    @FXML
    private Button facil;

    @FXML
    private Button fechar;

    @FXML
    private Button iniciante;

    @FXML
    private Button logOutButton;

    @FXML
    private Button medio;

    @FXML
    private BorderPane parent;

    @FXML
    private Label raLabel;

    @FXML
    private Label usuario;

    @FXML
    private Button voltar;

    Dados dados = new Dados();


    @FXML
    void initialize(){
        dados = new Dados(parent);
        
        Dados.acertos = 0;
        Dados.pont = 0;
        Dados.nivel = 0;
        raLabel.setText(Dados.raPuro);
        usuario.setText(Dados.user);
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

    @FXML
    void irIniciante(ActionEvent event) throws IOException {
        Dados.nivel = 1;
        App.setRoot("inicio");
    }

    @FXML
    void irFacil(ActionEvent event)throws IOException {
        Dados.nivel = 2;
        App.setRoot("inicio");

    }

    @FXML
    void irMedio(ActionEvent event)throws IOException {
        Dados.nivel = 3;
        App.setRoot("inicio");

    }

    @FXML
    void irDificil(ActionEvent event)throws IOException {
        Dados.nivel = 4;
        App.setRoot("inicio");

    }



    @FXML
    void irVoltar(ActionEvent event) throws IOException{
        App.setRoot("menu");
    }

    @FXML
    void logOut(ActionEvent event) throws IOException{
        App.setRoot("loginForm");

    }

    @FXML
    void sair(ActionEvent event) {
        System.exit(0);

    }

    
    
}
