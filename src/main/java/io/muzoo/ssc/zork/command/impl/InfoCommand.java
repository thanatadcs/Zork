package io.muzoo.ssc.zork.command.impl;

import io.muzoo.ssc.zork.Game;
import io.muzoo.ssc.zork.command.Command;
import io.muzoo.ssc.zork.interactable.Interactable;
import io.muzoo.ssc.zork.interactable.monster.Monster;
import io.muzoo.ssc.zork.room.Room;

public class InfoCommand implements Command {
    @Override
    public void execute(Game game, String argument) {
        if (argument != null) {
            System.out.println("Info what?");
            return ;
        }


        if (game.isGameStart()) {
            Room room = game.getCurrentRoom();
            System.out.println(room.getDescription());
            for (Interactable it: room.getInteractableList()) {
                if (it.getType().equals("monster")) {
                    // If monster is dead, show dead in front.
                    Monster monster = (Monster) it;
                    System.out.printf((monster.getName() + ", hp: " + monster.getHp() + ", engage: " + monster.isEngage()));
                    System.out.println();
                } else {
                    System.out.println(it);
                }
            }
        } else {
            System.out.println("play [map]");
            System.out.println("load [save file]");
        }
    }
}
