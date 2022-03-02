package io.muzoo.ssc.zork.interactable.item;

import io.muzoo.ssc.zork.interactable.InteractableType;

public enum ItemType implements InteractableType {
    POTION("potion", "Taste like medicine");

    private String name;

    private String description;

    ItemType(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


    @Override
    public Boolean match(String name) {
        return this.name.equals(name);
    }
}
