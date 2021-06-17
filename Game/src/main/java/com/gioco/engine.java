 package com.gioco;

import com.gioco.data.User;
import com.gioco.data.Testi;
import static com.gioco.manager.Manager_user.*;
import static com.gioco.manager.Manager_gioco.*;
import com.gioco.service.Threads;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public final class Engine {

    private String testo = "";
    private String testo_display = Testi.benvenuto.testo() + Testi.ins_nome.testo();
    private User u;
    private List<String> list;

    public Engine() throws InterruptedException {
        init();
    }

    public void init() throws InterruptedException {
        u = new User();
        list = new ArrayList<>();
        inizio();
    }

    public void getWord(String text, String text_display, JTextArea jt, JTextField jf)
            throws SQLException, IOException, InterruptedException {

        if (text.equals("exit") || text.equals("esci")) {
            setTesto(text);
            reset_area(jt);
            reset_field(jf);
            setTesto_display(Testi.testo_uscita.testo());
            
            Threads t = new Threads();
            t.start();
        } else if (text_display.equals(Testi.benvenuto.testo() + Testi.ins_nome.testo())) {
            u.setNome(text);
            setTesto(text);
            setTesto_display(Testi.ins_cognome.testo());
        } else if (text_display.equals(Testi.ins_cognome.testo())) {
            u.setCognome(text);
            setTesto(text);
            setTesto_display(Testi.ins_username.testo());
        } else if (text_display.equals(Testi.ins_username.testo())) {
            setTesto(text);
            u.setUsername(text);
            String s = creazione_utenti(u);
            setTesto_display(s + Testi.premere_tasto.testo());
        } else if (text_display.contains(Testi.premere_tasto.testo())) {
            reset_area(jt);
            reset_field(jf);
            setTesto("ciao " + u.getUsername() + "\n" + Testi.ritorno_utente.testo()+ getRisposta());
        } else {
            list.add(testo);
            resetRisposta();
            testo(text);
            setTesto(text);
            setTesto_display(getRisposta());
        }
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String text) {
        this.testo = text;
    }

    public String getTesto_display() {
        return testo_display;
    }

    public void setTesto_display(String text_display) {
        this.testo_display = text_display;
    }

    public void reset_area(JTextArea jt) {
        jt.setText("");
        setTesto_display("");
    }

    public void reset_field(JTextField jf) {
        jf.setText("");
        setTesto("");
    }
}
