package io.muzoo.ssc.zork;

import io.muzoo.ssc.zork.interactable.Interactable;
import io.muzoo.ssc.zork.interactable.weapon.Weapon;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private int maxHp;

    private int hp;

    private int atk;

    private Weapon weapon;

    private List<Interactable> inventory;

    public Player(int maxHp, int atk, Weapon weapon) {
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.atk = atk;
        this.weapon = weapon;
        this.inventory = new ArrayList<>();
    }

    public List<Interactable> getInventory() {
        return inventory;
    }
}
