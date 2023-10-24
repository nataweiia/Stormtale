package com.stormtale.stormtale.game;

import com.stormtale.stormtale.game.inventory.AbstractItem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractQuest implements Serializable {
    String name;
    Map<Integer,String[]> stages = new HashMap<Integer,String[]>();

    Integer currentStage = 1;

    List<String> pastStages = new ArrayList<>();
    Integer expReward;

    Integer moneyReward;
    AbstractItem itemReward;

    public AbstractQuest (String name, Integer exp, Integer money) {
        this.name = name;
        expReward = exp;
        moneyReward = money;
    }

    public AbstractQuest (String name, Integer exp, Integer money, AbstractItem item) {
        this.name = name;
        expReward = exp;
        itemReward = item;
        moneyReward = money;
    }

    public abstract void setStages();

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setExpReward(Integer expReward) {
        this.expReward = expReward;
    }

    public Integer getExpReward() {
        return expReward;
    }

    public Integer getMoneyReward() {
        return moneyReward;
    }

    public void setMoneyReward(Integer moneyReward) {
        this.moneyReward = moneyReward;
    }

    public AbstractItem getItemReward() {
        return itemReward;
    }

    public void setItemReward(AbstractItem itemReward) {
        this.itemReward = itemReward;
    }

    public Map<Integer, String[]> getStages() {
        return stages;
    }

    public void addStage (Integer n, String[] s) {
        stages.put(n,s);
    }

    public String[] getCurrentStage() {
        return stages.get(currentStage);
    }

    public void setCurrentStage(Integer currentStage) {
        this.currentStage = currentStage;
    }

    public void nextStage(Integer stage) {
        Integer n = currentStage;
        pastStages.add(stages.get(n)[0]);
        currentStage = stage;
    }

    public List<String> getPastStages() {
        return pastStages;
    }

    public String[] getStage(Integer n) {
        return stages.get(n);
    }
}
