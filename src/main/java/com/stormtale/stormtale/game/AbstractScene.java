package com.stormtale.stormtale.game;

import com.stormtale.stormtale.World;
import com.stormtale.stormtale.game.combat.AbstractAbility;

import java.util.ArrayList;

public abstract class AbstractScene {
    private String text;
    private ArrayList<ButtonInfo> buttons = new ArrayList<>();
    private AbstractLocation location;

    public void Scene () { //make full constructors
    }

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

    public void setLocation(AbstractLocation location) {
        this.location = location;
    }

    public AbstractLocation getLocation() {
        return location;
    }
}
