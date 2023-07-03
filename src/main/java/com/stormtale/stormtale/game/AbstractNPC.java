package com.stormtale.stormtale.game;

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
    }

    public abstract Ability attack(MainCharacter mc, ArrayList<AbstractNPC> enemies); // attack patterns go here

    public void setFirstConversation(Boolean condition) {
        firstConversation = condition;
    }

    public Boolean firstConversation() {
        return firstConversation;
    }

}
