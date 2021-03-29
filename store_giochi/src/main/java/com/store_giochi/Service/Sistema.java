/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store_giochi.Service;

/**
 *
 * @author domen
 */
public class Sistema {
    
    private static String percorso;
    
    public static String OS = System.getProperty("os.name").toLowerCase();
    
    public Sistema(){
        if (isWindows()){
            percorso ="C:\\Users\\domen\\Documents\\progetti";
        }
        if (isUnix()){
            percorso ="/home/domenico/Documenti/";
        }
    }    
    
    public static String getPercorso(){
        return percorso;
    }
    
    public static boolean isWindows() {
        return (OS.contains("win"));
    }

    public static boolean isUnix() {
        return (OS.contains("nix") || OS.contains("nux") || OS.indexOf("aix") > 0);
    }
    
    public static String aggiunta(String s1, String s2){
        if (isWindows()){
            return s1+ "\\" +s2;
        }
        if (isUnix()){
           return s1+ "/" +s2;
        }
        return null;
    }
    
}
