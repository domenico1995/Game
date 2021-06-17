/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gioco.service;

/**
 *
 * @author user
 */
public class Service {

    public String cancella_ultimo(String text) {

        if ((text != null) && (text.length() > 0)) {
            return text.substring(0, text.length() - 1);
        }

        return text;
    }

}
