package com.stormtale.stormtale.game.combat;

import com.stormtale.stormtale.game.AbstractCharacter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Ability implements Serializable {

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

        @Override
        public String use(AbstractCharacter user, ArrayList<AbstractCharacter> targets, Double difficulty) {
            return null;
        }

        @Override
        public String use(AbstractCharacter user, AbstractCharacter target, Double difficulty) {
            return null;
        }
    };

    public static AbstractAbility Flare = new AbstractAbility("Вспышка","Персонаж запускает во врага сгусток энергии, наносящий магический урон",
            2,0,true) {
        @Override
        public String use(AbstractCharacter user, ArrayList<AbstractCharacter> targets) {
            return null;
        }

        @Override
        public String use(AbstractCharacter user, AbstractCharacter target) {
            Random r = new Random();
            int n = r.nextInt(5);
            Double modifier = 0.2 * n * user.getCharisma() - 0.1 * target.getProtection();
            Integer damage = modifier.intValue() + 3;
            target.subtractHealth(damage);
            user.subtractResource(2);
            String text = user.getName()[0] + " создает в ладони сверкающий сгусток энергии и резким движением запускает его в " +
                    target.getName()[3] + "!";
            return text;
        }

        @Override
        public String use(AbstractCharacter user, ArrayList<AbstractCharacter> targets, Double difficulty) {
            return null;
        }

        @Override
        public String use(AbstractCharacter user, AbstractCharacter target, Double difficulty) {
            return null;
        }
    };

    public static AbstractAbility Thrust = new AbstractAbility("Выпад","Персонаж совершает резкий удар по врагу, нанося физический урон",
            2,0,true) {
        @Override
        public String use(AbstractCharacter user, ArrayList<AbstractCharacter> targets) {
            return null;
        }

        @Override
        public String use(AbstractCharacter user, AbstractCharacter target) {
            Random r = new Random();
            int n = r.nextInt(5);
            Double modifier = 0.2 * n * user.getStrength() - 0.1 * target.getProtection();
            Integer damage = modifier.intValue() + 3;
            target.subtractHealth(damage);
            user.subtractResource(2);
            String text = user.getName()[0] + " храбро бросается вперед, поражая  " +
                    target.getName()[3] + " могучим ударом!";
            return text;
        }

        @Override
        public String use(AbstractCharacter user, ArrayList<AbstractCharacter> targets, Double difficulty) {
            return null;
        }

        @Override
        public String use(AbstractCharacter user, AbstractCharacter target, Double difficulty) {
            return null;
        }
    };

    public static AbstractAbility Undercut = new AbstractAbility("Подсечка","Персонаж совершает удар в уязвимое место врага, " +
            "нанося небольшой урон и с вероятностью 50% вызывая кровотечение.",2,0,true) {
        @Override
        public String use(AbstractCharacter user, ArrayList<AbstractCharacter> targets) {
            return null;
        }

        @Override
        public String use(AbstractCharacter user, AbstractCharacter target) {
            Random r = new Random();
            int n = r.nextInt(5);
            Double modifier = 0.2 * n * user.getStrength() - 0.1 * target.getProtection();
            Integer damage = modifier.intValue();
            target.subtractHealth(damage);
            user.subtractResource(2);
            int p = r.nextInt(2);
            String text;
            if (p == 1) {
                target.removeCondition(Condition.Bleed);
                target.addCondition(Condition.Bleed);
                text = user.getName()[0] + " обманным маневром заставляет " +
                        target.getName()[3] + " открыть уязвимое место, тут же нанося туда коварный удар и оставляя кровоточащую рану!";
            } else {
                text = user.getName()[0] + " пытается заставить " +
                        target.getName()[3] + " открыть уязвимое место, однако " + target.getName()[0] +
                        " настороже и не поддается на провокации!";
            }
            return text;
        }

        @Override
        public String use(AbstractCharacter user, ArrayList<AbstractCharacter> targets, Double difficulty) {
            return null;
        }

        @Override
        public String use(AbstractCharacter user, AbstractCharacter target, Double difficulty) {
            return null;
        }
    };

    public static AbstractAbility Bite = new AbstractAbility("Укус","Волк кусает врага.",2,0,true) {
        @Override
        public String use(AbstractCharacter user, ArrayList<AbstractCharacter> targets) {
            return null;
        }

        @Override
        public String use(AbstractCharacter user, AbstractCharacter target) {

            return null;
        }

        @Override
        public String use(AbstractCharacter user, ArrayList<AbstractCharacter> targets, Double difficulty) {
            return null;
        }

        @Override
        public String use(AbstractCharacter user, AbstractCharacter target, Double difficulty) {
            Random r = new Random();
            int n = r.nextInt(5);
            Double modifier = (0.2 * n * user.getStrength() - 0.1 * target.getProtection()) * difficulty;
            Integer damage = modifier.intValue();
            target.subtractHealth(damage);
            user.subtractResource(2);
            int p = (int)(r.nextInt(100) * difficulty);
            String text;
            if (p > 50) {
                target.removeCondition(Condition.Bleed);
                target.addCondition(Condition.Bleed);
                text = user.getName()[0] + " бросается на " +
                        target.getName()[3] + ", широко раскрыв челюсти, и его острые зубы оставляют кровоточащую рану!";
            } else {
                text = user.getName()[0] + " бросается на " +
                        target.getName()[3] + ", однако ";
                if (target.getFemale()) text = text + "ей ";
                else text = text + "ему ";
                text = text + "удается увернуться, отделавшись царапиной!";
            }
            return text;
        }
    };
}
