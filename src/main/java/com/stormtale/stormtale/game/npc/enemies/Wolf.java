package com.stormtale.stormtale.game.npc.enemies;

import com.stormtale.stormtale.game.AbstractCharacter;
import com.stormtale.stormtale.game.MainCharacter;
import com.stormtale.stormtale.game.combat.Ability;
import com.stormtale.stormtale.game.inventory.AbstractItem;
import com.stormtale.stormtale.game.npc.AbstractNPC;

import java.io.Serializable;
import java.util.ArrayList;

public class Wolf extends AbstractNPC implements Serializable {

    public Wolf (Double difficulty) {
        setName(new String[]{"Волк", "Волка", "Волку", "Волка", "Волком", "Волку"});
        setFemale(false);
        setMaxHealth((int) (15 * difficulty));
        setCurrentHealth((int) (15 * difficulty));
        setResourceType("Выносливость");
        setMaxResource((int) (10 * difficulty));
        setCurrentResource((int) (10 * difficulty));
        setStrength(5);
        setDexterity(3);
        setMind(1);
        setCharisma(2);
        setProtection(4);
        setDifficulty(difficulty);
        addAbility(Ability.Bite);
        setConditionCount(0);
        setHealthPercentage(1.0);
        setResourcePercentage(1.0);
        setExpReward(1);
    }
    @Override
    public String action(AbstractNPC wolf, ArrayList<AbstractNPC> friends, ArrayList<AbstractNPC> enemies, MainCharacter mc, Boolean isMCFriendly) {
        if (isMCFriendly) return null;
        else {
            return Ability.Bite.use(wolf,mc,getDifficulty());
        }
    }

    @Override
    public ArrayList<AbstractItem> dropLoot() {
        return null;
    }
}
