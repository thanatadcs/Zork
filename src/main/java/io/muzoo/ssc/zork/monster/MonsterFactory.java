package io.muzoo.ssc.zork.monster;

public class MonsterFactory {
    public static Monster get(String monsterName) {
        for (MonsterType monsterType: MonsterType.values()) {
            if (monsterType.getName().equals(monsterName))
                return new Monster(monsterType.getName(), monsterType.getWeapon(), monsterType.getMaxHP(), monsterType.getAttackPower());
        }
        return null;
    }
}
