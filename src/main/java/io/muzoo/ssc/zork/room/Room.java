package io.muzoo.ssc.zork.room;

import io.muzoo.ssc.zork.interactable.Interactable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {
    private String description;

    private Map<String, Room> exits;

    private List<Interactable> interactableList;

    public Room(String description) {
        this.description = description;
        exits = new HashMap<>();
        interactableList = new ArrayList<>();
    }

    public List<Interactable> getInteractableList() {
        return interactableList;
    }

    public void addInteractable(Interactable it) {
        this.interactableList.add(it);
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
