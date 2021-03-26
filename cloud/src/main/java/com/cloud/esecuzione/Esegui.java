/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloud.esecuzione;

import com.cloud.data.Progetto;
import java.io.IOException;

/**
 *
 * @author domen
 */
public class Esegui {
    
    public static Process pro;
    
    public static void esegui(Progetto p) throws IOException{
        exec("cmd.exe /k");
        exec("cd "+ p.getPercorso());
        exec("mvn exec:java -Dexec.mainClass=" + p.getPercorso_file()); 
    }
    
    private static void exec(String command) throws IOException {
        pro = Runtime.getRuntime().exec(command, null);
    }
    
}
