package com.stormtale.stormtale.game.combat;

import com.stormtale.stormtale.game.*;
import com.stormtale.stormtale.game.inventory.AbstractItem;
import com.stormtale.stormtale.game.npc.AbstractNPC;

import java.util.ArrayList;
import java.util.Iterator;

public class Combat {

    MainCharacter mc;
    ArrayList<AbstractNPC> enemies = new ArrayList<>();
    ArrayList<AbstractNPC> companions = new ArrayList<>();

    Integer turn = 0;

    Integer totalExpReward;

    ArrayList<AbstractItem> loot = new ArrayList<>();

    AbstractScene nextScene;

    public Combat (MainCharacter mc, ArrayList<Companion> companions, ArrayList<AbstractNPC> enemies) {
        this.mc = mc;
        this.companions.addAll(companions);
        this.enemies.addAll(enemies);
        totalExpReward = 0;
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
        for (AbstractNPC enemy: enemies
             ) {
            if (!enemy.getConditions().isEmpty()) {
                tickConditions(enemy,text);
            }
        }
        if (companions != null) {
            for (AbstractNPC companion: companions
            ) {
                text = text + companion.action(companion,companions,enemies,mc,true);
            }
        }
        for (AbstractNPC enemy: enemies
             ) {
            text = text + enemy.action(enemy, enemies,companions,mc,false);
        }
        if (companions != null) {
            for (AbstractNPC companion: companions
            ) {
                if (companion.getCurrentHealth() == 0) companions.remove(companion);
            }
        }
        Iterator<AbstractNPC> iterator = enemies.iterator();
        while (iterator.hasNext()){
            AbstractNPC enemy = iterator.next();
            if (enemy.getCurrentHealth() == 0) {
                totalExpReward = totalExpReward + enemy.getExpReward();
                loot.addAll(enemy.dropLoot());
                iterator.remove();
            }
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

    public Integer getTotalExpReward() {
        return totalExpReward;
    }

    public ArrayList<AbstractItem> getLoot() {
        return loot;
    }
}
