package com.gioco;

import com.gioco.data.User;
import com.gioco.data.testi;
import com.gioco.manager.Manager_user;
import com.gioco.manager.Manager_gioco;
import com.gioco.manager.Manager_opzioni;

public class engine {

    private String testo = "";
    
    private String testo_display = testi.ins_nome.testo();
    
    public User u;

    public engine() {
        init();
    }

    public void init() {
        u = new User();
        Manager_user man_user = new Manager_user();
        Manager_gioco man_gioco = new Manager_gioco();
        Manager_opzioni man_opzioni = new Manager_opzioni();

    }

    public void getWord(String text, String text_display, int time) {
        
        if(text.equals("exit")){
            //opzioni di salvataggio
            System.exit(0);
        }
        else if (text_display.equals(testi.ins_nome.testo())) {
            u.setNome(text);
            setTesto(text);
            setTesto_display(testi.ins_cognome.testo());
        } else if (text_display.equals(testi.ins_cognome.testo())) {
            u.setCognome(text);
            setTesto_display(testi.ins_username.testo());
        } else if (text_display.equals(testi.ins_username.testo())) {
            u.setUsername(text);
            setTesto_display("riuscito\n");   
        }else{
            
        }

    }
    
    public String getTesto(){return testo;}
    
    public void setTesto(String text){this.testo = text;}
    
    public String getTesto_display(){return testo_display;}
    
    public void setTesto_display(String text_display){this.testo_display = text_display;}
    
}
