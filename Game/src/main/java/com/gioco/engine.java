package com.gioco;

import com.gioco.data.User;
import com.gioco.data.testi;
import com.gioco.manager.Manager_user;
import com.gioco.manager.Manager_gioco;
import com.gioco.manager.Manager_opzioni;
import java.io.IOException;
import java.sql.SQLException;

public final class Engine {

    private String testo = "";
    
    private String testo_display = testi.ins_nome.testo();
    
    public User u;

    public Engine() {
        init();
    }

    public void init() {
        u = new User();
    }

    public void getWord(String text, String text_display) throws SQLException, IOException  {
        
        if(text.equals("exit")){
            //opzioni di salvataggio
            System.exit(0);
        }else if (text_display.equals(testi.ins_nome.testo())) {
            u.setNome(text);
            setTesto(text);
            setTesto_display(testi.ins_cognome.testo());
        } else if (text_display.equals(testi.ins_cognome.testo())) {
            u.setCognome(text);
            setTesto_display(testi.ins_username.testo());
        } else if (text_display.equals(testi.ins_username.testo())) {
            u.setUsername(text);
            setTesto_display("riuscito\n");  
            Manager_user.creazione_utenti(u);
        }else{
            setTesto(text);
            setTesto_display("aspetta");
            Manager_gioco.init("", "");
        }
        
    }
    
    public String getTesto(){return testo;}
    
    public void setTesto(String text){this.testo = text;}
    
    public String getTesto_display(){return testo_display;}
    
    public void setTesto_display(String text_display){this.testo_display = text_display;}
    
}
