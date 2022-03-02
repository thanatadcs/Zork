package io.muzoo.ssc.zork.command.impl;

import io.muzoo.ssc.zork.Game;
import io.muzoo.ssc.zork.command.Command;

public class ExitCommand implements Command {
    @Override
    public void execute(Game game, String argument) {
        if (argument != null) {
            System.out.println("Quit what?");
        } else {
            System.out.println("Goodbye");
            game.exit();
        }
    }
}
