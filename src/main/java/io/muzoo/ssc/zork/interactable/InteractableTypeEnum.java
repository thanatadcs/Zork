package io.muzoo.ssc.zork.interactable;

import io.muzoo.ssc.zork.interactable.item.ItemFactory;
import io.muzoo.ssc.zork.interactable.item.ItemType;
import io.muzoo.ssc.zork.interactable.monster.MonsterFactory;
import io.muzoo.ssc.zork.interactable.monster.MonsterType;
import io.muzoo.ssc.zork.interactable.weapon.WeaponFactory;
import io.muzoo.ssc.zork.interactable.weapon.WeaponType;

public enum InteractableTypeEnum {
    WEAPON(WeaponType.values(), "weapon", new WeaponFactory()),
    MONSTER(MonsterType.values(), "monster", new MonsterFactory()),
    ITEM(ItemType.values(), "item", new ItemFactory());

    private InteractableTypeInterface[] itTypeArray;

    private InteractableFactory factory;

    private String type;

    InteractableTypeEnum(InteractableTypeInterface[] itTypeArray, String type, InteractableFactory factory) {
        this.itTypeArray = itTypeArray;
        this.type = type;
        this.factory = factory;
    }

    public String getType() {
        return type;
    }

    public InteractableTypeInterface[] getItTypeArray() {
        return itTypeArray;
    }

    public InteractableFactory getFactory() {
        return factory;
    }
}
