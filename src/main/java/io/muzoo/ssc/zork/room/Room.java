package io.muzoo.ssc.zork.room;

import java.util.HashMap;
import java.util.Map;

public class Room {
    private String description;

    private Map<String, Room> exits;

    public Room(String description) {
        this.description = description;
        exits = new HashMap<>();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Room getExits(String direction) {
        return exits.get(direction);
    }

    public void setExits(String direction, Room room) {
        this.exits.put(direction, room);
    }

}