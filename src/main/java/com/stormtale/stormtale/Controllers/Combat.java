package com.stormtale.stormtale.Controllers;

import com.stormtale.stormtale.game.*;

import java.util.ArrayList;

public class Combat {

    MainCharacter mc;
    ArrayList<AbstractNPC> enemies = new ArrayList<>();
    ArrayList<Companion> companions = new ArrayList<>(); //rewrite constructors

    Integer turn = 0;

    Scene nextScene;


    public Combat (MainCharacter mc, AbstractNPC enemy) {
        this.mc = mc;
        enemies.add(enemy);
    }
    public Combat (MainCharacter mc, Companion companion, AbstractNPC enemy) {
        this.mc = mc;
        companions.add(companion);
        enemies.add(enemy);
    }

    public Combat (MainCharacter mc, AbstractNPC[] enemies) {
        this.mc = mc;
        for (int i = 0; i < enemies.length; i++) {
            this.enemies.add(enemies[i]);
        }
    }

    public Combat (MainCharacter mc, Companion[] companions, AbstractNPC[] enemies) {
        this.mc = mc;
        for (int i = 0; i < companions.length; i++) {
            this.companions.add(companions[i]);
        }
        for (int i = 0; i < enemies.length; i++) {
            this.enemies.add(enemies[i]);
        }
    }

    public void turn () {
        turn++;
        if (!mc.getConditions().isEmpty()) {
            tickConditions(mc);
        }
        //condi duration -1 on everyone
        //apply condis, maybe make method in char temp?
        //playerAttack
        //maybe playerAttack -> turn -> player Attack?
        if (companions != null) {
            for (Companion companion: companions
                 ) {
                if (!companion.getConditions().isEmpty()) {
                    tickConditions(companion);
                }
            }
            //companionAttack
        }
        for (AbstractNPC enemy: enemies
             ) {
            if (!enemy.getConditions().isEmpty()) {
                tickConditions(enemy);
            }
            //enemyAttack
        }
    }

    public void tickConditions (AbstractCharacter character) {
        for (AbstractCondition condition: character.getConditions()) {
            condition.apply(character);
            condition.tick();
            if (condition.getDuration() == 0) character.removeCondition(condition);
        }
    }

    public void playerAttack () {
        //code for choosing attack here?
        //probably not here, but parts here?
    }


}
