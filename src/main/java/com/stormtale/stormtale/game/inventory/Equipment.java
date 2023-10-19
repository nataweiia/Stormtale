package com.stormtale.stormtale.game.inventory;

import com.stormtale.stormtale.game.MainCharacter;
import com.stormtale.stormtale.game.npc.AbstractNPC;

import java.io.Serializable;
import java.util.ArrayList;

public class Equipment implements Serializable {
    public static AbstractEquipment ScholarStartingHead = new AbstractEquipment("Шапочка","Снаряжение",
            "Небольшая шапочка, украшенная искусной вышивкой. Такие часто носят имперские ученые.","Обычный",30,"Голова","Легкая") {
        @Override
        public void equip(MainCharacter mc) {
            mc.addProtection(1);
        }

        @Override
        public void unequip(MainCharacter mc) {
            mc.subtractProtection(1);
        }

        @Override
        public String use(MainCharacter mc, ArrayList<AbstractNPC> companions, ArrayList<AbstractNPC> enemies) {
            return null;
        }
    };
    public static AbstractEquipment ScholarStartingBody = new AbstractEquipment("Робы","Снаряжение",
            "Официальные одеяния имперского ученого.","Обычный",30,"Тело","Легкая") {
        @Override
        public void equip(MainCharacter mc) {
            mc.addProtection(1);
        }

        @Override
        public void unequip(MainCharacter mc) {
            mc.subtractProtection(1);
        }

        @Override
        public String use(MainCharacter mc, ArrayList<AbstractNPC> companions, ArrayList<AbstractNPC> enemies) {
            return null;
        }
    };
    public static AbstractEquipment ScholarStartingAccessory = new AbstractEquipment("Амулет","Снаряжение",
            "Деревянный амулет, защищающий от злых духов.","Обычный",30,"Украшение","Легкая") {
        @Override
        public void equip(MainCharacter mc) {
            mc.addProtection(1);
        }

        @Override
        public void unequip(MainCharacter mc) {
            mc.subtractProtection(1);
        }

        @Override
        public String use(MainCharacter mc, ArrayList<AbstractNPC> companions, ArrayList<AbstractNPC> enemies) {
            return null;
        }
    };
}
