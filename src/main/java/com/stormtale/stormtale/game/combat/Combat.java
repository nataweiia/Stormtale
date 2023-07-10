package com.stormtale.stormtale.game.combat;

import com.stormtale.stormtale.game.*;

import java.util.ArrayList;
import java.util.Iterator;

public class Combat {

    MainCharacter mc;
    ArrayList<AbstractNPC> enemies = new ArrayList<>();
    ArrayList<AbstractNPC> companions = new ArrayList<>();

    Integer turn = 0;

    AbstractScene nextScene;

    public Combat (MainCharacter mc, ArrayList<Companion> companions, ArrayList<AbstractNPC> enemies) {
        this.mc = mc;
        this.companions.addAll(companions);
        this.enemies.addAll(enemies);
    }

    public String turn () {
        turn++;
        String text = "";
        if (!mc.getConditions().isEmpty()) {
            tickConditions(mc,text);
        }
        if (companions != null) {
            for (AbstractNPC companion: companions
                 ) {
                if (!companion.getConditions().isEmpty()) {
                    tickConditions(companion,text);
                }
            }
        }
        System.out.println("point 1");
        for (AbstractNPC enemy: enemies
             ) {
            if (!enemy.getConditions().isEmpty()) {
                tickConditions(enemy,text);
            }
        }
        if (companions != null) {
            for (AbstractNPC companion: companions
            ) {
                text = text + companion.action(companions,enemies,mc,true);
            }
        }
        System.out.println("point 2");
        for (AbstractNPC enemy: enemies
             ) {
            text = text + enemy.action(enemies,companions,mc,false);
        }
        if (companions != null) {
            for (AbstractNPC companion: companions
            ) {
                if (companion.getCurrentHealth() == 0) companions.remove(companion);
            }
        }
        System.out.println("point 3");
        Iterator<AbstractNPC> iterator = enemies.iterator();
        while (iterator.hasNext()){
            AbstractNPC enemy = iterator.next();
            if (enemy.getCurrentHealth() == 0) iterator.remove();
        }
        return text;
    }

    public void tickConditions (AbstractCharacter character, String text) {
        for (AbstractCondition condition: character.getConditions()) {
            condition.apply(character);
            condition.tick();
            text = text + character.getName()[0] + condition.getDescription();
            if (condition.getDuration() == 0) character.removeCondition(condition);
        }
    }

    public void setNextScene(AbstractScene nextScene) {
        this.nextScene = nextScene;
    }

    public AbstractScene getNextScene() {
        return nextScene;
    }

    public ArrayList<AbstractNPC> getEnemies() {
        return enemies;
    }

    public ArrayList<AbstractNPC> getCompanions() {
        return companions;
    }

    public Integer getTurn() {
        return turn;
    }

    public MainCharacter getMc() {
        return mc;
    }
}
