package io.muzoo.ssc.zork;

import io.muzoo.ssc.zork.command.*;
import io.muzoo.ssc.zork.interactable.Interactable;
import io.muzoo.ssc.zork.interactable.monster.Monster;
import io.muzoo.ssc.zork.room.LoadRoom;
import io.muzoo.ssc.zork.room.Room;

import java.util.Collection;
import java.util.Map;
import java.util.Scanner;

public class Game {

    private Scanner scanner = new Scanner(System.in);

    private boolean exit = false;

    private Player player = new Player(5, 1); // Default player stat

    private Room currentRoom = null;

    private Collection<Room> allRooms = null;

    private boolean gameStart = false;

    // Call this to start gameg
    public void start() {
//        // Load map
//        LoadRoom loadRoom = new LoadRoom("map.txt");
//        currentRoom = loadRoom.getStartRoom();
//        allRooms = loadRoom.getAllRooms();
//
//        // Safety check
//        if (currentRoom == null) {
//            System.out.println("Failed to load map");
//            exit();
//        } else
//            System.out.println("Game started");

        // Main game loop
        // Parse and execute command
        while (!isExit() && scanner.hasNextLine()) {
            String rawInput = scanner.nextLine();
            CommandLine commandLine = CommandParser.parseCommand(rawInput);
            Command command = CommandFactory.get(commandLine.getCommandType());
            if (command == null) {
                // Command not found
                System.out.println("Command not found");
            } else if (isGameStart()) {
                // Command while playing the game
                command.execute(this, commandLine.getArgument());
                hitPlayer();
            } else if (
                    commandLine.getCommandType().match("play") ||
                    commandLine.getCommandType().match("load") ||
                    commandLine.getCommandType().match("info")
            ) {
                // Before starting the game
                // Only play and load command is available
                // This is to choose map or safe point
                command.execute(this, commandLine.getArgument());
            } else {
                // Show info if no valid command being enter
                CommandFactory.get(CommandType.INFO).execute(this, null);
            }
        }
    }

    // Monster support
    public void hitPlayer() {
        // Check for monster
        Room room = getCurrentRoom();
        Monster monster = null;
        for (Interactable it: room.getInteractableList()) {
            if (it.getType().equals("monster")) {
                monster = (Monster) it;

                if (monster.isAlive() && monster.isEngage()){
                    monster.attack(getPlayer());
                }

                if (!getPlayer().isAlive()) {
                    System.out.println("You are dead!");
                    exit();
                }
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

    // Play command and Load command
    public void setAllRooms(Collection<Room> allRooms) {
        this.allRooms = allRooms;
    }

    public boolean isGameStart() {
        return gameStart;
    }

    public void setGameStart(boolean gameStart) {
        this.gameStart = gameStart;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
