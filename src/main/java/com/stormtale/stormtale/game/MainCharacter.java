package com.stormtale.stormtale.game;

import com.stormtale.stormtale.game.combat.Ability;
import com.stormtale.stormtale.game.inventory.AbstractItem;
import com.stormtale.stormtale.game.inventory.Equipment;
import com.stormtale.stormtale.game.inventory.Weapon;

import java.io.Serializable;
import java.util.ArrayList;

public class MainCharacter extends AbstractCharacter implements Serializable {


    //equipment slots?
    Integer exp;

    Integer maxExp;

    ArrayList<AbstractItem> inventory = new ArrayList<>();

    Weapon weapon;
    ArrayList<String> availableWeaponTypes;
    Equipment head;
    Equipment body;
    Equipment accessory;

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
                setMaxHealth(20); //delete later
                setCurrentHealth(20);
                setMaxResource(10);
                setCurrentResource(10);
                setExp(0);
                setMaxExp(10);
                addAbility(Ability.Punch);
                break;
            case "Ученый":
                resourceType = "Мана";
                strength = 1;
                dexterity = 2;
                mind = 4;
                charisma = 3;
                setMaxHealth(20);
                setCurrentHealth(20);
                setMaxResource(10);
                setCurrentResource(10);
                setExp(0);
                setMaxExp(10);
                addAbility(Ability.Spark);
                break;
            case "Прохиндей":
                resourceType = "Выносливость";
                strength = 1;
                dexterity = 4;
                mind = 2;
                charisma = 3;
                setMaxHealth(20);
                setCurrentHealth(20);
                setMaxResource(10);
                setCurrentResource(10);
                setExp(0);
                setMaxExp(10);
                addAbility(Ability.Trick);
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

    public String description() {
        return "Описание персонажа";
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

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setAvailableWeaponTypes(ArrayList<String> availableWeaponTypes) {
        this.availableWeaponTypes = availableWeaponTypes;
    }

    public ArrayList<String> getAvailableWeaponTypes() {
        return availableWeaponTypes;
    }

    public void setAccessory(Equipment accessory) {
        this.accessory = accessory;
    }

    public void setBody(Equipment body) {
        this.body = body;
    }

    public void setHead(Equipment head) {
        this.head = head;
    }

    public Equipment getAccessory() {
        return accessory;
    }

    public Equipment getBody() {
        return body;
    }

    public Equipment getHead() {
        return head;
    }
}
