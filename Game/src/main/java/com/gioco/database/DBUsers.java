package com.gioco.database;

import com.gioco.data.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUsers {

    public static final String CREATE_USER = "CREATE TABLE IF NOT EXISTS user(nome VARCHAR(20), cognome VARCHAR(20),"
            + " username VARCHAR(25) PRIMARY KEY)";

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

    public void insertUsers(User u) throws SQLException {
        reconnect();
        try (PreparedStatement pre = con.prepareStatement("INSERT INTO user VALUES (?,?,?)")) {
            pre.setString(1, u.getNome());
            pre.setString(2, u.getCognome());
            pre.setString(3, u.getUsername());
            pre.executeUpdate();
            pre.close();
        }
    }

    public User cerca_user(User user) throws SQLException {
        reconnect();
        System.out.println("hello world!!!!!!!!!!!!!");
        User u = new User();
        try (PreparedStatement pre = con.prepareStatement("SELECT * FROM user WHERE nome = ? and cognome = ? and username = ?")) {
            pre.setString(1, user.getNome());
            pre.setString(2, user.getCognome());
            pre.setString(3, user.getUsername());
            try (ResultSet re = pre.executeQuery()) {
                if (re.next()) {
                    u.setNome(re.getString(1));
                    u.setNome(re.getString(2));
                    u.setNome(re.getString(3));
                }
            }
        }finally{
            u.setNome("Nome");
            u.setCognome("Cognome");
            u.setUsername("Username");
        }
        
        return u;
    }
}