/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server;

import com.server.classi.Game;
import com.server.thread.GameThread;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

/**
 *
 * @author user
 */
public class main {
    
    public static void main(String[] args) throws IOException{
        Game game = new Game();
        ServerSocket s = new ServerSocket(6666);
        try{
            while(true){
                Socket socket = s.accept();
                Thread t = new GameThread(socket, game, UUID.randomUUID().toString());
                t.start();
            }
        }
        finally{
            s.close();
        }
    }
    
}
