package com.stormtale.stormtale.game.inventory;

import com.stormtale.stormtale.game.inventory.Item;

import java.util.ArrayList;

public class Inventory {

    ArrayList<Item> inv;

    public Inventory () {
        inv = new ArrayList<Item>();
    }

    public void addItem (Item item) {
        inv.add(item);
    }

    public void removeItem (Item item) {
        inv.remove(item);
    }

    public ArrayList<Item> getInv () {
        return inv;
    }
}
