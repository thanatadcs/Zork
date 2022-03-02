package io.muzoo.ssc.zork.weapon;

public enum WeaponType {
    SPOON("spoon", "You eat soup with this.", 1);

    private String name;

    private String description;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getDamage() {
        return damage;
    }

    private int damage;

    WeaponType(String name, String description, int damage) {
        this.name = name;
        this.description = description;
        this.damage = damage;
    }
}
