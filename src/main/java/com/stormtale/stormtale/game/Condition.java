package com.stormtale.stormtale.game;

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
}
