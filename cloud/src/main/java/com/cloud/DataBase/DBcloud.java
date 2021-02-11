/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloud.DataBase;

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

    private final String percorso= "C:\\Program Files";
    
    public static final String CREATE_USER = "CREATE TABLE IF NOT EXISTS user(nome VARCHAR(20), cognome VARCHAR(20),"
            + " username VARCHAR(25) PRIMARY KEY)";

    public static final String SEARCH_USER = "SELECT * FROM user WHERE nome = ? and cognome = ? and username = ?";

    private Connection con;

    private Properties pro;

    public void connect() throws SQLException {
        pro = new Properties();
        pro.setProperty("user", "user");
        pro.setProperty("password", "1995");
        con = DriverManager.getConnection("jdbc:h2:./resources/db/user", pro);
        try (Statement stm = con.createStatement()) {
            stm.executeUpdate(CREATE_USER);
        }
    }

    private void reconnect() throws SQLException {
        if (con != null && !con.isValid(0)) {
            con = DriverManager.getConnection("jdbc:h2:./resources/db/user", pro);
        }
    }

}
