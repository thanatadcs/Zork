package io.muzoo.ssc.zork.weapon;

public class Weapon {

    private String name;

    private String description;

    private int damage;

    public Weapon(String name, String description, int damage) {
        this.name = name;
        this.description = description;
        this.damage = damage;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
