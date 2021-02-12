/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server_dati;

import com.server_dati.Service.StoreItem;
import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * 
 * @author user
 */
public class main {
    
    public static void main(String[] args) throws IOException{
        URI baseUri = UriBuilder.fromUri("http://192.168.1.6/").port(4321).build();
        ResourceConfig config = new ResourceConfig(StoreItem.class);
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(baseUri, config);
        try {
            server.start();
            System.in.read();
            server.shutdown();
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
