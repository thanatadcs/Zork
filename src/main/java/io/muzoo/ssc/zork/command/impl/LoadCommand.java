package io.muzoo.ssc.zork.command.impl;

import io.muzoo.ssc.zork.Game;
import io.muzoo.ssc.zork.command.Command;
import io.muzoo.ssc.zork.room.LoadFile;
import io.muzoo.ssc.zork.room.Room;

import java.util.Collection;

public class LoadCommand implements Command {
    @Override
    public void execute(Game game, String argument) {
        if (argument == null) {
            System.out.println("No saved point specify");
            return ;
        }

        if (game.isGameStart()) {
            System.out.println("Can't use while playing game");
            return ;
        }

        LoadFile loadFile = new LoadFile(game, argument);
        Room currentRoom = loadFile.getStartRoom();
        Collection<Room> allRooms = loadFile.getAllRooms();

        if (currentRoom == null || allRooms == null) {
            System.out.println("Can't load file");
            return ;
        } else {
            game.setCurrentRoom(currentRoom);
            game.setAllRooms(allRooms);
            game.setGameStart(true);
            System.out.println("Game started");
        }
    }
}
