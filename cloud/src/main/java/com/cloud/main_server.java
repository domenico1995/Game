/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloud;

import com.cloud.Service.CloudService;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author domenico
 */
public class main_server {
    
    public static void main(String args[]) throws IOException{
        
        main_server m = new main_server();
        URI baseUri = UriBuilder.fromUri("http://localhost/").port(4321).build();
        ResourceConfig config = new ResourceConfig(CloudService.class);
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(baseUri, config);
        try {
            server.start();
            System.out.println(String.format("Cloud server in caricamento."));
            m.run();
            System.out.println(String.format("Cloud server pronto"));
            System.in.read();
            server.shutdown();
        } catch (IOException ex) {
            Logger.getLogger(main_server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void run(){
    
        //inserire codice relativo esecuzione programmi sul database.
        
        List<String> list = new ArrayList<>();
        
        

    }
    
}
