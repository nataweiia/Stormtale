package com.stormtale.stormtale.game;

import com.stormtale.stormtale.game.combat.AbstractAbility;
import com.stormtale.stormtale.game.inventory.AbstractWeapon;
import com.stormtale.stormtale.game.npc.AbstractNPC;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class AbstractCompanion extends AbstractNPC implements Serializable {

    AbstractWeapon weapon;
    ArrayList<String> availableWeaponTypes = new ArrayList<>();


    public void setAvailableWeaponTypes(ArrayList<String> availableWeaponTypes) {
        this.availableWeaponTypes = availableWeaponTypes;
    }

    public ArrayList<String> getAvailableWeaponTypes() {
        return availableWeaponTypes;
    }
    public AbstractCompanion(String[] name, Boolean female, Integer maxHealth, String resourceType, Integer maxResource, Integer strength, Integer dexterity, Integer mind, Integer charisma) {
        super(name, female, maxHealth, resourceType, maxResource, strength, dexterity, mind, charisma);
        setConditionCount(0);
    }

    public AbstractCompanion(String[] name, Boolean female, Integer maxHealth, String resourceType, Integer maxResource, AbstractAbility[] abilities,
                             Integer strength, Integer dexterity, Integer mind, Integer charisma, AbstractWeapon weapon, String[] availableWeaponTypes) {
        super(name, female, maxHealth, resourceType, maxResource, strength, dexterity, mind, charisma);
        setWeapon(weapon);
        for (int i = 0; i < abilities.length; i++) {
            addAbility(abilities[i]);
        }
        for (int i = 0; i < availableWeaponTypes.length; i++) {
            addWeaponType(availableWeaponTypes[i]);
        }
        setConditionCount(0);
    }

    public void addWeaponType(String weaponType) {
        availableWeaponTypes.add(weaponType);
    }

    public abstract String description();

    public AbstractWeapon getWeapon() {
        return weapon;
    }

    public void setWeapon(AbstractWeapon weapon) {
        this.weapon = weapon;
    }
}
