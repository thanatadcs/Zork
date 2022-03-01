package io.muzoo.ssc.zork;

import io.muzoo.ssc.zork.command.ExitCommand;

import java.util.Scanner;

public class Game {

    private Scanner scanner = new Scanner(System.in);

    private boolean exit = false;

    public boolean isExit() {
        return exit;
    }

    public void exit() {
        this.exit = true;
        scanner.close();
    }

    public void start() {
        System.out.println("Game started");

        while (!isExit() && scanner.hasNextLine()) {
            String rawInput = scanner.nextLine();
            System.out.println(rawInput);

            ExitCommand exitCommand = new ExitCommand();
            exitCommand.execute(this);
        }
        scanner.close();
    }
}
