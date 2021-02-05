/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server_dati;

import com.server_dati.thread.GameThread;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author user
 */
public class main {
    
    public static void main(String[] args) throws IOException{
        ServerSocket s = new ServerSocket(6666);
        int i = 0;
        try{
            while(true){
                Socket socket = s.accept();
                Thread t = new GameThread(socket, i);
                i++;
                t.start();
            }
        }
        finally{
            s.close();
        }
    }
    
}
