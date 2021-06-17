
package com.gioco.connection;

import com.gioco.data.MyFile;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class Connection_store {

    private static Client client;
    private static WebTarget web;
    private static Response resp;
    private static Gson gson;
    
    public static void Connection_store() {
        client = ClientBuilder.newClient();
        web = client.target("http://localhost:4322");
        gson = new Gson();
    }

    public static List<String> leggi_lista_file(String progetto) {
        Connection_store();
        resp = web.path("store/read_lista_file")
                .queryParam("progetto", progetto)
                .request(MediaType.APPLICATION_JSON).get();
        return gson.fromJson(resp.readEntity(String.class), ArrayList.class);
    }

    public static MyFile leggi_file(String percorso) {
        Connection_store();
        resp = web.path("store/read_file")
                .queryParam("percorso", percorso)
                .request(MediaType.APPLICATION_JSON).get();
        return gson.fromJson(resp.readEntity(String.class), MyFile.class);
    }
    
    public static boolean controllo_file(String percorso) {
        Connection_store();
        resp = web.path("store/controllo_file")
                .queryParam("progetto", percorso)
                .request(MediaType.APPLICATION_JSON).get();
        return Boolean.parseBoolean(resp.readEntity(String.class));
    }
    
    
    public static List<String> numero_giochi() {
        Connection_store();
        resp = web.path("store/numero_giochi")
                .request(MediaType.APPLICATION_JSON).get();
        return gson.fromJson(resp.readEntity(String.class), ArrayList.class);
    }
    
}
