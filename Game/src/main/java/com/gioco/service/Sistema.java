package com.gioco.service;

import java.io.File;

public class Sistema {

    private static String percorso;
    private static String carattere;
    public static String OS = System.getProperty("os.name").toLowerCase();

    public static String getPercorso() {
        if (isWindows()) {
            percorso = "C:\\Users\\domen\\Documents\\giochi";
            File file = new File(percorso);
            boolean mkdir = file.mkdir();
        }
        if (isUnix()) {
            percorso = "/home/domenico/Documenti/giochi";
            File file = new File(percorso);
            boolean mkdir = file.mkdir();
        }
        return percorso;
    }

    public static String getCarattere() {
        if (isWindows()) {
            carattere = "\\";
        }
        if (isUnix()) {
            carattere = "/";
        }
        return carattere;
    }

    public static boolean isWindows() {
        return (OS.contains("win"));
    }

    public static boolean isUnix() {
        return (OS.contains("nix") || OS.contains("nux") || OS.indexOf("aix") > 0);
    }

    public static String aggiunta(String s1, String s2) {
        if (isWindows()) {
            return s1 + "\\" + s2;
        }
        if (isUnix()) {
            return s1 + "/" + s2;
        }
        return null;
    }

}
