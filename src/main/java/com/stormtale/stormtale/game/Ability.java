package com.stormtale.stormtale.game;

import com.stormtale.stormtale.Controllers.Combat;

import java.util.ArrayList;

public abstract class Ability {
    private String name;
    private String description;
    private Integer cost;
    private String performingText;
    private Integer cooldown;
    private String target;
    private ArrayList<AbstractCondition> conditions = new ArrayList<>();

    public abstract void use (Combat combatScene);

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getCost() {
        return cost;
    }

    public void setPerformingText(String performingText) {
        this.performingText = performingText;
    }

    public String getPerformingText() {
        return performingText;
    }
}
