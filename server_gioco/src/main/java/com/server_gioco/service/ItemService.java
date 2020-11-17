package org.server.service;

import com.google.gson.Gson;
import org.server.data.User;
import org.server.database.DBUsersSingleton;

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
    /*
    inserimento utente
    */
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
            return Response.serverError().build();
        }
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
            return Response.ok(js, MediaType.APPLICATION_JSON).build();
        } else {
            return Response.serverError().build();
        }
    }
    /*
    cancella user
    */
    @DELETE
    @Path("/delete/")
    @Produces("application/json")
    public Response delete(@QueryParam("user") String user) {
        try {
            DBUsersSingleton.getInstance().removeUsers(user);
        } catch (SQLException ex) {
            return Response.serverError().build();
        }
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
            System.out.println("prova");
            flag = DBUsersSingleton.getInstance().trova_nome_cognome_username(u);
            System.out.println(flag);
        } catch (SQLException ex) {
            return Response.serverError().build();
        }

        Gson gson = new Gson();
        String js = gson.toJson(flag);
        System.out.println(js);
        return Response.ok(js, MediaType.APPLICATION_JSON).build();
    }
}
