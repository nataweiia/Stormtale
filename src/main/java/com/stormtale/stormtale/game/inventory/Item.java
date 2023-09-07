package com.stormtale.stormtale.game.inventory;

import com.stormtale.stormtale.game.MainCharacter;
import com.stormtale.stormtale.game.npc.AbstractNPC;

import java.util.ArrayList;

public class Item {

    public static AbstractItem testBerry = new AbstractItem("Ягода","Боевой","Светящаяся ягода. Восстанавливает силы при использовании.","Common") {
        @Override
        public String use(MainCharacter mc, ArrayList<AbstractNPC> companions, ArrayList<AbstractNPC> enemies) {
            String text = mc.getName()[0] + " съедает ягоду, восстанавливая 8 единиц здоровья!\n";
            mc.addHealth(8);
            return text;
        }
    };
}
