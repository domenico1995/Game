/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gioco.esecuzione;

import static com.gioco.connection.Connection_store.*;
import com.gioco.data.MyFile;
import com.gioco.service.InputStreamLineBuffer;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author domen
 */
public class Esegui {

    private String risp = "";
    private InputStream inStream, inErrStream;
    private OutputStream outStream;
    private Process pro;
    private Thread streamReader;
    private final List<String> list = new ArrayList<>();
    private boolean flag = false;

    public void caricamento (String gioco) throws InterruptedException {
        flag = true;
        MyFile m = new MyFile();

        List<String> l = new ArrayList<>();
        String jar = new String();
        File f = new File(gioco);
        f.mkdir();
        l = leggi_lista_file(gioco);
        for (String s : l) {
            f = new File(s);
            if (controllo_file(s)) {
                f.mkdir();
            } else {
                m = leggi_file(s);
                try (FileOutputStream fileOutputStream = new FileOutputStream(f)) {
                    fileOutputStream.write(m.getData());
                } catch (IOException ex) {
                    System.err.println("Errore nella scrittura su file.\n" + ex);
                }
            }
            if (s.contains("SNAPSHOT")) {
                jar = s;
            }
        }

        esegui("java -jar " + jar);
    }

    

    public void esegui(String command) throws InterruptedException {
        if (outStream != null) {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outStream));
            try {
                writer.write(command + "\n");
                writer.flush();
            } catch (IOException e1) {
                System.out.println(e1);
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
                                setRisp(outBuff.getNext() + "\n");
                            }
                        }
                        if (errBuff.timeElapsed() > 50) {
                            while (errBuff.hasNext()) {
                                setRisp(errBuff.getNext() + "\n");
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

    public void time_stop() throws InterruptedException {
        while (getRisp().length() == 0) {
            Thread.sleep(100);
        }
        Thread.sleep(200);
        list.add(getRisp());
        resetRisp();
        setRisp(list.get(list.size() - 1));
    }

    public void setRisp(String line) {
        if (line != null) {
            risp += line;
        }
    }

    public String getRisp() {
        return risp;
    }

    public void resetRisp() {
        risp = "";
    }

    public boolean getFlag(){
        return flag;
    }
}
