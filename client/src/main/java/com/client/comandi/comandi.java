/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.comandi;

import com.client.service.InputStreamLineBuffer;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;


public class comandi {

    private String risp = "";
    private InputStream inStream, inErrStream;
    private OutputStream outStream;
    private Process pro;
    private Thread streamReader;

    public boolean flag = false;

    public boolean trova_comando(String comando) {
        esegui("cmd.exe /k");
        switch (comando) {
            case "cd ..":
                return true;
            case "dir":
                return true;
            case "crea":
                return true;
            default:
                return false;
        }
    }

    public void esegui(String command) {
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

    public void setRisp(String line){
        if (line != null){
        risp += line + "\n";
        }
    }
    
    public String getRisp(){
        return risp;
    }

    public void setRisp(){
        String s = "";
        risp = s;
        System.out.println("hello world " + risp.length());

    }
}
