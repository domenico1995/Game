package com.gioco.manager;

import com.gioco.connection.Connection_User;
import com.gioco.database.DBUsers;
import com.gioco.data.User;
import java.sql.SQLException;

public class Manager_user {

    private DBUsers us;

    private Connection_User cs;

    public void manager_user() throws SQLException {

        us = new DBUsers();
        us.connect();
        cs = new Connection_User();

    }

    public void manager_user(User u) throws SQLException {

        if (trova_utente(u) == false) {
            if (trova_utente_server(u) == false) {
                nuovo_utente_server(u);
            }
            nuovo_utente(u);
        } else {
            if (trova_utente_server(u) == false) {
                nuovo_utente_server(u);
            }
        }
        
        us.cambia_ultimo_utente();

    }

    public void nuovo_utente(User u) throws SQLException {
        us.insertUsers(u);
    }

    public void nuovo_utente_server(User u) {
        cs.nuovo_utente(u);
    }

    public boolean trova_utente(User u) throws SQLException {
        if (us.cerca_user(u) != null) {
            return true;
        }
        return false;

    }

    public boolean trova_utente_server(User u) {
        return cs.trova_utente(u);
    }

    public User ultimo_user() throws SQLException {
        return us.ultimo_utente();
    }
}
