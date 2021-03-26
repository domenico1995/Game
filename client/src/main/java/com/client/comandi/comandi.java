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
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author domen
 */
public class comandi {

    private final String testo_maven = "[INFO] --- exec-maven-plugin:3.0.0:java (default-cli) @ adventure ---";
    private String percorso, percorso_file;
    public List<String> risp = new ArrayList<>();
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
            case "cmd.exe /k":
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

    public void setRisp(String line) {
        if(flag == true){
            risp.add(line);
        }
        if (line.contains(testo_maven)) {
            flag = true;
        }
    }

    public List getRisp() {
        return risp;
    }

}
