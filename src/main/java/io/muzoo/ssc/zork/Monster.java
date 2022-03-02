package io.muzoo.ssc.zork;

public class Monster {

    private String name;

    private Weapon weapon;

    private int maxHP;

    private int HP;

    private int attackPower;

    public Monster(String name, Weapon weapon, int maxHP, int HP, int attackPower) {
        this.name = name;
        this.weapon = weapon;
        this.maxHP = maxHP;
        this.HP = HP;
        this.attackPower = attackPower;
    }
}
