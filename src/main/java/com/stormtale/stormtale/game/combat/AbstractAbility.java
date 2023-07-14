package com.stormtale.stormtale.game.combat;

import com.stormtale.stormtale.game.AbstractCharacter;

import java.util.ArrayList;

public abstract class AbstractAbility {
    private String name;
    private String description;
    private Integer cost;
    private Integer cooldown;

    private Boolean chooseTarget;

    private Integer currentCooldown = 0;

    public AbstractAbility (String name, String description, Integer cost, Integer cooldown, Boolean chooseTarget) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.cooldown = cooldown;
        this.chooseTarget = chooseTarget;
    }

    public abstract String use (AbstractCharacter user, ArrayList<AbstractCharacter> targets);

    public abstract String use (AbstractCharacter user, AbstractCharacter target);

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

    public void setCooldown(Integer cooldown) {
        this.cooldown = cooldown;
    }

    public Integer getCooldown() {
        return cooldown;
    }

    public Boolean getChooseTarget() {
        return chooseTarget;
    }
}
