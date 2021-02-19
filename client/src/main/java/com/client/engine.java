package com.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public final class engine {

    private String risposta = "";

    private String testo_display = "";

    public engine() {
        init();
    }

    public void init() {

    }

    public void getWord(String text_display, String com) throws IOException {

        //setRisposta("prova");
        System.out.println();

        if (com.equals("exit")) {
            System.exit(0);
        } else {
            terminal(com);
        }

    }

    public String getRisposta() {
        return risposta;
    }

    public void setRisposta(String text) {
        this.risposta = text;
    }

    public String getTesto_display() {
        return testo_display;
    }

    public void setTesto_display(String text_display) {
        this.testo_display = text_display;
    }

    public void terminal(String comm) throws IOException {

        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("cmd", "/c", comm).directory(new File("C:\\Users\\domen\\Desktop\\test\\"));

        Process process = processBuilder.start();
        setRisposta(printResults(process));

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
            System.out.println(line);
        }

        return list;
    }

}
