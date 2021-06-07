/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloud.DataBase;

import com.cloud.data.Progetto;
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
 * @author domenico
 */
public class DBcloud {

    private final String percorso = "C:\\Program Files";

    public static final String CREATE_USER = "CREATE TABLE IF NOT EXISTS cloud(nome_progetto VARCHAR(20) PRIMARY KEY, percorso VARCHAR(20),"
            + " percorso_file VARCHAR(25))";

    public static final String SEARCH_USER = "";

    private static Connection con;

    private static Properties pro;

    public static void connect() throws SQLException {
        pro = new Properties();
        pro.setProperty("user", "user");
        pro.setProperty("password", "1995");
        con = DriverManager.getConnection("jdbc:h2:./resources/db/cloud", pro);
        try (Statement stm = con.createStatement()) {
            stm.executeUpdate(CREATE_USER);
        }
    }

    private static void reconnect() throws SQLException {
        if (con != null && !con.isValid(0)) {
            con = DriverManager.getConnection("jdbc:h2:./resources/db/cloud", pro);
        }
    }

    public static List leggi_contenuto() throws SQLException {
        connect();
        reconnect();
        List<Progetto> list = new ArrayList<>();
        Statement sta = con.createStatement();
        ResultSet re = sta.executeQuery("SELECT * FROM cloud");
        while (re.next()) {
            Progetto p = new Progetto(re.getString(1), re.getString(2), re.getString(3));
            list.add(p);
        }

        return list;
    }

    public static boolean vuoto() throws SQLException{
        return leggi_contenuto() == null;
    }
    
}
