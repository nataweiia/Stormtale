package com.stormtale.stormtale.game;

import javafx.scene.paint.Color;

public abstract class AbstractLocation {
    Color color;
    AbstractLocation[] connectedTopBottomRightLeft = new AbstractLocation[4];

    public AbstractLocation(Color color) {
        this.color = color;
    }

    public AbstractLocation(Color color, AbstractLocation[] connectedTopBottomRightLeft) {
        this.color = color;
        this.connectedTopBottomRightLeft = connectedTopBottomRightLeft;
    }

    public AbstractLocation[] getConnectedTopBottomRightLeft() {
        return connectedTopBottomRightLeft;
    }

    public void setConnectedTopBottomRightLeft(AbstractLocation[] connectedTopBottomRightLeft) {
        this.connectedTopBottomRightLeft = connectedTopBottomRightLeft;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
