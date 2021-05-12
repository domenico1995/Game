/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store_giochi.service;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Cartella extends Sistema {

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
                file.write(i.next() + "\n");
            }
        }
    }

    public static List<String> leggi_file(String per) throws IOException {
        List<String> list = new ArrayList<>();
        try (BufferedReader input = new BufferedReader(new FileReader(per));) {
            String l = null;
            while ((l = input.readLine()) != null) {
                list.add(l);
            }
        }
        return list;
    }

    public static void leggi_lista_file(String per, List<String> list) {
        File dir = new File(per);
        File[] listFiles = dir.listFiles();
        for (File file : listFiles) {
            if(file.isDirectory() == true){
               leggi_lista_file(per + getCarattere()+ file.getName(), list);
               list.add(per + getCarattere()+ file.getName());
            }else{
            list.add(per + getCarattere()+ file.getName());
            }
        }
    }
    
    public static void lista_file(String per, List<String> list) {
        File dir = new File(per);
        File[] listFiles = dir.listFiles();
        for (File file : listFiles) {
            list.add(per + getCarattere()+ file.getName());
        }
    }
}
