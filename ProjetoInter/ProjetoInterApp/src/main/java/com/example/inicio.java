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

public class inicio {

    login login = new login();

    @FXML 
    private BorderPane parent;

    @FXML
    private Button fechar;

    @FXML
    private Label dialogLabel;

    @FXML
    private Button logOutButton;

    @FXML
    private Label raLabel;

    @FXML
    private Label usuario;

    @FXML
    private Label Perg;

    @FXML
    private Button RespA;

    @FXML
    private Button RespB;

    @FXML
    private Button RespC;

    @FXML
    private Button RespD;

    @FXML
    private Button nextQuestion;

    @FXML
    private Button botaoDica;

    //Variaveis
    public int contador = 0;

    public int dicas = 4;

    public int OpCorreta,OpEscolhida;

    public int pergAtual, pergMax;

    Dados dados = new Dados();


    void nivel(){
        switch (Dados.nivel) {
            case 1:
                Dados.pontNivel = 1;
                Dados.pergAtual = 0;
                pergMax = 5;
                break;
            case 2:
                Dados.pontNivel = 2;
                Dados.pergAtual = 6;
                pergMax = 10;
                break;
            case 3:
                Dados.pontNivel = 5;
                Dados.pergAtual = 10;
                pergMax = 15;
                break;
            case 4:
                Dados.pontNivel = 10;
                Dados.pergAtual = 15;
                pergMax = 20;
                break;
        
            default:
                break;
        }
        
    }

