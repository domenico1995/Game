/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gioco.file;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author domenico
 */
public class Cache {
    
    private String text1;
    
    private String text2;
    
    public void Cache(){
        
    }
    
    //inserire testo nel file cache
    public void setString(String testo1, String testo2){
        try {
            DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("resources/file/cache")));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Cache.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //restituire e cancellare contenuto file cache
    public String getText1(){
        return text1;
    }

    public String getText2(){
        return text1;
    }
    
}
