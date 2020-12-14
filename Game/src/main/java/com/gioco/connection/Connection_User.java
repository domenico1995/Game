/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gioco.connection;

import javax.ws.rs.core.Response;
import com.gioco.data.User;
import com.google.gson.Gson;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class Connection_User {
    
    private Client client;
    
    private WebTarget web;
    
    private Response resp;
    
    private Gson gson;
    
    public void Connection_Server1(){    
        client = ClientBuilder.newClient();
        web = client.target("http://localhost:4321");
        gson = new Gson();
    }
    
    public void nuovo_utente(User u){
        resp = web.path("user/add").request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(gson.toJson(u), MediaType.APPLICATION_JSON));
    }
    
    public boolean trova_utenti(User u){
        
        boolean flag;
        
        resp = web.path("user/get")
                .queryParam("nome", u.getNome())
                .queryParam("cognome", u.getNome())
                .queryParam("username", u.getNome())
                .request(MediaType.APPLICATION_JSON).get();
        return gson.fromJson(resp.readEntity(String.class), boolean.class);
    }
    
}
