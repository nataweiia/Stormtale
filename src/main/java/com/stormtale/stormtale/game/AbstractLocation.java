package com.stormtale.stormtale.game;

import javafx.scene.paint.Color;

public abstract class AbstractLocation {
    Color color;
    String name;
    AbstractLocation connectedTop;
    AbstractLocation connectedBottom;
    AbstractLocation connectedRight;
    AbstractLocation connectedLeft;

    public AbstractLocation(Color color) {
        this.color = color;
    }

    public AbstractLocation(Color color, String name){
        this.color = color;
        this.name = name;
    }

    public abstract void setConnected();

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
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
}
