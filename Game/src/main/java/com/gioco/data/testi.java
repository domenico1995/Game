package com.gioco.data;

public enum Testi {
    
    ins_nome("Inserire nome: "),
    ins_cognome("Inserire cognome: "),
    ins_username("inserire username: "),
    utente_trovato("utente trovato\n"),
    utente_trovato_server("utente trovato nel server.\n"),
    nome_cognome_non_trovati("Nome e cognome non trovati\n"),
    ritorno_utente("Bentornato a Game Adventure!!!!\n"),
    benvenuto("Benvenuto a Game Adventure.\n"),
    creazione_utente("Creazione dell'utente in corso nel server.\n"),
    utente_creato("Utente è stato creato e pronto all'uso.\n"),
    premere_tasto("Premere una lettera per continuare"),
    gioco_winner("Complimenti hai vinto il gioco!!!!\n"),
    testo_uscita("Questo gioco è offerto da DoppiaT Entertaiment!\n");
    
    private final String testo;   // in kilograms

    Testi(String testo) {
        this.testo = testo;
    }
    
    public String testo(){
        return testo;
    }
    
}
