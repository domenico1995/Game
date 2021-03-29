/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gioco.service;

/**
 *
 * @author domen
 */
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ConcurrentLinkedQueue;

public class InputStreamLineBuffer {

    private InputStream inputStream;
    private ConcurrentLinkedQueue<String> lines;
    private long lastTimeModified;
    private final Thread inputCatcher;
    private boolean isAlive;

    public InputStreamLineBuffer(InputStream is) {
        inputStream = is;
        lines = new ConcurrentLinkedQueue<>();
        lastTimeModified = System.currentTimeMillis();
        isAlive = false;
        inputCatcher = new Thread(() -> {
            StringBuilder sb = new StringBuilder(100);
            int b;
            try {
                while ((b = inputStream.read()) != -1) {
                    if ((char) b == '\n') {
                        lines.offer(sb.toString());
                        sb.setLength(0);
                        lastTimeModified = System.currentTimeMillis();
                    } else {
                        StringBuilder append = sb.append((char) b);
                    }
                }
            } catch (IOException e) {
            } finally {
                isAlive = false;
            }
        });
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void start() {
        isAlive = true;
        inputCatcher.start();
    }

    public boolean hasNext() {
        return lines.size() > 0;
    }

    public String getNext() {
        return lines.poll();
    }

    public long timeElapsed() {
        return (System.currentTimeMillis() - lastTimeModified);
    }
}
