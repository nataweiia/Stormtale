package com.stormtale.stormtale;

import com.stormtale.stormtale.game.Companion;
import com.stormtale.stormtale.game.MainCharacter;

import java.io.Serializable;
import java.util.ArrayList;

public class World implements Serializable {

    String currentLocation;

    Time currentTime;

    MainCharacter mainCharacter;

    ArrayList<Companion> companions = new ArrayList<Companion>();

    //locations here

    //quests here

    //companions here

    //npcs here

    public World () {
        currentLocation = "Очень длинная длинная длинная тестовая стартовая локация";
        currentTime = new Time();
        currentTime.setCurrentTime(660);
    }

    public void setCurrentTime(Time time) {
        currentTime = time;
    }

    public Time getCurrentTime() {
        return currentTime;
    }

    public void addTime(Integer n) {
        currentTime.addTime(n);
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

    public MainCharacter getMainCharacter() {
        return mainCharacter;
    }

    public ArrayList<Companion> getCompanions() {
        return companions;
    }

    public void setCompanions(ArrayList<Companion> companions) {
        this.companions = companions;
    }

    public void addCompanion(Companion companion) {
        companions.add(companion);
    }

    public void removeCompanion(Companion companion) {
        companions.remove(companion);
    }
}
