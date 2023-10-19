package com.stormtale.stormtale.game.npc.enemies;

import com.stormtale.stormtale.game.AbstractCharacter;
import com.stormtale.stormtale.game.MainCharacter;
import com.stormtale.stormtale.game.combat.Ability;
import com.stormtale.stormtale.game.inventory.AbstractItem;
import com.stormtale.stormtale.game.npc.AbstractNPC;

import java.io.Serializable;
import java.util.ArrayList;

public class Yuka extends AbstractNPC implements Serializable {

    public Yuka( Double difficulty) {
        setName(new String[]{"Юка", "Юки", "Юке", "Юку", "Юкой", "Юке"});
        setFemale(true);
        setMaxHealth((int) (11 * difficulty));
        setCurrentHealth((int) (11 * difficulty));
        setResourceType("Выносливость");
        setMaxResource((int) (8 * difficulty));
        setCurrentResource((int) (8 * difficulty));
        setStrength(1);
        setDexterity(2);
        setMind(3);
        setCharisma(4);
        addAbility(Ability.testAttack);
        setConditionCount(0);
        setHealthPercentage(1.0);
        setResourcePercentage(1.0);
        setExpReward(1);
    }
    @Override
    public String action(AbstractNPC yuka, ArrayList<AbstractNPC> friends, ArrayList<AbstractNPC> enemies, MainCharacter mc, Boolean isMCFriendly) {
        if (isMCFriendly) return null;
        else {
            ArrayList<AbstractCharacter> target = new ArrayList<>();
            target.add(mc);
            return Ability.testAttack.use(yuka,target);
        }
    }

    @Override
    public ArrayList<AbstractItem> dropLoot() {
        return null;
    }
}
