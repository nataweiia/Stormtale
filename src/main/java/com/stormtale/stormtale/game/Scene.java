package com.stormtale.stormtale.game;

import com.stormtale.stormtale.World;
import com.stormtale.stormtale.game.inventory.Item;
import com.stormtale.stormtale.game.npc.enemies.Yuka;

public class Scene {

    public static AbstractScene testScene1 = new AbstractScene() {
        @Override
        public void setUpScene(World world) {
            setText(world.getMainCharacter().getName()[0] + " оказывается в узком, продуваемом резким ветром ущелье. Справа и слева высятся неровные каменные стены, позади - захлопнувшиеся ворота.\nЕдинственный путь - вперед.");
            world.setCurrentSceneText(getText());
            setLocation(Location.testLocation);
            world.setCurrentLocation(getLocation());
            ButtonInfo button1 = new ButtonInfo();
            button1.setRow(1);
            button1.setColumn(1);
            button1.setName("Вперед");
            button1.setType("Movement");
            button1.setNewLocation(Location.testLocation2);
            button1.setNextScene(Scene.testScene2);
            addButton(button1);
            ButtonInfo button2 = new ButtonInfo();
            button2.setRow(2);
            button2.setColumn(0);
            button2.setName("Влево");
            button2.setAvailability(false);
            addButton(button2);
            ButtonInfo button3 = new ButtonInfo();
            button3.setRow(2);
            button3.setColumn(2);
            button3.setName("Вправо");
            button3.setAvailability(false);
            addButton(button3);
            ButtonInfo button4 = new ButtonInfo();
            button4.setRow(2);
            button4.setColumn(1);
            button4.setName("Назад");
            button4.setAvailability(false);
            addButton(button4);
            ButtonInfo buttongates = new ButtonInfo();
            buttongates.setRow(0);
            buttongates.setColumn(0);
            buttongates.setName("Ворота");
            buttongates.setType("Continue");
            buttongates.setNextScene(gates);
            addButton(buttongates);
            world.setCurrentButtons(getButtons());
        }
        @Override
        public void changeFlag(World world) {
        }
    };

    public static AbstractScene gates = new AbstractScene() {
        @Override
        public void setUpScene(World world) {
            setText("Ворота каменные и покрыты искусной резьбой. В них заметна небольшая замочная скважина. Возможно, где-то есть ключ?");
            world.setCurrentSceneText(getText());
            setLocation(Location.testLocation);
            world.setCurrentLocation(getLocation());
            ButtonInfo button = new ButtonInfo();
            button.setRow(0);
            button.setColumn(0);
            button.setName("Назад");
            button.setType("Continue");
            button.setNextScene(testScene1repeat);
            addButton(button);
            if (world.testCombat) {
                ButtonInfo key = new ButtonInfo();
                key.setRow(0);
                key.setColumn(1);
                key.setName("Ключ");
                key.setType("Continue");
                key.setNextScene(testEnd);
                addButton(key);
            }
            world.setCurrentButtons(getButtons());
        }
        @Override
        public void changeFlag(World world) {
        }
    };

