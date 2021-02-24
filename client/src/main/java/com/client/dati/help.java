/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.dati;

/**
 *
 * @author domen
 */
public enum help {
    
    crea("permette la creazione di un progetto\n"),
    salva("salva le modifiche di progetto"),
    help("comando per informazioni dei comandi");
    
    
    private final String testo;   // in kilograms

    help(String testo) {
        this.testo = testo;
    }
    
    public String testo(){
        return testo;
    }
    
}
