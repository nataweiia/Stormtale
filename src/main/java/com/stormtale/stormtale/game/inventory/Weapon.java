package com.stormtale.stormtale.game.inventory;

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
