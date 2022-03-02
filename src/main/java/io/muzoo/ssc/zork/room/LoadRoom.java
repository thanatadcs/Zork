package io.muzoo.ssc.zork.room;

import io.muzoo.ssc.zork.interactable.Interactable;
import io.muzoo.ssc.zork.interactable.InteractableFactory;
import io.muzoo.ssc.zork.interactable.InteractableFactoryProducer;
import io.muzoo.ssc.zork.interactable.InteractableTypeInterface;
import io.muzoo.ssc.zork.interactable.InteractableTypeEnum;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class LoadRoom {

    public static Room load(String filepath) {
        Map<String, Room> roomMap = new HashMap<>();
        List<String> dirs = List.of("north", "south", "east", "west");
        InteractableTypeEnum[] allType = InteractableTypeEnum.values();
        // Generate rough map (String map)
        try {
            Scanner scanner = new Scanner(new File(filepath));
            String roomName = null;
            String startRoom = null; // Starting room is the first room
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(":");

                // Create new room if not exists
                if (line[0].equals("name")) {
                    roomName = line[1];
                    if (startRoom == null) startRoom = roomName;

                    if (roomMap.get(roomName) == null) roomMap.put(roomName, new Room(roomName));
                }

                // Add description to existing room
                if (line[0].equals("description")) {
                    roomMap.get(roomName).setDescription(line[1]);
                }

                for (InteractableTypeEnum type: allType) {
                    if (type.getType().equals(line[0])) {
                        addInteractable(roomMap, type, roomName, line);
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

            return roomMap.get(startRoom);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        return null;
    }

    private static void addInteractable(Map<String, Room> roomMap, InteractableTypeEnum type, String roomName, String[] line) {
        String[] interactableList = line[1].split(",");

        for (String interactableSt: interactableList) {

            // Determine which factory to use
            InteractableFactory itFactory = null;
            for (InteractableTypeInterface itType: type.getItTypeArray()) {
                if (itType.match(interactableSt)) {
                    itFactory = InteractableFactoryProducer.getFactory(type.getType());
                    break;
                }
            }


            // Add interactable to a room
            Interactable interact = itFactory.get(interactableSt);
            if (interact != null)
                roomMap.get(roomName).addInteractable(interact);
            else
                System.out.println("Can't add " + interactableSt);
        }
    }

}
