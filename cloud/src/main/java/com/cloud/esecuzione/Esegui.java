
package com.cloud.esecuzione;

import com.cloud.data.Progetto;
import java.io.IOException;

/**
 *
 * @author domen
 */
public class Esegui {
    
    public static Process pro;
    
    public static void esegui(Progetto p) throws IOException{
        exec("cmd.exe /k");
        exec("cd "+ p.getNome_eseguibile());
        exec("mvn exec:java -Dexec.mainClass=" + p.getPercorso_file());
        
    }
    
    public static void exec(String command) throws IOException {
        pro = Runtime.getRuntime().exec(command, null);
    }

    
}
