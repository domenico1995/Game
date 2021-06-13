package com.gioco.service;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Threads extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            System.exit(0);
        } catch (InterruptedException ex) {
            Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
