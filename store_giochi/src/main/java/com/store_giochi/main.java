package com.store_giochi;

import com.store_giochi.esecuzione.comandi;
import static com.store_giochi.service.Sistema.getPercorso;
import com.store_giochi.service.StoreItem;
import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class main extends comandi {

    public static void main(String[] args) throws IOException {
        URI baseUri = UriBuilder.fromUri("http://localhost/").port(4322).build();
        ResourceConfig config = new ResourceConfig(StoreItem.class);
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(baseUri, config);

        try {
            run();
            server.start();
            System.in.read();
            server.shutdown();
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void run() {
        esegui("cmd.exe /k");
        esegui("cd " + getPercorso());
        esegui("git clone https://github.com/domenico1995/cloud.git");
    }
}
