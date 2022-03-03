package io.muzoo.ssc.zork.interactable.monster;

import io.muzoo.ssc.zork.Player;
import io.muzoo.ssc.zork.interactable.Interactable;

public class Monster extends Interactable {

    private String attackDescription;

    private int maxHp;

    private int hp;

    private int atk;

    private boolean engage = false;

    public Monster(String name, String description, String attackDescription, int maxHP, int atk) {
        super(name, description, "monster",false);
        this.attackDescription = attackDescription;
        this.maxHp = maxHP;
        this.hp = maxHP;
        this.atk = atk;
    }

    public void attack(Player player) {
        System.out.println(this.attackDescription);
        player.takeDamage(this.atk);
    }

    public void takeDamage(int damage) {
        this.hp -= damage;
    }

    public boolean isAlive() {
        return this.hp > 0;
    }

    public boolean isEngage() {
        return engage;
    }

    public void setEngage(boolean engage) {
        this.engage = engage;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    @Override
    public String toString() {
        if (isAlive())
            return super.getName();
        else
            return "dead " + super.getName();
    }
}
