package io.muzoo.ssc.zork.command.impl;

import io.muzoo.ssc.zork.Game;
import io.muzoo.ssc.zork.command.Command;
import io.muzoo.ssc.zork.interactable.Interactable;

import java.util.List;

public class TakeCommand implements Command {
    @Override
    public void execute(Game game, String argument) {
        if (argument == null) {
            System.out.println("take What?");
            return ;
        }

        boolean found = false;
        List<Interactable> interactableList = game.getCurrentRoom().getInteractableList();
        for (Interactable it: interactableList) {
            if (it.match(argument) && it.isPickable()) {
                game.getPlayer().getInventory().add(it);
                interactableList.remove(it);
                System.out.println("You put " + argument + " in your bag.");
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Take what?");
    }
}
