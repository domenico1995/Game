package com.gioco.manager;

import static com.gioco.connection.Connection_store.*;
import static com.gioco.service.Sistema.getCarattere;
import static com.gioco.service.Sistema.getPercorso;
import java.io.File;
import java.util.List;

public class Manager_gioco {

    public void init(String gioco) {
        
        String s = getPercorso() + getCarattere() + gioco;
        
        File dir = new File(s);
        if (!dir.exists()) {
            File f = new File(s + getCarattere() + "target");
            f.mkdir();
        }else{
            dir.mkdir();
            File f = new File(s + getCarattere() + "target");
            f.mkdir();
            List<String> list = leggi_file(gioco + getCarattere() + "target");
        }
    }
}