    public static AbstractScene testScene1repeat = new AbstractScene() {
        @Override
        public void setUpScene(World world) {
            setText(world.getMainCharacter().getName()[0] + " стоит перед захлопнутыми воротами. В них заметна небольшая замочная скважина. Возможно, где-то есть ключ?");
            world.setCurrentSceneText(getText());
            setLocation(Location.testLocation);
            world.setCurrentLocation(getLocation());
            ButtonInfo button1 = new ButtonInfo();
            button1.setRow(1);
            button1.setColumn(1);
            button1.setName("Вперед");
            button1.setType("Movement");
            button1.setNewLocation(Location.testLocation2);
            button1.setNextScene(Scene.testScene2);
            addButton(button1);
            ButtonInfo button2 = new ButtonInfo();
            button2.setRow(2);
            button2.setColumn(0);
            button2.setName("Влево");
            button2.setAvailability(false);
            addButton(button2);
            ButtonInfo button3 = new ButtonInfo();
            button3.setRow(2);
            button3.setColumn(2);
            button3.setName("Вправо");
            button3.setAvailability(false);
            addButton(button3);
            ButtonInfo button4 = new ButtonInfo();
            button4.setRow(2);
            button4.setColumn(1);
            button4.setName("Назад");
            button4.setAvailability(false);
            addButton(button4);
            ButtonInfo buttongates = new ButtonInfo();
            buttongates.setRow(0);
            buttongates.setColumn(0);
            buttongates.setName("Ворота");
            buttongates.setType("Continue");
            buttongates.setNextScene(gates);
            addButton(buttongates);
            world.setCurrentButtons(getButtons());
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene testScene2 = new AbstractScene() {
        @Override
        public void setUpScene(World world) {
            setText(world.getMainCharacter().getName()[0] + " идет по узкому ущелью, впереди и позади высятся каменные стены.");
            world.setCurrentSceneText(getText());
            setLocation(Location.testLocation2);
            world.setCurrentLocation(getLocation());
            ButtonInfo button1 = new ButtonInfo();
            button1.setRow(1);
            button1.setColumn(1);
            button1.setName("Вперед");
            button1.setType("Movement");
            button1.setNewLocation(Location.testLocation3);
            button1.setNextScene(Scene.testScene3);
            addButton(button1);
            ButtonInfo button2 = new ButtonInfo();
            button2.setRow(2);
            button2.setColumn(0);
            button2.setName("Влево");
            button2.setAvailability(false);
            addButton(button2);
            ButtonInfo button3 = new ButtonInfo();
            button3.setRow(2);
            button3.setColumn(2);
            button3.setName("Вправо");
            button3.setAvailability(false);
            addButton(button3);
            ButtonInfo button4 = new ButtonInfo();
            button4.setRow(2);
            button4.setColumn(1);
            button4.setName("Назад");
            button4.setType("Movement");
            button4.setNewLocation(Location.testLocation);
            button4.setNextScene(testScene1repeat);
            addButton(button4);
            world.setCurrentButtons(getButtons());
        }

        @Override
        public void changeFlag(World world) {
        }
    };

    public static AbstractScene testScene3 = new AbstractScene() {
        @Override
        public void setUpScene(World world) {
            clearButtons();
            String text = "";
            if (world.testBerryPicked) text = " идет по узкому ущелью, впереди и позади высятся каменные стены. Невдалеке стоит куст.\nЯгод на нем больше нет.";
            else text = " идет по узкому ущелью, впереди и позади высятся каменные стены. Невдалеке виднеется что-то светящееся.";
            setText(world.getMainCharacter().getName()[0] + text);
            world.setCurrentSceneText(getText());
            setLocation(Location.testLocation3);
            world.setCurrentLocation(getLocation());
            ButtonInfo button1 = new ButtonInfo();
            button1.setRow(1);
            button1.setColumn(1);
            button1.setName("Вперед");
            button1.setType("Movement");
            button1.setNewLocation(Location.testLocation4);
            button1.setNextScene(Scene.testScene4);
            addButton(button1);
            ButtonInfo button2 = new ButtonInfo();
            button2.setRow(2);
            button2.setColumn(0);
            button2.setName("Влево");
            button2.setType("Movement");
            button2.setNewLocation(Location.testLocationShrub);
            button2.setNextScene(shrub);
            addButton(button2);
            ButtonInfo button3 = new ButtonInfo();
            button3.setRow(2);
            button3.setColumn(2);
            button3.setName("Вправо");
            button3.setAvailability(false);
            addButton(button3);
            ButtonInfo button4 = new ButtonInfo();
            button4.setRow(2);
            button4.setColumn(1);
            button4.setName("Назад");
            button4.setType("Movement");
            button4.setNewLocation(Location.testLocation2);
            button4.setNextScene(testScene2);
            addButton(button4);
            world.setCurrentButtons(getButtons());
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene shrub = new AbstractScene() {
        @Override
        public void setUpScene(World world) {
            String text = "";
            if (!world.testBerryPicked){
                text = "Среди камней ущелья притаился небольшой куст. На нем висит одинокая светящаяся ягода. " +
                        world.getMainCharacter().getName()[0] +
                        " знает, что съев такую ягоду в бою, можно быстро воостановить силы.";
                ButtonInfo pick = new ButtonInfo();
                pick.setRow(0);
                pick.setColumn(0);
                pick.setName("Ягода");
                pick.setType("Item");
                pick.setFlag(true);
                pick.setItem(Item.testBerry);
                addButton(pick);
            } else {
                text = "Среди камней ущелья притаился небольшой куст.\nЯгод на нем больше нет.";
            }
            setText(text);
            world.setCurrentSceneText(getText());
            setLocation(Location.testLocationShrub);
            world.setCurrentLocation(getLocation());
            ButtonInfo button1 = new ButtonInfo();
            button1.setRow(1);
            button1.setColumn(1);
            button1.setName("Вперед");
            button1.setAvailability(false);
            addButton(button1);
            ButtonInfo button2 = new ButtonInfo();
            button2.setRow(2);
            button2.setColumn(0);
            button2.setName("Влево");
            button2.setAvailability(false);
            addButton(button2);
            ButtonInfo button3 = new ButtonInfo();
            button3.setRow(2);
            button3.setColumn(2);
            button3.setName("Вправо");
            button3.setType("Movement");
            button3.setNewLocation(Location.testLocation3);
            button3.setNextScene(testScene3);
            addButton(button3);
            ButtonInfo button4 = new ButtonInfo();
            button4.setRow(2);
            button4.setColumn(1);
            button4.setName("Назад");
            button4.setAvailability(false);
            addButton(button4);
            world.setCurrentButtons(getButtons());
        }

        @Override
        public void changeFlag(World world) {
            world.testBerryPicked = true;
        }
    };

    public static AbstractScene testScene4 = new AbstractScene() {
        @Override
        public void setUpScene(World world) {
            setText(world.getMainCharacter().getName()[0] + " идет по узкому ущелью, впереди и позади высятся каменные стены.\n\nЧуть впереди ущелье совершает резкий поворот.");
            world.setCurrentSceneText(getText());
            setLocation(Location.testLocation4);
            world.setCurrentLocation(getLocation());
            ButtonInfo button1 = new ButtonInfo();
            button1.setRow(1);
            button1.setColumn(1);
            button1.setName("Вперед");
            button1.setAvailability(false);
            addButton(button1);
            ButtonInfo button2 = new ButtonInfo();
            button2.setRow(2);
            button2.setColumn(0);
            button2.setName("Влево");
            button2.setAvailability(false);
            addButton(button2);
            ButtonInfo button3 = new ButtonInfo();
            button3.setRow(2);
            button3.setColumn(2);
            button3.setName("Вправо");
            button3.setType("Movement");
            button3.setNewLocation(Location.testLocation5);
            button3.setNextScene(testScene5);
            addButton(button3);
            ButtonInfo button4 = new ButtonInfo();
            button4.setRow(2);
            button4.setColumn(1);
            button4.setName("Назад");
            button4.setType("Movement");
            button4.setNewLocation(Location.testLocation3);
            button4.setNextScene(testScene3);
            addButton(button4);
            world.setCurrentButtons(getButtons());
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene testScene5 = new AbstractScene() {
        @Override
        public void setUpScene(World world) {
            clearButtons();
            String text = "";
            if (!world.testCombat) {
                text = "Впереди высится искусно украшенный каменный алтарь. На нем лежит ключ.";
                ButtonInfo combat = new ButtonInfo();
                combat.setRow(0);
                combat.setColumn(0);
                combat.setName("Ключ");
                combat.setType("Combat");
                Yuka yuka1 = new Yuka();
                combat.addEnemy(yuka1);
                Yuka yuka2 = new Yuka();
                combat.addEnemy(yuka2);
                combat.setNextScene(testScene5);
                String combatText ="Когда " + world.getMainCharacter().getName()[0]
                        + " поднимает с алтаря ключ, окружающие камни начинают дрожать и в воздух взметаются клубы пыли.\n\nНа ";
                if (world.getMainCharacter().getFemale()) combatText = combatText + "нее ";
                else combatText = combatText + "него ";
                combatText = combatText + "нападают две дикие юки!";
                combat.setStartCombatText(combatText);
                combat.setFlag(true);
                addButton(combat);
                //combat here
            } else {
                text = "Впереди высится искусно украшенный каменный алтарь. Ключа на нем больше нет.";
            }
            setText(text);
            setLocation(Location.testLocation5);
            world.setCurrentLocation(getLocation());
            world.setCurrentSceneText(getText());
            ButtonInfo button1 = new ButtonInfo();
            button1.setRow(1);
            button1.setColumn(1);
            button1.setName("Вперед");
            button1.setAvailability(false);
            addButton(button1);
            ButtonInfo button2 = new ButtonInfo();
            button2.setRow(2);
            button2.setColumn(0);
            button2.setName("Влево");
            button2.setType("Movement");
            button2.setNewLocation(Location.testLocation4);
            button2.setNextScene(testScene4);
            addButton(button2);
            ButtonInfo button3 = new ButtonInfo();
            button3.setRow(2);
            button3.setColumn(2);
            button3.setName("Вправо");
            button3.setAvailability(false);
            addButton(button3);
            ButtonInfo button4 = new ButtonInfo();
            button4.setRow(2);
            button4.setColumn(1);
            button4.setName("Назад");
            button4.setAvailability(false);
            addButton(button4);
            world.setCurrentButtons(getButtons());
        }

        @Override
        public void changeFlag(World world) {
            world.testCombat = true;
        }
    };

    public static AbstractScene testEnd = new AbstractScene() {
        @Override
        public void setUpScene(World world) {
            setText(world.getMainCharacter().getName()[0] + " отпирает ключом ворота и успешно покидает ущелье!");
            setLocation(Location.testLocation);
            setButton(testScene21,0,0,"Далее");
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene testScene21 = new AbstractScene(Location.testLocation21) {
        @Override
        public void setUpScene(World world) {
            setText("Локация 2 комната 1");
            setMovementButtons(true,testScene22,false,null,false,null,false,null);
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene testScene22 = new AbstractScene(Location.testLocation22) {
        @Override
        public void setUpScene(World world) {
            setText("Локация 2 комната 2");
            setMovementButtons(false,null,true,testScene21,false,null,false,null);
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene ScholarStart1 = new AbstractScene(Location.ScholarHome) {
        @Override
        public void setUpScene(World world) {
            String text = "\tЭто был ясный летний день.\n\t" + world.getMainCharacter().getName()[0] +
                    " как раз заканчивал";
            if (world.getMainCharacter().getFemale()) text = text + "а";
            text = text + " разбирать утренние письма. Старый дед Мехоро опять жалуется на бессонницу и странные звуки по ночам, надо бы проверить талисманы." +
                    " Кто-то подбросил шуточную листовку о \"персиках, лучших на этой стороне моря! Персики, персики, покупайте персики, сочные, свежие, красивые!\"." +
                    "Нарисованный рядом персик отчетливо напоминал некую неназываемую часть тела. " +
                    "Видимо, не всем нравились каждодневные крики торговца Ру. Из столицы прислали новую теорию о влиянии подводных течений" +
                    " на перемещения морских духов, будет весьма интересно ознакомиться—\n" +
                    "\tВнезапно раздался громкий, лихорадочный стук.";
            setText(text);
            setButton(ScholarStart2,0,0,"Далее");
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene ScholarStart2 = new AbstractScene(Location.ScholarHome) {
        @Override
        public void setUpScene(World world) {
            String text = "\t\"";
            if (world.getMainCharacter().getFemale()) text = text + "Госпожа ";
            else text = text + "Господин ";
            text = text + world.getMainCharacter().getName()[0] + "!  Беда! Беда случилась!\"\n" +
                    "\tПосыльный, мальчишка лет четырнадцати в одеждах слуги, явно был в полушаге от паники. " +
                    "Что бы ни случилось, это явно было что-то серьезное.\n\t\"Тихо, тихо. Дыши. " +
                    "Давай, вместе со мной, раз, два…\", — " + world.getMainCharacter().getName()[0] +
                    "приобнял";
            if  (world.getMainCharacter().getFemale()) text = text + "а";
            text = text + " посыльного за плечи, положив руку ему на грудь.  Мальчишка вздрогнул, " +
                    "хватая воздух губами, но через несколько мгновений все же смог произнести:\n\t" +
                    "\"Дракон… небесный дракон пал, ";
            if (world.getMainCharacter().getFemale()) text = text + "госпожа.\"";
            else text = text + "господин.\"";
            setText(text);
            setButton(ScholarStart3,0,0,"Далее");
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene ScholarStart3 = new AbstractScene(Location.ScholarHome) {
        @Override
        public void setUpScene(World world) {
            String text = "\tЭти слова пронзили " + world.getMainCharacter().getName()[1] + ", словно пылающее копье.\n" +
                    "\t\"Наместница Кизу п-просит вашего присутствия.\", — продолжал тем временем посыльный.\n" +
                    "\"Передай ей, что я прибуду как можно скорее.\"";
            setText(text);
            setButton(ScholarHome,0,0,"Далее");
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene ScholarHome = new AbstractScene(Location.ScholarHome) {
        @Override
        public void setUpScene(World world) {
            String text = world.getMainCharacter().getName()[0] + " стоит во дворе небольшого поместья, пожалованного ";
            if (world.getMainCharacter().getFemale()) text = text + "ей ";
            else text = text + "ему ";
            text = text + "указанием императора вместе с должностью. Слева раскинулся небольшой садик, вперемешку засаженный яркими декоративными " +
                    "цветами и невзрачными травками, использующимися в ворожбе. Справа — беседка, нависающая над небольшим прудиком. " +
            "Само поместье выглядит изящным и возвышенным, в самый раз утонченному столичному служащему.";
            setText(text);
            setMovementButtons(false,null,true,RichStreet1,false,null,false,null);
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene RichStreet1 = new AbstractScene(Location.RichStreet1) {
        @Override
        public void setUpScene(World world) {
            setText(world.getMainCharacter().getName()[0] + " идет по широкой улице, мощеной узорчатым камнем. По обеим сторонам высятся яркие, " +
                    "искусно разукрашенные дома. Туда-сюда спешат слуги в добротных одеждах, степенно прогуливаются знатные господа, " +
                    "прикрываясь от солнца цветными зонтиками.");
            setMovementButtons(true,ScholarHome,false,null,true,RichStreet2,false,null);
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene RichStreet2 = new AbstractScene(Location.RichStreet2) {
        @Override
        public void setUpScene(World world) {
            setText(world.getMainCharacter().getName()[0] + " идет по широкой улице, мощеной узорчатым камнем. По обеим сторонам высятся яркие, " +
                    "искусно разукрашенные дома. Туда-сюда спешат слуги в добротных одеждах, степенно прогуливаются знатные господа, " +
                    "прикрываясь от солнца цветными зонтиками.");
            setMovementButtons(false,null,false,null,true,RichStreet3,true,RichStreet1);
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene RichStreet3 = new AbstractScene(Location.RichStreet3) {
        @Override
        public void setUpScene(World world) {
            setText(world.getMainCharacter().getName()[0] + " идет по широкой улице, мощеной узорчатым камнем. По обеим сторонам высятся яркие, " +
                    "искусно разукрашенные дома. Туда-сюда спешат слуги в добротных одеждах, степенно прогуливаются знатные господа, " +
                    "прикрываясь от солнца цветными зонтиками.");
            setMovementButtons(false,null,true,Pier1,false,null,true,RichStreet2);
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene Pier1 = new AbstractScene(Location.Pier1) {
        @Override
        public void setUpScene(World world) {
            setText(world.getMainCharacter().getName()[0] + " идет вдоль многочисленных причалов. Волны лениво бьются о берег, " +
                    "слышны крики матросов, загружающих что-то на корабль — или может, выгружающих? Сложно понять. " +
                    "Оглушительно несет рыбой от разложенных неподалеку рыбацких прилавков.");
            setMovementButtons(true,RichStreet3,true,Pier2,false,null,false,null);
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene Pier2 = new AbstractScene(Location.Pier2) {
        @Override
        public void setUpScene(World world) {
            setText(world.getMainCharacter().getName()[0] + " идет вдоль многочисленных причалов. Волны лениво бьются о берег, " +
                    "слышны крики матросов, загружающих что-то на корабль — или может, выгружающих? Сложно понять. " +
                    "Оглушительно несет рыбой от разложенных неподалеку рыбацких прилавков.");
            setMovementButtons(true,Pier1,false,null,false,null,false,null);
        }

        @Override
        public void changeFlag(World world) {

        }
    };
}
