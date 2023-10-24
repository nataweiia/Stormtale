package com.stormtale.stormtale.game.npc;

import com.stormtale.stormtale.game.AbstractCharacter;
import com.stormtale.stormtale.game.MainCharacter;
import com.stormtale.stormtale.game.combat.AbstractAbility;
import com.stormtale.stormtale.game.inventory.AbstractItem;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class AbstractNPC extends AbstractCharacter implements Serializable {

    Integer expReward;

    Double difficulty;

    public AbstractNPC (String[] name,
                        Boolean female,
                        Integer maxHealth,
                        String resourceType,
                        Integer maxResource,
                        Integer strength,
                        Integer dexterity,
                        Integer mind,
                        Integer charisma) {
        setName(name);
        setFemale(female);
        setMaxHealth(maxHealth);
        setCurrentHealth(maxHealth);
        setResourceType(resourceType);
        setMaxResource(maxResource);
        setCurrentResource(maxResource);
        setStrength(strength);
        setDexterity(dexterity);
        setProtection(dexterity);
        setMind(mind);
        setCharisma(charisma);
        setConditionCount(0);
    }
    public AbstractNPC (String[] name,
                        Boolean female,
                        Integer maxHealth,
                        String resourceType,
                        Integer maxResource,
                        Integer strength,
                        Integer dexterity,
                        Integer mind,
                        Integer charisma,
                        AbstractAbility[] abilities,
                        Integer expReward) {
        setName(name);
        setFemale(female);
        setMaxHealth(maxHealth);
        setCurrentHealth(maxHealth);
        setResourceType(resourceType);
        setMaxResource(maxResource);
        setCurrentResource(maxResource);
        setStrength(strength);
        setDexterity(dexterity);
        setProtection(dexterity);
        setMind(mind);
        setCharisma(charisma);
        setExpReward(expReward);
        setConditionCount(0);
        for (int i = 0; i < abilities.length; i++) {
            addAbility(abilities[i]);
        }
        setHealthPercentage(1.0);
        setResourcePercentage(1.0);
    }

    public AbstractNPC (String[] name,
                        Boolean female,
                        AbstractItem[] inventory) {
        setName(name);
        setFemale(female);
        setConditionCount(0);
        for (int i = 0; i < inventory.length; i++) {
            addItem(inventory[i]);
        }
        setHealthPercentage(1.0);
        setResourcePercentage(1.0);
    }

    public AbstractNPC() {    }

    public AbstractNPC(String[] name){
        setName(name);
    }

    public abstract String action(AbstractNPC user, ArrayList<AbstractNPC> friends, ArrayList<AbstractNPC> enemies, MainCharacter mc, Boolean isMCFriendly); // attack patterns go here

    public abstract ArrayList<AbstractItem> dropLoot();

    public Integer getExpReward() {
        return expReward;
    }

    public void setExpReward(Integer expReward) {
        this.expReward = expReward;
    }

    public Double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Double difficulty) {
        this.difficulty = difficulty;
    }
}
