package io.muzoo.ssc.zork.interactable.monster;

import io.muzoo.ssc.zork.interactable.Interactable;

public class Monster extends Interactable {

    private String attack;

    private int maxHp;

    private int hp;

    private int atk;

    public Monster(String name, String description, String attack, int maxHP, int atk) {
        super(name, description, "monster",false);
        this.attack = attack;
        this.maxHp = maxHP;
        this.atk = atk;
    }
}
