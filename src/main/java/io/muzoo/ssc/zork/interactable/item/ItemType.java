package io.muzoo.ssc.zork.interactable.item;

import io.muzoo.ssc.zork.interactable.InteractableTypeInterface;

public enum ItemType implements InteractableTypeInterface {
    POTION(
            "potion",
            "Taste like medicine",
            "You drink the potion. Nothing interesting happen.",
            true
    ),
    MUG(
            "mug",
            "Your everyday mug",
            "There is nothing in the mug.",
            false
    );

    private String name;

    private String description;

    private String effect;

    private boolean consumable;

    ItemType(String name, String description, String effect, boolean consumable) {
        this.name = name;
        this.description = description;
        this.effect = effect;
        this.consumable = consumable;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getEffect() {
        return effect;
    }

    public boolean isConsumable() {
        return consumable;
    }

    @Override
    public Boolean match(String name) {
        return this.name.equals(name);
    }
}
