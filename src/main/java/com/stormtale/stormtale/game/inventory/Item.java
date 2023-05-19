package com.stormtale.stormtale.game.inventory;

public class Item {
    String name;
    String type;
    String description;
    String rarity;
    Integer value;
    Integer ID;
    public Item (String n, String t, String d, String r) {
        name = n;
        type = t;
        description = d;
        rarity = r;
        value = 0;
    }

    public Item (String n, String t, String d, String r, Integer v) {
        name = n;
        type = t;
        description = d;
        rarity = r;
        value = v;
    }

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
