package com.store_giochi.service;

import com.google.gson.Gson;
import static com.store_giochi.service.Sistema.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("store")
public class StoreItem {

    public final String percorso = aggiunta(getPercorso(), "cloud");
    
    public final String percorso_replace = getPercorso() + getCarattere() + "cloud" + getCarattere();

    @GET
    @Path("/add_list_file/")
    @Consumes("application/json")
    @Produces("application/json")
    public Response add_list_file(@QueryParam("progetto") String progetto, @QueryParam("lista_file") String lista) {
        System.out.println(percorso);
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
        System.out.println("hello " + js);
        return Response.ok(js, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/add_file/")
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
    @Path("/read_lista_file/")
    @Consumes("application/json")
    @Produces("application/json")
    public Response return_lista_file(@QueryParam("progetto") String progetto) throws IOException {
        progetto = aggiunta(percorso, progetto);
        List<String> s = new ArrayList<>();
        List<String> list = new ArrayList<>();
        Cartella.leggi_lista_file(progetto, s);
        ListIterator l = s.listIterator();
        while(l.hasNext()){
            String t = (String) l.next();
            list.add(t.substring(percorso_replace.length()));
        }
        Collections.sort(list);
        Gson gson = new Gson();
        String js = gson.toJson(list);
        return Response.ok(js, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/read_file/")
    @Consumes("application/json")
    @Produces("application/json")
    public Response return_file(@QueryParam("percorso") String per) throws IOException {
        per = aggiunta(percorso, per);
        List<String> s = Cartella.leggi_file(per);
        Gson gson = new Gson();
        String js = gson.toJson(s);
        return Response.ok(js, MediaType.APPLICATION_JSON).build();
    }
    
    @GET
    @Path("/controllo_file/")
    @Consumes("application/json")
    @Produces("application/json")
    public Response controllo_file(@QueryParam("progetto") String per) throws IOException {
        boolean flag;
        String s = per;
        flag = controlloFile(s);
        Gson gson = new Gson();
        String js = gson.toJson(flag);
        return Response.ok(js, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/get_percorso/")
    @Produces("application/json")
    public Response Percorso(){
        String s = getPercorso() + getCarattere();
        return Response.ok(s, MediaType.APPLICATION_JSON).build();
    }
    
    private boolean controlloFile(String s) {
        File dir = new File(percorso);
        return dir.isDirectory();
    }
    
    @GET
    @Path("/lista_file/")
    @Consumes("application/json")
    @Produces("application/json")
    public Response lista_file(@QueryParam("percorso") String per) throws IOException {
        per = aggiunta(percorso, per);
        List<String> s = new ArrayList<>();
        List<String> list = new ArrayList<>();
        Cartella.lista_file(per, s);
        ListIterator l = s.listIterator();
        while(l.hasNext()){
            String t = (String) l.next();
            list.add(t.substring(percorso_replace.length()));
        }
        Collections.sort(list);
        Gson gson = new Gson();
        String js = gson.toJson(list);
        return Response.ok(js, MediaType.APPLICATION_JSON).build();
    }
}
