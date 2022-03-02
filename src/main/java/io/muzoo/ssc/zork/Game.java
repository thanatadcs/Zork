package io.muzoo.ssc.zork;

import io.muzoo.ssc.zork.command.*;
import io.muzoo.ssc.zork.room.Room;
import io.muzoo.ssc.zork.room.impl.MyRoom;

import java.util.Scanner;

public class Game {

    private Scanner scanner = new Scanner(System.in);

    private boolean exit = false;

    private Room currentRoom = new MyRoom("I'm in my room.");

    // Call this to start game
    public void start() {
        System.out.println("Game started");

        // Main game loop
        // Parse and execute command
        while (!isExit() && scanner.hasNextLine()) {
            String rawInput = scanner.nextLine();
            CommandLine commandLine = CommandParser.parseCommand(rawInput);
            Command command = CommandFactory.get(commandLine.getCommandType());
            if (command == null) {
                System.out.println("Command not found");
            } else {
                command.execute(this, commandLine.getArgument());
            }
        }
    }

    // Getter Setter
    // Exit functionality
    public boolean isExit() {
        return exit;
    }

    public void exit() {
        this.exit = true;
        scanner.close();
    }

    // Room functionality
    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}
