package io.muzoo.ssc.zork.interactable;

public abstract class Interactable {

    private String name;

    private String description;

    public Interactable(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
