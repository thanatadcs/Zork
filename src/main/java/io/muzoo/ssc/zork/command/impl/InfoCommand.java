package io.muzoo.ssc.zork.command.impl;

import io.muzoo.ssc.zork.Game;
import io.muzoo.ssc.zork.Player;
import io.muzoo.ssc.zork.command.Command;
import io.muzoo.ssc.zork.interactable.Interactable;
import io.muzoo.ssc.zork.interactable.monster.Monster;
import io.muzoo.ssc.zork.room.Room;

import java.sql.SQLOutput;

public class InfoCommand implements Command {
    @Override
    public void execute(Game game, String argument) {
        if (argument != null) {
            System.out.println("Info what?");
            return ;
        }


        Room room = game.getCurrentRoom();
        Player player = game.getPlayer();
        System.out.printf("Player: HP=%d/%d ATK=%d\n", player.getHp(), player.getMaxHp(), player.getAtk());
        System.out.println("Inventory: " + player.getInventory());
        System.out.println("Location: " + room.getDescription());

        // Print thing in the room
        System.out.println("Environment:");
        for (Interactable it: room.getInteractableList()) {
            if (it.getType().equals("monster")) {
                // If monster is dead, show dead in front.
                Monster monster = (Monster) it;
                if (monster.isAlive())
                    System.out.printf((monster + ", hp: " + monster.getHp() + "\n"));
                else
                    System.out.printf(monster.toString() + "\n");
            } else {
                System.out.println(it + " (" +it.getType() + ")");
            }
        }
    }
}
