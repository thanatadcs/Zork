package io.muzoo.ssc.zork.interactable.item;

import io.muzoo.ssc.zork.interactable.Interactable;

public class Item extends Interactable {

    private String effect;

    private boolean consumable;

    public Item(String name, String description, String effect, boolean consumable) {
        super(name, description, "item",true);
        this.effect = effect;
        this.consumable = consumable;
    }

    public String getEffect() {
        return effect;
    }

    public boolean isConsumable() {
        return consumable;
    }
}
