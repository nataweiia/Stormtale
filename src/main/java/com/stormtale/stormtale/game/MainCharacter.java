package com.stormtale.stormtale.game;

import java.io.Serializable;

public class MainCharacter extends AbstractCharacter implements Serializable {


    //equipment slots?

    public MainCharacter () {
        name[0] = "Неизвестно";
        level = 1;
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
}
