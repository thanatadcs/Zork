package io.muzoo.ssc.zork.interactable.monster;

import io.muzoo.ssc.zork.interactable.Interactable;
import io.muzoo.ssc.zork.interactable.weapon.Weapon;

public class Monster extends Interactable {

    private String attack;

    private int maxHP;

    private int HP;

    private int attackPower;

    public Monster(String name, String description, String attack, int maxHP, int attackPower) {
        super(name, description);
        this.attack = attack;
        this.maxHP = maxHP;
        this.attackPower = attackPower;
    }
}
