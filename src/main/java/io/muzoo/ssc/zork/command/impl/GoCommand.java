package io.muzoo.ssc.zork.command.impl;

import io.muzoo.ssc.zork.Game;
import io.muzoo.ssc.zork.Player;
import io.muzoo.ssc.zork.command.Command;
import io.muzoo.ssc.zork.room.Room;

public class GoCommand implements Command {
    @Override
    public void execute(Game game, String argument) {
        Room nextRoom = game.getCurrentRoom().getExits(argument);
        Player player = game.getPlayer();
        if (nextRoom == null) {
            System.out.println("Nowhere to go");
        } else {
            game.setCurrentRoom(nextRoom);
            // Increment hp
            player.heal(1);
        }
    }
}
