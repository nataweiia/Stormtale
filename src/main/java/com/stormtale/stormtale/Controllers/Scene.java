package com.stormtale.stormtale.Controllers;

import com.stormtale.stormtale.game.NPC;
import com.stormtale.stormtale.game.inventory.Item;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.ArrayList;

public class Scene {
    private Integer ID;
    private String text;
    private ArrayList<ButtonInfo> buttons;
    private String location;

    public void Scene () {
    }

    public void Scene (String text) {  //maybe more constructors?

    }

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
