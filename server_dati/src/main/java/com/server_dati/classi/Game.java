/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.classi;

import com.server.thread.GameThread;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author user
 */
public class Game {
    
    private final Map<String, GameThread> gioco = new HashMap<>();
    
    public synchronized void download_file_info(){}
    
    public synchronized void download_file_text(){}
    
    
}
