/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloud;

import com.cloud.DataBase.DBcloud;
import static com.cloud.DataBase.DBcloud.vuoto;
import com.cloud.Service.CloudService;
import com.cloud.data.Progetto;
import com.cloud.esecuzione.Esegui;
import java.io.IOException;
import java.net.URI;
import java.sql.SQLException;
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

    public static void main(String args[]) throws IOException, SQLException {
        URI baseUri = UriBuilder.fromUri("http://localhost/").port(4321).build();
        ResourceConfig config = new ResourceConfig(CloudService.class);
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(baseUri, config);
        try {
            server.start();
            System.out.println(String.format("Cloud server in caricamento ..."));
            run();
            System.out.println(String.format("Cloud server in esecuzione."));
            System.in.read();
            server.shutdown();
        } catch (IOException ex) {
            Logger.getLogger(main_server.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void run() throws SQLException, IOException {
        if (vuoto() == true) {
            List<Progetto> list = new ArrayList<>();
            list = DBcloud.leggi_contenuto();
            for (Progetto p : list) {
                Esegui.esegui(p);
            }
            
        }else{
        
            Esegui.exec("cmd.exe /k");
//            Esegui.exec("cd " + percorso);
        }
    }
}
