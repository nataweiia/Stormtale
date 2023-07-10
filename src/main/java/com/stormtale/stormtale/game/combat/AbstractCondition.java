package com.stormtale.stormtale.game.combat;

import com.stormtale.stormtale.game.AbstractCharacter;

public abstract class AbstractCondition {
    String name;
    String description;
    Integer duration;
    String iconURL;

    public AbstractCondition (String name, String description, Integer duration, String iconURL){
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.iconURL = iconURL;
    }



    public abstract void apply (AbstractCharacter character);

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void tick () {
        duration--;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIconURL() {
        return iconURL;
    }

    public void setIconURL(String iconURL) {
        this.iconURL = iconURL;
    }
}
