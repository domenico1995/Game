package com.server_utenti.data;

public class User {


    private String nome;

    private String cognome;

    private String username;

    public User(){}


    public User(String nome, String cognome, String username){
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCognome(){
        return cognome;
    }

    public void setCognome(String cognome){
        this.cognome = cognome;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

}
