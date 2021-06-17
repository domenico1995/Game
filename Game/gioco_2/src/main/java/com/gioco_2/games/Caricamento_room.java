/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gioco_2.games;

import com.gioco_2.type.Room;
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
        
        Room corridoio = new Room(0, "Corridoio", "Il corridoio è pieno di fumo devi prendere le scale. Trovale");
        corridoio.setLook("trovi un corridoio a destra e a sinistra");
        Room corridoio_sinistra = new Room(1, "Corridoio sinistra", "è pieno di fumo.");
        corridoio_sinistra.setLook("trovi un corridoio a nord e a sud");
        Room corridoio_destra = new Room(2, "Corridoio destra", "il fumo è ovunque");
        corridoio_destra.setLook("trovi un corridoio a nord e a sud");
        
        Room corridoio_sinistra_nord = new Room(3, "Corridoio sinistra nord", "non si vede niete");
        corridoio_sinistra_nord.setLook("ci sono stanze a ovest, nord e est");
        Room corridoio_sinistra_sud = new Room(4, "Corridoio sinistra sud", "c'è troppo fumo");
        corridoio_sinistra_sud.setLook("ci sono stanze a ovest, sud e est");
        Room corridoio_destra_nord = new Room(5, "Corridoio destra nord", "non si vede un palmo dal naso");
        corridoio_destra_nord.setLook("ci sono stanze a ovest, nord e est");
        Room corridoio_destra_sud = new Room(6, "Corridoio destra sud", "non si vede niente");
        corridoio_destra_sud.setLook("ci sono stanze a ovest, sud e est");
        
        Room stanza11 = new Room(7, "Stanza 11", "è piena di fumo.");
        Room stanza12 = new Room(8, "Stanza 12", "è piena di fumo.");
        Room stanza13 = new Room(9, "Stanza 13", "è piena di fumo.");
        Room stanza21 = new Room(10, "Stanza 21", "Sorpresa, è pieno di fumo. Scappa!");
        Room stanza22 = new Room(11, "Stanza 22", "è piena di fumo.");
        Room stanza23 = new Room(12, "Stanza 23", "è piena di fumo.");
        Room stanza31 = new Room(12, "Stanza 31", "è piena di fumo.");
        Room stanza32 = new Room(13, "Stanza 32", "è piena di fumo.");
        Room stanza33 = new Room(14, "Stanza 33", "è piena di fumo.");
        Room stanza41 = new Room(15, "Stanza 41", "è piena di fumo.");
        Room stanza42 = new Room(16, "Scale giu", "Scendi le scale e vai al piano di sotto. Sta completamente bruciando");
        Room stanza43 = new Room(17, "Stanza 43", "è piena di fumo.");
        
        Room appartamento = new Room(18, "Appartamento", "Rientri nel tuo appartamento.");
        
        
        corridoio.setWest("Corridoio sinistra");
        corridoio.setEast("Corridoio destra");
        corridoio.setSouth("Appartamento");
        
        corridoio_sinistra.setEast("Corridoio");
        corridoio_sinistra.setNorth("Corridoio sinistra nord");
        corridoio_sinistra.setSouth("Corridoio sinistra sud");
        
        corridoio_destra.setWest("Corridoio");
        corridoio_destra.setNorth("Corridoio destra nord");
        corridoio_destra.setSouth("Corridoio destra sud");
        
        corridoio_sinistra_sud.setWest("Stanza 11");
        corridoio_sinistra_sud.setSouth("Stanza 12");
        corridoio_sinistra_sud.setEast("Stanza 13");
        corridoio_sinistra_sud.setNorth("Corridoio sinistra");
        
        corridoio_destra_sud.setWest("Stanza 21");
        corridoio_destra_sud.setSouth("Stanza 22");
        corridoio_destra_sud.setEast("Stanza 23");
        corridoio_destra_sud.setNorth("Corridoio destra");
        
        corridoio_destra_nord.setWest("Stanza 31");
        corridoio_destra_nord.setNorth("Stanza 32");
        corridoio_destra_nord.setEast("Stanza 33");
        corridoio_destra_nord.setSouth("Corridoio destra");
        
        corridoio_sinistra_nord.setWest("Stanza 41");
        corridoio_sinistra_nord.setNorth("Scale giu");
        corridoio_sinistra_nord.setEast("Stanza 43");
        corridoio_sinistra_nord.setSouth("Corridoio sinistra");
        
        stanza11.setEast("Corridoio sinistra sud");
        stanza12.setNorth("Corridoio sinistra sud");
        stanza13.setWest("Corridoio sinistra sud");
        stanza21.setEast("Corridoio destra sud");
        stanza22.setNorth("Corridoio destra sud");
        stanza23.setWest("Corridoio destra sud");
        stanza31.setWest("Corridoio destra nord");
        stanza32.setSouth("Corridoio destra nord");
        stanza33.setEast("Corridoio destra nord");
        stanza41.setEast("Corridoio sinistra nord");
        //stanza42.setSouth("Corridoio sinistra nord");
        stanza43.setWest("Corridoio sinistra nord");
                
        list.add(corridoio);
        list.add(corridoio_sinistra);
        list.add(corridoio_destra);
        list.add(corridoio_sinistra_nord);
        list.add(corridoio_destra_nord);
        list.add(corridoio_sinistra_sud);
        list.add(corridoio_destra_sud);
        list.add(stanza11);
        list.add(stanza12);
        list.add(stanza13);
        list.add(stanza21);
        list.add(stanza22);
        list.add(stanza23);
        list.add(stanza31);
        list.add(stanza32);
        list.add(stanza33);
        list.add(stanza41);
        list.add(stanza42);
        list.add(stanza43);
        list.add(appartamento);
        
        setList(list);
        setStanza(corridoio);
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
