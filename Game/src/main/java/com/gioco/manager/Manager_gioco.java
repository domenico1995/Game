package com.gioco.manager;

import static com.gioco.connection.Connection_store.*;
import com.gioco.data.MyFile;
import static com.gioco.service.Sistema.getCarattere;
import static com.gioco.service.Sistema.getPercorso;
import java.io.File;

public class Manager_gioco {

    public Manager_gioco(){}
    
    public void init(String gioco) {
        
        String s = getPercorso() + getCarattere() + gioco;
        System.out.println(s);
        
        //da test_store prendere il corpo delle funzioni della creazione progetto
        File dir = new File(s);
        if (dir.exists()) {
            File f = new File(s + getCarattere() + "target");
            f.mkdir();
        }else{
            dir.mkdir();
            File f = new File(s + getCarattere() + "target");
            f.mkdir();    
            MyFile list = leggi_file(gioco + getCarattere() + "target");
        }
    }
    
    
    public static void main(String[] args){
        Manager_gioco m = new Manager_gioco();
        m.init("gioco_1");
    }
}
