
package com.gioco_1;

import com.gioco_1.parser.ParserOutput;
import com.gioco_1.type.Command;
import com.gioco_1.type.Room;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public abstract class GameDescription {

    private List<Room> rooms = new ArrayList<>();

    private final List<Command> commands = new ArrayList<>();

    private Room currentRoom;

    public List<Room> getRooms() {
        return rooms;
    }
    
    public void setRooms(List<Room> r){
        rooms = r;
    }
    
    public void addRooms(Room r){
        rooms.add(r);
    }

    public List<Command> getCommands() {
        return commands;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public abstract void init() throws Exception;

    public abstract void nextMove(ParserOutput p, PrintStream out);

}
