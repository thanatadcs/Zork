package io.muzoo.ssc.zork.interactable;

public abstract class Interactable {

    private String name;

    private String description;

    private boolean pickable;

    private String type;

    public Interactable(String name, String description, String type, boolean pickable) {
        this.name = name;
        this.description = description;
        this.pickable = pickable;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
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

    public String getType() {
        return type;
    }
}
