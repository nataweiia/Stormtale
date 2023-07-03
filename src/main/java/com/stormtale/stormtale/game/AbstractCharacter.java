package com.stormtale.stormtale.game;

import com.stormtale.stormtale.game.inventory.Inventory;

import java.util.ArrayList;

public abstract class AbstractCharacter {
    String[] name = new String[6];
    Boolean female;
    String characterClass;
    Integer level;
    Integer maxHealth;
    Integer currentHealth;
    String resourceType;
    Integer maxResource;
    Integer currentResource;
    //armor? resistances?

    Integer strength;
    Integer dexterity;
    Integer mind;
    Integer charisma;

    ArrayList<Ability> abilities = new ArrayList<>();
    Inventory inventory;
    ArrayList<AbstractCondition> conditions = new ArrayList<>();
    //equipment slots?
    String portraitUrl;
    String imageUrl;

    public void rest () {
        currentHealth = maxHealth;
        currentResource = maxResource;
        clearConditions();
    }

    public void addAbility (Ability ability) {
        abilities.add(ability);
    }

    public void  removeAbility (Ability ability) {
        abilities.remove(ability);
    }

    public void addCondition (AbstractCondition condition) {
        conditions.add(condition);
    }

    public void removeCondition (AbstractCondition condition) {
        conditions.remove(condition);
    }

    public void clearConditions () {
        conditions.clear();
    }

    public String[] getName() {
        return name;
    }

    public void setName(String[] name) {
        this.name = name;
    }

    public Boolean getFemale() {
        return female;
    }

    public void setFemale(Boolean female) {
        this.female = female;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setLevel(Integer level) {
        if (level < 6 && level > 0) {
            if (level > this.level) {
                addLevel(level - this.level);
            }
            if (level < this.level) {
                subtractLevel(this.level - level);
            }
        }
        //correct things according to level?
    }

    public void addLevel (Integer n) {
        level = level + n;
        //correct things here
    }

    public void subtractLevel(Integer n) {
        level = level - n;
    }

    public Integer getLevel() {
        return level;
    }

    public void setMaxHealth(Integer health) {
        maxHealth = health;
    }

    public Integer getMaxHealth() {
        return maxHealth;
    }

    public void setCurrentHealth(Integer health) {
        currentHealth = health;
    }

    public Integer getCurrentHealth() {
        return currentHealth;
    }

    public void addHealth (Integer health) {
        currentHealth = currentHealth + health;
        if (currentHealth > maxHealth) currentHealth = maxHealth;
    }

    public void subtractHealth(Integer health) {
        currentHealth = currentHealth - health;
        if (currentHealth < 0) currentHealth = 0;
        //death effects? maybe not here?
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setMaxResource(Integer resource) {
        maxResource = resource;
    }

    public Integer getMaxResource() {
        return maxResource;
    }

    public void setCurrentResource(Integer resource) {
        currentResource = resource;
    }

    public Integer getCurrentResource() {
        return currentResource;
    }

    public void addResource(Integer resource) {
        currentResource = currentResource + resource;
        if (currentResource > maxResource) currentResource = maxResource;
    }

    public void subtractResource(Integer resource) {
        currentResource = currentResource - resource;
        if (currentResource < 0) currentResource = 0;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getStrength() {
        return strength;
    }

    public void addStrength(Integer strength) {
        this.strength = this.strength + strength;
    }

    public void subtractStrength(Integer strength) {
        this.strength = this.strength - strength;
        if (this.strength < 1) this.strength = 1;
    }

    public void setDexterity(Integer dexterity) {
        this.dexterity = dexterity;
    }

    public Integer getDexterity() {
        return dexterity;
    }

    public void addDexterity(Integer dexterity) {
        this.dexterity = this.dexterity + dexterity;
    }

    public void subtractDexterity(Integer dexterity) {
        this.dexterity = this.dexterity - dexterity;
        if (this.dexterity < 1) this.dexterity = 1;
    }

    public void setMind(Integer mind) {
        this.mind = mind;
    }

    public Integer getMind() {
        return mind;
    }

    public void addMind(Integer mind) {
        this.mind = this.mind + mind;
    }

    public void subctractMind(Integer mind) {
        this.mind = this.mind - mind;
        if (this.mind < 1) this.mind = 1;
    }

    public void setCharisma(Integer charisma) {
        this.charisma = charisma;
    }

    public Integer getCharisma() {
        return charisma;
    }

    public void addCharisma(Integer charisma) {
        this.charisma = this.charisma + charisma;
    }

    public void subtractCharisma(Integer charisma) {
        this.charisma = this.charisma - charisma;
        if (this.charisma < 1) this.charisma = 1;
    }

    public ArrayList<AbstractCondition> getConditions() {
        return conditions;
    }

    public String getPortraitUrl() {
        return portraitUrl;
    }

    public void setPortraitUrl(String portraitUrl) {
        this.portraitUrl = portraitUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
