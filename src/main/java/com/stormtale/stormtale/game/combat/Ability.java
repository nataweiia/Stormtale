package com.stormtale.stormtale.game.combat;

import com.stormtale.stormtale.game.AbstractCharacter;

import java.util.ArrayList;

public class Ability {

    public static AbstractAbility testAttack = new AbstractAbility("Атака -2",
            "Персонаж совершает атаку, наносящую 2 урона",
            1,
            0,
            true) {
        @Override
        public String use(AbstractCharacter user, ArrayList<AbstractCharacter> targets) {
            String text = "" + user.getName()[0];
            text = text + " совершает атаку по ";
            text = text + targets.get(0).getName()[2];
            text = text + "!\n";
            user.subtractResource(1);
            targets.get(0).subtractHealth(1);
            return text;
        }

        @Override
        public String use(AbstractCharacter user, AbstractCharacter target) {
            String text = "" + user.getName()[0];
            text = text + " совершает атаку по ";
            text = text + target.getName()[2];
            text = text + "!\n";
            user.subtractResource(1);
            target.subtractHealth(1);
            return text;
        }
    };

    public static AbstractAbility Punch = new AbstractAbility("Удар",
            "Персонаж взмахивает своим оружием, совершая мощную атаку.",
            1,
            0,
            true) {
        @Override
        public String use(AbstractCharacter user, ArrayList<AbstractCharacter> targets) {
            String text = "" + user.getName()[0];
            text = text + " совершает резкий удар по ";
            text = text + targets.get(0).getName()[2];
            text = text + "!\n";
            user.subtractResource(1);
            targets.get(0).subtractHealth(3);
            return text;
        }

        @Override
        public String use(AbstractCharacter user, AbstractCharacter target) {
            String text = "" + user.getName()[0];
            text = text + " совершает резкий удар по ";
            text = text + target.getName()[2];
            text = text + "!\n";
            user.subtractResource(1);
            target.subtractHealth(3);
            return text;
        }
    };

    public static AbstractAbility Spark = new AbstractAbility("Искра",
            "Персонаж взмахивает своим волшебным инструментов, выпуская сноп искр во врага.",
            1,
            0,
            true) {
        @Override
        public String use(AbstractCharacter user, ArrayList<AbstractCharacter> targets) {
            String text = "" + user.getName()[0];
            text = text + " выпускает сноп искр в ";
            text = text + targets.get(0).getName()[3];
            text = text + "!\n";
            user.subtractResource(1);
            targets.get(0).subtractHealth(3);
            return text;
        }

        @Override
        public String use(AbstractCharacter user, AbstractCharacter target) {
            String text = "" + user.getName()[0];
            text = text + " выпускает сноп искр в ";
            text = text + target.getName()[3];
            text = text + "!\n";
            user.subtractResource(1);
            target.subtractHealth(3);
            return text;
        }
    };

    public static AbstractAbility Trick = new AbstractAbility("Трюк",
            "Персонаж проворачивает ловкий трюк, провощируя врага ударить самого себя.",
            1,
            0,
            true) {
        @Override
        public String use(AbstractCharacter user, ArrayList<AbstractCharacter> targets) {
            String text = "" + user.getName()[0];
            text = text + " ловко уворачивается от удара ";
            text = text + targets.get(0).getName()[1];
            text = text + "!\n" + targets.get(0).getName()[0];
            text = text + "наносит удар по себе!\n";
            user.subtractResource(1);
            targets.get(0).subtractHealth(3);
            return text;
        }

        @Override
        public String use(AbstractCharacter user, AbstractCharacter target) {
            String text = "" + user.getName()[0];
            text = text + " ловко уворачивается от удара ";
            text = text + target.getName()[1];
            text = text + "!\n" + target.getName()[0];
            text = text + " наносит удар по себе!\n";
            user.subtractResource(1);
            target.subtractHealth(3);
            return text;
        }
    };
}
