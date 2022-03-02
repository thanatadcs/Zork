package io.muzoo.ssc.zork.command.impl;

import io.muzoo.ssc.zork.Game;
import io.muzoo.ssc.zork.Player;
import io.muzoo.ssc.zork.command.Command;
import io.muzoo.ssc.zork.interactable.Interactable;
import io.muzoo.ssc.zork.interactable.item.Item;
import io.muzoo.ssc.zork.room.Room;

import java.util.List;

public class UseCommand implements Command {
    @Override
    public void execute(Game game, String argument) {
        if (argument == null) System.out.println("use what?");

        Player player = game.getPlayer();
        List<Interactable> inventory =  player.getInventory();

        for (Interactable it: inventory) {
            if (it.match(argument) && it.getType().equals("item")) {
                Item item = (Item) it;
                System.out.println(item.getEffect());

                if (item.isConsumable()) inventory.remove(item);

                return ;
            }
        }
        System.out.println("You don't have that.");
    }
}
