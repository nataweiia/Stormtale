package com.stormtale.stormtale.game.inventory;

import com.stormtale.stormtale.game.MainCharacter;

public abstract class Equipment extends AbstractItem{
    String armorSlot;
    String requirementType;
    String requirementValue;

    public abstract void equip (MainCharacter mc);

    public abstract void unequip (MainCharacter mc);

    public void setArmorSlot(String armorSlot) {
        this.armorSlot = armorSlot;
    }

    public String getArmorSlot() {
        return armorSlot;
    }

    public void setRequirementType(String requirementType) {
        this.requirementType = requirementType;
    }

    public String getRequirementType() {
        return requirementType;
    }

    public void setRequirementValue(String requirementValue) {
        this.requirementValue = requirementValue;
    }

    public String getRequirementValue() {
        return requirementValue;
    }
}
