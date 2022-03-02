package io.muzoo.ssc.zork.room;

import io.muzoo.ssc.zork.interactable.Interactable;
import io.muzoo.ssc.zork.interactable.InteractableFactory;
import io.muzoo.ssc.zork.interactable.InteractableFactoryProducer;
import io.muzoo.ssc.zork.interactable.InteractableType;
import io.muzoo.ssc.zork.interactable.monster.Monster;
import io.muzoo.ssc.zork.interactable.monster.MonsterFactory;
import io.muzoo.ssc.zork.interactable.monster.MonsterType;
import io.muzoo.ssc.zork.interactable.weapon.Weapon;
import io.muzoo.ssc.zork.interactable.weapon.WeaponFactory;
import io.muzoo.ssc.zork.interactable.weapon.WeaponType;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class LoadRoom {

    public static Room load(String filepath) {
        Map<String, Room> roomMap = new HashMap<>();
        List<String> dirs = List.of("north", "south", "east", "west");
        List<String> interactables = List.of("monsters", "weapons", "items");
        List<InteractableType[]> itTypeList = List.of(WeaponType.values(), MonsterType.values());

        // Generate rough map (String map)
        try {
            Scanner scanner = new Scanner(new File(filepath));
            String roomName = null;
            String startRoom = null; // Starting room is the first room
            while (scanner.hasNextLine()) {
                String[] room = scanner.nextLine().split(":");

                // Create new room if not exists
                if (room[0].equals("name")) {
                    roomName = room[1];
                    if (startRoom == null) startRoom = roomName;

                    if (roomMap.get(roomName) == null) roomMap.put(roomName, new Room(roomName));
                }

                // Add description to existing room
                if (room[0].equals("description")) {
                    roomMap.get(roomName).setDescription(room[1]);
                }

                if (interactables.contains(room[0])) {
                    String[] interactableList = room[1].split(",");

                    for (String interactableSt: interactableList) {

                        // Determine which factory to use
                        InteractableFactory itFactory = null;
                        for (InteractableType[] itTypeArray: itTypeList) {
                            for (InteractableType itType: itTypeArray) {
                                if (itType.match(interactableSt)) {
                                    itFactory = InteractableFactoryProducer.getFactory(itType.getType());
                                    break;
                                }
                            }
                            if (itFactory != null) break;
                        }


                        Interactable interact = itFactory.get(interactableSt);
                        if (interact != null)
                            roomMap.get(roomName).addInteractable(interact);
                        else
                            System.out.println("Can't add " + interactableSt);
                    }
                }


                // Add exits to exiting room and create adjacent room if necessary.
                if (dirs.contains(room[0])) {
                    String dir = room[0];
                    String adjRoom = room[1];

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
}
