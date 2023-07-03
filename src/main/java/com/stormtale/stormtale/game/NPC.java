package com.stormtale.stormtale.game;

import java.util.ArrayList;

public class NPC {

    public static AbstractNPC testNPC = new AbstractNPC(new String[]{"Кира", "test", "testt", "test", "test", "test"},
            true,
            16,
            7,
            "Мана",
            4,
            2,
            1,
            2,
            3,
            4) {
        @Override
        public Ability attack(MainCharacter mc, ArrayList<AbstractNPC> enemies) {
            return null;
        }
    };

}
