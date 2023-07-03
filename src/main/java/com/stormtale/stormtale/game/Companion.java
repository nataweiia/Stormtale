package com.stormtale.stormtale.game;

public abstract class Companion extends AbstractNPC {
    public Companion(String[] name, Boolean female, Integer maxHealth, Integer currentHealth, String resourceType, Integer maxResource, Integer currentResource, Integer strength, Integer dexterity, Integer mind, Integer charisma) {
        super(name, female, maxHealth, currentHealth, resourceType, maxResource, currentResource, strength, dexterity, mind, charisma);
    }
}
