package com.example;

import java.io.IOException;
import java.sql.*;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class login {

    @FXML
    private BorderPane parent;

    @FXML
    private Button entrarButton;

    @FXML
    private Button sairButton;

    @FXML
    private PasswordField senhaPasswordField;

    @FXML
    private TextField userTextField;
    
    @FXML
    private Button semLogin;
    
    @FXML
    private Button comLogin;

    @FXML
    private Button registarButton;

    @FXML
    private PasswordField senhaRgPasswordField;

    @FXML
    private TextField userRgTextField;

    @FXML
    private TextField raTextField;

    @FXML
    private Label errorLabel;

    @FXML
    private ToggleButton switchTheme;

    @FXML
    private ImageView themeIMG;

    Dados dados = new Dados();

    
    @FXML
    void switchColor(ActionEvent event) {
        Dados.modoEsc ++;
        if( Dados.modoEsc > 1){
            Dados.modoEsc = 0;
        }
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
    public void initialize() {
        dados = new Dados(parent) ;
        Dados.raPuro = "";
        testa = "";
        Dados.modoEsc = 1;
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
    void comLogin(ActionEvent event)throws IOException{
        App.setRoot("loginForm");
    }

    public String numberOnly;

    @FXML
    void registar(ActionEvent event) {
        Dados.user = userRgTextField.getText();
        Dados.senha = senhaRgPasswordField.getText();
        
        Dados.raPuro = raTextField.getText();
        numberOnly = Dados.raPuro. replaceAll("[-+.^:,]","");
        
        try {
            registraDB();    
        } catch (Exception error) {
            System.out.println("ConexaoLogin "+ error.getMessage());
        }
    }

    

    //Fim das Variaveis
    @FXML
    void entrar(ActionEvent event) {
        Dados.user = userTextField.getText();
        Dados.senha = senhaPasswordField.getText();
        Dados.pont = 0;
        try {
            logarDB();
        } catch (Exception error) {
            System.out.println("ConexaoLogin "+ error.getMessage());
        }
    }

    @FXML
    void sair(ActionEvent event) throws IOException{
        System.exit(0);
    }
    
    @FXML
    void semLogin(ActionEvent event) throws IOException{
        App.setRoot("registroForm");
    }

    public Connection registraDB() throws IOException{
        Connection conn = null;


        try {
            String url = dados.url;
                        
            conn = DriverManager.getConnection(url);
            System.out.println("Conexao bem sucedida");
            Statement st = conn.createStatement();

            st.executeUpdate(String.format("INSERT INTO user(username,password,ra)" + "VALUES ('%s','%s','%s')", Dados.user, Dados.senha, numberOnly));
            
            conn.close();
            App.setRoot("loginForm");
           
        } catch (SQLException error) {
            errorLabel.setText("Dados invalidos");
            System.out.println("conexao "+ error.getMessage());
        }

        return conn;
    }
    
    public static String testa = "";
    
    public Connection logarDB() throws IOException{
        Connection conn = null;
        

        try{
            String url = dados.url;
            conn = DriverManager.getConnection(url);
            System.out.println("Conexao bem sucedida");

            String queryCheck = "SELECT * from user WHERE username=? and password=?";
            
            PreparedStatement preparedStatement = conn.prepareStatement(queryCheck);
            preparedStatement.setString(1,Dados.user);

            preparedStatement.setString(2,Dados.senha);

            ResultSet resultSet = preparedStatement.executeQuery();
            
            String test = String.format("SELECT ra from user where username='%s' and password='%s'", Dados.user, Dados.senha);
            PreparedStatement preparedStatement2 = conn.prepareStatement(test);
            

            ResultSet resultSet2 = preparedStatement2.executeQuery();
            
            if(resultSet2 != null && resultSet2.next()){
                Dados.raPuro = resultSet2.getString(1);
                for (int i = 0; i < Dados.raPuro.length(); i++){
                    char t = Dados.raPuro.charAt(i);
                    if (i == 2){
                        testa = testa + ".";
                    }else if ( i == 7){
                        testa = testa + "-";
                    }
                    testa = testa + t + "";
                    
                }
            }else{
                errorLabel.setText("Dados invalidos");

            }


            if (resultSet.next()){

                App.setRoot("bemVindo");


            }/* else{
                String error = new String("Usuario e/ou \nsenha incorreto(s)");
            } */
            preparedStatement2.close();
            preparedStatement.close();
            conn.close();

        } catch (SQLException error) {
            errorLabel.setText("Dados invalidos");
            System.out.println("ConexaoLogin "+ error.getMessage());
            
        }

        return conn;
    }


}
