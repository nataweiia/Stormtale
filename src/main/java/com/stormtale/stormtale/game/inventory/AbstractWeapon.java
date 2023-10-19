package com.stormtale.stormtale.game.inventory;

import com.stormtale.stormtale.game.Companion;
import com.stormtale.stormtale.game.MainCharacter;

import java.io.Serializable;
import java.util.Random;

public abstract class AbstractWeapon extends AbstractItem implements Serializable {
    String weaponType;
    Integer minDmg;
    Integer maxDmg;

    public AbstractWeapon(String n, String t, String d, String r, Integer v, String type, Integer min, Integer max) {
        super(n, t, d, r, v);
        weaponType = type;
        minDmg = min;
        maxDmg = max;
    }

    public AbstractWeapon() {
        super();
    }

    public abstract void equip (MainCharacter mc);

    public abstract  void equip (Companion companion);

    public abstract void unequip (MainCharacter mc);

    public abstract void unequip (Companion companion);

    public int getDmg () {
        Random random = new Random();
        return random.nextInt(maxDmg - minDmg) + minDmg;
    }

    public String getWeaponType () {
        return weaponType;
    }

}
