package com.stormtale.stormtale.game;

import com.stormtale.stormtale.game.combat.Ability;
import com.stormtale.stormtale.game.combat.AbstractAbility;
import com.stormtale.stormtale.game.inventory.AbstractItem;
import com.stormtale.stormtale.game.inventory.AbstractWeapon;
import com.stormtale.stormtale.game.inventory.Weapon;
import com.stormtale.stormtale.game.npc.AbstractNPC;

import java.util.ArrayList;

public class Companion {
    public static AbstractCompanion GoBei = new AbstractCompanion(new String[]{"Го-Бэй", "Го-Бэя", "Го-Бэю", "Го-Бэя", "Го-Бэем", "Го-Бэе"},false,
            60,"Выносливость",20, new AbstractAbility[]{
            Ability.Thrust
    },6,5,2,2, Weapon.SamuraiStartingWeapon,new String[]{"Меч", "Кинжал"}) {
        @Override
        public String description() {
            return "Высокий, худощавый юноша в самурайских доспехах. Длинные темно-каштановые волосы собраны в высокий хвост, узкое, интеллигентное лицо " +
                    "чисто выбрито.";
        }

        @Override
        public String action(AbstractNPC user, ArrayList<AbstractNPC> friends, ArrayList<AbstractNPC> enemies, MainCharacter mc, Boolean isMCFriendly) {
            String text = Ability.Thrust.use(GoBei, enemies.get(0));
            return text;
        }

        @Override
        public ArrayList<AbstractItem> dropLoot() {
            return null;
        }
    };

    public static AbstractCompanion Caesi = new AbstractCompanion(new String[]{"Цаэси", "Цаэси", "Цаэси", "Цаэси", "Цаэси", "Цаэси"},true,
            40,"Мана",30, new AbstractAbility[]{
            Ability.Flare
    },1,5,6,4, Weapon.ScholarStartingWeapon,new String[]{"Фокусировка", "Кинжал"}) {
        @Override
        public String description() {
            return "Невысокая девушка в жело-зеленом наряде писаря. Длинные черные волосы полусобраны сзади и каскадом спускаются на спину.";
        }

        @Override
        public String action(AbstractNPC user, ArrayList<AbstractNPC> friends, ArrayList<AbstractNPC> enemies, MainCharacter mc, Boolean isMCFriendly) {
            String text = Ability.Flare.use(Caesi, enemies.get(0));
            return text;
        }

        @Override
        public ArrayList<AbstractItem> dropLoot() {
            return null;
        }
    };

    public static AbstractCompanion Maru = new AbstractCompanion(new String[]{"Мару", "Мару", "Мару", "Мару", "Мару", "Мару"},false,
            70,"Выносливость",15, new AbstractAbility[]{
            Ability.Pound
    },6,5,2,2, Weapon.RascalStartingWeapon,new String[]{"Меч", "Кинжал"}) {
        @Override
        public String description() {
            return "Высокий, широкоплечий мужчина, одетый в расшитую жилетку и свободные штаны. Ярко-рыжие волосы собраны в неряшливый пучок.";
        }

        @Override
        public String action(AbstractNPC user, ArrayList<AbstractNPC> friends, ArrayList<AbstractNPC> enemies, MainCharacter mc, Boolean isMCFriendly) {
            String text = Ability.Pound.use(GoBei, enemies.get(0));
            return text;
        }

        @Override
        public ArrayList<AbstractItem> dropLoot() {
            return null;
        }
    };
}
