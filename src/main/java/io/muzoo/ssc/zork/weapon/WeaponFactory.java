package io.muzoo.ssc.zork.weapon;

public class WeaponFactory {
    public static Weapon get(String weaponName) {
        for (WeaponType weaponType: WeaponType.values()) {
            if (weaponType.getName().equals(weaponName)) {
                return new Weapon(weaponType.getName(), weaponType.getDescription(), weaponType.getDamage());
            }
        }
        return null;
    }
}
