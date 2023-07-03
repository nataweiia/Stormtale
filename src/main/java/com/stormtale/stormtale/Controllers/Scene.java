package com.stormtale.stormtale.Controllers;

import com.stormtale.stormtale.World;

import java.util.ArrayList;

public abstract class Scene {
    private Integer ID;
    private String text;
    private ArrayList<ButtonInfo> buttons = new ArrayList<>();
    private String location;

    public void Scene () { //make full constructors
    }

    public abstract void setUpScene (World world);

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getID() {
        return ID;
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

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }
}
