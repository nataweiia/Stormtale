package com.stormtale.stormtale.game.inventory;

import com.stormtale.stormtale.game.MainCharacter;
import com.stormtale.stormtale.game.npc.AbstractNPC;

import java.io.Serializable;
import java.util.ArrayList;

public class Item implements Serializable {

    public static AbstractItem testBerry = new AbstractItem("Ягода","Боевой","Светящаяся ягода. Восстанавливает здоровье при использовании.","Обычный") {
        @Override
        public String use(MainCharacter mc, ArrayList<AbstractNPC> companions, ArrayList<AbstractNPC> enemies) {
            String text = mc.getName()[0] + " съедает ягоду, восстанавливая 8 единиц здоровья!\n";
            mc.addHealth(8);
            return text;
        }
    };

    public static AbstractItem Poultice = new AbstractItem("Припарка","Боевой",
            "Небольшая повязка, наполненная травами. Восстанавливает здоровье при использовании.","Обычный",20) {
        @Override
        public String use(MainCharacter mc, ArrayList<AbstractNPC> companions, ArrayList<AbstractNPC> enemies) {
            String text = mc.getName()[0] + " использует припарку, восстанавливая 8 единиц здоровья!\n";
            mc.addHealth(8);
            return text;
        }
    };
}
