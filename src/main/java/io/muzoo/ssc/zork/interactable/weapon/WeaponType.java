package io.muzoo.ssc.zork.interactable.weapon;

import io.muzoo.ssc.zork.interactable.InteractableTypeInterface;

public enum WeaponType implements InteractableTypeInterface {
    SPOON("spoon", "You eat soup with this.", 1);

    private String name;

    private String description;

    private int damage;

    WeaponType(String name, String description, int damage) {
        this.name = name;
        this.description = description;
        this.damage = damage;
    }

    public Boolean match(String name) {
        return this.name.equals(name);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getDamage() {
        return damage;
    }
}
