package com.gioco.manager;

import com.gioco.connection.Connection_User;
import com.gioco.data.User;
import com.gioco.database.DBUsers;
import java.sql.SQLException;

public class Manager_user {

    public DBUsers us;

    public Connection_User cs;

    public void Manager_user() throws SQLException {

        us = new DBUsers();
        us.connect();
        cs = new Connection_User();
    }

    public void creazione_utenti(User utente) throws SQLException{
 
        
        if(cerca_utente(utente) == true){
            if(cerca_utente_server(utente) != false){
                nuovo_utente(utente);
            }
            System.out.println("hello");
        }else{
         System.out.println("world");
        }
    }    
    
    public void nuovo_utente(User utente) throws SQLException{
        us.insertUsers(utente);
    }
    
    public boolean cerca_utente(User utente) throws SQLException{
        return us.cerca_user(utente);
    }

    public void nuovo_utente_server(User utente) {
        cs.nuovo_utente(utente);
    }

    public boolean cerca_utente_server(User u) {
        return cs.trova_utenti(u);
    }

}
