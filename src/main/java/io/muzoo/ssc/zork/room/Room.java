package io.muzoo.ssc.zork.room;

import io.muzoo.ssc.zork.item.Item;
import io.muzoo.ssc.zork.monster.Monster;
import io.muzoo.ssc.zork.weapon.Weapon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {
    private String description;

    private Map<String, Room> exits;

    private List<Weapon> weaponList;

    public List<Weapon> getWeaponList() {
        return weaponList;
    }

    public void addWeapon(Weapon weapon) {
        this.weaponList.add(weapon);
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void addItem(Item item) {
        this.itemList.add(item);
    }

    public List<Monster> getMonsterList() {
        return monsterList;
    }

    public void addMonster(Monster monster) {
        this.monsterList.add(monster);
    }

    private List<Item> itemList;

    private List<Monster> monsterList;

    public Room(String description) {
        this.description = description;
        exits = new HashMap<>();
        weaponList = new ArrayList<>();
        itemList = new ArrayList<>();
        monsterList = new ArrayList<>();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Room getExits(String direction) {
        return exits.get(direction);
    }

    public void setExits(String direction, Room room) {
        this.exits.put(direction, room);
    }

}
