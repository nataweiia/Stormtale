package com.stormtale.stormtale.Controllers;

import com.stormtale.stormtale.game.NPC;
import com.stormtale.stormtale.game.inventory.Item;

import java.util.ArrayList;

public class ButtonInfo {
    enum Type {
        Combat, Item, Dialogue, Movement, Continue
    }
    private String name;
    private String tooltip;
    private Boolean availability = true;
    private Integer row;
    private Integer column;
    private Item item;
    private Type type;
    private ArrayList<NPC> enemies;
    private NPC npc;
    private String newLocation;
    private String nextFile;
    private Scene nextScene;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
    }

    public String getTooltip() {
        return tooltip;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getRow() {
        return row;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public Integer getColumn() {
        return column;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public void setType(String type) {
        this.type = Type.valueOf(type);
    }

    public Type getType() {
        return type;
    }

    public ArrayList<NPC> getEnemies() {
        return enemies;
    }

    public void addEnemy(NPC enemy) {
        enemies.add(enemy);
    }

    public void setNpc(NPC npc) {
        this.npc = npc;
    }

    public NPC getNpc() {
        return npc;
    }

    public void setNewLocation(String newLocation) {
        this.newLocation = newLocation;
    }

    public String getNewLocation() {
        return newLocation;
    }

    public void setNextFile(String nextFile) {
        this.nextFile = nextFile;
    }

    public String getNextFile() {
        return nextFile;
    }

    public void setNextScene(Scene nextScene) {
        this.nextScene = nextScene;
    }

    public Scene getNextScene() {
        return nextScene;
    }
}
