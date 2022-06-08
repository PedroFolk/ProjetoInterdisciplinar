package com.example;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class menu {


    

    @FXML
    private Button credtios;

    @FXML
    private Button fechar;

    @FXML
    private Button jogar;

    @FXML
    private Button prof;

    @FXML
    private Button logOutButton;

    @FXML
    private Button ranking;

    @FXML
    private BorderPane parent;

    @FXML
    private Label raLabel;

    @FXML
    private Label hehe;

    @FXML
    private Label usuario;

    Dados dados;


    @FXML
    void profRi(ActionEvent event) {
        Dados.cliquesNele ++;
        if (Dados.cliquesNele > 10){
            hehe.setVisible(true);
        }
    }
    @FXML
    void initialize() throws IOException{
        dados = new Dados(parent);
        System.out.println(Dados.raPuro);
        
        Dados.cliquesNele = 0;
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
    void irRanking(ActionEvent event) throws IOException{
        App.setRoot("ranking");
    }


    @FXML
    void irCreditos(ActionEvent event) throws IOException{
        App.setRoot("creditos");

    }

    @FXML
    void irJogar(ActionEvent event) throws IOException {
        App.setRoot("selecao");
    }

    @FXML
    void logOut(ActionEvent event) throws IOException {
        App.setRoot("loginForm");

    }

    @FXML
    void sair(ActionEvent event) {
        System.exit(0);

    }

    
    


}
