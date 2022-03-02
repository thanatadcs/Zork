package io.muzoo.ssc.zork.interactable.monster;

import io.muzoo.ssc.zork.interactable.InteractableType;

public enum MonsterType implements InteractableType {
    LIZARDMAN("lizard man", "Normal lizard male", "attacked with a spear!", 2, 1);

    private String name;

    private String description;

    private String attack;

    private int maxHP;

    private int attackPower;

    MonsterType(String name, String description, String weapon, int maxHP, int attackPower) {
        this.name = name;
        this.attack = weapon;
        this.maxHP = maxHP;
        this.attackPower = attackPower;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAttack() {
        return attack;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public Boolean match(String name) {
        return this.name.equals(name);
    }
}
