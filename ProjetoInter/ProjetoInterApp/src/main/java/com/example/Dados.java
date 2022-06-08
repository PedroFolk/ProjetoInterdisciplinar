package com.example;

import javafx.scene.layout.BorderPane;

public class Dados {
    //variaveis do usuario
    static String user,senha,raPuro;

    //preferencias do usuario
    public static int modoEsc = 0;

    //temas
    public String css = this.getClass().getResource("DarkTheme.css").toExternalForm();
    public String css_light = this.getClass().getResource("LightTheme.css").toExternalForm();
    
    // Pontuacao
    public static int pont = 0;
    public static int pontNivel;
    public static int pergAtual;
    public static int acertos = 0;


    // Selecao de fase
    public static int nivel;

    // Cliques no prof
    public static int cliquesNele;

    //DB
    public String DBuser = "root";
    public String DBsenha = "pituca99";
    public String url = String.format("jdbc:mysql://localhost/projeto_inter?user=%s&password=%s", DBuser, DBsenha);

    public BorderPane border;
    Dados(){}

    Dados(BorderPane border){
        this.border = border;
        
    }
    public void setLight(){
        border.getStylesheets().remove(css);
        border.getStylesheets().add(css_light);
    }
    public void setNight(){
        border.getStylesheets().remove(css_light);
        border.getStylesheets().add(css);

    }
    

}
