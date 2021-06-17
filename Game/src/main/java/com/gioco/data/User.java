/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gioco.data;

/**
 *
 * @author user
 */
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
