/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloud.data;

/**
 *
 * @author domen
 */
public class Progetto {
    
    private String nome_progetto;

    private String percorso;

    private String percorso_file;

    public Progetto(){}
    
    public Progetto(String nome_progetto, String percorso, String percorso_file){
        this.nome_progetto = nome_progetto;
        this.percorso = percorso;
        this.percorso_file = percorso_file;
    }

    public String getNome_progetto(){
        return nome_progetto;
    }

    public void setNome_progetto(String nome_progetto){
        this.nome_progetto = nome_progetto;
    }

    public String getPercorso(){
        return percorso;
    }

    public void setPercorso(String percorso){
        this.percorso = percorso;
    }

    public String getPercorso_file(){
        return percorso_file;
    }

    public void setPercorso_file(String percorso_file){
        this.percorso_file = percorso_file;
    }
    
}
