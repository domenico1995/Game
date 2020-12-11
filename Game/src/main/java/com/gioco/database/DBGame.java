/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gioco.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author user
 */
public class DBGame {
    
    public static final String CREATE_GAME="CREATE TABLE IF NOT EXISTS game( testo1 VARCHAR(200), risposta VARCHAR(40), testo3 VARCHAR(200))";
    
    private Connection con;
    
    private Properties pro;

    
    public void connect() throws SQLException{
        pro = new Properties();
        pro.setProperty("user", "user");
        pro.setProperty("password", "1995");
        con = DriverManager.getConnection("jdbc:h2:./resources/db/game", pro);
        Statement stm = con.createStatement();
        stm.executeUpdate(CREATE_GAME);
        stm.close();
    }
    
    private void reconnect() throws SQLException{
        if(con != null && !con.isValid(0)){
            con = DriverManager.getConnection("jdbc:h2:./resources/db/user", pro);
        }
    }
    
    private String leggi(String id, String op) throws SQLException{
        reconnect();
        PreparedStatement pre = con.prepareStatement("SELECT testo3 FROM game WHERE testo1 = ? AND risposta = ?");
        pre.setString(1, id);
        pre.setString(2, op);
        pre.executeQuery();
        pre.close();
        return null;
    }   
}