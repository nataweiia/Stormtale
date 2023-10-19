package com.stormtale.stormtale.game;

import com.stormtale.stormtale.game.inventory.AbstractWeapon;
import com.stormtale.stormtale.game.npc.AbstractNPC;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Companion extends AbstractNPC implements Serializable {

    AbstractWeapon weapon;
    ArrayList<String> availableWeaponTypes;
    public void setAvailableWeaponTypes(ArrayList<String> availableWeaponTypes) {
        this.availableWeaponTypes = availableWeaponTypes;
    }

    public ArrayList<String> getAvailableWeaponTypes() {
        return availableWeaponTypes;
    }
    public Companion(String[] name, Boolean female, Integer maxHealth, String resourceType, Integer maxResource, Integer strength, Integer dexterity, Integer mind, Integer charisma) {
        super(name, female, maxHealth, resourceType, maxResource, strength, dexterity, mind, charisma);
        setConditionCount(0);
    }

    public abstract String description();

    public AbstractWeapon getWeapon() {
        return weapon;
    }

    public void setWeapon(AbstractWeapon weapon) {
        this.weapon = weapon;
    }
}
