package io.muzoo.ssc.zork.interactable;

public abstract class Interactable {

    private String name;

    private String description;

    private boolean pickable;

    public Interactable(String name, String description, boolean pickable) {
        this.name = name;
        this.description = description;
        this.pickable = pickable;
    }

    public boolean match(String name) {
        return this.name.equals(name);
    }

    @Override
    public String toString() {
        return this.name;
    }

    public boolean isPickable() {
        return pickable;
    }
}
