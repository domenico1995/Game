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

public class DBUsers {

    public static final String CREATE_USER = "CREATE TABLE IF NOT EXISTS user(nome VARCHAR(20), cognome VARCHAR(20),"
            + " username VARCHAR(25))";

    public static final String SEARCH_USER = "SELECT * FROM user WHERE nome = ? and cognome = ? and username = ?";

    private static Connection con;

    private static Properties pro;

    public static void connect() throws SQLException {
        pro = new Properties();
        pro.setProperty("user", "user");
        pro.setProperty("password", "1995");
        con = DriverManager.getConnection("jdbc:h2:./resources/db/user", pro);
        try (Statement stm = con.createStatement()) {
            stm.executeUpdate(CREATE_USER);
        }
    }

    private static void reconnect() throws SQLException {
        if (con != null && !con.isValid(0)) {
            con = DriverManager.getConnection("jdbc:h2:./resources/db/user", pro);
        }
    }

    public static void insertUsers(User u) throws SQLException {
        connect();
        reconnect();
        try (PreparedStatement pre = con.prepareStatement("INSERT INTO user VALUES (?,?,?)")) {
            pre.setString(1, u.getNome());
            pre.setString(2, u.getCognome());
            pre.setString(3, u.getUsername());
            pre.executeUpdate();
            pre.close();
        }
    }

    public static boolean cerca_user(User user) throws SQLException {
        connect();
        reconnect();
        List<User> u = new ArrayList<>();
        try (PreparedStatement pre = con.prepareStatement(SEARCH_USER)) {
            pre.setString(1, user.getNome());
            pre.setString(2, user.getCognome());
            pre.setString(3, user.getUsername());
            try (ResultSet re = pre.executeQuery()) {
                while (re.next()) {
                    User utente = new User(re.getString(1), re.getString(2), re.getString(3));
                    u.add(utente);
                }
            }
        }
        return u.isEmpty() != true;
    }
}
