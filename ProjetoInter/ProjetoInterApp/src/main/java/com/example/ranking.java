package com.example;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class ranking {

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
    private Label usuario;

    @FXML
    private Label value1;

    @FXML
    private Label value2;

    @FXML
    private Label value3;

    @FXML
    private Label value4;

    @FXML
    private Label value5;

    @FXML
    private Button voltar;

    List<String> list = new ArrayList<String>();

    @FXML
    void initialize() throws IOException{

        dados = new Dados(parent);
        rankingDB();
        String[] vals = list.toArray(new String[] {});

        if(vals.length > 0){
            value1.setText(vals[0]);
        }
        else{
            value1.setText("Não há dados");
        }
        if(vals.length > 1){
            value2.setText(vals[1]);
        }
        else{
            value2.setText("Não há dados");
        }
        if(vals.length > 2){
            value3.setText(vals[2]);
        }
        else{
            value3.setText("Não há dados");
        }
        if(vals.length > 3){
            value4.setText(vals[3]);
        }
        else{
            value4.setText("Não há dados");
        }
        if(vals.length > 4){
            value5.setText(vals[4]);
        }
        else{
            value5.setText("Não há dados");
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



    public Connection rankingDB() throws IOException{
        Connection conn = null;
        
        try{
            String url = dados.url;
            conn = DriverManager.getConnection(url);
            System.out.println("Conexao bem sucedida");

            String queryCheck = "select username from ranking order by pontos desc;";

            
            PreparedStatement preparedStatement = conn.prepareStatement(queryCheck);


            ResultSet resultSet = preparedStatement.executeQuery();
            
            for (int i= 0;i<6; i++){
                resultSet.next();
                String val = resultSet.getString(1);
                list.add(val);

            }

            preparedStatement.close();
            conn.close();

        } catch (SQLException error) {
            System.out.println("conexao Ranking "+ error.getMessage());
        }
        return conn;
    }


    @FXML
    void irvoltar(ActionEvent event) throws IOException{
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
