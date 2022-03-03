package io.muzoo.ssc.zork.interactable.weapon;

import io.muzoo.ssc.zork.interactable.Interactable;

public class Weapon extends Interactable {

    private int atk;

    public Weapon(String name, String description, int atk) {
        super(name, description, "weapon",true);
        this.atk = atk;
    }

    public int getAtk() {
        return atk;
    }
}
