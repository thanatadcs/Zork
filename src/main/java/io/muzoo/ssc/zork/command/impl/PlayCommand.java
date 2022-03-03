package io.muzoo.ssc.zork.command.impl;

import io.muzoo.ssc.zork.Game;
import io.muzoo.ssc.zork.command.Command;
import io.muzoo.ssc.zork.room.LoadFile;
import io.muzoo.ssc.zork.room.Room;

import java.util.Map;

public class PlayCommand implements Command {
    @Override
    public void execute(Game game, String argument) {
        if (game.isGameStart()) {
            System.out.println("Can't use while playing game");
            return ;
        }

        if (argument == null) {
            System.out.println("No map specify");
            return ;
        }

        LoadFile loadFile = new LoadFile(game, argument);
        Room currentRoom = loadFile.getStartRoom();
        Map<String, Room> roomMap = loadFile.getRoomMap();

        if (currentRoom == null || roomMap == null) {
            System.out.println("Failed to load map");
            return ;
        } else {
            game.setCurrentRoom(currentRoom);
            game.setRoomMap(roomMap);
            game.setGameStart(true);
            game.setMonsterNum(loadFile.getMonsterNum());
            System.out.println("Game started");
        }
    }
}
