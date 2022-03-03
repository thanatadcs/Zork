package io.muzoo.ssc.zork;

import io.muzoo.ssc.zork.command.*;
import io.muzoo.ssc.zork.room.LoadRoom;
import io.muzoo.ssc.zork.room.Room;

import java.util.Collection;
import java.util.Map;
import java.util.Scanner;

public class Game {

    private Scanner scanner = new Scanner(System.in);

    private boolean exit = false;

    private Player player = new Player(5, 1);

    private Room currentRoom;

    private Collection<Room> allRooms;

    // Call this to start gameg
    public void start() {
        // Load map
        LoadRoom loadRoom = new LoadRoom("map.txt");
        currentRoom = loadRoom.getStartRoom();
        allRooms = loadRoom.getAllRooms();

        // Safety check
        if (currentRoom == null) {
            System.out.println("Failed to load map");
            exit();
        } else
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

    // Player support
    public Player getPlayer() {
        return player;
    }

    // Command support
    // Exit command
    public boolean isExit() {
        return exit;
    }

    public void exit() {
        this.exit = true;
        scanner.close();
    }

    // Go command
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    // Info command
    public Room getCurrentRoom() {
        return currentRoom;
    }

    // Save command
    public Collection<Room> getAllRooms() {
        return allRooms;
    }
}
