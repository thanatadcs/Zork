package io.muzoo.ssc.zork.interactable.weapon;

import io.muzoo.ssc.zork.interactable.Interactable;

public class Weapon extends Interactable {

    private int damage;

    public Weapon(String name, String description, int damage) {
        super(name, description, "weapon",true);
        this.damage = damage;
    }
}
