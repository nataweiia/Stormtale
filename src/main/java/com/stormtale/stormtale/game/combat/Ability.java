package com.stormtale.stormtale.game.combat;

import com.stormtale.stormtale.game.AbstractCharacter;

import java.util.ArrayList;

public class Ability {

    public static AbstractAbility testAttack = new AbstractAbility("Атака -2",
            "Персонаж совершает атаку, наносящую 2 урона",
            1,
            0,
            true) {
        @Override
        public String use(AbstractCharacter user, ArrayList<AbstractCharacter> targets) {
            String text = "" + user.getName()[0];
            text = text + " совершает атаку по ";
            text = text + targets.get(0).getName()[2];
            text = text + "!\n";
            user.subtractResource(1);
            targets.get(0).subtractHealth(2);
            return text;
        }

        @Override
        public String use(AbstractCharacter user, AbstractCharacter target) {
            String text = "" + user.getName()[0];
            text = text + " совершает атаку по ";
            text = text + target.getName()[2];
            text = text + "!\n";
            user.subtractResource(1);
            target.subtractHealth(2);
            return text;
        }
    };
}
