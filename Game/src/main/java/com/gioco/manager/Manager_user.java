package com.gioco.manager;

import com.gioco.connection.Connection_User;
import com.gioco.data.User;
import com.gioco.database.DBUsers;
import java.sql.SQLException;

public class Manager_user {

    public static void creazione_utenti(User utente) throws SQLException{
        
        if(DBUsers.cerca_user(utente) == false){
            if(Connection_User.trova_utenti(utente) == false){
                DBUsers.insertUsers(utente);
                Connection_User.nuovo_utente(utente);
            }else{
                DBUsers.insertUsers(utente);
            }
        }else{
            if(Connection_User.trova_utenti(utente) == false){
                Connection_User.nuovo_utente(utente);  
            }
        }
    }    
}
