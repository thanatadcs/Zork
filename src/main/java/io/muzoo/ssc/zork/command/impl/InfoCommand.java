package io.muzoo.ssc.zork.command.impl;

import io.muzoo.ssc.zork.Game;
import io.muzoo.ssc.zork.command.Command;
import io.muzoo.ssc.zork.monster.Monster;
import io.muzoo.ssc.zork.room.Room;
import io.muzoo.ssc.zork.weapon.Weapon;

public class InfoCommand implements Command {
    @Override
    public void execute(Game game, String argument) {
        if (argument != null) {
            System.out.println("Info what?");
        } else {
            Room room = game.getCurrentRoom();
            System.out.println(room.getDescription());
            for (Monster monster: room.getMonsterList()) {
                System.out.println(monster);
            }
            for (Weapon weapon: room.getWeaponList()) {
                System.out.println(weapon);
            }
        }
    }
}
