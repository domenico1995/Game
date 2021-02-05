/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server_dati.thread;

import com.server_dati.classi.Game;
import java.net.Socket;

/**
 *
 * @author user
 */
public class GameThread extends Thread{
    
    private final Socket socket;
    
    private boolean run = true;
    
    private String text;
    
    private final Game game;
    
    public GameThread(Socket socket, Game game){
        this.socket = socket;
        this.game = game;
    }


    public GameThread(Socket socket, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void run(){}
    
}
