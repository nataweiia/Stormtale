package com.stormtale.stormtale.game.inventory;

import com.stormtale.stormtale.game.AbstractCompanion;
import com.stormtale.stormtale.game.MainCharacter;
import com.stormtale.stormtale.game.npc.AbstractNPC;

import java.io.Serializable;
import java.util.ArrayList;

public class Weapon implements Serializable {
    public static AbstractWeapon testWeapon = new AbstractWeapon("test","Оружие","Какое-то оружие","Редкий",300,"тест",3,4) {

        @Override
        public void equip(MainCharacter mc) {
            System.out.println("smth works1");
        }
        @Override
        public void equip(AbstractCompanion companion) {

        }
        @Override
        public void unequip(MainCharacter mc) {
            System.out.println("smth works2");
        }
        @Override
        public void unequip(AbstractCompanion companion) {

        }
        @Override
        public String use(MainCharacter mc, ArrayList<AbstractNPC> companions, ArrayList<AbstractNPC> enemies) {
            return null;
        }
    };

    public static AbstractWeapon ScholarStartingWeapon = new AbstractWeapon("Талисман","Оружие",
            "Нефритовый талисман с выгравированными на нем словами Сутры Об Очищении Сознания.","Обычный",50,"Фокусировка",2,4) {
        @Override
        public void equip(MainCharacter mc) {

        }

        @Override
        public void equip(AbstractCompanion companion) {

        }

        @Override
        public void unequip(MainCharacter mc) {

        }

        @Override
        public void unequip(AbstractCompanion companion) {

        }

        @Override
        public String use(MainCharacter mc, ArrayList<AbstractNPC> companions, ArrayList<AbstractNPC> enemies) {
            return null;
        }
    };

    public static AbstractWeapon SamuraiStartingWeapon = new AbstractWeapon("Меч","Оружие",
            "Ваш верный самурайский меч. Или не очень верный, учитывая что это уже третий за время службы.",
            "Обычный",50,"Меч",2,4) {
        @Override
        public void equip(MainCharacter mc) {

        }

        @Override
        public void equip(AbstractCompanion companion) {

        }

        @Override
        public void unequip(MainCharacter mc) {

        }

        @Override
        public void unequip(AbstractCompanion companion) {

        }

        @Override
        public String use(MainCharacter mc, ArrayList<AbstractNPC> companions, ArrayList<AbstractNPC> enemies) {
            return null;
        }
    };

    public static AbstractWeapon RascalStartingWeapon = new AbstractWeapon("Нож","Оружие",
            "Старый добрый ножик. Таким можно и в замке поковыряться, и пырнуть кого нехорошего.","Обычный",50,"Кинжал",2,4) {
        @Override
        public void equip(MainCharacter mc) {

        }

        @Override
        public void equip(AbstractCompanion companion) {

        }

        @Override
        public void unequip(MainCharacter mc) {

        }

        @Override
        public void unequip(AbstractCompanion companion) {

        }

        @Override
        public String use(MainCharacter mc, ArrayList<AbstractNPC> companions, ArrayList<AbstractNPC> enemies) {
            return null;
        }
    };
}
