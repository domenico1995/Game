package com.gioco.manager;

import com.gioco.connection.Connection_User;
import com.gioco.database.DBUsers;
import com.gioco.data.User;
import java.sql.SQLException;

public class Manager_user {

    private DBUsers us;

    private Connection_User cs;

    public void Manager_user() throws SQLException {

        us = new DBUsers();
        System.out.println("manager user");
        us.connect();
        cs = new Connection_User();
    }

    public void utente(User u) throws SQLException {

        System.out.println("hello world1");
        
        if (trova_utente(u) == false) {
            if (trova_utente_server(u) == false) {
                nuovo_utente_server(u);
            }
            System.out.println("hello world!!!");
            nuovo_utente(u);
        }/* else {
            System.out.println("hello world!!!!!!!!");
            if (trova_utente_server(u) == false) {
                nuovo_utente_server(u);
            }
        }
        System.out.println("hello wo");
        us.cambia_ultimo_utente();*/
    }

    public void nuovo_utente(User u) throws SQLException {
        System.out.println("hello world2");
        us.insertUsers(u);
    }

    public void nuovo_utente_server(User u) {
        System.out.println("hello world3");
        cs.nuovo_utente(u);
    }

    public boolean trova_utente(User u) throws SQLException {
        System.out.println("hello world!");
        
        boolean flag;
        
        if(us.cerca_user(u) != null){
            flag = true;
        }else
            flag = false;
        
        return flag;
    }

    public boolean trova_utente_server(User u) {
        System.out.println("hello world5");
        return cs.trova_utenti(u);
    }

}
