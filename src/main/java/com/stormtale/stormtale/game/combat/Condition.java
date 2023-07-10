package com.stormtale.stormtale.game.combat;

import com.stormtale.stormtale.game.AbstractCharacter;
import com.stormtale.stormtale.game.combat.AbstractCondition;

public class Condition {

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
}
