package com.gioco.manager;

import static com.gioco.connection.Connection_store.numero_giochi;
import com.gioco.esecuzione.Esegui;

public class Manager_gioco {
    
    private static int numero = numero_giochi().size() - 2;
    private static final Esegui[] list = new Esegui[numero];
    private static int posizione = 0;
    private static String risposta = "";

    public static void inizio() throws InterruptedException {
        for (int i = 0; i < numero; i++) {
            list[i] = new Esegui();
        }
        setRisposta("====================================================\n");
        setRisposta("livello gioco -> " + (posizione + 1) + "\n");
        creazione();
    }

    public static void testo(String testo) throws InterruptedException {

        list[posizione].esegui(testo);
        list[posizione].time_stop();

        setRisposta(list[posizione].getRisp());

        if (list[posizione].getRisp().contains("Porta") || list[posizione].getRisp().contains("Scale giu")) {
            successivo();
        }
        
        list[posizione].resetRisp();
    }

    public static void creazione() throws InterruptedException {
        if (posizione < numero) {
            int i = posizione + 1;
            list[posizione].caricamento("gioco_" + i);
            list[posizione].time_stop();
            setRisposta(list[posizione].getRisp());
            list[posizione].resetRisp();
        }
    }

    public static void successivo() throws InterruptedException {
        posizione++;
        setRisposta("====================================================\n");
        setRisposta("livello gioco -> " + (posizione) + "\n");
        if (list[posizione + 1].getFlag() == false) {
            creazione();
        }
        list[posizione].getRisp();
    }

    public static void setRisposta(String line) {
        risposta += line;
    }

    public static String getRisposta() {
        return risposta;
    }

    public static void resetRisposta() {
        risposta = "";
    }
}
