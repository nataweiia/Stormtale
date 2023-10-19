package com.stormtale.stormtale.game;

import com.stormtale.stormtale.World;
import com.stormtale.stormtale.game.inventory.AbstractItem;
import com.stormtale.stormtale.game.npc.AbstractNPC;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class AbstractScene implements Serializable {
    private String text;
    private ArrayList<ButtonInfo> buttons = new ArrayList<>();
    private AbstractLocation location;
    public AbstractScene() {
    }

    public AbstractScene(String text, AbstractLocation location) {
        this.text = text;
        this.location = location;
    }

    public AbstractScene(AbstractLocation location) {
        this.location = location;
    }

    public abstract void setUpScene (World world);

    public abstract void changeFlag(World world);

    public void setButton(AbstractScene nextScene, Integer row, Integer column, String name) {
        ButtonInfo button = new ButtonInfo();
        button.setRow(row);
        button.setColumn(column);
        button.setType("Continue");
        button.setName(name);
        button.setNextScene(nextScene);
        buttons.add(button);
    }

    public void setItemButton(Integer row, Integer column, String name, AbstractItem item, Boolean isFlag) {
        ButtonInfo button = new ButtonInfo();
        button.setRow(row);
        button.setColumn(column);
        button.setType("Item");
        button.setName(name);
        button.setFlag(isFlag);
        button.setItem(item);
        buttons.add(button);
    }

    public void setCombatButton(AbstractScene nextScene, Integer row, Integer column, String name, ArrayList<AbstractNPC> enemies) {
        ButtonInfo button = new ButtonInfo();
        button.setRow(row);
        button.setColumn(column);
        button.setType("Combat");
        button.setName(name);
        button.setNextScene(nextScene);
        button.setFlag(true);
        button.getEnemies().addAll(enemies);
        buttons.add(button);
    }
    public void setMovementButtons(Boolean availTop, AbstractLocation nextTop, Boolean availBottom, AbstractLocation nextBottom,
                                   Boolean availLeft, AbstractLocation nextLeft, Boolean availRight, AbstractLocation nextRight) {
        ButtonInfo top = new ButtonInfo();
        top.setRow(1);
        top.setColumn(1);
        top.setName("Вперед");
        if (availTop) {
            top.setNewLocation(nextTop);
            top.setType("Movement");
        } else top.setAvailability(false);
        buttons.add(top);
        ButtonInfo bottom = new ButtonInfo();
        bottom.setRow(2);
        bottom.setColumn(1);
        bottom.setName("Назад");
        if (availBottom) {
            bottom.setNewLocation(nextBottom);
            bottom.setType("Movement");
        } else bottom.setAvailability(false);
        buttons.add(bottom);
        ButtonInfo left = new ButtonInfo();
        left.setRow(2);
        left.setColumn(0);
        left.setName("Влево");
        if (availLeft) {
            left.setNewLocation(nextLeft);
            left.setType("Movement");
        } else left.setAvailability(false);
        buttons.add(left);
        ButtonInfo right = new ButtonInfo();
        right.setRow(2);
        right.setColumn(2);
        right.setName("Вправо");
        if (availRight) {
            right.setNewLocation(nextRight);
            right.setType("Movement");
        } else right.setAvailability(false);
        buttons.add(right);
    }

    public void setTradeButton(Integer row, Integer column, String name, AbstractNPC npc){
        ButtonInfo button = new ButtonInfo();
        button.setRow(row);
        button.setColumn(column);
        button.setType("Trade");
        button.setName(name);
        button.setNpc(npc);
        buttons.add(button);
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public ArrayList<ButtonInfo> getButtons() {
        return buttons;
    }

    public void addButton (ButtonInfo button) {
        buttons.add(button);
    }

    public void clearButtons() {buttons.clear();}

    public void setLocation(AbstractLocation location) {
        this.location = location;
    }

    public AbstractLocation getLocation() {
        return location;
    }
}
