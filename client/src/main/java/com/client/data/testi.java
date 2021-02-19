/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.data;

/**
 *
 * @author domen
 */
public enum testi {
    
    testo_introduttivo("benvenuto su Client. Per ulteriori informazioni digitare help.\n");
    
    private final String testo;   // in kilograms

    testi(String testo) {
        this.testo = testo;
    }
    
    public String testo(){
        return testo;
    }
    
}
