package io.muzoo.ssc.zork.command.impl;

import io.muzoo.ssc.zork.Game;
import io.muzoo.ssc.zork.command.Command;
import io.muzoo.ssc.zork.interactable.Interactable;
import io.muzoo.ssc.zork.room.Room;

public class InfoCommand implements Command {
    @Override
    public void execute(Game game, String argument) {
        if (argument != null) {
            System.out.println("Info what?");
        } else {
            Room room = game.getCurrentRoom();
            System.out.println(room.getDescription());
            for (Interactable it: room.getInteractableList()) {
                System.out.println(it);
            }
        }
    }
}
