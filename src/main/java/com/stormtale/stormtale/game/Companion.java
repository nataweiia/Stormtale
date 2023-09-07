package com.stormtale.stormtale.game;

import com.stormtale.stormtale.game.inventory.Weapon;
import com.stormtale.stormtale.game.npc.AbstractNPC;

public abstract class Companion extends AbstractNPC {

    Weapon weapon;
    public Companion(String[] name, Boolean female, Integer maxHealth, String resourceType, Integer maxResource, Integer strength, Integer dexterity, Integer mind, Integer charisma) {
        super(name, female, maxHealth, resourceType, maxResource, strength, dexterity, mind, charisma);
        setConditionCount(0);
    }

    public abstract String description();

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
