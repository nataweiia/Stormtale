package com.stormtale.stormtale;

import com.stormtale.stormtale.game.*;
import javafx.scene.Scene;

import java.io.Serializable;
import java.util.ArrayList;

public class World implements Serializable {

    AbstractLocation currentLocation;

    Time currentTime;

    MainCharacter mainCharacter;

    ArrayList<Companion> companions = new ArrayList<Companion>();

    AbstractScene currentScene;

    String currentSceneText;

    ArrayList<ButtonInfo> currentButtons;

    Double difficulty;

    public Boolean testBerryPicked = false;

    public Boolean testCombat = false;

    public World () {
        currentTime = new Time();
        currentTime.setCurrentTime(660);
        difficulty = 1.0;
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

    public void setCurrentLocation(AbstractLocation location) {
        currentLocation = location;
    }

    public AbstractLocation getCurrentLocation() {
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

    public ArrayList<ButtonInfo> getCurrentButtons() {
        return currentButtons;
    }

    public void setCurrentButtons(ArrayList<ButtonInfo> currentButtons) {
        this.currentButtons = currentButtons;
    }

    public void setCurrentScene(AbstractScene currentScene) {
        this.currentScene = currentScene;
    }

    public AbstractScene getCurrentScene() {
        return currentScene;
    }

    public String getCurrentSceneText() {
        return currentSceneText;
    }

    public void setCurrentSceneText(String currentSceneText) {
        this.currentSceneText = currentSceneText;
    }

    public Double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Double difficulty) {
        this.difficulty = difficulty;
    }

    public void changeDifficulty() {
        if (difficulty == 0.8) {
            setDifficulty(1.0);
        }
        if (difficulty == 1) {
            setDifficulty(1.2);
        }
        if (difficulty == 1.2){
            setDifficulty(0.8);
        }
    }
}
