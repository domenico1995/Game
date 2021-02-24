/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store_giochi.Service;

import com.google.gson.Gson;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author domen
 */
public class Cartella {
    
    public static void crea_cartella(String percorso){
        File file = new File(percorso);
        boolean mkdir = file.mkdir();
    }
    
    public static void inserire_file(String per, String l){
        Gson gson = new Gson();
        List<String> lista = new ArrayList<>();
        lista = gson.fromJson(l, ArrayList.class);
    }
}
