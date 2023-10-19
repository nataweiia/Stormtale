package com.stormtale.stormtale.game.combat;

import com.stormtale.stormtale.game.AbstractCharacter;
import com.stormtale.stormtale.game.combat.AbstractCondition;

import java.io.Serializable;

public class Condition implements Serializable {

    public static AbstractCondition testCondition = new AbstractCondition("test",
            "test condition",
            99,
            "/com/stormtale/stormtale/images/rooster.png") {
        @Override
        public void apply(AbstractCharacter character) {
            character.subtractHealth(1);
        }
    };

    public static AbstractCondition testCondition3 = new AbstractCondition("test",
            "test condition",
            99,
            "/com/stormtale/stormtale/images/rooster.png") {
        @Override
        public void apply(AbstractCharacter character) {
            character.subtractHealth(1);
        }
    };

    public static AbstractCondition Bleed = new AbstractCondition("Кровотечение","Цель медленно истекает кровью.",4,
            "/com/stormtale/stormtale/images/rooster.png") {
        @Override
        public void apply(AbstractCharacter character) {
            character.subtractHealth(2);
        }
    };
}
