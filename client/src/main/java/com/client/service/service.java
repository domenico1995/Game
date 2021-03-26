/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author user
 */
public class service {
    
    public String cancella_ultimo(String text){        
        if ((text != null) && (text.length() > 0)) {
            return text.substring(0, text.length() - 1);
        }
        return text;
    }
    
    public String terminal(String comm) throws IOException {
        Process pro = Runtime.getRuntime().exec("cmd /c cd");
        return printResults(pro);
    }

    public String printResults(Process process) throws IOException {
        String list = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = "";
        while ((line = reader.readLine()) != null) {
            if (list.equals("")) {
                list = line;
            } else {
                list = list + "\n" + line;
            }
        }
        return list;
    }
    
}
