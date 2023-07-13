package com.stormtale.stormtale.game.npc;

import com.stormtale.stormtale.game.AbstractCharacter;
import com.stormtale.stormtale.game.MainCharacter;
import com.stormtale.stormtale.game.combat.Ability;
import com.stormtale.stormtale.game.combat.AbstractAbility;
import com.stormtale.stormtale.game.npc.AbstractNPC;

import java.util.ArrayList;

public class NPC {

    public static AbstractNPC testNPC = new AbstractNPC(new String[]{"Юка", "Юки", "Юке", "Юку", "Юкой", "Юке"},
            true,
            16,
            "Мана",
            4,
            1,
            2,
            3,
            4,
            new AbstractAbility[]{Ability.testAttack}) {
        @Override
        public String action(AbstractNPC user, ArrayList<AbstractNPC> friends, ArrayList<AbstractNPC> enemies, MainCharacter mc, Boolean isMCFriendly) {
            if (isMCFriendly) return null;
            else {
                ArrayList<AbstractCharacter> target = new ArrayList<>();
                target.add(mc);
                return Ability.testAttack.use(user,target);
            }
        }
    };

}
