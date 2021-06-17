/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gioco_1.games;

import com.gioco_1.type.Room;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author domen
 */
public class Caricamento_room {
    
    private List<Room> l;
    
    private Room stanza_inizio;
    
    public void caricamento_room(){
    
        List<Room> list = new ArrayList<>();
        Room cucina = new Room(0, "Cucina", "Sei in cucina e all'improviso senti l'allarme antincedio, il tuo appartamento sta prendendo fuoco.\nDevi scappare.");
        cucina.setLook("Sei in cucina, a sud c'è il soggiorno.");
        Room soggiorno = new Room(1, "Soggiorno", "Sei nel soggiono del tuo appartamento e senti puzza di fumo");
        soggiorno.setLook("Sei nel tuo soggiorno, a est trovi il corridoi.");
        Room corridoio = new Room(2, "Corridoio", "Sei in corridoio. Inizi a vedere un pò di fumo");
        corridoio.setLook("Sei nel corridoio, a sud c'è il bagno, a est la tua coamera, a ovest il soggionrno e a nord l'uscita");
        Room bagno = new Room(3, "Bagno", "Ti trovi nel bagno e vedo del fumo entrare dalla finestra");
        bagno.setLook("E un bagno, non c'è niente di interessante");
        Room camera = new Room(4, "Camera", "Stai nella tua camera e come al solito è sporca");
        camera.setLook("Apparte il fumo e lo sporco non c'è niente.");
        Room uscita = new Room(5, "Porta", "Complimenti sei vivo ma il tuo condominio è in fiamme.");
        
        cucina.setSouth("Soggiorno");
        soggiorno.setNorth("Cucina");
        soggiorno.setEast("Corridoio");
        corridoio.setWest("Soggiorno");
        corridoio.setSouth("Bagno");
        corridoio.setEast("Camera");
        corridoio.setNorth("Porta");
        bagno.setNorth("Corridoio");
        camera.setWest("Corridoio");
        uscita.setSouth("Corridoio");
        list.add(corridoio);
        list.add(soggiorno);
        list.add(cucina);
        list.add(bagno);
        list.add(camera);
        list.add(uscita);
        setList(list);
        setStanza(cucina);
    }
    
    public void setList(List<Room> list){
        this.l = list;
    }
    
    public List<Room> getList(){return l;}
    
    public void setStanza(Room r){
        this.stanza_inizio = r;
    }
    
    public Room geStanza(){return stanza_inizio;}
}
