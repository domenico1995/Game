/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store_giochi.Service;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author domen
 */
public class Cartella extends Sistema{
    
    public static void crea_cartella(String percorso) {
        File file = new File(percorso);
        boolean mkdir = file.mkdir();
    }

    public static void inserire_file(String per, String l, String nome) throws IOException {
        Gson gson = new Gson();
        List<String> lista = new ArrayList<>();
        lista = gson.fromJson(l, ArrayList.class);
        try (FileWriter file = new FileWriter(aggiunta(per, nome))) {
            ListIterator<String> i = lista.listIterator();
            while (i.hasNext()) {
                file.write(i.next()+ "\n");
            }
        }
    }
    
    public static void leggi_file(String per, String l, String nome) throws IOException {
        Gson gson = new Gson();
        List<String> lista = new ArrayList<>();
        lista = gson.fromJson(l, ArrayList.class);
        try (FileWriter file = new FileWriter(aggiunta(per, nome))) {
            ListIterator<String> i = lista.listIterator();
            while (i.hasNext()) {
                file.write(i.next()+ "\n");
            }
        }
    }
}
