/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store_giochi.Service;

import com.google.gson.Gson;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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

    public Sistema os = new Sistema();
    
    public final String percorso = os.getPercorso();

    @GET
    @Path("/add_list_file/")
    @Consumes("application/json")
    @Produces("application/json")
    public Response add_list_file(@QueryParam("account") String account, @QueryParam("progetto") String progetto, @QueryParam("lista_file") String lista) {
        String s = os.aggiunta(percorso,account);
        Cartella.crea_cartella(s);
        s = os.aggiunta(s, progetto);
        Cartella.crea_cartella(s);
        
        Gson gson = new Gson();
        List<String> l = new ArrayList<>();
        l = gson.fromJson(lista, ArrayList.class);
        ListIterator<String> lit = l.listIterator();
        
        while (lit.hasNext()) {
            Cartella.crea_cartella(os.aggiunta(s, lit.next()));
        }
        boolean flag = true;
        String js = gson.toJson(flag);
        return Response.ok(js, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/add_list_file/")
    @Consumes("application/json")
    @Produces("application/json")
    public Response add_file(@QueryParam("account") String account, @QueryParam("progetto") String progetto, @QueryParam("percorso") String per, @QueryParam("file") String lista) {
        String s = os.aggiunta(percorso,account);
        s = os.aggiunta(s, progetto);
        Cartella.inserire_file(s, lista);
        Gson gson = new Gson();
        boolean flag = true;
        String js = gson.toJson(flag);
        return Response.ok(js, MediaType.APPLICATION_JSON).build();
    }
    
}
