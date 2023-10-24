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
    public static AbstractEquipment SamuraiStartingHead = new AbstractEquipment("Шлем","Снаряжение",
            "Самурайский шлем. Похожих шлемов много, но этот ваш.","Обычный",30,"Голова","Тяжелая") {
        @Override
        public void equip(MainCharacter mc) {
            mc.addProtection(2);
        }

        @Override
        public void unequip(MainCharacter mc) {
            mc.subtractProtection(2);
        }

        @Override
        public String use(MainCharacter mc, ArrayList<AbstractNPC> companions, ArrayList<AbstractNPC> enemies) {
            return null;
        }
    };
    public static AbstractEquipment SamuraiStartingBody = new AbstractEquipment("Доспех","Снаряжение",
            "Самурайский доспех. Нагрудные пластины уже изрядно покрыты царапинами и сколами.","Обычный",30,"Тело","Тяжелая") {
        @Override
        public void equip(MainCharacter mc) {
            mc.addProtection(2);
        }

        @Override
        public void unequip(MainCharacter mc) {
            mc.subtractProtection(2);
        }

        @Override
        public String use(MainCharacter mc, ArrayList<AbstractNPC> companions, ArrayList<AbstractNPC> enemies) {
            return null;
        }
    };
    public static AbstractEquipment SamuraiStartingAccessory = new AbstractEquipment("Амулет","Снаряжение",
            "Деревянный амулет, защищающий от злых духов.","Обычный",30,"Украшение","Тяжелая") {
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

    public static AbstractEquipment RascalStartingHead = new AbstractEquipment("Бандана","Снаряжение",
            "Когда-то ярко-красная бандана, давным давно выцветшая в грязно-оранжевый от солнца и соленого морского воздуха.",
            "Обычный",30,"Голова","Средняя") {
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
    public static AbstractEquipment RascalStartingBody = new AbstractEquipment("Куртка","Снаряжение",
            "Плотная кожаная куртка, украшенная вышивкой и подпоясанная ярким поясом.","Обычный",30,"Тело","Средняя") {
        @Override
        public void equip(MainCharacter mc) {
            mc.addProtection(2);
        }

        @Override
        public void unequip(MainCharacter mc) {
            mc.subtractProtection(2);
        }

        @Override
        public String use(MainCharacter mc, ArrayList<AbstractNPC> companions, ArrayList<AbstractNPC> enemies) {
            return null;
        }
    };
    public static AbstractEquipment RascalStartingAccessory = new AbstractEquipment("Амулет","Снаряжение",
            "Деревянный амулет, защищающий от злых духов.","Обычный",30,"Украшение","Средняя") {
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
