package io.muzoo.ssc.zork.interactable.monster;

import io.muzoo.ssc.zork.interactable.InteractableTypeInterface;

public enum MonsterType implements InteractableTypeInterface {
    LIZARDMAN("lizard man", "Normal lizard male", "attacked with a spear!", 2, 1);

    private String name;

    private String description;

    private String attack;

    private int maxHp;

    private int atk;

    MonsterType(String name, String description, String weapon, int maxHP, int attackPower) {
        this.name = name;
        this.attack = weapon;
        this.maxHp = maxHP;
        this.atk = attackPower;
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
        return maxHp;
    }

    public int getAtk() {
        return atk;
    }

    public Boolean match(String name) {
        return this.name.equals(name);
    }
}
