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

    private static Connection con;
    private static Properties pro;
    private static User u;

    public static final String CREATE_TABLE_USERS = "CREATE TABLE IF NOT EXISTS users( comando VARCHAR(15))";

    private DBGame(User utente) {
        u = new User();
        u = utente;
    }


    public static void connect(User u) throws SQLException {
        pro = new Properties();
        String s = u.getNome() + "_" + u.getCognome() + "_" + u.getUsername();
        pro.setProperty("user", s);
        pro.setProperty("password", "1995");
        con = DriverManager.getConnection("jdbc:h2:./resources/db/" + s, pro);
        try (Statement stm = con.createStatement()) {
            stm.executeUpdate(CREATE_TABLE_USERS);
        }
    }

    public static void reconnect(User u) throws SQLException {
        if (con != null && !con.isValid(0)) {
            String s = u.getNome() + "_" + u.getCognome() + "_" + u.getUsername();
            con = DriverManager.getConnection("jdbc:h2:./resources/db/" + s, pro);
        }
    }
    /*
    public static void inserire(User u, String comando) throws SQLException {
        connect(u);
        reconnect(u);
        String s = u.getNome() + "_" + u.getCognome() + "_" + u.getUsername();
        try (PreparedStatement ps = con.prepareStatement("INSERT INTO " + s + " VALUES (?,?,?)")) {
            ps.setString(1, comando);
            ps.executeUpdate();
            ps.close();
        }
    }

    public static void leggi(User u) throws SQLException {
        connect(u);
        reconnect(u);
    }

    public static void cancella(User u) throws SQLException {
        connect(u);
        reconnect(u);
        String s = u.getNome() + "_" + u.getCognome() + "_" + u.getUsername();
        try (PreparedStatement ps = con.prepareStatement("DROP TABLE " + s)) {
            ps.execute();
            ps.close();
        }
    }*/
}
