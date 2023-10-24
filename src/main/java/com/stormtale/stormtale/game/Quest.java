package com.stormtale.stormtale.game;

import java.io.Serializable;

public class Quest implements Serializable {
    public static AbstractQuest MainQuest = new AbstractQuest("Сказание Штормов",1000,1000) {
        @Override
        public void setStages() {
            String[] stage1 = {"-Найдите проход к храму Солнца в лесах близ форпоста Таки",
                    "Похоже, прошедний драконий шторм оказал более серьезные последствия, чем обычно. " +
                            "Небесный дракон повержен, но его жемчужина цела, а значит, не все потеряно. " +
                            "Но как же помочь дракону восстановиться? Возможно, солнечный монах знает ответ."};
            addStage(1,stage1);
        }
    };

    public static AbstractQuest PeachesQuest = new AbstractQuest("Роковые Персики",15,100) {
        @Override
        public void setStages() {
            String[] stage1 = {"-Найдите в лесу персиковую рощу",
                    "Торговца Ру поразила ужасная беда — Фея Персиковой Рощи прокляла его за отказ поклониться ей. " +
                            "Теперь ужасные боли в спине не дают ему разогнуться, заперев его в вечном поклоне. " +
                            "В отчаянии Ру умолил вас отправиться в лес, чтобы испросить прощения у феи вместо него."};
            addStage(1,stage1);
        }
    };
}
