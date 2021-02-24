/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.comandi;

/**
 *
 * @author domen
 */
public class comandi extends javax.swing.JDialog{

    public String com, per, risp;
    
    public void comandi(){}

    public boolean trova_comando(String comando) {
        switch (comando) {
            case "cd ..":
                return true;
            case "crea":
                return true;
            default:
                return false;
        }
    }

    public void esegui_comando(String comando) {
        switch (comando) {
            case "cd ..":
                
                break;
            case "crea":
                break;
            default:
                break;
        }
    }
}
