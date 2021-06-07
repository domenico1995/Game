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

    private String nome_eseuibile;

    private String percorso_file;
    
    private int pid;

    public Progetto(){}
    
    public Progetto(String nome_progetto, String nome_eseuibile, String percorso_file, int pid){
        this.nome_progetto = nome_progetto;
        this.nome_eseuibile = nome_eseuibile;
        this.percorso_file = percorso_file;
        this.pid = pid;
    }

    public Progetto(String nome_progetto, String nome_eseuibile, String percorso_file) {
        this.nome_progetto = nome_progetto;
        this.nome_eseuibile = nome_eseuibile;
        this.percorso_file = percorso_file;
    }

    public String getNome_progetto(){
        return nome_progetto;
    }

    public void setNome_progetto(String nome_progetto){
        this.nome_progetto = nome_progetto;
    }

    public String getNome_eseguibile(){
        return nome_eseuibile;
    }

    public void setNome_eseguibile(String nome_eseuibile){
        this.nome_eseuibile = nome_eseuibile;
    }

    public String getPercorso_file(){
        return percorso_file;
    }

    public void setPercorso_file(String percorso_file){
        this.percorso_file = percorso_file;
    }
    
    public int getPid(){
        return pid;
    }
    
    public void setPid(int pid){
        this.pid = pid;
    }
    
}
