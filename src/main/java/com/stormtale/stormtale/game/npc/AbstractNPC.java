package com.stormtale.stormtale.game.npc;

import com.stormtale.stormtale.game.AbstractCharacter;
import com.stormtale.stormtale.game.MainCharacter;
import com.stormtale.stormtale.game.combat.AbstractAbility;

import java.util.ArrayList;

public abstract class AbstractNPC extends AbstractCharacter {

    Boolean firstConversation = false;

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
                        AbstractAbility[] abilities) {
        setName(name);
        setFemale(female);
        setMaxHealth(maxHealth);
        setCurrentHealth(maxHealth);
        setResourceType(resourceType);
        setMaxResource(maxResource);
        setCurrentResource(maxResource);
        setStrength(strength);
        setDexterity(dexterity);
        setMind(mind);
        setCharisma(charisma);
        setConditionCount(0);
        for (int i = 0; i < abilities.length; i++) {
            addAbility(abilities[i]);
        }
        setHealthPercentage(1.0);
        setResourcePercentage(1.0);
    }

    public AbstractNPC() {

    }

    public abstract String action(AbstractNPC user, ArrayList<AbstractNPC> friends, ArrayList<AbstractNPC> enemies, MainCharacter mc, Boolean isMCFriendly); // attack patterns go here


    public void setFirstConversation(Boolean condition) {
        firstConversation = condition;
    }

    public Boolean firstConversation() {
        return firstConversation;
    }
}
