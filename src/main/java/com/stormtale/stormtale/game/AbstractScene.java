package com.stormtale.stormtale.game;

import com.stormtale.stormtale.World;

import java.util.ArrayList;

public abstract class AbstractScene {
    private String text;
    private ArrayList<ButtonInfo> buttons = new ArrayList<>();
    private String location;

    public void Scene () { //make full constructors
    }

    public AbstractScene() {
    }

    public AbstractScene(String text, String location) {
        this.text = text;
        this.location = location;
    }

    public AbstractScene(String location) {
        this.location = location;
    }

    public abstract void setUpScene (World world);

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

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }
}
