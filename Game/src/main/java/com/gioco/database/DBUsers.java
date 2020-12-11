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

    public static final String CREATE_USER = "CREATE TABLE IF NOT EXISTS user(nome VARCHAR(15), cognome VARCHAR(20),"
            + " username VARCHAR(25) PRIMARY KEY, account BOOLEAN DEFAULT false)";

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
        cambia_ultimo_utente();
        try (PreparedStatement pre = con.prepareStatement("INSERT INTO user VALUES (?,?,?,?)")) {
            pre.setString(1, u.getNome());
            pre.setString(2, u.getCognome());
            pre.setString(3, u.getUsername());
            pre.setBoolean(4, true);
            pre.executeUpdate();
            pre.close();
            modifica_user(u);
        }

    }

    public User cerca_user(User user) throws SQLException {
        reconnect();
        User u = null;
        try (PreparedStatement pre = con.prepareStatement("SELECT * FROM user WHERE nome = ? and cognome = ? and username = ?")) {
            pre.setString(1, user.getNome());
            pre.setString(2, user.getCognome());
            pre.setString(3, user.getUsername());
            try (ResultSet re = pre.executeQuery()) {
                if (re.next()) {
                    u = new User(re.getInt(1), re.getString(2), re.getString(3), re.getString(4));
                }
            }
        }
        return u;
    }

    public void modifica_user(User u) throws SQLException {
        reconnect();
        cambia_ultimo_utente();
        try (PreparedStatement pre = con.prepareStatement("UPDATE user SET account = true WHERE username=?")) {
            pre.setString(1, u.getUsername());
            pre.executeUpdate();
            pre.close();
        }
    }

    public void cambia_ultimo_utente() throws SQLException {
        reconnect();
        try (PreparedStatement pre = con.prepareStatement("UPDATE user SET account = flase WHERE account=?")) {
            pre.setBoolean(1, true);
            pre.executeUpdate();
            pre.close();
        }
    }

    public User ultimo_utente() throws SQLException {
        User u = null;
        try (PreparedStatement pre = con.prepareStatement("SELECT * FROM user WHERE account = ?")) {
            pre.setBoolean(1, true);
            try (ResultSet re = pre.executeQuery()) {
                if (re.next()) {
                    u = new User(re.getInt(1), re.getString(2), re.getString(3), re.getString(4));
                }
            }
        }
        return u;
    }
}
