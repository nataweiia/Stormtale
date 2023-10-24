package com.stormtale.stormtale.game;

import com.stormtale.stormtale.World;
import com.stormtale.stormtale.game.inventory.Item;
import com.stormtale.stormtale.game.npc.AbstractNPC;
import com.stormtale.stormtale.game.npc.NPC;
import com.stormtale.stormtale.game.npc.enemies.Wolf;
import com.stormtale.stormtale.game.npc.enemies.Yuka;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Scene implements Serializable {

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
                Yuka yuka1 = new Yuka(world.getDifficulty());
                combat.addEnemy(yuka1);
                Yuka yuka2 = new Yuka(world.getDifficulty());
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
            setMovementButtons(true,Location.testLocation22,false,null,false,null,false,null);
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene testScene22 = new AbstractScene(Location.testLocation22) {
        @Override
        public void setUpScene(World world) {
            setText("Локация 2 комната 2");
            setMovementButtons(false,null,true,Location.testLocation21,false,null,false,null);
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene ScholarStart1 = new AbstractScene(Location.ScholarHome) {
        @Override
        public void setUpScene(World world) {
            clearButtons();
            String text = "Это было ясное летнее утро.\nБледные лучи едва взошедшего солнца мягко скользили по каплям воды, "
                    + "оставленным прошедшим ночным штормом на лепестках цветов. Воздух был свежим и влажным, наполненным тем особенным запахом, " +
                    " что оставляет после себя напоенная дождем земля.\n" + world.getMainCharacter().getName()[0];
            if (world.getMainCharacter().getFemale()) text = text + " расположилась ";
            else text = text + "расположился ";
            text = text + "в дворовой беседке, не спеша наслаждаясь утренним чаем с капелькой меда и лениво прикидывая в голове сегодняшний план " +
                    " обхода. Дед Мехоро жаловался на подозрительные стуки по ночам, надо бы заглянуть; " +
                    "жемчужного порошка осталось совсем мало, не забыть пополнить запас; на окраине леса, говорят, видели—\n" +
                    "Внезапно раздался громкий стук в ворота.";
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
            clearButtons();
            String text = "Тяжело вздохнув, " + world.getMainCharacter().getName()[0] +
                    " отставил";
            if (world.getMainCharacter().getFemale()) text = text + "а";
            text = text + " почти допитый чай и легким движением запястья распахнул";
            if (world.getMainCharacter().getFemale()) text = text + "а";
            text = text + "ворота.\nВ поместье не было слуг — о домашних делах заботились крохотные духи-яко, в обмен на капельки пасты из жемчужного порошка " +
            " и ароматные палочки благовоний.\nЗа створкой оказалась пара старых знакомых — стражник Го-Бэй, высокий и худой юноша, которого " +
            "под предлогом набора опыта частенько назначали в телохранители " + world.getMainCharacter().getName()[2] +
            ", и наместница форпоста Кизу, низенькая, иссушенная морским ветром и бюрократией женщина лет пятидесяти.";
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
            clearButtons();
            String text = world.getMainCharacter().getName()[0] +
                    " встал";
            if (world.getMainCharacter().getFemale()) text = text + "а";
            text = text + " из-за стола — технически наместница обладала более высоким рангом, и встречать ее сидя было невместно.\n" +
                    "\"Приветствую госпожу наместницу, долгих лет и благополучия ей\", — церемонно ";
            if (world.getMainCharacter().getFemale()) text = text + "поклонилась ";
            else text = text + "поклонился ";
            text = text + world.getMainCharacter().getName()[0] + ".\n\"Приветствую ";
            if (world.getMainCharacter().getFemale()) text = text + "госпожу";
            else text = text + "господина";
            text = text + " императорского ученого, долгих лет и благополучия ";
            if (world.getMainCharacter().getFemale()) text = text + "ей";
            else text = text + "ему";
            text = text + "\", — так же церемонно поклонилась в ответ наместница.\n" +
                    "Теперь, когда с приличиями было покончено, можно было переходить к делу.";
            setText(text);
            setButton(ScholarStart4,0,0,"Далее");
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene ScholarStart4 = new AbstractScene(Location.ScholarHome) {
        @Override
        public void setUpScene(World world) {
            clearButtons();
            String text = world.getMainCharacter().getName()[0] +
                    " и госпожа Кизу проследовали в дом — теперь " + world.getMainCharacter().getName()[2] +
                    " стало заметно, что Го-Бэй несет какой-то предмет, завернутый в плотную ткань.\n" +
                    world.getMainCharacter().getName()[0];
            if (world.getMainCharacter().getFemale()) text = text + " нахмурилась";
            else text = text + " нахмурился";
            text = text + ". Что бы это могло быть?..\n Долго ";
            if (world.getMainCharacter().getFemale()) text = text + "ей";
            else text = text + "ему";
            text = text + " гадать не пришлось, потому как первым же делом госпожа Кизу приказала Го-Бэю установить предмет " +
            "на ближайший столик и развернуть ткань.";
            setText(text);
            setButton(ScholarStart5,0,0,"Далее");
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene ScholarStart5 = new AbstractScene(Location.ScholarHome) {
        @Override
        public void setUpScene(World world) {
            clearButtons();
            String text = "Бледно-голубое сияние залило дом " + world.getMainCharacter().getName()[1] +
                    ", окутав все неземной дымкой. На столике лежала Драконья Жемчужина — источник жизненной силы и вместилище души дракона. " +
                    "Ее свечение говорило о том, что дракон еще жив, однако ее нахождение в доме " + world.getMainCharacter().getName()[1] +
                    " определенно свидетельствовало о произошедшей катастрофе.\n\"Надеюсь, я правильно предполагаю, что вы понимаете, что это " +
                    "такое и какие последствия это несет для форпоста\", — тяжело произнесла госпожа Кизу, роняя каждое слово как " +
                    "десятипудовый камень.\n\"Разумеется, госпожа наместница. Верно ли будет с моей стороны предположить, что вы " +
                    "намереваетесь препоручить мне решение этой проблемы?\", — с не меньшей тяжестью произнес";
            if (world.getMainCharacter().getFemale()) text = text + "ла";
            text = text + " " + world.getMainCharacter().getName()[0] + ".";
            setText(text);
            setButton(ScholarStart6,0,0,"Далее");
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene ScholarStart6 = new AbstractScene(Location.ScholarHome) {
        @Override
        public void setUpScene(World world) {
            clearButtons();
            String text = "\"Рада, что мы поняли друг друга\", — с этими словами наместница Кизу покинула поместье, не попрощавшись.\n" +
                    "На секунду повисла напряженная тишина, а затем " + world.getMainCharacter().getName()[0] +
                    " с Го-Бэем синхронно рассмеялись.\n\"'Верно ли будет с моей стороны предположить'! Ну ты умеешь завернуть, конечно!\"" +
                    ", — повторил со смехом Го-Бэй, — \"Но на более серьезной ноте, это обнаружили рыбаки, вышедшие на утренний лов. " +
                    "Демонова штука так светилась, что они приняли ее за встающее солнце\".\n" + world.getMainCharacter().getName()[0] +
                    " тоже уже ";
            if (world.getMainCharacter().getFemale()) text = text + "успокоилась и принялась размышлять.";
            else text = text + "успокоился и принялся размышлять.";
            setText(text);
            setButton(ScholarStart7,0,0,"Далее");
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene ScholarStart7 = new AbstractScene(Location.ScholarHome) {
        @Override
        public void setUpScene(World world) {
            clearButtons();
            String text = "Одно из удивительных свойств Драконьих Жемчужин заключается в том, что они позволяют дракону " +
                    "выжить, даже если его тело мертво. Впоследствии, если жемчужина окажется в богатом духовной энергией месте, " +
                    "вокруг нее постепенно сформируется новое тело для дракона.\nК сожалению, по всем доступным сведениям " +
                    "этот процесс занимает никак не меньше половины столетия, а такой срок без защиты Небесного Дракона форпост Таки " +
                    "никак не переживет.\nМожет быть, можно как-то ускорить процесс?..";
            setText(text);
            setButton(ScholarStart8,0,0,"Далее");
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene ScholarStart8 = new AbstractScene(Location.ScholarHome) {
        @Override
        public void setUpScene(World world) {
            clearButtons();
            String text = "Го-Бэй терпеливо наблюдал, пока " + world.getMainCharacter().getName()[0] + " ходил";
            if (world.getMainCharacter().getFemale()) text = text + "а";
            text = text + " из стороны в сторону, рассуждая вслух. Когда рассуждения пошли на третий круг, " +
                    "он откашлялся и нерешительно заметил:\n\"Может быть, Солнечный монах что-то знает?\"" +
                    "\"Солнечный монах? Что этот старый дурак может… хм.\", — " + world.getMainCharacter().getName()[0];
            if (world.getMainCharacter().getFemale()) text = text + " остановилась, резко выбитая";
            else text = text + " остановился, резко выбитый";
            text = text + " из спирали рассуждений.\n\"Я крайне сомневаюсь, что ему известно что-то, что неизвестно мне, " +
                    "но Храм Солнца — самое богатое духовной энергией место на острове, и если у нас и есть какие-то шансы " +
                    "восстановить дракона побыстрее, они находятся там.\"";
            setText(text);
            setButton(ScholarStart9,0,0,"Далее");
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene ScholarStart9 = new AbstractScene(Location.ScholarHome) {
        @Override
        public void setUpScene(World world) {
            clearButtons();
            String text = "\"Ну что ж. Отправляемся в Храм Солнца!\"\n" + world.getMainCharacter().getName()[0] + " уже ";
            if (world.getMainCharacter().getFemale()) text = text + "отправилась к выходу из дома, однако остановилась";
            else text = text + "отправился к выходу из дома, однако остановился";
            text = text + " на полушаге, нерешительно оглянувшись на Го-Бэя:\n\"Ты ведь со мной?\"\n" +
            "\"Разумеется, ";
            if (world.getMainCharacter().getFemale()) text = text + "госпожа";
            else text = text + "господин";
            text = text + ". В конце концов, госпожа наместница так часто назначала меня вашим телохранителем, " +
                    "что мы можем принять это как данное\", — ободряюще улыбнулся Го-Бэй.";
            setText(text);
            world.addQuest(Quest.MainQuest);
            world.addCompanion(Companion.GoBei);
            setButton(ScholarHome,0,0,"Далее");
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene SamuraiStart1 = new AbstractScene(Location.SamuraiHome) {
        @Override
        public void setUpScene(World world) {
            clearButtons();
            String text = "Это было ясное летнее утро.\nУдар. Взмах. Поворот. Еще удар. Не обращая внимания на ранний час, " +
                    world.getMainCharacter().getName()[0] + " привычно проводил";
            if (world.getMainCharacter().getFemale()) text = text + "а";
            text = text + " утреннюю тренировку. Комья грязи и капли мутной воды разлетались во все стороны от оставленных прошедшим ночным " +
                    "штормом многочисленных луж.\nРывок. Выпад. Удар. Резкий взмах тренировочного меча выбил из потрепанного манекена " +
                    " острую щепку, которая отлетела в сторону, едва не вонзившись в руку молодой девушке, только что подошедшей на " +
                    "тренировочную площадку.\n" +
                    "Заметив посетительницу, " + world.getMainCharacter().getName()[0];
            if (world.getMainCharacter().getFemale()) text = text + " остановилась.";
            else text = text + " остановился.";
            setText(text);
            setButton(SamuraiStart2,0,0,"Далее");
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene SamuraiStart2 = new AbstractScene(Location.SamuraiHome) {
        @Override
        public void setUpScene(World world) {
            clearButtons();
            String text = "\"Приветствую ";
            if (world.getMainCharacter().getFemale()) text = text + "госпожу";
            else text = text + "господина";
            text = text + " капитана стражи, долгих лет и благополучия ";
            if (world.getMainCharacter().getFemale()) text = text + "ей";
            else text = text + "ему";
            text = text + "!\", — жизнерадостно поклонилась девушка, ничуть не смущенная едва не полученной раной.\n" +
            "\"Приветствую, госпожа…\", — " + world.getMainCharacter().getName()[0];
            if (world.getMainCharacter().getFemale()) text = text + " нахмурилась";
            else text = text + " нахмурился";
            text = text + " , пытаясь припомнить девушку.\n\"Цаэси! Младший писарь в свите ее высокоблагородия госпожи наместницы Кизу, " +
            "долгих лет и благополучия ей!\"\n" + world.getMainCharacter().getName()[0] + " не мог";
            if (world.getMainCharacter().getFemale()) text = text + "ла";
            text = text + " припомнить никакой Цаэси — девушка явно была ответственна за вопросы, не касающиеся стражи, " +
            "и раньше с " + world.getMainCharacter().getName()[4] + " не взаимодействовала.\n\"Итак… Цаэси. Что же тебе от меня нужно?\"";
            setText(text);
            setButton(SamuraiStart3,0,0,"Далее");
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene SamuraiStart3 = new AbstractScene(Location.SamuraiHome) {
        @Override
        public void setUpScene(World world) {
            clearButtons();
            String text = "\"Ах да, разумеется!\", — Цаэси резко выдернула из рукава официального вида свиток и протянула " +
                    world.getMainCharacter().getName()[2] + ".\n\"Госпожа наместница приказала мне сопровождать вас на вашем " +
                    "следующем официальном задании!\"\n" + world.getMainCharacter().getName()[0] + " не спеша развернул";
            if (world.getMainCharacter().getFemale()) text = text + "а";
            text = text + " свиток и, прищурившись, ";
            if (world.getMainCharacter().getFemale()) text = text + "вчиталась";
            else text = text + "вчитался";
            text = text + " в мелкие иероглифы.\nВ самом свитке не было ничего необычного — стандартный бланк официального поручения " +
            "от служащего ранга наместницы служащему ранга капитана стражи.\nЧто представляло интерес, так это само поручение.\n" +
            "Вместо обычного описания особо опасного преступника, по слухам прибывшего на остров или жуткого монстра, " +
            "в очередной раз выбравшегося из Бездны, там было нечто намного более серьезное.";
            setText(text);
            setButton(SamuraiStart4,0,0,"Далее");
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene SamuraiStart4 = new AbstractScene(Location.SamuraiHome) {
        @Override
        public void setUpScene(World world) {
            clearButtons();
            String text = "‘Небесный дракон пал. Капитан стражи " + world.getMainCharacter().getName()[0] +
                    ", вам поручается доставить оставленную им жемчужину в Храм Солнца, и далее содействовать " +
                    "Солнечному монаху в любых действиях, необходимых для восстановления тела Небесного Дракона.’\n" +
                    "\"Вот значит как… И что же, тебя послали в Храм Солнца вместе со мной? И с какой же целью?\", — " +
                    world.getMainCharacter().getName()[0] + " перевел";
            if (world.getMainCharacter().getFemale()) text = text + "а";
            text = text + " мрачный взгляд на Цаэси.\nТа, ничуть не смущенная очевидной враждебностью, бодро ответила:\n" +
            "\"Господин Пако заявил, что восстановление тела дракона, несомненно, потребует тонких манипуляций духовной " +
            "энергией, на которые вы, уж извините, вряд ли способны, однако он уже стар и не может ‘скакать по лесам молодым козлом’. " +
            "Так уж вышло, что я в свободное время немного изучала манипуляции энергией, и потому госпожа наместница " +
            "в бесконечной мудрости своей сочла меня наиболее подходящей кандидатурой!\"";
            setText(text);
            setButton(SamuraiStart5,0,0,"Далее");
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene SamuraiStart5 = new AbstractScene(Location.SamuraiHome) {
        @Override
        public void setUpScene(World world) {
            clearButtons();
            String text = "\"Ну что ж. Храм Солнца так Храм Солнца. Жемчужина-то где?\"\n" +
                    "\"Ах, вот она! Уж извините, пристроила ее тут в сторонке, а то она изрядно крупная, да и неудобная в обращении к тому же!\" , — " +
                    "указала Цаэси на угол рядом с входом на тренировочную площадку. Там действительно лежал некий завернутый в плотную ткань предмет, " +
                    "который " + world.getMainCharacter().getName()[0] + " и подобрал";
            if (world.getMainCharacter().getFemale()) text = text + "а";
            text = text + ", прежде чем уйти с площадки.";
            world.addQuest(Quest.MainQuest);
            world.addCompanion(Companion.Caesi);
            setText(text);
            setButton(SamuraiHome,0,0,"Далее");
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene RascalStart1 = new AbstractScene(Location.RascalHome) {
        @Override
        public void setUpScene(World world) {
            clearButtons();
            String text = "Это было ясное летнее утро.\nНе то чтобы " + world.getMainCharacter().getName()[0] + " мог";
            if (world.getMainCharacter().getFemale()) text = text + "ла";
            text = text + " лицезреть его милосердные лучи в данный момент. В конце концов, трудно лицезреть что бы там ни было, " +
            "когда отсыпаешься после вчерашней пьянки. \nВместо этого "  + world.getMainCharacter().getName()[0] + " удовлетворенно лицезрел";
            if (world.getMainCharacter().getFemale()) text = text + "а";
            text = text + " стайку зайцев, одетых в шелковые рубахи и расшитые золотом ботиночки. ";
            if (world.getMainCharacter().getFemale()) text = text + "Ей";
            else text = text + "Ему";
            text = text + " только что удалось успешно разрешить их спор, в котором богатый заяц настаивал, что заяц победнее " +
            "должен отдать ему свою дочь в жены в счет уплаты долга. Заяц победнее как раз со слезами на глазах предлагал свою дочь в жены уже " +
            world.getMainCharacter().getName()[2] + ", бесконечно благодарный за освобождение от долга, а " + world.getMainCharacter().getName()[0] +
            ", разумеется, благородно ";
            if (world.getMainCharacter().getFemale()) text = text + "отказывалась";
            else text = text + "отказывался";
            text = text + " от награды—\nВнезапно крики богатого зайца об обещании мести сменились криками несколько иного толка. " +
            "А через мгновение к ним добавились и звуки ударов по дереву.";
            setText(text);
            setButton(RascalStart2,0,0,"Далее");
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene RascalStart2 = new AbstractScene(Location.RascalHome) {
        @Override
        public void setUpScene(World world) {
            clearButtons();
            String text = "\"Угх, ну кто там еще?\", — с трудом продрав глаза, " + world.getMainCharacter().getName()[0];
            if (world.getMainCharacter().getFemale()) text = text + " поплелась";
            else text = text + " поплелся";
            text = text + " открывать дверь.\nЗа дверью был старый знакомый — стражник Суото, немолодой уже низкорослый мужчина, " +
            "главной отличительной чертой которого были длинные седые усы.\n\"Дед? Тебе чего?\", — поприветствовал";
            if (world.getMainCharacter().getFemale()) text = text + "а";
            text = text + " его " + world.getMainCharacter().getName()[0] + ".\nСуото был тем стражником, которого наместница Кизу " +
            "чаще всего посылала разбираться с трущобами, потому " + world.getMainCharacter().getName()[0] + " был";
            if (world.getMainCharacter().getFemale()) text = text + "а";
            text = text + " с ним хорошо и давно знаком";
            if (world.getMainCharacter().getFemale()) text = text + "а";
            text = text + ".\nВместо ответа Суото достал и развернул официального вида свиток.";
            setText(text);
            setButton(RascalStart3,0,0,"Далее");
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene RascalStart3 = new AbstractScene(Location.RascalHome) {
        @Override
        public void setUpScene(World world) {
            clearButtons();
            String text = "\"" + world.getMainCharacter().getName()[0];
            if (world.getMainCharacter().getFemale()) text = text + ", гнусная злодейка";
            else text = text + ", гнусный злодей";
            text = text + "! Ты обвиняешься в воровстве, вторжении на частную собственность, несоблюдении надлежащего " +
            "поведения в публичных местах…\", — чем дальше Суото зачитывал лист, тем в большее замешательство приходил";
            if (world.getMainCharacter().getFemale()) text = text + "а";
            text = text + " " + world.getMainCharacter().getName()[0] + ". Большая часть этих ‘преступлений’ совершалась всем населением трущоб и " +
            "примерно половиной населения порта, а среди оставшихся были и те, которые " + world.getMainCharacter().getName()[0] + " совершал";
            if (world.getMainCharacter().getFemale()) text = text + "а";
            text = text + " по заказу самой наместницы, когда ей требовалась тихая и аккуратная рука.\n" + world.getMainCharacter().getName()[0] +
            " в последнее время вроде бы не гневал";
            if (world.getMainCharacter().getFemale()) text = text + "а";
            text = text + " наместницу больше обычного, так с чего же?..\n\"…И несоблюдении небесных законов!\", — выразительно " +
            "дочитал наконец Суото.\n\"В наказание за твои многочисленные преступления, тебе предписываются общественные работы. " +
            "В бесконечной мудрости своей госпожа наместница уже подобрала назначение.\"";
            setText(text);
            setButton(RascalStart4,0,0,"Далее");
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene RascalStart4 = new AbstractScene(Location.RascalHome) {
        @Override
        public void setUpScene(World world) {
            clearButtons();
            String text = "Ах, так вот в чем дело. " + world.getMainCharacter().getName()[0] + " мгновенно ";
            if (world.getMainCharacter().getFemale()) text = text + "успокоилась";
            else text = text + "успокоился";
            text = text + ". Госпоже наместнице всего лишь вновь потребовалась тихая и аккуратная рука.\n" +
            "Список преступлений был здесь вовсе не для наказания, а, наоборот, в качестве награды. " +
            "В конце концов, согласно императорским законам невозможно было отслужить два наказания за одно преступление.\n" +
            world.getMainCharacter().getName()[0] + " протянул";
            if (world.getMainCharacter().getFemale()) text = text + "а";
            text = text + " руку за свитком с описанием назначения, который Суото торжественно передал.\n" +
            "\"Ну… удачи, я полагаю.\", — помявшись пару мгновений, пронаблюдав за чтением свитка " + world.getMainCharacter().getName()[4] +
            " и поняв что возражений не будет, Суото развернулся и двинулся прочь.";
            setText(text);
            setButton(RascalStart5,0,0,"Далее");
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene RascalStart5 = new AbstractScene(Location.RascalHome) {
        @Override
        public void setUpScene(World world) {
            clearButtons();
            String text = "В свитке, если вычеркнуть официальные завитушки, было написано следующее: " +
                    "Небесный Дракон пал, сплюнув свою жемчужину; в свите наместницы сидят одни надушенные куколки и старые деды " +
                    "(тут, конечно, " + world.getMainCharacter().getName()[0] + " перефразировал";
            if (world.getMainCharacter().getFemale()) text = text + "а";
            text = text + "), никто из которых не хочет отправляться лечить дракона, потому наместница нашла того, " +
            "кто не сможет отказаться; для лечения дракона требовалось оттащить жемчужину в лес, отыскать там неуловимый Храм Солнца " +
            "и уговорить Солнечного монаха разобраться со всеми этими делами.\nХа, да проще простого. " +
            "В лесу не было ничего такого уж смертельно опасного, твари Бездны до него обычно не добирались. Что же касается Храма Солнца, " +
            "тут " + world.getMainCharacter().getName()[0] + " знал";
            if (world.getMainCharacter().getFemale()) text = text + "а";
            text = text + " один трюк — Солнечный монах обожал медовое вино старухи Мао, поэтому если иметь " +
            "при себе кувшинчик этого вина, Храм Солнца появится очень быстро.";
            setText(text);
            setButton(RascalStart6,0,0,"Далее");
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene RascalStart6 = new AbstractScene(Location.RascalHome) {
        @Override
        public void setUpScene(World world) {
            clearButtons();
            String text = "К сожалению, " + world.getMainCharacter().getName()[0] + " изрядно ";
            if (world.getMainCharacter().getFemale()) text = text + "поистратилась";
            else text = text + "поистратился";
            text = text + " во вчерашнем походе в таверну, а вино старухи Мао — одно из самых дорогих в городе, так что сперва " +
            "придется быстро подзаработать чего-ничего. Это все равно будет быстрее чем шарахаться по лесу без вина.\n" +
            "Сонные прикидывания " + world.getMainCharacter().getName()[1] + " прервал звук громкого зевка у ";
            if (world.getMainCharacter().getFemale()) text = text + "нее";
            else text = text + "него";
            text = text + " за левым плечом.\nПотягиваясь на ходу, из дома вышел Мару, близкий друг " + world.getMainCharacter().getName()[1] +
            ", который после вчерашней пьянки за недостатком своего постоянного дома остался у " + world.getMainCharacter().getName()[1] + ".";
            setText(text);
            setButton(RascalStart7,0,0,"Далее");
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene RascalStart7 = new AbstractScene(Location.RascalHome) {
        @Override
        public void setUpScene(World world) {
            clearButtons();
            String text = "\"Че тут у тебя?\", — заглянул он через плечо " + world.getMainCharacter().getName()[2] +
                    ". Рост легко позволял ему это сделать — он был на голову выше " + world.getMainCharacter().getName()[1] +
                    ".\n\"Небесный дракон откинул копыта, и мне поручено его воскресить!\", — с фальшивой радостью ";
            if (world.getMainCharacter().getFemale()) text = text + "откликнулась";
            else text = text + "откликнулся";
            text = text + " " + world.getMainCharacter().getName()[0] + ".\n\"Демоновы портки!.. Это что же… Это как же так…\", — " +
            "от таких новостей Мару мгновенно проснулся.\nРастерянно пошатавшись несколько мгновений, он, однако, быстро пришел в себя " +
            "и преисполнился решимости:\n\"Ну, ниче! Мы с тобой всякое пережили, ";
            if (world.getMainCharacter().getFemale()) text = text + "подруга";
            else text = text + "друг";
            text = text + ", и это переживем! Че там делать-то надо?\"\n\"Для начала — подзаработать пару монет на вино.\"\n" +
            "\"О, ну это мы завсегда!\"";
            world.addQuest(Quest.MainQuest);
            world.addCompanion(Companion.Maru);
            setText(text);
            setButton(RascalHome,0,0,"Далее");
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene ScholarHome = new AbstractScene(Location.ScholarHome) {
        @Override
        public void setUpScene(World world) {
            clearButtons();
            String text = world.getMainCharacter().getName()[0] + " стоит во дворе небольшого поместья, пожалованного ";
            if (world.getMainCharacter().getFemale()) text = text + "ей ";
            else text = text + "ему ";
            text = text + "указанием императора вместе с должностью. Слева раскинулся небольшой садик, вперемешку засаженный яркими декоративными " +
                    "цветами и невзрачными травками, использующимися в ворожбе. Справа — беседка, нависающая над небольшим прудиком. " +
            "Само поместье выглядит изящным и возвышенным, в самый раз утонченному столичному служащему.";
            setText(text);
            setMovementButtons(false,null,true,Location.RichStreet1,false,null,false,null);
            if (world.getMainCharacter().getCharacterClass() == "Самурай") setButton(Rest,0,0,"Отдохнуть");
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene RichStreet1 = new AbstractScene(Location.RichStreet1) {
        @Override
        public void setUpScene(World world) {
            clearButtons();
            if (world.isDay()) {
                setText(world.getMainCharacter().getName()[0] + " идет по широкой улице, мощеной узорчатым камнем. По обеим сторонам высятся яркие, " +
                        "искусно разукрашенные дома. Туда-сюда спешат слуги в добротных одеждах, степенно прогуливаются знатные господа, " +
                        "прикрываясь от солнца цветными зонтиками.");
            } else {
                setText(world.getMainCharacter().getName()[0] + " идет по широкой улице, мощеной узорчатым камнем. Несмотря на ночное время, " +
                        "улица ярко освещена многочисленными фонарями. Вокруг пусто, не считая пары юношей, явно засидевшихся в таверне и теперь " +
                        "возвращающихся домой.");
            }
            if (world.getMainCharacter().getCharacterClass() == "Ученый") {
                setMovementButtons(true,Location.ScholarHome,false,null,true,Location.RichStreet2,false,null);
            } else {
                setMovementButtons(false,null,false,null,true,Location.RichStreet2,false,null);
            }

        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene RichStreet2 = new AbstractScene(Location.RichStreet2) {
        @Override
        public void setUpScene(World world) {
            clearButtons();
            if (world.isDay()) {
                setText(world.getMainCharacter().getName()[0] + " идет по широкой улице, мощеной узорчатым камнем. По обеим сторонам высятся яркие, " +
                        "искусно разукрашенные дома. Туда-сюда спешат слуги в добротных одеждах, степенно прогуливаются знатные господа, " +
                        "прикрываясь от солнца цветными зонтиками.");
            } else {
                setText(world.getMainCharacter().getName()[0] + " идет по широкой улице, мощеной узорчатым камнем. Несмотря на ночное время, " +
                        "улица ярко освещена многочисленными фонарями. Вокруг пусто, не считая пары юношей, явно засидевшихся в таверне и теперь " +
                        "возвращающихся домой.");
            }
            setMovementButtons(false,null,false,null,true,Location.RichStreet3,true,Location.RichStreet1);
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene RichStreet3 = new AbstractScene(Location.RichStreet3) {
        @Override
        public void setUpScene(World world) {
            clearButtons();
            if (world.isDay()) {
                setText(world.getMainCharacter().getName()[0] + " идет по широкой улице, мощеной узорчатым камнем. По обеим сторонам высятся яркие, " +
                        "искусно разукрашенные дома. Туда-сюда спешат слуги в добротных одеждах, степенно прогуливаются знатные господа, " +
                        "прикрываясь от солнца цветными зонтиками.");
            } else {
                setText(world.getMainCharacter().getName()[0] + " идет по широкой улице, мощеной узорчатым камнем. Несмотря на ночное время, " +
                        "улица ярко освещена многочисленными фонарями. Вокруг пусто, не считая пары юношей, явно засидевшихся в таверне и теперь " +
                        "возвращающихся домой.");
            }
            setMovementButtons(false,null,true,Location.Pier1,false,null,true,Location.RichStreet2);
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene Pier1 = new AbstractScene(Location.Pier1) {
        @Override
        public void setUpScene(World world) {
            clearButtons();
            if (world.isDay()) {
                setText(world.getMainCharacter().getName()[0] + " идет вдоль многочисленных причалов. Волны лениво бьются о берег, " +
                        "слышны крики матросов, загружающих что-то на корабль — или может, выгружающих? Сложно понять. " +
                        "Оглушительно несет рыбой от разложенных неподалеку рыбацких прилавков.\n" +
                        "С противоположной от причалов стороны располагается вход в поместье наместницы. " +
                        "По дневному времени ворота широко распахнуты, приглашая просителей.");
                setMovementButtons(true,Location.RichStreet3,true,Location.Pier2,true,Location.Bureau1,false,null);
            } else {
                setText(world.getMainCharacter().getName()[0] + " идет вдоль многочисленных причалов. Волны лениво бьются о берег, лунный свет " +
                        "красиво играет на парусах пришвартованных кораблей. Запах свежей рыбы сменился запахом рыбы протухшей, " +
                        "источаемым выброшенными за день потрохами и прочими неудобными частями рыбы.\n" +
                        "С противоположной от причалов стороны располагается вход в поместье наместницы. " +
                        "По ночному времени ворота плотно заперты.");
                setMovementButtons(true,Location.RichStreet3,true,Location.Pier2,false,null,false,null);
            }
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene Pier2 = new AbstractScene(Location.Pier2) {
        @Override
        public void setUpScene(World world) {
            clearButtons();
            setText(world.getMainCharacter().getName()[0] + " идет вдоль многочисленных причалов. Волны лениво бьются о берег, " +
                    "слышны крики матросов, загружающих что-то на корабль — или может, выгружающих? Сложно понять. " +
                    "Оглушительно несет рыбой от разложенных неподалеку рыбацких прилавков.");
            setMovementButtons(true,Location.Pier1,true,Location.LowStreet1,false,null,false,null);
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene Bureau1 = new AbstractScene(Location.Bureau1) {
        @Override
        public void setUpScene(World world) {
            clearButtons();
            setText(world.getMainCharacter().getName()[0] + " входит в поместье наместницы. Оно, как обычно, кишит жизнью. Туда-сюда " +
                    "снуют писари и прочие мелкие служащие, нагруженные различными документами и свитками. Во дворе, как обычно, " +
                    "выстроилась небольшая очередь из просителей.");
            setMovementButtons(false,null,false,null,true,Location.Bureau2,true,Location.Pier1);
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene Bureau2 = new AbstractScene(Location.Bureau2) {
        @Override
        public void setUpScene(World world) {
            clearButtons();
            setText(world.getMainCharacter().getName()[0] + " идет по внутренним помещениям поместья наместницы. \n" +
                    "Здесь значительно спокойнее, чем снаружи, однако все еще можно встретить случайного служащего, спешащего " +
                    "туда или сюда.\nВ левом крыле находятся казармы стражи.");
            if (world.getMainCharacter().getCharacterClass() == "Самурай") {
                setMovementButtons(false,null,true,Location.SamuraiHome,false,null,true,Location.Bureau1);
            } else {
                setMovementButtons(false,null,false,null,false,null,true,Location.Bureau1);
            }

        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene SamuraiHome = new AbstractScene(Location.SamuraiHome) {
        @Override
        public void setUpScene(World world) {
            clearButtons();
            String text = "Казармы стражи, укомплектованные оружейной и тренировочной площадкой. На тренировочной площадке можно заметить нескольких " +
                    "стражников, тренирующихся в стрельбе.";
            setText(text);
            setMovementButtons(true,Location.Bureau2,false,null,false,null,false,null);
            if (world.getMainCharacter().getCharacterClass() == "Самурай") setButton(Rest,0,0,"Отдохнуть");
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene Rest = new AbstractScene() {
        @Override
        public void setUpScene(World world) {
            clearButtons();
            setLocation(world.getCurrentLocation());
            setText(world.getMainCharacter().getName()[0] + " отдыхает и набирается сил, полностью восстанавливая здоровье и ресурсы.");
            world.getMainCharacter().rest();
            world.addTime(120);
            setButton(world.getCurrentLocation().getScene(), 0,0,"Далее");
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene LowStreet1 = new AbstractScene(Location.LowStreet1) {
        @Override
        public void setUpScene(World world) {
            clearButtons();
            if (world.isDay()) {
                setText(world.getMainCharacter().getName()[0] + " пробирается через узкие, застроенные вкривь и вкось переулочки. " +
                        " Тут и там валяются доски, перекинутые через лужи неясного происхождения, некоторые дома выглядят так, как будто вот-вот обрушатся, " +
                        "загородив дорогу. Пестро одетый народ спешит по своим делам, не обращая особого внимания на " + world.getMainCharacter().getName()[1] +
                        ".");
            } else {
                String text = world.getMainCharacter().getName()[0] + " пробирается через узкие, застроенные вкривь и вкось переулочки. " +
                        " Проходы освещены разве что лунным светом, да и тот во многом поглощен нависающими кособокими крышами. " +
                        "Кроме того, тут и там слышны подозрительные шепотки и неясные передвижения. Приходится быть особенно";
                if (world.getMainCharacter().getFemale()) text = text + " осторожной";
                else text = text + " осторожным";
                text = text + " — жизнь в этом районе не застывает с заходом солнца.";
                setText(text);
            }
            setButton(Gates,0,0,"Ворота");
            if (world.getMainCharacter().getCharacterClass() == "Прохиндей") {
                setMovementButtons(true,Location.Pier2,false,null,true,Location.RascalHome,true,Location.LowStreet2);
            } else {
                setMovementButtons(true,Location.Pier2,false,null,false,null,true,Location.LowStreet2);
            }
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene Gates = new AbstractScene() {
        @Override
        public void setUpScene(World world) {
            clearButtons();
            String text = world.getMainCharacter().getName()[0] + " покидает форпост и отправляется в лес.";
            world.setCurrentLocation(Location.Forest1);
            setText(text);
            setButton(Forest, Location.Forest1,0,0,"Далее");
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene LowStreet2 = new AbstractScene(Location.LowStreet2) {
        @Override
        public void setUpScene(World world) {
            clearButtons();
            if (world.isDay()) {
                setText(world.getMainCharacter().getName()[0] + " пробирается через узкие, застроенные вкривь и вкось переулочки. " +
                        " Тут и там валяются доски, перекинутые через лужи неясного происхождения, некоторые дома выглядят так, как будто вот-вот обрушатся, " +
                        "загородив дорогу. Пестро одетый народ спешит по своим делам, не обращая особого внимания на " + world.getMainCharacter().getName()[1] +
                        ".");
            } else {
                String text = world.getMainCharacter().getName()[0] + " пробирается через узкие, застроенные вкривь и вкось переулочки. " +
                        " Проходы освещены разве что лунным светом, да и тот во многом поглощен нависающими кособокими крышами. " +
                        "Кроме того, тут и там слышны подозрительные шепотки и неясные передвижения. Приходится быть особенно";
                if (world.getMainCharacter().getFemale()) text = text + " осторожной";
                else text = text + " осторожным";
                text = text + " — жизнь в этом районе не застывает с заходом солнца.";
                setText(text);
            }
            setMovementButtons(false,null,false,null,true,Location.LowStreet1,true,Location.LowStreet3);
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene LowStreet3 = new AbstractScene(Location.LowStreet3) {
        @Override
        public void setUpScene(World world) {
            clearButtons();
            if (world.isDay()) {
                setText(world.getMainCharacter().getName()[0] + " пробирается через узкие, застроенные вкривь и вкось переулочки. " +
                        " Тут и там валяются доски, перекинутые через лужи неясного происхождения, некоторые дома выглядят так, как будто вот-вот обрушатся, " +
                        "загородив дорогу. Пестро одетый народ спешит по своим делам, не обращая особого внимания на " + world.getMainCharacter().getName()[1] +
                        ".");
            } else {
                String text = world.getMainCharacter().getName()[0] + " пробирается через узкие, застроенные вкривь и вкось переулочки. " +
                        " Проходы освещены разве что лунным светом, да и тот во многом поглощен нависающими кособокими крышами. " +
                        "Кроме того, тут и там слышны подозрительные шепотки и неясные передвижения. Приходится быть особенно";
                if (world.getMainCharacter().getFemale()) text = text + " осторожной";
                else text = text + " осторожным";
                text = text + " — жизнь в этом районе не застывает с заходом солнца.";
                setText(text);
            }
            setMovementButtons(false,null,false,null,true,Location.LowStreet2,true,Location.LowStreet4);
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene LowStreet4 = new AbstractScene(Location.LowStreet4) {
        @Override
        public void setUpScene(World world) {
            clearButtons();
            if (world.isDay()) {
                setText(world.getMainCharacter().getName()[0] + " пробирается через узкие, застроенные вкривь и вкось переулочки. " +
                        " Тут и там валяются доски, перекинутые через лужи неясного происхождения, некоторые дома выглядят так, как будто вот-вот обрушатся, " +
                        "загородив дорогу. Пестро одетый народ спешит по своим делам, не обращая особого внимания на " + world.getMainCharacter().getName()[1] +
                        ".");
            } else {
                String text = world.getMainCharacter().getName()[0] + " пробирается через узкие, застроенные вкривь и вкось переулочки. " +
                        " Проходы освещены разве что лунным светом, да и тот во многом поглощен нависающими кособокими крышами. " +
                        "Кроме того, тут и там слышны подозрительные шепотки и неясные передвижения. Приходится быть особенно";
                if (world.getMainCharacter().getFemale()) text = text + " осторожной";
                else text = text + " осторожным";
                text = text + " — жизнь в этом районе не застывает с заходом солнца.";
                setText(text);
            }
            setTradeButton(0,0,"Аптекарь", NPC.Apothecary);
            setMovementButtons(false,null,false,null,true,Location.LowStreet3,false,null);
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene RascalHome = new AbstractScene(Location.RascalHome) {
        @Override
        public void setUpScene(World world) {
            clearButtons();
            setText(world.getMainCharacter().getName()[0] + " стоит возле своего дома. Возможно, самое время отдохнуть?");
            setButton(Rest,0,0,"Отдохнуть");
            setMovementButtons(false,null,false,null,false,null,true,Location.LowStreet1);
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene Forest = new AbstractScene() {
        @Override
        public void setUpScene(World world) {
            clearButtons();
            setLocation(world.getCurrentLocation());
            Random r = new Random();
            int n;
            n = r.nextInt(100);
            if (n > 90) {
                int c = r.nextInt(3) + 1;
                if (c == 1) setText("На " + world.getMainCharacter().getName()[1] + " выпрыгивает голодный волк!");
                else setText("На " + world.getMainCharacter().getName()[1] + " выпрыгивает стая голодных волков!");
                ArrayList<AbstractNPC> enemies = new ArrayList<>();
                for (int i = 0; i < c; i++) {
                    Wolf wolf = new Wolf(world.getDifficulty());
                    enemies.add(wolf);
                }
                setCombatButton(Forest,0,0,"Бой!",enemies);
            } else {
                String text = world.getMainCharacter().getName()[0] + " идет по окраине леса. ";
                if (world.isDay()) {
                    n = r.nextInt(60);
                    if (n > 20) text = text + "Лучи солнца пробиваются сквозь ветки редко стоящих деревьев, " +
                            "многочисленные тропинки поросли мхом и невысокой травкой.\n";
                    else if (n > 10) {
                        text = text + "Легкий ветерок приятно обдувает ";
                        if (world.getMainCharacter().getFemale()) text = text + "ее";
                        else text = text + "его";
                        text = text + " утомленное лицо, тут и там слышно негромкое пение прыгающих по веткам птиц.\n";
                    } else text = text + "Впереди виднеется небольщая полянка. Большая часть полянки заросла кустиками земляники. " +
                            world.getMainCharacter().getName()[0] + " проверяет ягоды — еще не созрели. Жаль.\n";
                } else {
                    n = r.nextInt(10);
                    if (n > 1) text = text + " Лунный свет окаймляет редко стоящие деревья, невысокая травка мягко шуршит под ногами.\n";
                    else text = text + " Из кустов с громким кваком выпрыгивает блестящая в лунном свете лягушка, изрядно напугав " +
                            world.getMainCharacter().getName()[1] + ".\n";
                }
                text = text + "Так близко к форпосту редко встречается что-то опасное.";
                setText(text);
                if (world.getCurrentLocation() == Location.Forest1) setButton(ForestGates,0,0,"Ворота");
                setMovementButtons(world.getCurrentLocation().isConnectedTop(),world.getCurrentLocation().getConnectedTop(),
                        world.getCurrentLocation().isConnectedBottom(),world.getCurrentLocation().getConnectedBottom(),
                        world.getCurrentLocation().isConnectedLeft(),world.getCurrentLocation().getConnectedLeft(),
                        world.getCurrentLocation().isConnectedRight(),world.getCurrentLocation().getConnectedRight());
            }
        }

        @Override
        public void changeFlag(World world) {

        }
    };

    public static AbstractScene ForestGates = new AbstractScene(Location.Forest1) {
        @Override
        public void setUpScene(World world) {
            clearButtons();
            String text = world.getMainCharacter().getName()[0] + " покидает лес и возвращается в форпост.";
            world.setCurrentLocation(Location.LowStreet1);
            setText(text);
            setButton(LowStreet1, Location.LowStreet1,0,0,"Далее");
        }

        @Override
        public void changeFlag(World world) {

        }
    };
}
