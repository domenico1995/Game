/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store_giochi.esecuzione;

import com.store_giochi.esecuzione.InputStreamLineBuffer;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;


public class comandi {

    private final String testo_maven = "[INFO] --- exec-maven-plugin:3.0.0:java (default-cli) @ ";
    private static String percorso, percorso_file;
    private static String risp = "";
    private static InputStream inStream, inErrStream;
    private static OutputStream outStream;
    private static Process pro;
    private static Thread streamReader;

    public static void esegui(String command) {
        if (outStream != null) {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outStream));
            try {
                writer.write(command + "\n");
                writer.flush();
            } catch (IOException e1) {
            }
        } else {
            try {
                pro = Runtime.getRuntime().exec(command, null);
                inStream = pro.getInputStream();
                inErrStream = pro.getErrorStream();
                outStream = pro.getOutputStream();

                InputStreamLineBuffer outBuff = new InputStreamLineBuffer(inStream);
                InputStreamLineBuffer errBuff = new InputStreamLineBuffer(inErrStream);

                streamReader = new Thread(() -> {
                    outBuff.start();
                    errBuff.start();

                    while (outBuff.isAlive() || outBuff.hasNext()
                            || errBuff.isAlive() || errBuff.hasNext()) {
                        if (outBuff.timeElapsed() > 50) {
                            while (outBuff.hasNext()) {
                                setRisp(outBuff.getNext());
                            }
                        }
                        if (errBuff.timeElapsed() > 50) {
                            while (errBuff.hasNext()) {
                                setRisp(errBuff.getNext());
                            }
                        }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                        }
                    }
                });
                streamReader.start();
            } catch (IOException e) {
            }
        }
    }

    public static void setRisp(String line){
        if (line != null){
        risp += line + "\n";
        }
    }
    
    public String getRisp(){
        return risp;
    }

    public void resetRisp(){
        risp = null;
    }
}
