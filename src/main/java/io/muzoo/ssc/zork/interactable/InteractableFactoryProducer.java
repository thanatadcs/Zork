package io.muzoo.ssc.zork.interactable;

public class InteractableFactoryProducer {
    public static InteractableFactory getFactory(String type) {
        for (InteractableTypeEnum itTypeEnum: InteractableTypeEnum.values()) {
            if (itTypeEnum.getType().equals(type)) return itTypeEnum.getFactory();
        }
        return null;
    }
}
