package com.gioco.manager;

import com.gioco.connection.Connection_User;
import com.gioco.data.*;
import com.gioco.database.DBUsers;
import java.sql.SQLException;

public class Manager_user {

    private static boolean utente_trovato = true;

    public static String creazione_utenti(User utente) throws SQLException {

        String list = "";

        if (DBUsers.cerca_user(utente) == false) {
            list += Testi.nome_cognome_non_trovati.testo();
            setUtente_trovato(false);
            if (Connection_User.trova_utenti(utente) == false) {
                list += Testi.creazione_utente.testo();
                DBUsers.insertUsers(utente);
                Connection_User.nuovo_utente(utente);
                list += Testi.utente_creato.testo();
            } else {
                DBUsers.insertUsers(utente);
            }
        } else {
            list += Testi.utente_trovato.testo();
            if (Connection_User.trova_utenti(utente) == false) {
                Connection_User.nuovo_utente(utente);
            } else {
                list += Testi.utente_trovato_server.testo();
            }
        }
        return list;
    }

    public static void setUtente_trovato(boolean b) {
        utente_trovato = b;
    }

    public static boolean getUtente_trovato() {
        return utente_trovato;
    }
}
