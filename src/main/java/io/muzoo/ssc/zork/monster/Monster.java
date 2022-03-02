package io.muzoo.ssc.zork.monster;

import io.muzoo.ssc.zork.weapon.Weapon;

public class Monster {

    private String name;

    private Weapon weapon;

    private int maxHP;

    private int HP;

    private int attackPower;

    public Monster(String name, Weapon weapon, int maxHP, int attackPower) {
        this.name = name;
        this.weapon = weapon;
        this.maxHP = maxHP;
        this.attackPower = attackPower;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
