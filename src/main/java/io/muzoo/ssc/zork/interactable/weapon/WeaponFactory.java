package io.muzoo.ssc.zork.interactable.weapon;

import io.muzoo.ssc.zork.interactable.Interactable;
import io.muzoo.ssc.zork.interactable.InteractableFactory;

public class WeaponFactory implements InteractableFactory {
    public Interactable get(String weaponName) {
        for (WeaponType weaponType: WeaponType.values()) {
            if (weaponType.getName().equals(weaponName)) {
                return new Weapon(weaponType.getName(), weaponType.getDescription(), weaponType.getDamage());
            }
        }
        return null;
    }
}
