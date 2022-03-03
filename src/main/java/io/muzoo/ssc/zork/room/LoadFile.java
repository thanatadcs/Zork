package io.muzoo.ssc.zork.room;

import io.muzoo.ssc.zork.Game;
import io.muzoo.ssc.zork.interactable.Interactable;
import io.muzoo.ssc.zork.interactable.InteractableFactory;
import io.muzoo.ssc.zork.interactable.InteractableFactoryProducer;
import io.muzoo.ssc.zork.interactable.InteractableTypeInterface;
import io.muzoo.ssc.zork.interactable.InteractableTypeEnum;
import io.muzoo.ssc.zork.interactable.monster.Monster;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class LoadFile {

    private Game game;
    private Map<String, Room> roomMap;
    private String startRoom; // Starting room is the first room
    List<String> dirs = List.of("north", "south", "east", "west");
    InteractableTypeEnum[] allType = InteractableTypeEnum.values();

    public LoadFile(Game game, String filepath) {
        this.game = game;
        roomMap = new HashMap<>();
        startRoom = null;
        load(filepath);
    }

    public void load(String filepath) {
        // Generate rough map (String map)
        try {
            Scanner scanner = new Scanner(new File(filepath));
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(":");


                if (line[0].equals("player")) {
                    loadPlayer(scanner);
                }

                if (line[0].equals("map")) {
                    generateMap(scanner);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

    }

    private void loadPlayer(Scanner scanner) {
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(":");

            if (line[0].equals("end")) break;

            if (line[0].equals("hp")) {
                game.getPlayer().setHp(Integer.parseInt(line[1]));
            }

            for (InteractableTypeEnum type : allType) {
                if (type.getType().equals(line[0])) {
                    addInteractableToPlayerOrRoom(type, null, line, true);
                }
            }
        }
    }

    private void generateMap(Scanner scanner) {
        String roomName = null;

        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(":");

            if (line[0].equals("end")) break;

            // Generate map for the game
            if (line[0].equals("start")) {
                if (startRoom == null) startRoom = line[1];
            }

            // Create new room if not exists
            if (line[0].equals("name")) {
                roomName = line[1];

                if (roomMap.get(roomName) == null) roomMap.put(roomName, new Room(roomName));
            }

            // Add description to existing room
            if (line[0].equals("description")) {
                roomMap.get(roomName).setDescription(line[1]);
            }

            for (InteractableTypeEnum type : allType) {
                if (type.getType().equals(line[0])) {
                    addInteractableToPlayerOrRoom(type, roomName, line, false);
                }
            }

            // Add exits to exiting room and create adjacent room if necessary.
            if (dirs.contains(line[0])) {
                String dir = line[0];
                String adjRoom = line[1];

                if (roomMap.get(adjRoom) == null) roomMap.put(adjRoom, new Room(adjRoom));

                roomMap.get(roomName).setExits(dir, roomMap.get(adjRoom));
            }
        }
    }

    private void addInteractableToPlayerOrRoom(InteractableTypeEnum type, String roomName, String[] line, boolean addToPlayer) {
        String[] interactableList = line[1].split(",");

        for (String interactableSt: interactableList) {

            String[] intWithAttr = interactableSt.split("/");

            // Determine which factory to use
            InteractableFactory itFactory = null;
            for (InteractableTypeInterface itType: type.getItTypeArray()) {
                if (itType.match(intWithAttr[0])) {
                    itFactory = InteractableFactoryProducer.getFactory(type.getType());
                    break;
                }
            }

            Interactable interact = itFactory.get(intWithAttr[0]);
            if (intWithAttr.length > 1) {
                Monster monster = (Monster) interact;
                for (int i=1;i<intWithAttr.length;i++) {
                    String[] attr = intWithAttr[i].split("=");
                    String attrName = attr[0];
                    String attrValue = attr[1];
                    if (attrName.equals("hp"))
                        monster.setHp(Integer.parseInt(attr[1]));
                    else if (attrName.equals("engage"))
                        monster.setEngage(Boolean.parseBoolean(attr[1]));
                }
            }

            // Add interactable to a room/player
            if (interact != null)
                if (addToPlayer)
                    game.getPlayer().getInventory().add(interact);
                else
                    roomMap.get(roomName).addInteractable(interact);
            else
                System.out.println("Can't add " + interactableSt);
        }
    }

    public Room getStartRoom() {
        return this.roomMap.get(startRoom);
    }

    public Collection<Room> getAllRooms() {
        return roomMap.values();
    }
}
