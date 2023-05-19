package com.stormtale.stormtale.game;

import com.stormtale.stormtale.game.inventory.Inventory;

import java.io.Serializable;
import java.util.ArrayList;

public class MainCharacter extends CharacterTemplate implements Serializable {


    //equipment slots?

    public MainCharacter () {
        name[0] = "Неизвестно";
        level = 1;
    }
    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
        switch (characterClass) {
            case "Самурай":
                resouseType = "Выносливость";
                strength = 4;
                dexterity = 3;
                mind = 1;
                charisma = 2;
                break;
            case "Ученый":
                resouseType = "Мана";
                strength = 1;
                dexterity = 2;
                mind = 4;
                charisma = 3;
                break;
            case "Прохиндей":
                resouseType = "Выносливость";
                strength = 1;
                dexterity = 4;
                mind = 2;
                charisma = 3;
                break;
        }
        //add abilities, stats, etc
    }
}
