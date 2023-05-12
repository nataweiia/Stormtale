package com.stormtale.stormtale;

import com.stormtale.stormtale.game.MainCharacter;

import java.io.Serializable;

public class World implements Serializable {

    String currentLocation;

    Time currentTime;

    MainCharacter mainCharacter;

    //locations here

    //quests here

    //companions here

    //npcs here

    public World () {
        currentLocation = "Стартовая локация";
        currentTime = new Time();
        currentTime.setCurrentTime(660);
    }

    public void setCurrentTime(Time time) {
        currentTime = time;
    }

    public Time getCurrentTime() {
        return currentTime;
    }

    public void setCurrentLocation(String location) {
        currentLocation = location;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setMainCharacter(MainCharacter character) {
        mainCharacter = character;
    }
}
