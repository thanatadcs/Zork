package io.muzoo.ssc.zork.command.impl;

import io.muzoo.ssc.zork.Game;
import io.muzoo.ssc.zork.command.Command;
import io.muzoo.ssc.zork.room.LoadRoom;
import io.muzoo.ssc.zork.room.Room;

import java.util.Collection;

public class PlayCommand implements Command {
    @Override
    public void execute(Game game, String argument) {
        if (argument == null) {
            System.out.println("No map specify");
            return ;
        }

        LoadRoom loadRoom = new LoadRoom(argument);
        Room currentRoom = loadRoom.getStartRoom();
        Collection<Room> allRooms = loadRoom.getAllRooms();

        if (currentRoom == null || allRooms == null) {
            System.out.println("Failed to load map");
            return ;
        } else {
            game.setCurrentRoom(currentRoom);
            game.setAllRooms(allRooms);
            game.setGameStart(true);
            System.out.println("Game started");
        }
    }
}
