package com.stormtale.stormtale.game;

import com.stormtale.stormtale.game.combat.Ability;
import com.stormtale.stormtale.game.inventory.AbstractEquipment;
import com.stormtale.stormtale.game.inventory.AbstractWeapon;
import com.stormtale.stormtale.game.inventory.Weapon;

import java.io.Serializable;
import java.util.ArrayList;

public class MainCharacter extends AbstractCharacter implements Serializable {

    Integer exp;

    Integer maxExp;

    AbstractWeapon weapon;
    ArrayList<String> availableWeaponTypes = new ArrayList<>();

    String armorType;
    AbstractEquipment head;
    AbstractEquipment body;
    AbstractEquipment accessory;

    Integer maxInventory;

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
                addAbility(Ability.Thrust);
                setMaxHealth(20);
                setCurrentHealth(20);
                setMaxResource(10);
                setCurrentResource(10);
                setExp(0);
                setMaxExp(10);
                armorType = "Тяжелая";
                break;
            case "Ученый":
                resourceType = "Мана";
                strength = 1;
                dexterity = 2;
                mind = 4;
                charisma = 3;
                addAbility(Ability.Flare);
                setMaxHealth(40);
                setCurrentHealth(40);
                setMaxResource(20);
                setCurrentResource(20);
                setExp(0);
                setMaxExp(10);
                availableWeaponTypes.add("Фокусировка");
                armorType = "Легкая";
                break;
            case "Прохиндей":
                resourceType = "Выносливость";
                strength = 1;
                dexterity = 4;
                mind = 2;
                charisma = 3;
                addAbility(Ability.Undercut);
                setMaxHealth(20);
                setCurrentHealth(20);
                setMaxResource(10);
                setCurrentResource(10);
                setExp(0);
                setMaxExp(10);
                armorType = "Средняя";
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

    public void setWeapon(AbstractWeapon weapon) {
        this.weapon = weapon;
    }

    public AbstractWeapon getWeapon() {
        return weapon;
    }

    public void setAvailableWeaponTypes(ArrayList<String> availableWeaponTypes) {
        this.availableWeaponTypes = availableWeaponTypes;
    }

    public ArrayList<String> getAvailableWeaponTypes() {
        return availableWeaponTypes;
    }

    public String getArmorType() {
        return armorType;
    }

    public void setAccessory(AbstractEquipment accessory) {
        this.accessory = accessory;
    }

    public void setBody(AbstractEquipment body) {
        this.body = body;
    }

    public void setHead(AbstractEquipment head) {
        this.head = head;
    }

    public AbstractEquipment getAccessory() {
        return accessory;
    }

    public AbstractEquipment getBody() {
        return body;
    }

    public AbstractEquipment getHead() {
        return head;
    }

    public void setMaxInventory(Integer maxInventory) {
        this.maxInventory = maxInventory;
    }

    public Integer getMaxInventory() {
        return maxInventory;
    }
}
