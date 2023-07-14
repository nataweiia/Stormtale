package com.stormtale.stormtale.game;

import com.stormtale.stormtale.game.inventory.AbstractItem;

import java.io.Serializable;
import java.util.ArrayList;

public class MainCharacter extends AbstractCharacter implements Serializable {


    //equipment slots?
    Integer exp;

    Integer maxExp;

    ArrayList<AbstractItem> inventory;

    public MainCharacter () {
        name[0] = "Неизвестно";
        level = 1;
        conditionCount.setValue(0);
    }
    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
        switch (characterClass) {
            case "Самурай":
                resourceType = "Выносливость";
                strength = 4;
                dexterity = 3;
                mind = 1;
                charisma = 2;
                break;
            case "Ученый":
                resourceType = "Мана";
                strength = 1;
                dexterity = 2;
                mind = 4;
                charisma = 3;
                break;
            case "Прохиндей":
                resourceType = "Выносливость";
                strength = 1;
                dexterity = 4;
                mind = 2;
                charisma = 3;
                break;
        }
        //add abilities, stats, etc
    }

    public String levelUp() {
        String text = "";
        switch (level) {
            case 2:
                switch (characterClass) {
                    case "Самурай":
                        //add ability to character
                        //add text about ability to text
                        text = text + "\nВы получаете способность " + "!"; //add ability name
                        //same for each ability and each class and each level
                        //increase hp, resource etc.
                        break;
                    case "Ученый":
                        break;
                    case "Прохиндей":
                        break;
                }
                setMaxExp(200);
                break;
            case 3:
                setMaxExp(300);
                break;
            case 4:
                setMaxExp(400);
                break;
            case 5:
                setMaxExp(500);
                break;
            case 6:
                setMaxExp(600);
                break;
        }
        return  text;
    }

    public void setMaxExp(Integer maxExp) {
        this.maxExp = maxExp;
    }

    public Integer getMaxExp() {
        return maxExp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public Integer getExp() {
        return exp;
    }

    public void addExp(Integer exp) {
        this.exp = this.exp + exp;
    }

    public void setInventory(ArrayList<AbstractItem> inventory) {
        this.inventory = inventory;
    }

    public ArrayList<AbstractItem> getInventory() {
        return inventory;
    }

    public void addItem(AbstractItem item) {
        inventory.add(item);
    }

    public void removeItem(AbstractItem item) {
        inventory.remove(item);
    }
}
