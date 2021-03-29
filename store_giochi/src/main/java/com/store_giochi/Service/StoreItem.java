/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store_giochi.Service;

import com.google.gson.Gson;
import static com.store_giochi.Service.Sistema.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author domen
 */
@Path("store")
public class StoreItem {

    public final String percorso = getPercorso();

    @GET
    @Path("/add_list_file/")
    @Consumes("application/json")
    @Produces("application/json")
    public Response add_list_file(@QueryParam("progetto") String progetto, @QueryParam("lista_file") String lista) {
        progetto = aggiunta(percorso, progetto);
        Cartella.crea_cartella(progetto);
        Gson gson = new Gson();
        List<String> l = new ArrayList<>();
        l = gson.fromJson(lista, ArrayList.class);
        ListIterator<String> lit = l.listIterator();
        while (lit.hasNext()) {
            Cartella.crea_cartella(aggiunta(progetto, lit.next()));
        }
        boolean flag = true;
        String js = gson.toJson(flag);
        return Response.ok(js, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/add_list_file/")
    @Consumes("application/json")
    @Produces("application/json")
    public Response add_file(@QueryParam("progetto") String progetto, @QueryParam("percorso") String per,
            @QueryParam("file") String lista, @QueryParam("nome_file") String nome_file) throws IOException {
        per = aggiunta(aggiunta(percorso, progetto), per);
        Cartella.inserire_file(per, lista, nome_file);
        Gson gson = new Gson();
        boolean flag = true;
        String js = gson.toJson(flag);
        return Response.ok(js, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/add_list_file/")
    @Consumes("application/json")
    @Produces("application/json")
    public Response return_file(@QueryParam("progetto") String progetto, @QueryParam("percorso") String per,
            @QueryParam("file") String lista, @QueryParam("nome_file") String nome_file) throws IOException {
        per = aggiunta(aggiunta(percorso, progetto), per);
        List<String> s = Cartella.leggi_file(per, nome_file);
        
        //sistemare meglio.
        Gson gson = new Gson();
        boolean flag = true;
        String js = gson.toJson(flag);
        return Response.ok(js, MediaType.APPLICATION_JSON).build();
    }
}
