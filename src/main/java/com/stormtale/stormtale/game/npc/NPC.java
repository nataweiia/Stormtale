package com.stormtale.stormtale.game.npc;

import com.stormtale.stormtale.game.AbstractCharacter;
import com.stormtale.stormtale.game.MainCharacter;
import com.stormtale.stormtale.game.combat.Ability;
import com.stormtale.stormtale.game.combat.AbstractAbility;
import com.stormtale.stormtale.game.inventory.AbstractItem;
import com.stormtale.stormtale.game.inventory.Item;

import java.io.Serializable;
import java.util.ArrayList;

public class NPC implements Serializable {

    public static AbstractNPC testNPC = new AbstractNPC(new String[]{"Юка", "Юки", "Юке", "Юку", "Юкой", "Юке"},
            true,
            16,
            "Мана",
            4,
            1,
            2,
            3,
            4,
            new AbstractAbility[]{Ability.testAttack},
            9) {
        @Override
        public String action(AbstractNPC user, ArrayList<AbstractNPC> friends, ArrayList<AbstractNPC> enemies, MainCharacter mc, Boolean isMCFriendly) {
            if (isMCFriendly) return null;
            else {
                ArrayList<AbstractCharacter> target = new ArrayList<>();
                target.add(mc);
                return Ability.testAttack.use(user,target);
            }
        }

        @Override
        public ArrayList<AbstractItem> dropLoot() {
            return null;
        }
    };

    public static AbstractNPC Apothecary = new AbstractNPC(new String[]{"Юка", "Юки", "Юке", "Юку", "Юкой", "Юке"},false,new AbstractItem[]{
            Item.Poultice
    }) {
        @Override
        public String action(AbstractNPC user, ArrayList<AbstractNPC> friends, ArrayList<AbstractNPC> enemies, MainCharacter mc, Boolean isMCFriendly) {
            return null;
        }

        @Override
        public ArrayList<AbstractItem> dropLoot() {
            return null;
        }
    };

}
