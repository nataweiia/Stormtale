package com.stormtale.stormtale.game.inventory;

import com.stormtale.stormtale.game.MainCharacter;

public abstract class Consumable extends AbstractItem{

    public abstract void consume (MainCharacter mc);
}
