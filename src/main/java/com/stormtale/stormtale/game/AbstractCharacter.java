package com.stormtale.stormtale.game;

import com.stormtale.stormtale.game.combat.AbstractAbility;
import com.stormtale.stormtale.game.combat.AbstractCondition;
import com.stormtale.stormtale.game.inventory.Inventory;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;

public abstract class AbstractCharacter {
    String[] name = new String[6];
    Boolean female;
    String characterClass;
    Integer level;
    Integer maxHealth;
    Integer currentHealth;
    DoubleProperty healthPercentage = new SimpleDoubleProperty();
    String resourceType;
    Integer maxResource;
    Integer currentResource;
    DoubleProperty resourcePercentage = new SimpleDoubleProperty();
    //armor? resistances?

    Integer strength;
    Integer dexterity;
    Integer mind;
    Integer charisma;

    ArrayList<AbstractAbility> abilities = new ArrayList<>();
    Inventory inventory;
    ArrayList<AbstractCondition> conditions = new ArrayList<>();
    IntegerProperty conditionCount = new SimpleIntegerProperty();
    //equipment slots?
    String portraitUrl;
    String imageUrl;

    public void rest () {
        currentHealth = maxHealth;
        currentResource = maxResource;
        clearConditions();
    }

    public void addAbility (AbstractAbility ability) {
        abilities.add(ability);
    }

    public void  removeAbility (AbstractAbility ability) {
        abilities.remove(ability);
    }

    public void addCondition (AbstractCondition condition) {
        conditions.add(condition);
        conditionCount.setValue(getConditionCount() + 1);
    }

    public void removeCondition (AbstractCondition condition) {
        conditions.remove(condition);
        conditionCount.setValue(getConditionCount() - 1);
    }

    public void clearConditions () {
        conditions.clear();
        conditionCount.setValue(0);
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
        healthPercentage.setValue((double)currentHealth / maxHealth);
    }

    public Integer getCurrentHealth() {
        return currentHealth;
    }

    public void addHealth (Integer health) {
        currentHealth = currentHealth + health;
        if (currentHealth > maxHealth) currentHealth = maxHealth;
        healthPercentage.setValue((double)currentHealth / maxHealth);
    }

    public void subtractHealth(Integer health) {
        currentHealth = currentHealth - health;
        if (currentHealth < 0) currentHealth = 0;
        healthPercentage.setValue((double)currentHealth / maxHealth);
        //death effects? maybe not here?
    }

    public double getHealthPercentage() {
        return healthPercentage.get();
    }

    public void setHealthPercentage(double healthPercentage) {
        this.healthPercentage.set(healthPercentage);
    }

    public DoubleProperty healthPercentageProperty() {
        return healthPercentage;
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
        resourcePercentage.setValue((double)currentResource / maxResource);
    }

    public Integer getCurrentResource() {
        return currentResource;
    }

    public void addResource(Integer resource) {
        currentResource = currentResource + resource;
        if (currentResource > maxResource) currentResource = maxResource;
        resourcePercentage.setValue((double)currentResource / maxResource);
    }

    public void subtractResource(Integer resource) {
        currentResource = currentResource - resource;
        if (currentResource < 0) currentResource = 0;
        resourcePercentage.setValue((double)currentResource / maxResource);
    }

    public double getResourcePercentage() {
        return resourcePercentage.get();
    }

    public void setResourcePercentage(double resourcePercentage) {
        this.resourcePercentage.set(resourcePercentage);
    }

    public DoubleProperty resourcePercentageProperty() {
        return resourcePercentage;
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

    public ArrayList<AbstractAbility> getAbilities() {
        return abilities;
    }

    public ArrayList<AbstractCondition> getConditions() {
        return conditions;
    }

    public int getConditionCount() {
        return conditionCount.get();
    }

    public IntegerProperty conditionCountProperty() {
        return conditionCount;
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
