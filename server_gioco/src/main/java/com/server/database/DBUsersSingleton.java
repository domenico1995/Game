package com.server.database;

import org.server.data.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUsersSingleton {

    private static DBUsersSingleton instance;

    public static final String CREATE_TABLE_USERS = "CREATE TABLE IF NOT EXISTS users( nome VARCHAR(15), cognome VARCHAR(20)"
            + ", username VARCHAR(25), PRIMARY KEY(nome, cognome, username))";

    public Connection con;

    private Properties pro;

    private DBUsersSingleton() {
    }

    public synchronized static DBUsersSingleton getInstance() {
        if (instance == null) {
            instance = new DBUsersSingleton();
            try {
                instance.connect();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
        return instance;
    }

    public void connect() throws SQLException {
        pro = new Properties();
        pro.setProperty("user", "user");
        pro.setProperty("password", "1995");
        con = DriverManager.getConnection("jdbc:h2:./resourcse/db/users", pro);
        try (Statement stm = con.createStatement()) {
            stm.executeUpdate(CREATE_TABLE_USERS);
        }
    }

    private void reconnect() throws SQLException {
        if (con != null && !con.isValid(0)) {
            con = DriverManager.getConnection("jdbc:h2:./resourcse/db/users", pro);
        }
    }

    public void insertUsers(User user) throws SQLException {

        reconnect();
        try (PreparedStatement ps = con.prepareStatement("INSERT INTO users VALUES (?,?,?)")) {
            ps.setString(1, user.getNome());
            ps.setString(2, user.getCognome());
            ps.setString(3, user.getUsername());
            ps.executeUpdate();
        }

    }

    public User getUsers(String username) throws SQLException {
        reconnect();
        User u;
        try (PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE username = ?")) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                u = null;
                if (rs.next()) {
                    u = new User(rs.getString(1), rs.getString(2), rs.getString(3));
                }
            }
        }
        return u;
    }

    public void removeUsers(String id) throws SQLException {
        reconnect();
        try (PreparedStatement ps = con.prepareStatement("DELETE FROM users WHERE id = ?")) {
            ps.setString(1, id);
            ps.executeUpdate();
        }
    }

    public boolean trova_nome_cognome(User u) throws SQLException {
        reconnect();
        PreparedStatement ps = con.prepareStatement("SELECT nome FROM users WHERE nome = ? and cognome = ?");
        ps.setString(1, u.getNome());
        ps.setString(2, u.getCognome());
        boolean flag;
        try (ResultSet rs = ps.executeQuery()) {
            flag = rs.next();
        }
        return flag;
    }

    public boolean trova_nome_cognome_username(User u) throws SQLException {
        reconnect();
        boolean flag = false;
        PreparedStatement ps;
        System.out.println("hello");
        ps = con.prepareStatement("SELECT * FROM users WHERE nome = ? AND cognome = ? AND username = ?");
        System.out.println("world");
        ps.setString(1, u.getNome());
        ps.setString(2, u.getCognome());
        ps.setString(3, u.getUsername());
        try (ResultSet rs = ps.executeQuery()) {
            flag = false;
            while (rs.next()) {
                flag = true;
            }
        }
        return flag;
    }
}
