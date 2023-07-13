package com.stormtale.stormtale.game;

import com.stormtale.stormtale.game.npc.AbstractNPC;

public abstract class Companion extends AbstractNPC {
    public Companion(String[] name, Boolean female, Integer maxHealth, String resourceType, Integer maxResource, Integer strength, Integer dexterity, Integer mind, Integer charisma) {
        super(name, female, maxHealth, resourceType, maxResource, strength, dexterity, mind, charisma);
        setConditionCount(0);
    }
}
