package com.stormtale.stormtale.game;

import com.stormtale.stormtale.game.inventory.Inventory;

import java.util.ArrayList;

public abstract class CharacterTemplate {
    String[] name = new String[6];
    Boolean female;
    String characterClass;
    Integer level;
    Integer maxHealth;
    Integer currentHealth;
    String resouseType;
    Integer maxResourse;
    Integer currentResourse;
    //armor? resistances?

    Integer strength;
    Integer dexterity;
    Integer mind;
    Integer charisma;

    ArrayList<Ability> abilities;
    Inventory inventory;
    ArrayList<Condition> conditions;
    //equipment slots?


    public void showProfile() {
        //check for serializable
        //Pane contains whole thing
        //picture in frame, can be clicked to fullsize
        //2 progress bars for health and resourse, bind progress to current? test later
        //space for conditions, bind here also?
        //name!!! maybe clickable to char window?
        //set sizes, define how to choose space, mc always first, overrride maybe? or just show mc first, idk
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
                substractLevel(this.level - level);
            }
        }
        //correct things according to level?
    }

    public void addLevel (Integer n) {
        level = level + n;
        //correct things here
    }

    public void substractLevel (Integer n) {
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

    public void substractHealth (Integer health) {
        currentHealth = currentHealth - health;
        if (currentHealth < 0) currentHealth = 0;
        //death effects? maybe not here?
    }

    public void setResouseType(String resouseType) {
        this.resouseType = resouseType;
    }

    public String getResouseType() {
        return resouseType;
    }

    public void setMaxResourse(Integer resourse) {
        maxResourse = resourse;
    }

    public Integer getMaxResourse() {
        return maxResourse;
    }

    public void setCurrentResourse(Integer resourse) {
        currentResourse = resourse;
    }

    public Integer getCurrentResourse() {
        return currentResourse;
    }

    public void addResourse (Integer resourse) {
        currentResourse = currentResourse + resourse;
        if (currentResourse > maxResourse) currentResourse = maxResourse;
    }

    public void substractResourse (Integer resourse) {
        currentResourse = currentResourse - resourse;
        if (currentResourse < 0) currentResourse = 0;
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

    public void substractStrength(Integer strength) {
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

    public void substractDexterity(Integer dexterity) {
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

    public void substractMind(Integer mind) {
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

    public void substractCharisma(Integer charisma) {
        this.charisma = this.charisma - charisma;
        if (this.charisma < 1) this.charisma = 1;
    }
}
