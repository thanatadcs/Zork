package io.muzoo.ssc.zork.monster;

import io.muzoo.ssc.zork.weapon.Weapon;

public enum MonsterType {
    LIZARDMAN("lizard man", null, 2, 1);

    private String name;

    private Weapon weapon;

    private int maxHP;

    private int attackPower;

    MonsterType(String name, Weapon weapon, int maxHP, int attackPower) {
        this.name = name;
        this.weapon = weapon;
        this.maxHP = maxHP;
        this.attackPower = attackPower;
    }

    public String getName() {
        return name;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getAttackPower() {
        return attackPower;
    }
}
