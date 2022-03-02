package io.muzoo.ssc.zork.interactable.item;

import io.muzoo.ssc.zork.interactable.Interactable;
import io.muzoo.ssc.zork.interactable.InteractableFactory;

public class ItemFactory implements InteractableFactory {
    public Interactable get(String itemName) {
        for (ItemType itemType: ItemType.values()) {
            if (itemType.match(itemName)) {
                return new Item(itemType.getName(), itemType.getDescription());
            }
        }
        return null;
    }
}
