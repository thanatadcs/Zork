package io.muzoo.ssc.zork;

import io.muzoo.ssc.zork.interactable.Interactable;
import io.muzoo.ssc.zork.interactable.monster.Monster;
import io.muzoo.ssc.zork.interactable.weapon.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {

    private int maxHp;

    private int hp;

    private int atk;

    private List<Interactable> inventory;

    private Random random = new Random();

    public Player(int maxHp, int atk) {
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.atk = atk;
        this.inventory = new ArrayList<>();
    }

    public List<Interactable> getInventory() {
        return inventory;
    }

    public void attack(Monster monster, Weapon weapon) {
        int damage = random.nextInt(this.atk + weapon.getAtk() + 1);
        if (damage <= 0)
            System.out.println("Your attack missed!");
        else {
            System.out.println("You attacked " + monster.getName() + " with " + weapon.getName());
            monster.takeDamage(damage);
        }
    }


    public void takeDamage(int damage) {
        this.hp -= damage;
    }

    public boolean isAlive() {
        return this.hp >= 0;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void increastAtk(int atk) {
        this.atk += atk;
    }

    public void heal(int n) {
        int newHp = this.hp + n;
        if (newHp > maxHp)
            this.hp = maxHp;
        else
            this.hp = newHp;
    }

    public int getAtk() {
        return atk;
    }

    public void setInventory(List<Interactable> inventory) {
        this.inventory = inventory;
    }
}
