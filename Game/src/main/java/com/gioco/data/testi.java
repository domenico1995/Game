/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data;

/**
 *
 * @author user
 */
public enum testi {
    
    ins_nome("inserire nome utente: "),
    ins_cognome("inserire cognome: "),
    ins_username("inserire username: "),
    nome_cognome_trovati("nome e cognome trovati\n"),
    nome_cognome_non_trovati("nome e cognome non trovati\n"),
    ritorno_utente("bentornato a Game Adventure!!!!\n"),
    benvenuto("benvenuto a Game Adventure"),
    creazione_utente("creazione dell'utente in corso ...\n"),
    creazione_utente_errore("errore della creazione in server dell'utente\n"),
    utente_creato("utente è stato creato e pronto all'uso.\n"),
    server_connesso("server connesso è pronto all'uso.\n"),
    server_non_connesso("server non connesso o in manutenzione\n" +"attendere prego\n"),
    errore_server("errore del server\n"),
    modalita_online("Game in modalità online\n"),
    modalita_offline("Game in modalita offline\n"),
    gioco_winner("complimenti hai vinto il gioco!!!!\n"),
    gioco_loser("hai perso!! riprova sei hai il coraggio.\n"),
    testo_uscita("Questo gioco è offerto da DoppiaT entertaiment.\n");

    
    private final String testo;   // in kilograms

    testi(String testo) {
        this.testo = testo;
    }
    
    public String testo(){
        return testo;
    }
    
}
