package io.muzoo.ssc.zork.command.impl;

import io.muzoo.ssc.zork.Game;
import io.muzoo.ssc.zork.Player;
import io.muzoo.ssc.zork.command.Command;
import io.muzoo.ssc.zork.interactable.Interactable;
import io.muzoo.ssc.zork.interactable.monster.Monster;
import io.muzoo.ssc.zork.interactable.weapon.Weapon;
import io.muzoo.ssc.zork.room.Room;

public class AttackWithCommand implements Command {
    @Override
    public void execute(Game game, String argument) {
        if (argument == null) {
            System.out.println("attack with what?");
            return ;
        }

        // Check if weapon is available
        Player player = game.getPlayer();
        Weapon weapon = null;
        for (Interactable inv: player.getInventory()) {
            if (inv.match(argument)) {
                weapon = (Weapon) inv;
            }
        }
        if (weapon == null) {
            System.out.println("You don't have that.");
            return ;
        }

        // Check for monster
        Room room = game.getCurrentRoom();
        Monster monster = null;
        for (Interactable it: room.getInteractableList()) {
            if (it.getType().equals("monster")) {
                monster = (Monster) it;
                player.attack(monster, weapon);

                if (!monster.isAlive()) {
                    System.out.println(monster.getName() + " is dead.");
                    monster.setName("dead " + monster.getName());
                }
            }
        }

        if (monster == null) {
            System.out.println("No monster to attack");
            return ;
        }
    }
}
