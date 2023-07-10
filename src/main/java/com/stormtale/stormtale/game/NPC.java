package com.stormtale.stormtale.game;

import com.stormtale.stormtale.game.combat.Ability;
import com.stormtale.stormtale.game.combat.AbstractAbility;

import java.util.ArrayList;

public class NPC {

    public static AbstractNPC testNPC = new AbstractNPC(new String[]{"Юка", "Юки", "Юке", "Юку", "Юкой", "Юке"},
            true,
            16,
            7,
            "Мана",
            4,
            2,
            1,
            2,
            3,
            4,
            new AbstractAbility[]{Ability.testAttack}) {
        @Override
        public String action(ArrayList<AbstractNPC> friends, ArrayList<AbstractNPC> enemies, MainCharacter mc, Boolean isMCFriendly) {
            if (isMCFriendly) return null;
            else {
                ArrayList<AbstractCharacter> target = new ArrayList<>();
                target.add(mc);
                return Ability.testAttack.use(testNPC,target);
            }
        }
    };

}
