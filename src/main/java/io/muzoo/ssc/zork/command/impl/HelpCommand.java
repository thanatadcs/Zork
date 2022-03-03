package io.muzoo.ssc.zork.command.impl;

import io.muzoo.ssc.zork.Game;
import io.muzoo.ssc.zork.command.Command;

public class HelpCommand implements Command {
    @Override
    public void execute(Game game, String argument) {
        if (game.isGameStart()) {
            System.out.println("take [weapon|item]");
            System.out.println("use [item]");
            System.out.println("drop [weapon|item]");
            System.out.println("attack with [weapon]");
            System.out.println("go [north|south|east|west]");
            System.out.println("quit (end current game)");
            System.out.println("exit (exit the game)");
        } else {
            System.out.println("play [map file]");
            System.out.println("load [save file]");
        }
    }
}
