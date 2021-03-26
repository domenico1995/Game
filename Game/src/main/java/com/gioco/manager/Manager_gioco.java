/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gioco.manager;

import com.testo_prova.test.InputStreamLineBuffer;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 *
 * @author user
 */
public class Manager_gioco {
    
    public static InputStream inStream, inErrStream;
    
    public static OutputStream outStream;
    
    public static Process pro;
    
    public static String testo;
    
    public static void init(String per, String classe) throws IOException{
        
        exec("cmd.exe /k");
        exec("cd " + per);
        exec("mvn exec:java -Dexec.mainClass=" + classe);
        
    }

    private static void read(String command) {
        if (outStream != null) {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outStream));
            try {
                writer.write(command + "\n");
                writer.flush();
            } catch (IOException e1) {
            }
        } else {
            try {
                exec(command);
            } catch (IOException e) {
            }
        }
    }
    
    private static void exec(String command) throws IOException {
        pro = Runtime.getRuntime().exec(command, null);
        inStream = pro.getInputStream();
        inErrStream = pro.getErrorStream();
        outStream = pro.getOutputStream();

        InputStreamLineBuffer outBuff = new InputStreamLineBuffer(inStream);
        InputStreamLineBuffer errBuff = new InputStreamLineBuffer(inErrStream);

        Thread streamReader;
        streamReader = new Thread(() -> {
            outBuff.start();
            errBuff.start();

            while (outBuff.isAlive() || outBuff.hasNext()
                    || errBuff.isAlive() || errBuff.hasNext()) {
                if (outBuff.timeElapsed() > 50) {
                    while (outBuff.hasNext()) {
                        System.out.print(outBuff.getNext());
                    }
                }
                if (errBuff.timeElapsed() > 50) {
                    while (errBuff.hasNext()) {
                        System.out.print(errBuff.getNext());
                    }
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
        });
        streamReader.start();

        Thread exitWaiter;
        exitWaiter = new Thread(() -> {
            try {
                int retValue = pro.waitFor();
                System.out.println("Command exit with return value " + retValue);
                outStream.close();
                outStream = null;
            } catch (InterruptedException | IOException e) {
            }
        });
        exitWaiter.start();
    }    
    
    public String getTesto(){
        return testo;
    }
    
    public void setTesto(String s){
        this.testo = s;
    }
}
