package io.muzoo.ssc.zork.interactable;

import io.muzoo.ssc.zork.interactable.monster.MonsterFactory;
import io.muzoo.ssc.zork.interactable.weapon.WeaponFactory;

public class InteractableFactoryProducer {
    public static InteractableFactory getFactory(String type) {
        for (InteractableTypeEnum itTypeEnum: InteractableTypeEnum.values()) {
            if (itTypeEnum.getType().equals(type)) return itTypeEnum.getFactory();
        }
        return null;
    }
}
