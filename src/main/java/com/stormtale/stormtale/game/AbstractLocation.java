package com.stormtale.stormtale.game;

import javafx.scene.paint.Color;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class AbstractLocation implements Serializable {
    //Color color;

    Integer[] color = new Integer[3];
    String name;
    AbstractLocation connectedTop = null;
    AbstractLocation connectedBottom = null;
    AbstractLocation connectedRight = null;
    AbstractLocation connectedLeft = null;

    public AbstractLocation(Integer r, Integer g, Integer b) {
        color[0] = r;
        color[1] = g;
        color[2] = b;
    }

    public AbstractLocation(Integer r, Integer g, Integer b, String name){
        color[0] = r;
        color[1] = g;
        color[2] = b;
        this.name = name;
    }

    public abstract void setConnected();

    public abstract AbstractScene getScene();

    public Integer[] getColor() {
        return color;
    }

    public void setColor(Integer r, Integer g, Integer b) {
        color[0] = r;
        color[1] = g;
        color[2] = b;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AbstractLocation getConnectedBottom() {
        return connectedBottom;
    }

    public AbstractLocation getConnectedLeft() {
        return connectedLeft;
    }

    public AbstractLocation getConnectedRight() {
        return connectedRight;
    }

    public AbstractLocation getConnectedTop() {
        return connectedTop;
    }

    public void setConnectedBottom(AbstractLocation connectedBottom) {
        this.connectedBottom = connectedBottom;
    }

    public void setConnectedLeft(AbstractLocation connectedLeft) {
        this.connectedLeft = connectedLeft;
    }

    public void setConnectedRight(AbstractLocation connectedRight) {
        this.connectedRight = connectedRight;
    }

    public void setConnectedTop(AbstractLocation connectedTop) {
        this.connectedTop = connectedTop;
    }

    public Boolean isConnectedBottom() {
        return connectedBottom != null;
    }

    public Boolean isConnectedLeft() {
        return connectedLeft != null;
    }

    public Boolean isConnectedRight() {
        return connectedRight != null;
    }

    public Boolean isConnectedTop() {
        return connectedTop != null;
    }
}
