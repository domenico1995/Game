package com.client;

import com.client.comandi.comandi;
import java.io.IOException;

public final class Engine extends comandi {

    private String risposta = "";

    private String testo_display = "";

    public void Engine() throws IOException{
        
    }
    
    public void getWord(String text_display, String com, String per) throws IOException {

        /*if (com.equals("exit")) {
            System.exit(0);
        } else if (trova_comando(com)) {
            esegui(com);
            setRisposta(getList().toString());
            //System.out.println(risposta);
        } else {
            
        }   */
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

    
}
