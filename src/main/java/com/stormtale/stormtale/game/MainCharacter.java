package com.stormtale.stormtale.game;

import com.stormtale.stormtale.game.combat.Ability;
import com.stormtale.stormtale.game.inventory.AbstractEquipment;
import com.stormtale.stormtale.game.inventory.AbstractWeapon;
import com.stormtale.stormtale.game.inventory.Weapon;

import java.io.Serializable;
import java.util.ArrayList;

public class MainCharacter extends AbstractCharacter implements Serializable {

    Integer exp;

    Integer maxExp;

    AbstractWeapon weapon;
    ArrayList<String> availableWeaponTypes = new ArrayList<>();

    String armorType;
    AbstractEquipment head;
    AbstractEquipment body;
    AbstractEquipment accessory;

    Integer maxInventory;

    public MainCharacter () {
        name[0] = "Неизвестно";
        level = 1;
        conCount = 0;
        conditionCount.setValue(0);
        money = 0;
    }
    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
        switch (characterClass) {
            case "Самурай":
                resourceType = "Выносливость";
                strength = 4;
                dexterity = 3;
                mind = 1;
                charisma = 2;
                addAbility(Ability.Thrust);
                setMaxHealth(60);
                setCurrentHealth(60);
                setMaxResource(10);
                setCurrentResource(10);
                setExp(0);
                setMaxExp(50);
                availableWeaponTypes.add("Меч");
                availableWeaponTypes.add("Кинжал");
                armorType = "Тяжелая";
                setMaxInventory(15);
                setMoney(100);
                break;
            case "Ученый":
                resourceType = "Мана";
                strength = 1;
                dexterity = 2;
                mind = 4;
                charisma = 3;
                addAbility(Ability.Flare);
                setMaxHealth(40);
                setCurrentHealth(40);
                setMaxResource(20);
                setCurrentResource(20);
                setExp(0);
                setMaxExp(50);
                availableWeaponTypes.add("Фокусировка");
                availableWeaponTypes.add("Кинжал");
                armorType = "Легкая";
                setMaxInventory(15);
                setMoney(150);
                break;
            case "Прохиндей":
                resourceType = "Выносливость";
                strength = 1;
                dexterity = 4;
                mind = 2;
                charisma = 3;
                addAbility(Ability.Undercut);
                setMaxHealth(50);
                setCurrentHealth(50);
                setMaxResource(15);
                setCurrentResource(15);
                setExp(0);
                setMaxExp(50);
                availableWeaponTypes.add("Меч");
                availableWeaponTypes.add("Кинжал");
                armorType = "Средняя";
                setMaxInventory(15);
                setMoney(15);
                break;
        }
    }

    public String levelUp() {
        String text = "";
        switch (level) {
            case 2:
                switch (characterClass) {
                    case "Самурай":
                        text = text + "\nВы получаете способность Обновление, позволяющую постепенно восстанавливать здоровье" + "!\n";
                        addAbility(Ability.Regeneration);
                        text = text + "Ваше максимальное здоровье увеличивается на 10!\n";
                        setMaxHealth(getMaxHealth() + 10);
                        text = text + "Ваша сила увеличивается на 2!\n";
                        addStrength(2);
                        text = text + "Ваша ловкость увеличивается на 1!\n";
                        addDexterity(1);
                        addProtection(1);
                        break;
                    case "Ученый":
                        text = text + "\nВы получаете способность Сияние, позволяющую залечивать ваши раны!\n";
                        addAbility(Ability.Shine);
                        text = text + "Ваше максимальное здоровье увеличивается на 10!\n";
                        setMaxHealth(getMaxHealth() + 10);
                        text = text + "Ваш разум увеличивается на 1!\n";
                        addMind(1);
                        text = text + "Ваша харизма увеличивается на 2!\n";
                        addCharisma(2);
                        break;
                    case "Прохиндей":
                        text = text + "\nВы получаете способность Уловка, позволяющую восстановить половину потерянного здоровья!\n";
                        addAbility(Ability.Trick);
                        text = text + "Ваше максимальное здоровье увеличивается на 10!\n";
                        setMaxHealth(getMaxHealth() + 10);
                        text = text + "Ваша сила увеличивается на 1!\n";
                        addStrength(1);
                        text = text + "Ваша ловкость увеличивается на 1!\n";
                        addDexterity(1);
                        addProtection(1);
                        text = text + "Ваш разум увеличивается на 1!\n";
                        addMind(1);
                        text = text + "Ваша харизма увеличивается на 1!\n";
                        addCharisma(1);
                        break;
                }
                calculateResource();
                setMaxExp(100);
                break;
            case 3:
                switch (characterClass) {
                    case "Самурай":
                        text = text + "\nВы получаете способность Размах, позволяющую наносить урон всем врагам" + "!\n";
                        addAbility(Ability.Slash);
                        text = text + "Ваше максимальное здоровье увеличивается на 10!\n";
                        setMaxHealth(getMaxHealth() + 10);
                        text = text + "Ваша сила увеличивается на 2!\n";
                        addStrength(2);
                        text = text + "Ваша ловкость увеличивается на 1!\n";
                        addDexterity(1);
                        addProtection(1);
                        break;
                    case "Ученый":
                        text = text + "\nВы получаете способность Перекачка, позволяющую одновременно наносить урон всем врагам и восстанавливать здоровье!\n";
                        addAbility(Ability.Siphon);
                        text = text + "Ваше максимальное здоровье увеличивается на 10!\n";
                        setMaxHealth(getMaxHealth() + 10);
                        text = text + "Ваш разум увеличивается на 1!\n";
                        addMind(1);
                        text = text + "Ваша харизма увеличивается на 2!\n";
                        addCharisma(2);
                        break;
                    case "Прохиндей":
                        text = text + "\nВы получаете способность Укол, позволяющую наносить большой урон врагам, уже истекающим кровью" + "!";
                        addAbility(Ability.Sting);
                        text = text + "Ваше максимальное здоровье увеличивается на 10!\n";
                        setMaxHealth(getMaxHealth() + 10);
                        text = text + "Ваша сила увеличивается на 1!\n";
                        addStrength(1);
                        text = text + "Ваша ловкость увеличивается на 1!\n";
                        addDexterity(1);
                        addProtection(1);
                        text = text + "Ваш разум увеличивается на 1!\n";
                        addMind(1);
                        text = text + "Ваша харизма увеличивается на 1!\n";
                        addCharisma(1);
                        break;
                }
                calculateResource();
                setMaxExp(15000);
                break;
            case 4:
                calculateResource();
                setMaxExp(250);
                break;
            case 5:
                calculateResource();
                setMaxExp(400);
                break;
            case 6:
                calculateResource();
                setMaxExp(600);
                break;
        }
        return  text;
    }

    public String description() {
        if (getCharacterClass() == "Самурай") {
            return "Бесстрашный воин, верный слуга императора. Как капитану стражи форпоста Таки, вам поручили почетную задачу "+
                    "оберегать жемчужину небесного дракона и найти для нее новое вместилище.";
        } else if (getCharacterClass() == "Ученый") {
            return "Молодой чиновник, занявший первое место на государственном экзамене, официальным императорским эдиктом назначенный" +
                    " Смотрителем за Мистическими Вопросами на форпост Таки. Как специалисту в вопросах магии, работу над новым вместилищем для" +
                    " небесного дракона было решено поручить вам.";
        } else {
            return "Разбойник, бродяга, фокусник, авантюрист. Вас можно описать любым из этих слов. Вы совершили множество преступлений, но " +
                    "каждое из них следовало духу закона, хоть и не букве. В отсутствие лучших кандидатов, вас арестовали за одно из ваших многочисленных " +
                    "преступлений и в наказание поручили восстановить тело небесного дракона. Хоть вы и недовольны арестом, дело как раз вам по душе.";
        }
    }

    public void setMaxExp(Integer maxExp) {
        this.maxExp = maxExp;
    }

    public Integer getMaxExp() {
        return maxExp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public Integer getExp() {
        return exp;
    }

    public void addExp(Integer exp) {
        this.exp = this.exp + exp;
    }

    public void setWeapon(AbstractWeapon weapon) {
        this.weapon = weapon;
    }

    public AbstractWeapon getWeapon() {
        return weapon;
    }

    public void setAvailableWeaponTypes(ArrayList<String> availableWeaponTypes) {
        this.availableWeaponTypes = availableWeaponTypes;
    }

    public ArrayList<String> getAvailableWeaponTypes() {
        return availableWeaponTypes;
    }

    public String getArmorType() {
        return armorType;
    }

    public void setAccessory(AbstractEquipment accessory) {
        this.accessory = accessory;
    }

    public void setBody(AbstractEquipment body) {
        this.body = body;
    }

    public void setHead(AbstractEquipment head) {
        this.head = head;
    }

    public AbstractEquipment getAccessory() {
        return accessory;
    }

    public AbstractEquipment getBody() {
        return body;
    }

    public AbstractEquipment getHead() {
        return head;
    }

    public void setMaxInventory(Integer maxInventory) {
        this.maxInventory = maxInventory;
    }

    public Integer getMaxInventory() {
        return maxInventory;
    }

    public void calculateResource() {
        setMaxResource(10 * level + 5 * mind);
        setCurrentResource(10 * level + 5 * mind);
    }
}
