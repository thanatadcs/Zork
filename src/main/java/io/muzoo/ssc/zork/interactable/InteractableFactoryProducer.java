package io.muzoo.ssc.zork.interactable;

import io.muzoo.ssc.zork.interactable.monster.Monster;
import io.muzoo.ssc.zork.interactable.monster.MonsterFactory;
import io.muzoo.ssc.zork.interactable.weapon.WeaponFactory;

public class InteractableFactoryProducer {
    public static InteractableFactory getFactory(String type) {
        if (type.equals("weapon")) return new WeaponFactory();
        if (type.equals("monster")) return new MonsterFactory();
        return null;
    }
}
