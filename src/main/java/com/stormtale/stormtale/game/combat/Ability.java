package com.stormtale.stormtale.game.combat;

import com.stormtale.stormtale.game.AbstractCharacter;
import com.stormtale.stormtale.game.AbstractNPC;

import java.util.ArrayList;

public class Ability {

    public static AbstractAbility testAttack = new AbstractAbility("Атака -2",
            "Персонаж совершает атаку, наносящую 2 урона",
            1,
            0) {
        @Override
        public String use(AbstractCharacter user, ArrayList<AbstractCharacter> targets) {
            String text = "" + user.getName()[0];
            text = text + " совершает атаку по ";
            text = text + targets.get(0).getName()[2];
            text = text + "!\n";
            System.out.println(user.getCurrentResource());
            user.subtractResource(1);
            targets.get(0).subtractHealth(2);
            System.out.println(user.getCurrentResource());
            return text;
        }
    };
}
