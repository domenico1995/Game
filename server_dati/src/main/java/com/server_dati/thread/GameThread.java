/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.thread;

import com.server.classi.Game;
import java.net.Socket;

/**
 *
 * @author user
 */
public class GameThread extends Thread{
    
    private final Socket socket;
    
    private boolean run = true;
    
    private String s;
    
    private final Game game;
    
    public GameThread(Socket socket, Game game){
        this.socket = socket;
        this.game = game;
    }

    public GameThread(Socket socket, Game game, String name) {
        this(socket, game);
        this.setName(name);
    }
    
}
