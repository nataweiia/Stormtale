package com.stormtale.stormtale.game;

import com.stormtale.stormtale.game.combat.AbstractAbility;

import java.util.ArrayList;

public abstract class AbstractNPC extends AbstractCharacter {

    Boolean firstConversation = false;

    public AbstractNPC (String[] name,
                        Boolean female,
                        Integer maxHealth,
                        Integer currentHealth,
                        String resourceType,
                        Integer maxResource,
                        Integer currentResource,
                        Integer strength,
                        Integer dexterity,
                        Integer mind,
                        Integer charisma) {
        this.name = name;
        this.female = female;
        this.maxHealth = maxHealth;
        this.currentHealth = currentHealth;
        this.resourceType = resourceType;
        this.maxResource = maxResource;
        this.currentResource = currentResource;
        this.strength = strength;
        this.dexterity = dexterity;
        this.mind = mind;
        this.charisma = charisma;
        conditionCount.setValue(0);
    }
    public AbstractNPC (String[] name,
                        Boolean female,
                        Integer maxHealth,
                        Integer currentHealth,
                        String resourceType,
                        Integer maxResource,
                        Integer currentResource,
                        Integer strength,
                        Integer dexterity,
                        Integer mind,
                        Integer charisma,
                        AbstractAbility[] abilities) {
        this.name = name;
        this.female = female;
        this.maxHealth = maxHealth;
        this.currentHealth = currentHealth;
        this.resourceType = resourceType;
        this.maxResource = maxResource;
        this.currentResource = currentResource;
        this.strength = strength;
        this.dexterity = dexterity;
        this.mind = mind;
        this.charisma = charisma;
        for (int i = 0; i < abilities.length; i++) {
            this.abilities.add(abilities[i]);
        }
        setHealthPercentage((double)currentHealth / maxHealth);
        setResourcePercentage((double)currentResource / maxResource);
        conditionCount.setValue(0);
    }

    public abstract String action(ArrayList<AbstractNPC> friends, ArrayList<AbstractNPC> enemies, MainCharacter mc, Boolean isMCFriendly); // attack patterns go here

    public void setFirstConversation(Boolean condition) {
        firstConversation = condition;
    }

    public Boolean firstConversation() {
        return firstConversation;
    }
}
