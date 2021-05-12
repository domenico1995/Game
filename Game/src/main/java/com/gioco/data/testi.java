package com.gioco.data;

public enum testi {
    
    ins_nome("Inserire nome: "),
    ins_cognome("Inserire cognome: "),
    ins_username("inserire username: "),
    utente_trovato("utente trovato\n"),
    utente_trovato_server("utente trovato nel server.\n"),
    nome_cognome_non_trovati("Nome e cognome non trovati\n"),
    ritorno_utente("Bentornato a Game Adventure!!!!\n"),
    benvenuto("Benvenuto a Game Adventure.\n"),
    creazione_utente("Creazione dell'utente in corso nel server.\n"),
    creazione_utente_errore("Errore della creazione in server dell'utente\n"),
    utente_creato("Utente è stato creato e pronto all'uso.\n"),
    server_connesso("Server connesso è pronto all'uso.\n"),
    server_non_connesso("Server non connesso o in manutenzione\n" +"attendere prego\n"),
    errore_server("Errore del server\n"),
    premere_tasto("Premere una lettera per continuare"),
    modalita_online("Game in modalità online\n"),
    modalita_offline("Game in modalita offline\n"),
    gioco_winner("Complimenti hai vinto il gioco!!!!\n"),
    gioco_loser("Hai perso!! riprova sei hai il coraggio.\n"),
    testo_uscita("Questo gioco è offerto da DoppiaT Entertaiment.\n");
    
    private final String testo;   // in kilograms

    testi(String testo) {
        this.testo = testo;
    }
    
    public String testo(){
        return testo;
    }
    
}
