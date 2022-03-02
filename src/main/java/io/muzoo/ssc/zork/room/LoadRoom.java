package io.muzoo.ssc.zork.room;

import io.muzoo.ssc.zork.monster.Monster;
import io.muzoo.ssc.zork.monster.MonsterFactory;
import io.muzoo.ssc.zork.monster.MonsterType;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LoadRoom {

    public static Room load(String filepath) {
        Map<String, Room> roomMap = new HashMap<>();
        List<String> dirs = List.of("north", "south", "east", "west");

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

                // Add monster
                if (room[0].equals("monsters")) {
                    String[] monstersList = room[1].split(",");

                    for (String monsterSt: monstersList) {
                        Monster monster = MonsterFactory.get(monsterSt);
                        if (monster != null) roomMap.get(roomName).addMonster(monster);
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
