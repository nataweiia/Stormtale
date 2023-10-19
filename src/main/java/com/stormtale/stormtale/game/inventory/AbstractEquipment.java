package com.stormtale.stormtale.game.inventory;

import com.stormtale.stormtale.game.MainCharacter;

import java.io.Serializable;

public abstract class AbstractEquipment extends AbstractItem implements Serializable {
    String armorSlot;
    String armorType;

    public AbstractEquipment(String n, String t, String d, String r, Integer v, String slot, String type){
        super(n, t, d, r, v);
        armorSlot = slot;
        armorType = type;
    }

    public abstract void equip (MainCharacter mc);

    public abstract void unequip (MainCharacter mc);

    public void setArmorSlot(String armorSlot) {
        this.armorSlot = armorSlot;
    }

    public String getArmorSlot() {
        return armorSlot;
    }

    public String getArmorType() {
        return armorType;
    }

    public void setArmorType(String armorType) {
        this.armorType = armorType;
    }
}
