package com.gioco.manager;

import com.gioco.connection.Connection_User;
import com.gioco.data.User;
import com.gioco.database.DBUsers;
import java.sql.SQLException;

public class Manager_user {

    public DBUsers us = new DBUsers();

    public Connection_User cs;

    public void Manager_user() throws SQLException {

        
        System.out.println("manager user");
        us.connect();
        //cs = new Connection_User();
    }

    public void creazione_utenti(User utente) throws SQLException {
 
        
        if(cerca_utente(utente) != false){
            us.insertUsers(utente);
        }else{
         
        }
    }    
    
    public boolean cerca_utente(User utente) throws SQLException{
        return us.cerca_user(utente);
    }

    /*public void nuovo_utente_server(User utente) {
        cs.nuovo_utente(utente);
    }*/

    /*public boolean trova_utente_server(User u) {
        return cs.trova_utenti(u);
    }*/

}
