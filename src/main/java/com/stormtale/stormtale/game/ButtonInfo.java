package com.stormtale.stormtale.game;

import com.stormtale.stormtale.game.inventory.Item;
import com.stormtale.stormtale.game.npc.AbstractNPC;

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
    private ArrayList<AbstractNPC> enemies;
    private String startCombatText;
    private AbstractNPC npc;
    private String newLocation;
    private String nextFile;
    private AbstractScene nextScene;

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

    public String getType() {
        return type.name();
    }

    public ArrayList<AbstractNPC> getEnemies() {
        return enemies;
    }

    public void addEnemy(AbstractNPC enemy) {
        enemies.add(enemy);
    }

    public String getStartCombatText() {
        return startCombatText;
    }

    public void setNpc(AbstractNPC npc) {
        this.npc = npc;
    }

    public AbstractNPC getNpc() {
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

    public void setNextScene(AbstractScene nextScene) {
        this.nextScene = nextScene;
    }

    public AbstractScene getNextScene() {
        return nextScene;
    }
}
