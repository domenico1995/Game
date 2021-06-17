package com.server_utenti.service;

import com.google.gson.Gson;
import com.server_utenti.data.User;
import com.server_utenti.database.DBStoreUser;
import static com.server_utenti.database.DBStoreUser.*;
import com.server_utenti.database.DBUsersSingleton;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
            DBStoreUser.getInstance(u);
        } catch (SQLException ex) {
            return Response.serverError().build();
        }
        return Response.ok().build();
    }

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
            return Response.ok(js, MediaType.APPLICATION_JSON).build();
        } else {
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("/delete/")
    @Produces("application/json")
    public Response delete(@QueryParam("username") String username) {
        try {
            DBUsersSingleton.getInstance().removeUsers(username);
        } catch (SQLException ex) {
            return Response.serverError().build();
        }
        return Response.ok().build();
    }

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
        return Response.ok(js, MediaType.APPLICATION_JSON).build();
    }

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
        return Response.ok(js, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/controll")
    @Produces("application/json")
    public Response controll() {
        String s = "hello world";
        return Response.ok(s, MediaType.APPLICATION_JSON).build();

    }

    /*
    @GET
    @Path("/add_comando/")
    public Response add_comando(@QueryParam("nome") String nome, @QueryParam("cognome") String cognome,
            @QueryParam("username") String username, @QueryParam("comando") String comando) {
        Gson gson = new Gson();
        User u = new User();
        u.setNome(nome);
        u.setCognome(cognome);
        u.setUsername(username);
        try {
            DBStoreUser.getInstance(u).inserire(u, comando);
        } catch (SQLException ex) {
            return Response.serverError().build();
        }
        boolean flag = true;
        String js = gson.toJson(flag);
        return Response.ok(js, MediaType.APPLICATION_JSON).build();
    }

    @PUT
    @Path("/cancella_comando")
    @Consumes("application/json")
    @Produces("application/json")
    public Response cancellazione(@QueryParam("nome") String nome, @QueryParam("cognome") String cognome,
            @QueryParam("username") String username, @QueryParam("comando") String comando) {
        Gson gson = new Gson();
        User u = new User();
        u.setNome(nome);
        u.setCognome(cognome);
        u.setUsername(username);
        try {
            DBStoreUser.getInstance(u).cancella(u);
        } catch (SQLException ex) {
            return Response.serverError().build();
        }
        return Response.ok().build();
    }

    @GET
    @Path("/leggi_comando/")
    @Consumes("application/json")
    @Produces("application/json")
    public Response lista_comando(@QueryParam("nome") String nome, @QueryParam("cognome") String cognome,
            @QueryParam("username") String username) throws SQLException {
        Gson gson = new Gson();
        User u = new User();
        u.setNome(nome);
        u.setCognome(cognome);
        u.setUsername(username);
        List<String> list = new ArrayList<>();
        list = DBStoreUser.getInstance(u).leggi(u);
        System.out.println("ff  ffff " + list);
        String js = gson.toJson(list);
        return Response.ok(js, MediaType.APPLICATION_JSON).build();
    }
*/
}
