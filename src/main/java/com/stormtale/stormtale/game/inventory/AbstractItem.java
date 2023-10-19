package com.stormtale.stormtale.game.inventory;

import com.stormtale.stormtale.game.MainCharacter;
import com.stormtale.stormtale.game.npc.AbstractNPC;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class AbstractItem implements Serializable {
    String name;
    String type;
    String description;
    String rarity;
    Integer value;
    Integer ID;
    public AbstractItem(String n, String t, String d, String r) {
        name = n;
        type = t;
        description = d;
        rarity = r;
        value = 0;
    }

    public AbstractItem(String n, String t, String d, String r, Integer v) {
        name = n;
        type = t;
        description = d;
        rarity = r;
        value = v;
    }

    public AbstractItem() {}

    public abstract String use(MainCharacter mc, ArrayList<AbstractNPC> companions, ArrayList<AbstractNPC> enemies);

    public String getName () {
        return name;
    }

    public String getType () {
        return type;
    }

    public String getDescription () {
        return description;
    }

    public String getRarity () {
        return rarity;
    }

    public Integer getValue () {
        return value;
    }

    public String getItem () {
        String item = new String(name +"\n\n" + type + "\n\n" + description + "\n\n" + rarity + ", стоимость:" + value.toString() + "зао");
        return item;
    }

    public Integer getID() {
        return ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void setID(Integer ID) { this.ID = ID; }
}
