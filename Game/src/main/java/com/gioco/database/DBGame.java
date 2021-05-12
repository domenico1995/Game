/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gioco.database;


import com.gioco.data.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author user
 */
public class DBGame {
    
    private static final String CREATE_GAME="CREATE TABLE IF NOT EXISTS game( nome VARCHAR(20), percorso VARCHAR(60), percorso_file VARCHAR(30))";
    
    private static Connection con;
    
    private static Properties pro;

    
    public static void connect() throws SQLException{
        pro = new Properties();
        pro.setProperty("user", "user");
        pro.setProperty("password", "1995");
        con = DriverManager.getConnection("jdbc:h2:./resources/db/game", pro);
        try (Statement stm = con.createStatement()) {
            stm.executeUpdate(CREATE_GAME);
        }
    }
    
    public static void reconnect() throws SQLException{
        if(con != null && !con.isValid(0)){
            con = DriverManager.getConnection("jdbc:h2:./resources/db/user", pro);
        }
    }
    
    public static List<String> leggi() throws SQLException{
        reconnect();
        try (PreparedStatement pre = con.prepareStatement("SELECT nome FROM game")) {
            pre.executeQuery();
            try (ResultSet re = pre.executeQuery()) {
               //da milgiorare
            }
        }
        return null;
    }   
    
    public static void scrivi() throws SQLException{
        reconnect();
        try (PreparedStatement pre = con.prepareStatement("SELECT nome FROM game")) {
            pre.executeQuery();
            try (ResultSet re = pre.executeQuery()) {
               //da milgiorare
            }
        }
    }
}