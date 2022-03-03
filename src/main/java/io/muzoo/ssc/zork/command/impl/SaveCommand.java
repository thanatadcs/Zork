package io.muzoo.ssc.zork.command.impl;

import io.muzoo.ssc.zork.Game;
import io.muzoo.ssc.zork.Player;
import io.muzoo.ssc.zork.command.Command;
import io.muzoo.ssc.zork.interactable.Interactable;
import io.muzoo.ssc.zork.interactable.monster.Monster;
import io.muzoo.ssc.zork.room.Room;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;

public class SaveCommand implements Command {
    @Override
    public void execute(Game game, String argument) {
        if (argument == null) {
            System.out.println("Please specify safe point");
            return ;
        }

        Player player = game.getPlayer();
        Room currentRoom = game.getCurrentRoom();
        Map<String, Room> roomMap = game.getRoomMap();
        try (FileWriter writer = new FileWriter(argument)) {
            StringBuilder weaponSt = new StringBuilder("weapon:");
            StringBuilder itemSt = new StringBuilder("item:");

            // Save player data
            writer.write("player\n");
            writer.write("hp:" + player.getHp() + "\n");
            for (Interactable it: player.getInventory()) {
                switch(it.getType()) {
                    case "weapon":
                        weaponSt.append(it.getName() + ",");
                        break;
                    case "item":
                        itemSt.append(it.getName() + ",");
                        break;
                }
            }
            if (weaponSt.length() > 8) writer.write(weaponSt.toString() + "\n");
            if (itemSt.length() > 5) writer.write(itemSt.toString() + "\n");
            writer.write("end\n");

            weaponSt = new StringBuilder("weapon:");
            itemSt = new StringBuilder("item:");
            StringBuilder monsterSt = new StringBuilder("monster:");
            // Save map state
            writer.write("map\n");
            writer.write("start:" + currentRoom.getName() + "\n");
            for (String roomName: roomMap.keySet()) {
                writer.write("name:" + roomName + "\n");
                Room room = roomMap.get(roomName);
                writer.write("description:" + room.getDescription() + "\n");
                for (Interactable it: room.getInteractableList()) {
                    switch(it.getType()) {
                        case "weapon":
                            weaponSt.append(it.getName() + ",");
                            break;
                        case "item":
                            itemSt.append(it.getName() + ",");
                            break;
                        case "monster":
                            Monster monster = (Monster) it;
                            monsterSt.append(it.getName() + "/hp=" + monster.getHp() + "/engage=" + monster.isEngage() + ",");
                            break;
                    }
                }
                if (weaponSt.length() > 8) writer.write(weaponSt.toString() + "\n");
                if (itemSt.length() > 5) writer.write(itemSt.toString() + "\n");
                if (monsterSt.length() > 9) writer.write(monsterSt.toString() + "\n");

                for (String dir: room.getExitsMap().keySet()) {
                    writer.write(dir + ":" + room.getExits(dir).getName() + "\n");
                }
            }
            writer.write("end\n");
        } catch (IOException e) {
            System.out.println("Error when writing save file");
        }
    }
}
