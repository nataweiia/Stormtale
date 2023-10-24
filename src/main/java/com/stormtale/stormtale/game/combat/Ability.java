package com.stormtale.stormtale.game.combat;

import com.stormtale.stormtale.game.AbstractCharacter;
import com.stormtale.stormtale.game.AbstractCompanion;
import com.stormtale.stormtale.game.MainCharacter;

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
            int damageRange;
            if (user instanceof MainCharacter) {
                damageRange = ((MainCharacter) user).getWeapon().getDmg();
            } else if (user instanceof AbstractCompanion) {
                damageRange = ((AbstractCompanion) user).getWeapon().getDmg();
            } else {
                Random r = new Random();
                damageRange = r.nextInt(5);
            }
            Double modifier = 0.2 * damageRange * user.getCharisma() - 0.1 * target.getProtection();
            Integer damage = modifier.intValue() + 3;
            target.subtractHealth(damage);
            user.subtractResource(2);
            String text = user.getName()[0] + " создает в ладони сверкающий сгусток энергии и резким движением запускает его в " +
                    target.getName()[3] + "!\n";
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

    public static AbstractAbility Shine = new AbstractAbility("Сияние",
            "Персонаж использует целительную магию, чтобы восстановить себе здоровье.",5,2,false) {
        @Override
        public String use(AbstractCharacter user, ArrayList<AbstractCharacter> targets) {
            Random r = new Random();
            int n = r.nextInt(3);
            user.addHealth(n * user.getCharisma());
            user.subtractResource(5);
            String text = user.getName()[0] + " окутывает себя мягким теплым светом, затягивающим ";
            if (user.getFemale()) text = text + "ее ";
            else text = text + "его ";
            text = text + "раны.\n";
            return text;
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
            return null;
        }
    };

    public static AbstractAbility Siphon = new AbstractAbility("Перекачка",
            "Персонаж поглощает жизненную энергию врагов, нанося им урон и восстанавливая себе здоровье.",15,5,false) {
        @Override
        public String use(AbstractCharacter user, ArrayList<AbstractCharacter> targets) {
            int damageRange;
            if (user instanceof MainCharacter) {
                damageRange = ((MainCharacter) user).getWeapon().getDmg();
            } else if (user instanceof AbstractCompanion) {
                damageRange = ((AbstractCompanion) user).getWeapon().getDmg();
            } else {
                Random r = new Random();
                damageRange = r.nextInt(5);
            }
            for (AbstractCharacter target:targets
                 ) {
                Double modifier = 0.2 * damageRange * user.getCharisma() - 0.1 * target.getProtection();
                Integer damage = modifier.intValue() + 3;
                Integer healing = damage / 3;
                user.addHealth(healing);
                target.subtractHealth(damage);
            }
            user.subtractResource(15);
            String text = user.getName()[0] + " взмахами рук создает в воздухе вихрь болезненно-зеленой энергии, высасывающей " +
                    "жизненную силу из врагов!\n";
            return text;
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
            return null;
        }
    };

    public static AbstractAbility Thrust = new AbstractAbility("Выпад","Персонаж совершает резкий удар по врагу, нанося физический урон.",
            2,0,true) {
        @Override
        public String use(AbstractCharacter user, ArrayList<AbstractCharacter> targets) {
            return null;
        }

        @Override
        public String use(AbstractCharacter user, AbstractCharacter target) {
            int damageRange;
            if (user instanceof MainCharacter) {
                damageRange = ((MainCharacter) user).getWeapon().getDmg();
            } else if (user instanceof AbstractCompanion) {
                damageRange = ((AbstractCompanion) user).getWeapon().getDmg();
            } else {
                Random r = new Random();
                damageRange = r.nextInt(5);
            }
            Double modifier = 0.2 * damageRange * user.getStrength() - 0.1 * target.getProtection();
            Integer damage = modifier.intValue() + 3;
            target.subtractHealth(damage);
            user.subtractResource(2);
            String text = user.getName()[0] + " храбро бросается вперед, поражая  " +
                    target.getName()[3] + " могучим ударом!\n";
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

    public static AbstractAbility Regeneration = new AbstractAbility("Обновление",
            "Персонаж сосредотачивает свою духовную энергию на залечивании повреждений, постепенно восстанавливая здоровье.",
            5,3,false) {
        @Override
        public String use(AbstractCharacter user, ArrayList<AbstractCharacter> targets) {
            user.addCondition(Condition.Regen);
            user.subtractResource(5);
            String text = user.getName()[0] + " сосредотачивает свою жизненную энергию на полученных ранах, заставляя их медленно затягиваться.\n";
            return text;
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
            return null;
        }
    };

    public static AbstractAbility Slash = new AbstractAbility("Размах",
            "Персонаж совершает круговой удар, нанося урон всем врагам.",10,2,false) {
        @Override
        public String use(AbstractCharacter user, ArrayList<AbstractCharacter> targets) {
            int damageRange;
            if (user instanceof MainCharacter) {
                damageRange = ((MainCharacter) user).getWeapon().getDmg();
            } else if (user instanceof AbstractCompanion) {
                damageRange = ((AbstractCompanion) user).getWeapon().getDmg();
            } else {
                Random r = new Random();
                damageRange = r.nextInt(5);
            }
            for (AbstractCharacter target:targets
            ) {
                Double modifier = 0.2 * damageRange * user.getCharisma() - 0.1 * target.getProtection();
                Integer damage = modifier.intValue() + 5;
                target.subtractHealth(damage);
            }
            user.subtractResource(15);
            String text = user.getName()[0] + " совершает размашистый круговой удар, " +
                    "поражающий всех врагов!\n";
            return text;
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
            int damageRange;
            if (user instanceof MainCharacter) {
                damageRange = ((MainCharacter) user).getWeapon().getDmg();
            } else if (user instanceof AbstractCompanion) {
                damageRange = ((AbstractCompanion) user).getWeapon().getDmg();
            } else {
                damageRange = r.nextInt(5);
            }
            Double modifier = 0.2 * damageRange * user.getStrength() - 0.1 * target.getProtection();
            Integer damage = modifier.intValue();
            target.subtractHealth(damage);
            user.subtractResource(2);
            int p = r.nextInt(2);
            String text;
            if (p == 1) {
                target.removeCondition(Condition.Bleed);
                target.addCondition(Condition.Bleed);
                text = user.getName()[0] + " обманным маневром заставляет " +
                        target.getName()[3] + " открыть уязвимое место, тут же нанося туда коварный удар и оставляя кровоточащую рану!\n";
            } else {
                text = user.getName()[0] + " пытается заставить " +
                        target.getName()[3] + " открыть уязвимое место, однако " + target.getName()[0] +
                        " настороже и не поддается на провокации!\n";
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

    public static AbstractAbility Trick = new AbstractAbility("Уловка",
            "Персонаж раскрывает врагу, что он ранен слабее, чем казалось, восстанавливая половину потерянного здоровья.",
            10,3,false) {
        @Override
        public String use(AbstractCharacter user, ArrayList<AbstractCharacter> targets) {
            int healing = (user.getMaxHealth() - user.getCurrentHealth()) / 2;
            user.addHealth(healing);
            user.subtractResource(10);
            String text = user.getName()[0] + " перестает притворяться ";
            if (user.getFemale()) text = text + "раненой, ";
            else text = text + "раненым, ";
            text = text + "демонстрируя, что полученные удары были не такими уж и серьезными!\n";
            return text;
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
            return null;
        }
    };

    public static AbstractAbility Sting = new AbstractAbility("Укол","Персонаж совершает прицельный удар по врагу, " +
            "наносящий в 2 раза больше урона, если персонаж недавно обнаружил уязвимое место врага.",10,3,true) {
        @Override
        public String use(AbstractCharacter user, ArrayList<AbstractCharacter> targets) {
            return null;
        }

        @Override
        public String use(AbstractCharacter user, AbstractCharacter target) {
            Random r = new Random();
            int damageRange;
            if (user instanceof MainCharacter) {
                damageRange = ((MainCharacter) user).getWeapon().getDmg();
            } else if (user instanceof AbstractCompanion) {
                damageRange = ((AbstractCompanion) user).getWeapon().getDmg();
            } else {
                damageRange = r.nextInt(5);
            }
            Double modifier = 0.2 * damageRange * user.getStrength() - 0.1 * target.getProtection();
            Integer damage = modifier.intValue() + 4;
            int p = 1;
            if (target.getConditions().contains(Condition.Bleed)) {
                p = 2;
                damage = damage * 2;
            }
            target.subtractHealth(damage);
            user.subtractResource(10);
            String text;
            if (p == 1) {
                text = user.getName()[0] + " совершает резкий удар в уязвимое место " +
                        target.getName()[1] + ", оставляя небольшую, но жгучую рану!\n";
            } else {
                text = user.getName()[0] + " совершает резкий удар в уязвимое место " +
                        target.getName()[1] + ", расширяя уже имеющуюся рану!\n";
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
                        target.getName()[3] + ", широко раскрыв челюсти, и его острые зубы оставляют кровоточащую рану!\n";
            } else {
                text = user.getName()[0] + " бросается на " +
                        target.getName()[3] + ", однако ";
                if (target.getFemale()) text = text + "ей ";
                else text = text + "ему ";
                text = text + "удается увернуться, отделавшись царапиной!\n";
            }
            return text;
        }
    };

    public static AbstractAbility Pound = new AbstractAbility("Удар","Персонаж с размаха бьет врага кулаком.",
            2,0,true) {
        @Override
        public String use(AbstractCharacter user, ArrayList<AbstractCharacter> targets) {
            return null;
        }

        @Override
        public String use(AbstractCharacter user, AbstractCharacter target) {
            int damageRange;
            if (user instanceof MainCharacter) {
                damageRange = ((MainCharacter) user).getWeapon().getDmg();
            } else if (user instanceof AbstractCompanion) {
                damageRange = ((AbstractCompanion) user).getWeapon().getDmg();
            } else {
                Random r = new Random();
                damageRange = r.nextInt(5);
            }
            Double modifier = 0.2 * damageRange * user.getStrength() - 0.1 * target.getProtection();
            Integer damage = modifier.intValue() + 3;
            target.subtractHealth(damage);
            user.subtractResource(2);
            String text = user.getName()[0] + " заносит кулак и стремительно опускает его на " +
                    target.getName()[3] + "!\n";
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
}
