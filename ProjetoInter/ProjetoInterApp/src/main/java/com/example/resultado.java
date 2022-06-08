package com.example;

import java.io.IOException;
import java.sql.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class resultado {

    Dados dados = new Dados();

    @FXML
    private Button fechar;

    @FXML
    private Button logOutButton;

    @FXML
    private BorderPane parent;

    @FXML
    private Label raLabel;

    @FXML
    private Label resultado;

    @FXML
    private Label usuario;

    @FXML
    private Button voltar;

    @FXML 
    private Button prox;

    @FXML
    void irProx(ActionEvent event) throws IOException{
        Dados.nivel ++;
        App.setRoot("Inicio");
    }

    
    @FXML
    void irVoltar(ActionEvent event) throws IOException {
        App.setRoot("menu");
    }

    @FXML
    void initialize(){
        if (Dados.pergAtual == 20) {
            prox.setVisible(false);
        }

        dados = new Dados(parent);
        System.out.println(Dados.pontNivel);
        resultado.setText(String.format("Voce acertou: %s", Dados.acertos));
        try {
            rankingDB();
        } catch (IOException error) {
            System.out.println("conexao Resultado "+ error.getMessage());
        }

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

    public int test;

    public Connection rankingDB() throws IOException{
        Connection conn = null;


        try {
            String url = dados.url;
            
            conn = DriverManager.getConnection(url);
            System.out.println("Conexao bem sucedida");
            Statement st = conn.createStatement();
            String queryCheck = String.format("select pontos from ranking where username = '%s';",Dados.user);

            PreparedStatement ps = conn.prepareStatement(queryCheck);
            ResultSet rs =  ps.executeQuery();
            if (rs.next()){
                test = rs.getInt(1);
            }

            if (test < Dados.acertos){
                st.executeUpdate(String.format("DELETE FROM RANKING WHERE USERNAME = '%s'", Dados.user));
                st.executeUpdate(String.format("INSERT INTO ranking(username, pontos) VALUES ('%s','%s') ON DUPLICATE KEY UPDATE pontos = %s;", Dados.user, Dados.pont, Dados.pont));
            }
            
           
        } catch (SQLException error) {
            
            System.out.println("conexao Resultado "+ error.getMessage());
        }

        return conn;
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
