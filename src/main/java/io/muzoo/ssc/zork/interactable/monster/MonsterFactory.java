package io.muzoo.ssc.zork.interactable.monster;

import io.muzoo.ssc.zork.interactable.Interactable;
import io.muzoo.ssc.zork.interactable.InteractableFactory;

public class MonsterFactory implements InteractableFactory {
    public Interactable get(String monsterName) {
        for (MonsterType monsterType: MonsterType.values()) {
            if (monsterType.getName().equals(monsterName))
                return new Monster(monsterType.getName(), monsterType.getDescription(), monsterType.getAttackDescription(), monsterType.getMaxHP(), monsterType.getAtk());
        }
        return null;
    }
}
