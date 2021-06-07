package com.server_utenti.service;

import com.google.gson.Gson;
import com.server_utenti.data.User;
import com.server_utenti.database.DBUsersSingleton;

import java.sql.SQLException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("user")
public class ItemService {
   
    @PUT
    @Path("/add")
    @Consumes("application/json")
    @Produces("application/json")
    public Response add(String json) {
        Gson gson = new Gson();
        User u = gson.fromJson(json, User.class);
        try {
            DBUsersSingleton.getInstance().insertUsers(u);
        } catch (SQLException ex) {
            System.out.println("Inserimento: fallito");
            return Response.serverError().build();
        }
        System.out.println("Inserimento: " + u.getNome() + " " + u.getCognome() + " " + u.getUsername());
        return Response.ok().build();
    }

    /*
    restituisce user da username
    */
    @GET
    @Path("/get/")
    @Produces("application/json")
    public Response get(@QueryParam("username") String username) {
        User u;
        try {
            u = DBUsersSingleton.getInstance().getUsers(username);
        } catch (SQLException ex) {
            return Response.serverError().build();
        }
        if (u != null) {
            Gson gson = new Gson();
            String js = gson.toJson(u);
            System.out.println("Ricerca: " + username);
            return Response.ok(js, MediaType.APPLICATION_JSON).build();
        } else {
            System.out.println("Ricerca: falita");
            return Response.serverError().build();
        }
    }
    /*
    cancella user
    */
    @DELETE
    @Path("/delete/")
    @Produces("application/json")
    public Response delete(@QueryParam("username") String username) {
        try {
            DBUsersSingleton.getInstance().removeUsers(username);
        } catch (SQLException ex) {
            return Response.serverError().build();
        }
        System.out.println("Cancelazione: " + username);
        return Response.ok().build();
    }

    /*
    da vero se è presente user
    */
    @GET
    @Path("/find_name_surname/")
    @Produces("application/json")
    public Response find_name_surname(@QueryParam("nome") String nome, @QueryParam("cognome") String cognome) {
        boolean flag;
        try {
            User u = new User();
            u.setNome(nome);
            u.setCognome(cognome);
            u.setUsername(cognome);
            flag = DBUsersSingleton.getInstance().trova_nome_cognome(u);
        } catch (SQLException ex) {
            return Response.serverError().build();
        }

        Gson gson = new Gson();
        String js = gson.toJson(flag);
        System.out.println("Controllo utente: " + nome + " " + cognome);
        return Response.ok(js, MediaType.APPLICATION_JSON).build();
    }
    /*
    da vero se è presente user
    */
    @GET
    @Path("/find_user/")
    @Produces("application/json")
    public Response find_user(@QueryParam("nome") String nome, @QueryParam("cognome") String cognome, @QueryParam("username") String username) {
        boolean flag;
        try {
            User u = new User();
            u.setNome(nome);
            u.setCognome(cognome);
            u.setUsername(username);
            flag = DBUsersSingleton.getInstance().trova_nome_cognome_username(u);
        } catch (SQLException ex) {
            return Response.serverError().build();
        }
        Gson gson = new Gson();
        String js = gson.toJson(flag);
        System.out.println("Controllo utente: " + nome + " " + cognome + " " + username);
        return Response.ok(js, MediaType.APPLICATION_JSON).build();
    }
    
    @GET
    @Path("/controll")
    @Produces("application/json")
    public Response controll() {
        
        String s = "hello world";
        System.out.println("Controllo: applicazione in esecuzione");
        return Response.ok(s, MediaType.APPLICATION_JSON).build();
        
    }
    
}
