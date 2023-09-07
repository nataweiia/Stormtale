package com.stormtale.stormtale.game.inventory;

import com.stormtale.stormtale.game.Companion;
import com.stormtale.stormtale.game.MainCharacter;

import java.util.Random;

public abstract class Weapon extends AbstractItem {
    String weaponType;
    String dmgType;
    Integer minDmg;
    Integer maxDmg;

    public Weapon(String n, String t, String d, String r, Integer v) {
        super(n, t, d, r, v);
    }

    public Weapon() {
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

    public String getDmgType () {
        return dmgType;
    }
}