    @FXML
    void initialize() throws IOException{
        perguntasDB();
        nivel();
        AtualizarQuestao();
        System.out.println(sizesz);
        System.out.println(Dados.raPuro);
        raLabel.setText(Dados.raPuro);
        usuario.setText(Dados.user);
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

    @FXML
    void logOut(ActionEvent event) throws IOException {
        App.setRoot("loginForm");
    }

    @FXML
    void sair(ActionEvent event){
        System.exit(0);
    }

    

    void Dicas(){
        if(dicas != OpCorreta && contador < 3){
            
            contador ++;
            OpEscolhida = 0;
            switch (dicas) {
                case 1:
                    RespA.setStyle("-fx-background-color: #ff4040");
                    RespA.setDisable(true);
                    break;
                case 2:
                    RespB.setStyle("-fx-background-color: #ff4040");
                    RespB.setDisable(true);
                    break;
                case 3:
                    RespC.setStyle("-fx-background-color: #ff4040");
                    RespC.setDisable(true);
                    break;
                case 4:
                    RespD.setStyle("-fx-background-color: #ff4040");
                    RespD.setDisable(true);
                    break;
                default:
                    break;
            }
            dicas --;
        }    
    }

    @FXML
    void Dica(ActionEvent event) {
        Dicas();
        if (dicas == OpCorreta){
            dicas --;
            Dicas();
        } 
    }
 

    @FXML
    void RespA(ActionEvent event) {
        OpEscolhida ++;
        if (OpEscolhida > 1){
            OpEscolhida = 0;
        }
        Quiz();
    }

    @FXML
    void RespB(ActionEvent event) {
        OpEscolhida += 2;
        if (OpEscolhida != 2){
            OpEscolhida = 0;
        }
        Quiz();
    }

    @FXML
    void RespC(ActionEvent event) {
        OpEscolhida += 3;
        if (OpEscolhida != 3){
            OpEscolhida = 0;
        }
        Quiz();
    }

    @FXML
    void RespD(ActionEvent event) {
        OpEscolhida += 4;
        if (OpEscolhida != 4){
            OpEscolhida = 0;
        }
        Quiz();
    }

    void Quiz(){
        switch (OpEscolhida) {
            case 0:
                RespA.setDefaultButton(false);
                RespB.setDefaultButton(false);
                RespC.setDefaultButton(false);
                RespD.setDefaultButton(false);
                RespA.setDisable(false);
                RespB.setDisable(false);
                RespC.setDisable(false);
                RespD.setDisable(false);
                nextQuestion.setDisable(true);
                break;
            case 1:
                RespA.setDefaultButton(true);
                RespB.setDisable(true);
                RespC.setDisable(true);
                RespD.setDisable(true);
                nextQuestion.setDisable(false);

                break;
            case 2:
                RespB.setDefaultButton(true);
                RespA.setDisable(true);
                RespC.setDisable(true);
                RespD.setDisable(true);
                nextQuestion.setDisable(false);

                break;
            case 3:
                RespC.setDefaultButton(true);
                RespA.setDisable(true);
                RespB.setDisable(true);
                RespD.setDisable(true);
                nextQuestion.setDisable(false);

                break;
            case 4:
                RespD.setDefaultButton(true);
                RespA.setDisable(true);
                RespB.setDisable(true);
                RespC.setDisable(true);
                nextQuestion.setDisable(false);

                break;
            default:
                break;
        }
    }

    List<String> list = new ArrayList<String>();
    List<String> listA = new ArrayList<String>();
    List<String> listB = new ArrayList<String>();
    List<String> listC = new ArrayList<String>();
    List<String> listD = new ArrayList<String>();
    List<String> listCorreto = new ArrayList<String>();
    public int sizesz;

    void AtualizarQuestao(){
        String[] pergs = list.toArray(new String[] {});
        String[] OpA = listA.toArray(new String[] {});
        String[] OpB = listB.toArray(new String[] {});
        String[] OpC = listC.toArray(new String[] {});
        String[] OpD = listD.toArray(new String[] {});
        String[] OpCorreta = listCorreto.toArray(new String[] {});
        System.out.println("tt" + sizesz);

        this.OpCorreta = Integer.parseInt(OpCorreta[Dados.pergAtual]);
        Perg.setText(pergs[Dados.pergAtual]);
        RespA.setText(OpA[Dados.pergAtual]);    
        RespB.setText(OpB[Dados.pergAtual]);    
        RespC.setText(OpC[Dados.pergAtual]);    
        RespD.setText(OpD[Dados.pergAtual]);    
        

    }
    public Connection perguntasDB() throws IOException{
        Connection conn = null;

        try{
            String url = dados.url;
            conn = DriverManager.getConnection(url);
            System.out.println("Conexao bem sucedida");

            String perguntasCheck = "select Pergunta from perguntas order by Ordem;";
            String OpA = "select OpA from perguntas order by Ordem;";
            String OpB = "select OpB from perguntas order by Ordem;";
            String OpC = "select OpC from perguntas order by Ordem;";
            String OpD = "select OpD from perguntas order by Ordem;";
            String OpCorreta = "select opCorreta from perguntas order by Ordem;";
            String quantidade = "SELECT COUNT(*) FROM perguntas;";
            
            PreparedStatement preparedStatement = conn.prepareStatement(perguntasCheck);
            PreparedStatement preparedStatementA = conn.prepareStatement(OpA);
            PreparedStatement preparedStatementB = conn.prepareStatement(OpB);
            PreparedStatement preparedStatementC = conn.prepareStatement(OpC);
            PreparedStatement preparedStatementD = conn.prepareStatement(OpD);
            PreparedStatement preparedStatementCorreto = conn.prepareStatement(OpCorreta);
            PreparedStatement Quantidade = conn.prepareStatement(quantidade);

            ResultSet resultSetA = preparedStatementA.executeQuery();
            ResultSet resultSetB = preparedStatementB.executeQuery();
            ResultSet resultSetC = preparedStatementC.executeQuery();
            ResultSet resultSetD = preparedStatementD.executeQuery();
            ResultSet resultSetCorreto = preparedStatementCorreto.executeQuery();
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSet QauntidadeSet = Quantidade.executeQuery();
            
            if(QauntidadeSet.next()){
                sizesz = QauntidadeSet.getInt(1);
            }
            

            for (int i= 0;i<sizesz; i++){
                resultSetCorreto.next();
                String val = resultSetCorreto.getString(1);
                listCorreto.add(val);
            }

            for (int i= 0;i<sizesz; i++){
                resultSetA.next();
                String val = resultSetA.getString(1);
                listA.add(val);
            }

            for (int i= 0;i<sizesz; i++){
                resultSetB.next();
                String val = resultSetB.getString(1);
                listB.add(val);
            }
            for (int i= 0;i<sizesz; i++){
                resultSetC.next();
                String val = resultSetC.getString(1);
                listC.add(val);
            }
            for (int i= 0;i<sizesz; i++){
                resultSetD.next();
                String val = resultSetD.getString(1);
                listD.add(val);
            }
           

            for (int i= 0;i<sizesz; i++){
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
    void nextQuestion(ActionEvent event) throws IOException {

        dados = new Dados(parent);

        RespA.setStyle(null);
        RespB.setStyle(null);
        RespC.setStyle(null);
        RespD.setStyle(null);

        if (OpEscolhida == OpCorreta){
            Dados.pont = Dados.pont + Dados.pontNivel;
            Dados.acertos ++;
        }

        Dados.pergAtual ++;

        AtualizarQuestao();

        OpEscolhida = 0;

        Quiz();

        if (Dados.pergAtual == pergMax){
            App.setRoot("resultado");
        }
    }
}
