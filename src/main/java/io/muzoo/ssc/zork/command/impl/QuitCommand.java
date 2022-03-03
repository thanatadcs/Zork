package io.muzoo.ssc.zork.command.impl;

import io.muzoo.ssc.zork.Game;
import io.muzoo.ssc.zork.command.Command;

public class QuitCommand implements Command {
    @Override
    public void execute(Game game, String argument) {
        if (!game.isGameStart()) {
            System.out.println("Can quit only while playing game");
            return ;
        }

        game.setGameStart(false);
    }
}
