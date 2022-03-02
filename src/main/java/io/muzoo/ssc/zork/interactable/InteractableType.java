package io.muzoo.ssc.zork.interactable;

public interface InteractableType {
    Boolean match(String name);

    String getType();
}
