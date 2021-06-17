/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gioco.connection;

import static com.gioco.connection.Connection_store.Connection_store;
import javax.ws.rs.core.Response;
import com.gioco.data.User;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class Connection_User {

    private static Client client;
    private static WebTarget web;
    private static Response resp;
    private static Gson gson;

    public static void Connection_Server() {
        client = ClientBuilder.newClient();
        web = client.target("http://localhost:4321");
        gson = new Gson();
    }

    public static void nuovo_utente(User u) {
        Connection_Server();
        resp = web.path("user/add").request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(gson.toJson(u), MediaType.APPLICATION_JSON));
    }

    public static boolean trova_utenti(User u) {
        Connection_Server();
        resp = web.path("user/find_user")
                .queryParam("nome", u.getNome())
                .queryParam("cognome", u.getCognome())
                .queryParam("username", u.getUsername())
                .request(MediaType.APPLICATION_JSON).get();
        return Boolean.parseBoolean(resp.readEntity(String.class));
    }
    /*
    public static boolean trova_nome_cognome(User u) {
        Connection_Server();
        resp = web.path("user/find_nome_surname")
                .queryParam("nome", u.getNome())
                .queryParam("cognome", u.getCognome())
                .request(MediaType.APPLICATION_JSON).get();
        return Boolean.parseBoolean(resp.readEntity(String.class));
    }

    public static void nuovo_comando(User u, String comando) {
        Connection_Server();
        resp = web.path("user/add_comando")
                .queryParam("nome", u.getNome())
                .queryParam("cognome", u.getCognome())
                .queryParam("username", u.getUsername())
                .queryParam("comando", comando)
                .request(MediaType.APPLICATION_JSON).get();
    }

    public static List<String> leggi_comandi(User u) {
        Connection_store();
        resp = web.path("user/leggi_comando")
                .queryParam("nome", u.getNome())
                .queryParam("cognome", u.getCognome())
                .queryParam("username", u.getUsername())
                .request(MediaType.APPLICATION_JSON).get();
        return gson.fromJson(resp.readEntity(String.class), ArrayList.class);
    }

    public static void cancella_comandi(User u) {
        Connection_store();
        resp = web.path("user/cancella_comando")
               .queryParam("nome", u.getNome())
                .queryParam("cognome", u.getCognome())
                .queryParam("username", u.getUsername())
                .request(MediaType.APPLICATION_JSON).get();
    }
    */
}
