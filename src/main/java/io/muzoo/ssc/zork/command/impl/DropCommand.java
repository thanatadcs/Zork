package io.muzoo.ssc.zork.command.impl;

import io.muzoo.ssc.zork.Game;
import io.muzoo.ssc.zork.command.Command;
import io.muzoo.ssc.zork.interactable.Interactable;
import io.muzoo.ssc.zork.room.Room;

import java.util.List;

public class DropCommand implements Command {
    @Override
    public void execute(Game game, String argument) {
        if (argument == null) {
            System.out.println("drop what?");
            return ;
        }

        Room room = game.getCurrentRoom();
        List<Interactable> inventory = game.getPlayer().getInventory();
        for (Interactable it: inventory) {
            if (it.match(argument)) {
                inventory.remove(it);
                room.getInteractableList().add(it);
                System.out.println("You dropped " + argument + ".");
                return ;
            }
        }

        System.out.println("drop what?");
    }
}
