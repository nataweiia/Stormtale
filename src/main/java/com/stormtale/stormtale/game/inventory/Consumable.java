package com.stormtale.stormtale.game.inventory;

import com.stormtale.stormtale.game.MainCharacter;

import java.io.Serializable;

public abstract class Consumable extends AbstractItem implements Serializable {

    public abstract void consume (MainCharacter mc);
}
