package com.stormtale.stormtale.Controllers;

import com.stormtale.stormtale.game.*;
import com.stormtale.stormtale.game.combat.*;
import com.stormtale.stormtale.game.inventory.AbstractItem;
import com.stormtale.stormtale.World;
import com.stormtale.stormtale.game.inventory.Consumable;
import com.stormtale.stormtale.game.inventory.Equipment;
import com.stormtale.stormtale.game.inventory.Weapon;
import com.stormtale.stormtale.game.npc.AbstractNPC;
import com.stormtale.stormtale.game.npc.enemies.Yuka;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.*;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.fxml.Initializable;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.util.Duration;

public class MainController implements Initializable{
    @FXML
    GridPane ButtonGrid;

    @FXML
    TextFlow MainField;

    @FXML
    GridPane MainGrid;

    @FXML
    ScrollPane MainScroll;

    @FXML
    Pane MainPane;

    @FXML
    VBox LeftBox;

    @FXML
    VBox RightBox;

    @FXML
    Button SaveLoadButton;

    @FXML
    Button ShowMenuButton;

    @FXML
    Button InventoryButton;

    @FXML
    Button ProfileButton;

    @FXML
    Button QuestButton;

    World world;

    Button[] buttonsForKeys = new Button[15];


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        SaveLoadButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                showSaveMenu();
            }
        });
        ShowMenuButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                showMainMenu();
            }
        });
        InventoryButton.setDisable(true);
        QuestButton.setDisable(true);
        ProfileButton.setDisable(true);
        ProfileButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                displayMCProfile();
            }
        });
        showMainMenu();
    }

    private void showMainMenu() {
        clearButtons();
        clearMainText();
        RightBox.getChildren().clear();
        Button newGame = new Button();
        setButton(newGame,"Новая игра",0,0);
        newGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                MainCharacter mc = new MainCharacter();
                characterCreation(mc);
            }
        });
        Button continueGame = new Button();
        if (world == null) {
            setDisabledButton(continueGame,"Продолжить",0,1);
        } else {
            setButton(continueGame,"Продолжить",0,1);
            continueGame.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    displayCurrentScene();
                }
            });
        }
        Button settings = new Button();
        setButton(settings,"Настройки",0,3);
        settings.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                showSettings();
            }
        });
        addText("Stormtale – текстовая ролевая игра о противостоянии двух драконов, о том что случается, когда сталкиваются небо и море, "+
                "и о штормах, которые рождаются от их союза.\n В центре острова Таки находится зияющая пропасть, Бездонная Бездна, " +
                "ведущая на оборотную сторону мира. Столетиями дракон неба защищал мир живых от нападений с Той Стороны, " +
                "но и люди не оставались в стороне, основав на острове аванпост и неустанно сражась с тварями Бездны. " +
                "Но дракон неба пал, и теперь на жителей острова пала задача создать для него новое вместилище. " +
                "\n\nСправитесь ли вы с этой задачей вовремя? Или остров, а с ним и весь мир заполонят твари Бездны?");
    }

    private void setButton (Button button, String text, int row, int column) {
        button.setText(text);
        button.setPadding(new Insets(5));
        button.setPrefSize(110,35);
        button.setId("Button");
        ButtonGrid.setHalignment(button, HPos.CENTER);
        buttonsForKeys[column + row * 5] = button;
        ButtonGrid.add(button, column, row);
    }

    private void setDisabledButton (Button button, String text, int row, int column) {
        button.setText(text);
        button.setPadding(new Insets(5));
        button.setPrefSize(110,35);
        button.setId("Button");
        button.setDisable(true);
        ButtonGrid.setHalignment(button, HPos.CENTER);
        ButtonGrid.add(button, column, row);
    }

    private void setButtonHover (Button button, String text, String tooltip, int row, int column) {
        button.setText(text);
        button.setPadding(new Insets(5));
        button.setPrefSize(110,35);
        button.setId("Button");
        Tooltip tt = new Tooltip(tooltip);
        button.setTooltip(tt);
        button.getTooltip().setShowDelay(Duration.ZERO);
        button.getTooltip().setOnShowing(s->{
            Bounds bounds = button.localToScreen(button.getBoundsInLocal());
            button.getTooltip().setX(bounds.getMaxX()-15);
            button.getTooltip().setY(bounds.getMinY()-50);
            button.getTooltip().setShowDuration(Duration.INDEFINITE);
        });
        ButtonGrid.setHalignment(button, HPos.CENTER);
        buttonsForKeys[column + row * 5] = button;
        ButtonGrid.add(button, column, row);
    }

    private void clearButtons () {
        ButtonGrid.getChildren().clear();
        for (int i = 0; i < 15; i++) {
            buttonsForKeys[i] = null;
        }
    }

    public void keyPress(KeyCode key) {
        switch (key) {
            case DIGIT1:
                if (buttonsForKeys[0] != null) buttonsForKeys[0].fire();
                break;
            case DIGIT2:
                if (buttonsForKeys[1] != null) buttonsForKeys[1].fire();
                break;
            case DIGIT3:
                if (buttonsForKeys[2] != null) buttonsForKeys[2].fire();
                break;
            case DIGIT4:
                if (buttonsForKeys[3] != null) buttonsForKeys[3].fire();
                break;
            case DIGIT5:
                if (buttonsForKeys[4] != null) buttonsForKeys[4].fire();
                break;
            case Q:
                if (buttonsForKeys[5] != null) buttonsForKeys[5].fire();
                break;
            case W:
                if (buttonsForKeys[6] != null) buttonsForKeys[6].fire();
                break;
            case E:
                if (buttonsForKeys[7] != null) buttonsForKeys[7].fire();
                break;
            case R:
                if (buttonsForKeys[8] != null) buttonsForKeys[8].fire();
                break;
            case T:
                if (buttonsForKeys[9] != null) buttonsForKeys[9].fire();
                break;
            case A:
                if (buttonsForKeys[10] != null) buttonsForKeys[10].fire();
                break;
            case S:
                if (buttonsForKeys[11] != null) buttonsForKeys[11].fire();
                break;
            case D:
                if (buttonsForKeys[12] != null) buttonsForKeys[12].fire();
                break;
            case F:
                if (buttonsForKeys[13] != null) buttonsForKeys[13].fire();
                break;
            case G:
                if (buttonsForKeys[14] != null) buttonsForKeys[14].fire();
                break;
        }
    }

    private void showSettings() {
        clearMainText();
        clearButtons();
        addText("Сложность: ");
        if (world != null){
            if (world.getDifficulty() == 0.8) addText("Легкая");
            if (world.getDifficulty() == 1.0) addText("Обычная");
            if (world.getDifficulty() == 1.2) addText("Сложная");
        } else {
            addText("Обычная");
        }
        addText("\n\n\n");
        addText("------------------------------------------------------------");
        addText("\n\n\n");
        addText("Автор: Шилова Наталья\n\n");
        addText("Помощь в написании текстов: Назар Вилинхеймов\n\n");
        addText("Иконки и значки: icons8.com\n\n");
        addText("Фоновые изображения: pngtree.com");
        Button difficulty = new Button();
        if (world != null){
            setButton(difficulty,"Сложность",0,0);
            difficulty.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    world.changeDifficulty();
                    showSettings();
                }
            });
        } else {
            setDisabledButton(difficulty,"Сложность",0,0);
        }
        Button back = new Button();
        setButton(back,"Назад",2,4);
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                showMainMenu();
            }
        });
    }

    private void startCombat (Combat combat, String text) {
        clearMainText();
        clearButtons();
        addText(text);
        Button button = new Button();
        setButton(button,"Далее",0,0);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                clearMainText();
                clearButtons();
                nextTurn(combat);
            }
        });
    }

    private void endCombat(Combat combat) {
        addText("Все враги повержены!");
        world.getMainCharacter().addExp(combat.getTotalExpReward());
        addText("\n\nВы получаете " + combat.getTotalExpReward() + " опыта!");
        for (AbstractItem item: combat.getLoot()
             ) {
            addText("\nВы получаете " + item.getName() + ".");
            world.getMainCharacter().addItem(item);
            //possible place for out of capacity dialogue
        }
        LeftBox.getChildren().clear();
        RightBox.getChildren().clear();
        Button button = new Button();
        setButton(button,"Далее",0,0);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                checkForLevelUp(combat.getNextScene());
            }
        });
    }

    private void nextTurn (Combat combat) {
        addText(combat.turn());
        if (combat.getMc().getCurrentHealth() == 0) {
            addText("Ваш персонаж повержен!");
            clearButtons();
            Button button = new Button();
            setButton(button,"Далее",0,0);
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    showSaveMenu();
                }
            });
        }
        if (combat.getEnemies().isEmpty()) {
            endCombat(combat);
        }
        else {
            setUpAbilities(combat);
            Button items = new Button();
            setButton(items,"Предметы",2,4);
            items.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    hideButtons();
                    setUpItems(combat);
                }
            });
        }
    }

    private void setUpAbilities(Combat combat) {
        int row = 0;
        int column = 0;
        for (AbstractAbility ability: combat.getMc().getAbilities()
        ) {
            Button button = new Button();
            setButtonHover(button, ability.getName(), ability.getDescription(), row, column);
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    ArrayList<AbstractCharacter> targets = new ArrayList<>();
                    targets.addAll(combat.getEnemies());
                    if (ability.getChooseTarget() && combat.getEnemies().size() > 1){
                        hideButtons();
                        chooseTarget(combat, ability);
                    } else {
                        clearMainText();
                        clearButtons();
                        addText(ability.use(combat.getMc(), targets));
                        nextTurn(combat);
                    }
                }
            });
            row++;
            if (row == 5) {
                column++;
                row = 0;
            }
        }
    }

    private void chooseTarget(Combat combat, AbstractAbility ability) {
        int column = 0;
        for (AbstractNPC enemy: combat.getEnemies()
             ) {
            Button button = new Button();
            setButton(button, enemy.getName()[0],0,column);
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    clearMainText();
                    clearButtons();
                    addText(ability.use(combat.getMc(), enemy));
                    nextTurn(combat);
                }
            });
            column++;
        }
        Button back = new Button();
        setButton(back,"Назад",2,4);
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                deleteVisibleButtons();
                showButtons();
            }
        });
    }

    private void setUpItems(Combat combat) {
        int row = 0;
        int column = 0;
        for (AbstractItem item: combat.getMc().getInventory()
             ) {
            if (item.getType() == "Боевой") {
                Button button = new Button();
                setButtonHover(button, item.getName(), item.getDescription(), row, column);
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        clearMainText();
                        clearButtons();
                        addText(item.use(combat.getMc(),combat.getCompanions(),combat.getEnemies()));
                        world.getMainCharacter().removeItem(item);
                        nextTurn(combat);
                    }
                });
                row++;
                if (row == 5) {
                    column++;
                    row = 0;
                }
            }
        }
        Button back = new Button();
        setButton(back,"Назад",2,4);
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                deleteVisibleButtons();
                showButtons();
            }
        });
    }

    private void nextScene (AbstractScene scene) {
        scene.setUpScene(world);
        world.setCurrentScene(scene);
        world.setCurrentSceneText(scene.getText());
        world.setCurrentLocation(scene.getLocation());
        world.setCurrentButtons(scene.getButtons());
        displayCurrentScene();
    }

    private void displayCurrentScene() {
        clearMainText();
        clearButtons();
        drawMap();
        Button inventory = new Button();
        setButton(inventory,"Инвентарь",2,4);
        inventory.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                displayInventory(world.getMainCharacter().getInventory());
            }
        });
        ArrayList<ButtonInfo> buttons = world.getCurrentButtons();
        //add map change here
        //show profiles maybe? think about it
        addText(world.getCurrentSceneText());
        for (Integer i = 0; i < buttons.size(); i++) {
            Button button = new Button();
            ButtonInfo buttonInfo = buttons.get(i);
            if (buttonInfo.getAvailability()) {
                //everything goes here
                if (buttonInfo.getTooltip() != null) {
                    setButtonHover(button,buttonInfo.getName(),buttonInfo.getTooltip(),buttonInfo.getRow(),buttonInfo.getColumn());
                } else {
                    setButton(button,buttonInfo.getName(),buttonInfo.getRow(),buttonInfo.getColumn());
                }
                switch (buttonInfo.getType()) {
                    case "Item":
                        button.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) { //change later to "name" gains
                                String text = "\nВы получаете " + buttonInfo.getItem().getName() + ".";
                                addText(text);
                                world.setCurrentSceneText(world.getCurrentSceneText() + text);
                                world.getMainCharacter().addItem(buttonInfo.getItem());
                                if (buttonInfo.isFlag()) world.getCurrentScene().changeFlag(world);
                                //do smth with saves here, idk
                                //maybe keep all scenes in world?
                                //check with world if already taken or smth
                                //world.getMainCharacter().addItem(buttonInfo.getItem());
                                buttons.remove(buttonInfo);
                                ButtonGrid.getChildren().remove(button);
                            }
                        });
                        break;
                    case "Combat":
                        button.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                //hideMap
                                if (buttonInfo.isFlag()) world.getCurrentScene().changeFlag(world);
                                Combat combat = new Combat(world.getMainCharacter(),world.getCompanions(),buttonInfo.getEnemies());
                                combat.setNextScene(buttonInfo.getNextScene());
                                RightBox.getChildren().clear();
                                showProfile(combat.getMc(), LeftBox);
                                if (combat.getCompanions() != null) {
                                    for (AbstractNPC companion: combat.getCompanions()
                                    ) {
                                        showProfile(companion, LeftBox);
                                    }
                                }
                                for (AbstractNPC enemy: combat.getEnemies()
                                ) {
                                    showProfile(enemy, RightBox);
                                }
                                startCombat(combat, buttonInfo.getStartCombatText());
                            }
                        });
                        break;
                    case "Continue":
                        button.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                if (buttonInfo.isFlag()) world.getCurrentScene().changeFlag(world);
                                nextScene(buttonInfo.getNextScene());
                            }
                        });
                        break;
                    case "Movement":
                        button.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                RightBox.getChildren().clear();
                                world.setCurrentLocation(buttonInfo.getNewLocation());
                                drawMap();
                                //add time
                                nextScene(buttonInfo.getNextScene());
                            }
                        });
                        break;
                }
            } else {
                setDisabledButton(button,buttonInfo.getName(),buttonInfo.getRow(),buttonInfo.getColumn());
            }
        }
    }

    private void displayInventory (ArrayList<AbstractItem> inventory) {
        clearMainText();
        clearButtons();
        addText("В инвентаре " + world.getMainCharacter().getName()[1] + " находятся следующие предметы:");
        if (inventory.size() > 0) displayRowOfItems(inventory,0);
        Button forward = new Button();
        setDisabledButton(forward,">>",1,4);
        Button backward = new Button();
        setDisabledButton(backward,"<<",1,3);
        Button back = new Button();
        setButton(back,"Назад",2,4);
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                displayCurrentScene();
            }
        });
        if (inventory.size() > 5) {
            final int[] n = {0};
            forward.setDisable(false);
            forward.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    n[0] = n[0] + 5;
                    ButtonGrid.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 0);
                    displayRowOfItems(inventory,n[0]);
                    if (n[0] + 5 > inventory.size()) forward.setDisable(true);
                    backward.setDisable(false);
                }
            });
            backward.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    n[0] = n[0] - 5;
                    ButtonGrid.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 0);
                    displayRowOfItems(inventory,n[0]);
                    if (n[0] - 5 < 0) backward.setDisable(true);
                    forward.setDisable(false);
                }
            });
        }
    }

    private void displayRowOfItems(ArrayList<AbstractItem> inventory, Integer startingPoint) {
        int endingPoint;
        if (startingPoint + 4 > inventory.size()) endingPoint = inventory.size() - startingPoint;
        else endingPoint = 4;
        ArrayList<AbstractItem> row = new ArrayList<>();
        for (int j = 0; j < endingPoint; j++){
            row.add(inventory.get(startingPoint + j));
        }
        int i = 0;
        for (AbstractItem item: row
        ) {
            addText("\n" + item.getName());
            Button button = new Button();
            setButtonHover(button, inventory.get(i).getName(), inventory.get(i).getDescription(), 0, i);
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    hideButtons();
                    Button drop = new Button();
                    setButton(drop,"Выкинуть",0,0);
                    drop.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            inventory.remove(item);
                            displayInventory(inventory);
                        }
                    });
                    Button back = new Button();
                    setButton(back,"Назад",2,4);
                    back.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            deleteVisibleButtons();
                            showButtons();
                        }
                    });
                    if (item instanceof Weapon) {
                        Button equipWeapon = new Button();
                        setButton(equipWeapon,"Надеть",0,1);
                        equipWeapon.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                //world.getMainCharacter.equipWeapon()
                                //also check if able to equip?
                                //equip to companion?
                                inventory.remove(item);
                                displayInventory(inventory);
                            }
                        });
                    }
                    if (item instanceof Equipment) {
                        Button equip = new Button();
                        setButton(equip,"Надеть",0,1);
                        equip.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                //world.getMainCharacter.equip()
                                //also check if able to equip?
                                //equip to companion?
                                inventory.remove(item);
                                displayInventory(inventory);
                            }
                        });
                    }
                    if (item instanceof Consumable) {
                        Button consume = new Button();
                        setButton(consume,"Использовать",0,1);
                        consume.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                ((Consumable) item).consume(world.getMainCharacter());
                                inventory.remove(item);
                                displayInventory(inventory);
                            }
                        });
                    }
                }
            });
            i++;
        }
    }

    private void displayMCProfile() {
        clearMainText();
        clearButtons();
        addText(world.getMainCharacter().getName()[0] + world.getMainCharacter().getCharacterClass() + "\n\n" + world.getMainCharacter().description() +
                "\n\n Здоровье: " + world.getMainCharacter().getCurrentHealth() + "/" + world.getMainCharacter().getMaxHealth() +
                "\n" + world.getMainCharacter().getResourceType() + ": " + world.getMainCharacter().getCurrentResource() + "/" + world.getMainCharacter().getMaxResource() +
                "\nБроня: " + world.getMainCharacter().getArmor() +
                "\n\nСила: " + world.getMainCharacter().getStrength() +
                "\nЛовкость: " + world.getMainCharacter().getDexterity() +
                "\nРазум: " + world.getMainCharacter().getMind() +
                "\nХаризма: " + world.getMainCharacter().getCharisma() +
                "\n\nОружие: " + world.getMainCharacter().getWeapon().getName() +
                "\nГолова: " + world.getMainCharacter().getHead().getName() +
                "\nТело: " + world.getMainCharacter().getBody().getName() +
                "\nУкрашение: " + world.getMainCharacter().getAccessory().getName());
        Button mcprofile = new Button();
        setDisabledButton(mcprofile,"Профиль",0,0);
        Button abilities = new Button();
        setButton(abilities,"Способности",0,1);
        abilities.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                displayMCActions();
            }
        });
        Button mc = new Button();
        setDisabledButton(mc, world.getMainCharacter().getName()[0],1,0);
        if (!world.getCompanions().isEmpty()) {
            int i = 1;
            for (Companion companion: world.getCompanions()
                 ) {
                Button profile = new Button();
                setButton(profile,companion.getName()[0],1,i);
                profile.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        displayCompanionProfile(companion);
                    }
                });
                i++;
            }
        }
        Button back = new Button();
        setButton(back,"Назад",2,4);
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                displayCurrentScene();
            }
        });
    }

    private void displayMCActions() {
        clearMainText();
        clearButtons();
        for (AbstractAbility ability: world.getMainCharacter().getAbilities()
             ) {
            addText(ability.getName());
            addText(" : ");
            addText(ability.getDescription());
            addText("\n\n");
        }
        Button mcprofile = new Button();
        setDisabledButton(mcprofile,"Профиль",0,0);
        mcprofile.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                displayMCProfile();
            }
        });
        Button abilities = new Button();
        setDisabledButton(abilities,"Способности",0,1);
        Button mc = new Button();
        setDisabledButton(mc, world.getMainCharacter().getName()[0],1,0);
        if (!world.getCompanions().isEmpty()) {
            int i = 1;
            for (Companion companion: world.getCompanions()
            ) {
                Button profile = new Button();
                setButton(profile,companion.getName()[0],1,i);
                profile.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        displayCompanionProfile(companion);
                    }
                });
                i++;
            }
        }
    }

    private void displayCompanionProfile(Companion companion){
        clearMainText();
        clearButtons();
        addText(companion.getName()[0] + "\n" + companion.getCharacterClass() + "\n\n" + companion.description() +
                "\n\n Здоровье: " + companion.getCurrentHealth() + "/" + companion.getMaxHealth() +
                "\n" + companion.getResourceType() + ": " + companion.getCurrentResource() + "/" + companion.getMaxResource() +
                "\nБроня: " + companion.getArmor() +
                "\n\nСила: " + companion.getStrength() +
                "\nЛовкость: " + companion.getDexterity() +
                "\nРазум: " + companion.getMind() +
                "\nХаризма: " + companion.getCharisma() +
                "\n\nОружие: " + companion.getWeapon().getName());
        Button profile = new Button();
        setDisabledButton(profile,"Профиль",0,0);
        Button abilities = new Button();
        setButton(abilities,"Способности",0,1);
        abilities.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                displayCompanionAbilities(companion);
            }
        });
        Button mc = new Button();
        setButton(mc,world.getMainCharacter().getName()[0],1,0);
        mc.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                displayMCProfile();
            }
        });
        int i = 1;
        for (Companion comp: world.getCompanions()
        ) {
            Button cprofile = new Button();
            if (comp.equals(companion)){
                setDisabledButton(cprofile,comp.getName()[0],1,i);
            } else {
                setButton(cprofile,comp.getName()[0],1,i);
                cprofile.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        displayCompanionProfile(comp);
                    }
                });
            }
            i++;
        }
    }

    private void displayCompanionAbilities(Companion companion){
        clearMainText();
        clearButtons();
        for (AbstractAbility ability: companion.getAbilities()
             ) {
            addText(ability.getName());
            addText(" : ");
            addText(ability.getDescription());
            addText("\n\n");
        }
        Button profile = new Button();
        setButton(profile,"Профиль",0,0);
        profile.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                displayCompanionProfile(companion);
            }
        });
        Button abilities = new Button();
        setDisabledButton(abilities,"Способности",0,1);
        Button mc = new Button();
        setButton(mc,world.getMainCharacter().getName()[0],1,0);
        mc.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                displayMCProfile();
            }
        });
        int i = 1;
        for (Companion comp: world.getCompanions()
        ) {
            Button cprofile = new Button();
            if (comp.equals(companion)){
                setDisabledButton(cprofile,comp.getName()[0],1,i);
            } else {
                setButton(cprofile,comp.getName()[0],1,i);
                cprofile.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        displayCompanionProfile(comp);
                    }
                });
            }
            i++;
        }
    }

    private void showSaveMenu () {
        GridPane SaveMenu = new GridPane();
        SaveMenu.setId("Menu");
        SaveMenu.setPrefWidth(520);
        for (int i = 0; i < 10; i++) {
            RowConstraints row = new RowConstraints(50);
            SaveMenu.getRowConstraints().add(row);
            HBox SaveSlot = new HBox(5);
            SaveSlot.setId("MenuSlot");
            SaveSlot.setPrefWidth(SaveMenu.getPrefWidth());
            SaveSlot.setPadding(new Insets(5, 5, 5, 5));
            SaveSlot.setAlignment(Pos.CENTER_LEFT);
            SaveMenu.add(SaveSlot,0,i);
            SaveMenu.setHalignment(SaveSlot, HPos.CENTER);
            Button SaveButton = new Button();
            SaveButton.setText("Сохранить");
            SaveButton.setTextFill(Color.WHITE);
            SaveButton.setPrefSize(85,25);
            SaveButton.setMinSize(85,25);
            SaveButton.setId("MenuButton");
            if (world == null) SaveButton.setDisable(true);
            SaveSlot.getChildren().add(SaveButton);
            Button LoadButton = new Button();
            LoadButton.setText("Загрузить");
            LoadButton.setTextFill(Color.WHITE);
            LoadButton.setPrefSize(85,25);
            LoadButton.setMinSize(85,25);
            LoadButton.setId("MenuButton");
            int j = i;
            String filePath = "Saves/Save" + j + ".sav";
            File saveFile = new File(filePath);
            Label name = new Label();
            name.setFont(new Font(12));
            if (saveFile.exists()) {
                try {
                    FileInputStream fileIn = new FileInputStream(filePath);
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    World tempWorld = (World) in.readObject();
                    name.setText(tempWorld.getCurrentLocation().getName());
                    in.close();
                    fileIn.close();
                } catch (IOException | ClassNotFoundException c) {
                    c.printStackTrace();
                }
            } else {
                name.setText("---");
                LoadButton.setDisable(true);
            }
            Button DeleteButton = new Button();
            SaveButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                    if (saveFile.exists()) {
                        saveFile.delete();
                        File newSaveFile = new File(filePath);
                        try {
                            newSaveFile.createNewFile();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        try {
                            FileOutputStream fileOut =
                                    new FileOutputStream(filePath);
                            ObjectOutputStream out = new ObjectOutputStream(fileOut);
                            out.writeObject(world);
                            out.close();
                            fileOut.close();
                        } catch (IOException i) {
                            i.printStackTrace();
                        }
                    } else {
                        try {
                            saveFile.createNewFile();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        try {
                            FileOutputStream fileOut =
                                    new FileOutputStream(filePath);
                            ObjectOutputStream out = new ObjectOutputStream(fileOut);
                            out.writeObject(world);
                            out.close();
                            fileOut.close();
                        } catch (IOException i) {
                            i.printStackTrace();
                        }
                        LoadButton.setDisable(false);
                        DeleteButton.setDisable(false);
                    }
                    name.setText(world.getCurrentLocation().getName());
                }
            });
            LoadButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                    if (saveFile.exists()) {
                        try {
                            FileInputStream fileIn = new FileInputStream(filePath);
                            ObjectInputStream in = new ObjectInputStream(fileIn);
                            world = (World) in.readObject();
                            in.close();
                            fileIn.close();
                            closeMenu();
                            displayCurrentScene();
                        } catch (IOException | ClassNotFoundException c) {
                            c.printStackTrace();
                        }
                    }
                }
            });
            SaveSlot.getChildren().add(LoadButton);
            SaveSlot.getChildren().add(name);
            Region space = new Region();
            HBox.setHgrow(space,Priority.ALWAYS);
            SaveSlot.getChildren().add(space);
            DeleteButton.setText("Удалить");
            DeleteButton.setTextFill(Color.WHITE);
            DeleteButton.setPrefSize(80,25);
            DeleteButton.setMinSize(80,25);
            DeleteButton.setId("MenuButton");
            if (!saveFile.exists()) DeleteButton.setDisable(true);
            SaveSlot.getChildren().add(DeleteButton);
            DeleteButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                    saveFile.delete();
                    name.setText("---");
                    DeleteButton.setDisable(true);
                }
            });
        }
        SaveMenu.setLayoutX((MainPane.getPrefWidth() - 520) / 2 );
        SaveMenu.setLayoutY(20);
        hideMainText();
        hideButtons();
        MainPane.getChildren().add(SaveMenu);
        Button back = new Button();
        setButton(back,"Назад",0,0);
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                closeMenu();
                deleteVisibleButtons();
                showButtons();
            }
        });
    }

    private void characterCreation(MainCharacter mc) {
        clearMainText();
        clearButtons();
        addText("Вступление");
        Button next = new Button();
        setButton(next,"Далее",0,0);
        next.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                displayHotkeys(mc);
            }
        });
    }

    private void displayHotkeys(MainCharacter mc) {
        clearButtons();
        clearMainText();
        addText("Основным методом управления в игре является нажатие кнопок с помощю курсора мыши." +
                "\nКроме того, для нажатия основных кнопок можно использовать следующие горячие клавиши:\n");
        Button cont = new Button();
        setButton(cont,"Далее",0,0);
        cont.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                chooseSex(mc);
            }
        });
        GridPane hotkeys = new GridPane();
        hotkeys.setId("Menu");
        hotkeys.setPrefWidth(500);
        String[] keys = {"1","2","3","4","5","q","w","e","r","t","a","s","d","f","g"};
        Integer row = 0;
        Integer column = 0;
        for (int i = 0; i < 15; i++){
            StackPane keySlot = new StackPane();
            keySlot.setId("MenuSlot");
            keySlot.setPrefWidth(100);
            keySlot.setPrefHeight(40);
            hotkeys.add(keySlot,column,row);
            column++;
            if (column > 4) {
                column = 0;
                row++;
            }
            Label key = new Label(keys[i]);
            keySlot.getChildren().add(key);
        }
        MainField.getChildren().add(hotkeys);
    }

    private void chooseSex(MainCharacter mc) {
        clearMainText();
        clearButtons();
        addText("Какого пола ваш персонаж?");
        Button male = new Button();
        setButton(male,"Мужчина",0,0);
        male.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                mc.setFemale(false);
                chooseClass(mc);
            }
        });
        Button female = new Button();
        setButton(female,"Женщина",0,1);
        female.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                mc.setFemale(true);
                chooseClass(mc);
            }
        });
    }

    private void chooseClass(MainCharacter mc) {
        clearMainText();
        clearButtons();
        addText("Выберите класс вашего персонажа:\n\n");
        addText("САМУРАЙ\n");
        addText("Бесстрашный воин, верный слуга императора. Как капитану стражи форпоста Таки, вам поручили почетную задачу "+
                "оберегать жемчужину небесного дракона и найти для нее новое вместилище.\n Этот класс отличается высокой устойчивостью, но" +
                " малым уроном. Он носит тяжелую броню и может пользоваться любым боевым оружием.\n\n");
        addText("УЧЕНЫЙ\n");
        addText("Молодой чиновник, занявший первое место на государственном экзамене, официальным императорским эдиктом назначенный" +
                " Смотрителем за Мистическими Вопросами на форпост Таки. Как специалисту в вопросах магии, работу над новым вместилищем для" +
                " небесного дракона было решено поручить вам.\nЭтот класс отличается высоким уроном, но низкой выживаемостью. Он носит легие одеяния" +
                " и использует различные магические фокусировки в качестве оружия.\n\n");
        addText("ПРОХИНДЕЙ\n");
        addText("Разбойник, бродяга, фокусник, авантюрист. Вас можно описать любым из этих слов. Вы совершили множество преступлений, но " +
                "каждое из них следовало духу закона, хоть и не букве. В отсутствие лучших кандидатов, вас арестовали за одно из ваших многочисленных " +
                "преступлений и в наказание поручили восстановить тело небесного дракона. Хоть вы и недовольны арестом, дело как раз вам по душе.\n" +
                "Этот класс отличается средними уроном и выживаемостью, и кроме того обладает необычными способностями, способными переломить ход боя.\n\n");
        Button samurai = new Button();
        setButton(samurai,"Самурай",0,0);
        samurai.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                clearMainText();
                clearButtons();
                mc.setCharacterClass("Самурай");
                chooseStats(mc);
            }
        });
        Button scholar = new Button();
        setButton(scholar,"Ученый",0,1);
        scholar.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                clearMainText();
                clearButtons();
                mc.setCharacterClass("Ученый");
                chooseStats(mc);
            }
        });
        Button rascal = new Button();
        setButton(rascal,"Прохиндей",0,2);
        rascal.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                mc.setCharacterClass("Прохиндей");
                chooseStats(mc);
            }
        });
    }

    private void chooseStats (MainCharacter mc) {
        clearMainText();
        clearButtons();
        addText("Распределите характеристики:\n\n"); //elaborate here
        Button cont = new Button();
        setButton(cont,"Далее",0,0);
        cont.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                chooseName(mc);
            }
        });
        cont.setDisable(true);
        GridPane statMenu = new GridPane();

        statMenu.setId("Menu");
        statMenu.setPrefWidth(200);
        MainField.getChildren().add(statMenu);
        for (int i = 0; i < 5; i++) {
            RowConstraints row = new RowConstraints(40);
            statMenu.getRowConstraints().add(row);
        }
        HBox firstMenuSlot = new HBox(5);
        firstMenuSlot.setPadding(new Insets(5, 5, 5, 5));
        firstMenuSlot.setPrefWidth(200);
        firstMenuSlot.setAlignment(Pos.CENTER_LEFT);
        firstMenuSlot.setId("MenuSlot");
        statMenu.add(firstMenuSlot,0,0);
        Label statText = new Label("Осталось очков: ");
        statText.setFont(new Font(16));
        firstMenuSlot.getChildren().add(statText);
        final Integer[] statCount = {8,3,3,3,3};
        final Integer[] stats = {mc.getStrength(), mc.getDexterity(), mc.getMind(), mc.getCharisma()};
        Label statCountText = new Label(Integer.toString(statCount[0]));
        statCountText.setFont(new Font(16));
        firstMenuSlot.getChildren().add(statCountText);

        HBox firstStatSlot = new HBox(5);
        Label StrengthText = new Label("Сила");
        Button splus = new Button("+");
        Button sminus = new Button("-");
        Label scount = new Label(Integer.toString(mc.getStrength()));
        setUpStatSlot(firstStatSlot,statMenu,StrengthText,1,splus,sminus,scount);

        HBox secondStatSlot = new HBox(5);
        Label DexterityText = new Label("Ловкость");
        Button dplus = new Button("+");
        Button dminus = new Button("-");
        Label dcount = new Label(Integer.toString(mc.getDexterity()));
        setUpStatSlot(secondStatSlot,statMenu,DexterityText,2,dplus,dminus,dcount);

        HBox thirdStatSlot = new HBox(5);
        Label MindText = new Label("Разум");
        Button mplus = new Button("+");
        Button mminus = new Button("-");
        Label mcount = new Label(Integer.toString(mc.getMind()));
        setUpStatSlot(thirdStatSlot,statMenu,MindText,3,mplus,mminus,mcount);

        HBox fourthStatSlot = new HBox(5);
        Label CharismaText = new Label("Харизма");
        Button cplus = new Button("+");
        Button cminus = new Button("-");
        Label ccount = new Label(Integer.toString(mc.getCharisma()));
        setUpStatSlot(fourthStatSlot,statMenu,CharismaText,4,cplus,cminus,ccount);
        splus.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                statCount[0] = statCount[0] - 1;
                statCountText.setText(Integer.toString(statCount[0]));
                statCount[1] = statCount[1] - 1;
                if (statCount[1] == 0 || statCount[0] == 0) splus.setDisable(true);
                if (statCount[0] == 0) {
                    cont.setDisable(false);
                    dplus.setDisable(true);
                    mplus.setDisable(true);
                    cplus.setDisable(true);
                }
                sminus.setDisable(false);
                mc.addStrength(1);
                scount.setText(Integer.toString(mc.getStrength()));
            }
        });
        sminus.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                if (statCount[0] == 0) {
                    cont.setDisable(true);
                    if (statCount[1] > 0) splus.setDisable(false);
                    if (statCount[2] > 0) dplus.setDisable(false);
                    if (statCount[3] > 0) mplus.setDisable(false);
                    if (statCount[4] > 0) cplus.setDisable(false);
                }
                statCount[0] = statCount[0] + 1;
                statCountText.setText(Integer.toString(statCount[0]));
                statCount[1] = statCount[1] + 1;
                mc.subtractStrength(1);
                if (mc.getStrength() == stats[0]) sminus.setDisable(true);
                splus.setDisable(false);
                scount.setText(Integer.toString(mc.getStrength()));
            }
        });
        dplus.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                statCount[0] = statCount[0] - 1;
                statCountText.setText(Integer.toString(statCount[0]));
                statCount[2] = statCount[2] - 1;
                if (statCount[2] == 0 || statCount[0] == 0) dplus.setDisable(true);
                if (statCount[0] == 0) {
                    splus.setDisable(true);
                    mplus.setDisable(true);
                    cplus.setDisable(true);
                    cont.setDisable(false);
                }
                dminus.setDisable(false);
                mc.addDexterity(1);
                dcount.setText(Integer.toString(mc.getDexterity()));
            }
        });
        dminus.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                if (statCount[0] == 0) {
                    cont.setDisable(true);
                    if (statCount[1] > 0) splus.setDisable(false);
                    if (statCount[2] > 0) dplus.setDisable(false);
                    if (statCount[3] > 0) mplus.setDisable(false);
                    if (statCount[4] > 0) cplus.setDisable(false);
                }
                statCount[0] = statCount[0] + 1;
                statCountText.setText(Integer.toString(statCount[0]));
                statCount[2] = statCount[2] + 1;
                mc.subtractDexterity(1);
                if (mc.getDexterity() == stats[1]) dminus.setDisable(true);
                dplus.setDisable(false);
                dcount.setText(Integer.toString(mc.getDexterity()));
            }
        });
        mplus.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                statCount[0] = statCount[0] - 1;
                statCountText.setText(Integer.toString(statCount[0]));
                statCount[3] = statCount[3] - 1;
                if (statCount[3] == 0 || statCount[0] == 0) mplus.setDisable(true);
                if (statCount[0] == 0) {
                    splus.setDisable(true);
                    dplus.setDisable(true);
                    cplus.setDisable(true);
                    cont.setDisable(false);
                }
                mminus.setDisable(false);
                mc.addMind(1);
                mcount.setText(Integer.toString(mc.getMind()));
            }
        });
        mminus.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                if (statCount[0] == 0) {
                    cont.setDisable(true);
                    if (statCount[1] > 0) splus.setDisable(false);
                    if (statCount[2] > 0) dplus.setDisable(false);
                    if (statCount[3] > 0) mplus.setDisable(false);
                    if (statCount[4] > 0) cplus.setDisable(false);
                }
                statCount[0] = statCount[0] + 1;
                statCountText.setText(Integer.toString(statCount[0]));
                statCount[3] = statCount[3] + 1;
                mc.subctractMind(1);
                if (mc.getMind() == stats[2]) mminus.setDisable(true);
                mplus.setDisable(false);
                mcount.setText(Integer.toString(mc.getMind()));
            }
        });
        cplus.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                statCount[0] = statCount[0] - 1;
                statCountText.setText(Integer.toString(statCount[0]));
                statCount[4] = statCount[4] - 1;
                if (statCount[4] == 0 || statCount[0] == 0) cplus.setDisable(true);
                if (statCount[0] == 0) {
                    splus.setDisable(true);
                    dplus.setDisable(true);
                    mplus.setDisable(true);
                    cont.setDisable(false);
                }
                cminus.setDisable(false);
                mc.addCharisma(1);
                ccount.setText(Integer.toString(mc.getCharisma()));
            }
        });
        cminus.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                if (statCount[0] == 0) {
                    cont.setDisable(true);
                    if (statCount[1] > 0) splus.setDisable(false);
                    if (statCount[2] > 0) dplus.setDisable(false);
                    if (statCount[3] > 0) mplus.setDisable(false);
                    if (statCount[4] > 0) cplus.setDisable(false);
                }
                statCount[0] = statCount[0] + 1;
                statCountText.setText(Integer.toString(statCount[0]));
                statCount[4] = statCount[4] + 1;
                mc.subtractCharisma(1);
                if (mc.getCharisma() == stats[3]) cminus.setDisable(true);
                cplus.setDisable(false);
                ccount.setText(Integer.toString(mc.getCharisma()));
            }
        });

    }

    private void setUpStatSlot (HBox statSlot, GridPane statMenu, Label text, Integer number, Button plus, Button minus, Label count) {
        statSlot.setPadding(new Insets(5, 5, 5, 5));
        statSlot.setPrefWidth(200);
        statSlot.setAlignment(Pos.CENTER_LEFT);
        statSlot.setId("MenuSlot");
        statMenu.add(statSlot,0,number);
        text.setFont(new Font(16));
        statSlot.getChildren().add(text);
        Region space = new Region();
        HBox.setHgrow(space,Priority.ALWAYS);
        statSlot.getChildren().add(space);
        minus.setId("MenuButton");
        minus.setTextFill(Color.WHITE);
        minus.setPrefWidth(25);
        minus.setDisable(true);
        statSlot.getChildren().add(minus);
        count.setFont(new Font(16));
        statSlot.getChildren().add(count);
        plus.setId("MenuButton");
        plus.setTextFill(Color.WHITE);
        plus.setPrefWidth(25);
        statSlot.getChildren().add(plus);
    }

    private void chooseName (MainCharacter mc) {
        clearMainText();
        clearButtons();
        addText("Осталось выбрать имя!\n\n");
        String[] DefaultNames = new String[6];
        if (mc.getFemale()) {
            DefaultNames[0] = "Кира";
            DefaultNames[1] = "Киры";
            DefaultNames[2] = "Кире";
            DefaultNames[3] = "Киру";
            DefaultNames[4] = "Кирой";
            DefaultNames[5] = "Кире";
        } else {
            DefaultNames[0] = "Джин";
            DefaultNames[1] = "Джина";
            DefaultNames[2] = "Джину";
            DefaultNames[3] = "Джина";
            DefaultNames[4] = "Джином";
            DefaultNames[5] = "Джине";
        }
        TextField name0 = new TextField();
        name0.setId("NameField");
        name0.setPrefWidth(110);
        name0.setText(DefaultNames[0]);
        MainField.getChildren().add(name0);
        if (mc.getFemale()) {
            addText(" вошла в чайную.\n");
        } else {
            addText(" вошел в чайную.\n");
        }
        TextField name1 = new TextField();
        name1.setId("NameField");
        name1.setPrefWidth(110);
        name1.setText(DefaultNames[1]);
        addText("Все обрадовались приходу ");
        MainField.getChildren().add(name1);
        addText(".\n");
        TextField name2 = new TextField();
        name2.setId("NameField");
        name2.setPrefWidth(110);
        name2.setText(DefaultNames[2]);
        addText("Одна из служанок подала ");
        MainField.getChildren().add(name2);
        addText(" чашку чая.\n");
        TextField name3 = new TextField();
        name3.setId("NameField");
        name3.setPrefWidth(110);
        name3.setText(DefaultNames[3]);
        addText("Старый знакомый пригласил ");
        MainField.getChildren().add(name3);
        addText(" сыграть раунд в го.\n");
        TextField name4 = new TextField();
        name4.setId("NameField");
        name4.setPrefWidth(110);
        name4.setText(DefaultNames[4]);
        addText("Он был очень впечатлен ");
        MainField.getChildren().add(name4);
        addText(" на прошлом турнире.\n");
        TextField name5 = new TextField();
        name5.setId("NameField");
        name5.setPrefWidth(110);
        name5.setText(DefaultNames[5]);
        addText("Одна из наблюдающих девушек упомянула, что новые одеяния прекрасно смотрятся на ");
        MainField.getChildren().add(name5);
        addText(".\n");
        String[] name = new String[6];
        Button cont = new Button();
        setButton(cont,"Далее",0,0);
        cont.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                //confirmation popup?
                clearMainText();
                clearButtons();
                name[0] = name0.getText();
                name[1] = name1.getText();
                name[2] = name2.getText();
                name[3] = name3.getText();
                name[4] = name4.getText();
                name[5] = name5.getText();
                mc.setName(name);
                World newWorld = new World();
                world = newWorld;
                world.setMainCharacter(mc);
                System.out.println(world.getMainCharacter().getCharacterClass());
                if (world.getMainCharacter().getCharacterClass().equals("Самурай")) nextScene(Scene.testScene1);
                else if (world.getMainCharacter().getCharacterClass().equals("Ученый")) nextScene(Scene.ScholarStart1);
                else nextScene(Scene.testScene1);
            }
        });
    }

    private void showProfile(AbstractCharacter character, VBox box) {
        Pane profilePane = new Pane();
        profilePane.setId("ProfileField");
        profilePane.setPrefSize(255,140);
        StackPane portraitContainer = new StackPane();
        String url;
        if (character.getPortraitUrl() == null) {
            url = "/com/stormtale/stormtale/images/rooster.png";
        } else {
            url = character.getPortraitUrl();
            if (character.getImageUrl() != null) {
                portraitContainer.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        StackPane PictureStack = new StackPane();
                        PictureStack.setId("PopUp");
                        MainGrid.add(PictureStack,0,0,3,2);
                        Region shade = new Region();
                        shade.prefWidthProperty().bind(MainGrid.widthProperty());
                        shade.prefHeightProperty().bind(MainGrid.heightProperty());
                        shade.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent mouseEvent) {
                                MainGrid.getChildren().remove(PictureStack);
                            }
                        });
                        PictureStack.getChildren().add(shade);
                        Image picture = new Image(this.getClass().getResourceAsStream(character.getImageUrl()));
                        ImageView pictureView = new ImageView(picture);
                        pictureView.setPreserveRatio(true);
                        if (picture.getWidth() > picture.getHeight()) {
                            if (picture.getWidth() > 1100) {
                                pictureView.setFitWidth(1100);
                            } else {
                                pictureView.setFitWidth(picture.getWidth());
                            }
                        } else {
                            if (picture.getHeight() > 750) {
                                pictureView.setFitHeight(750);
                            } else {
                                pictureView.setFitHeight(picture.getHeight());
                            }
                        }
                        PictureStack.getChildren().add(pictureView);

                    }
                });
            }
        }

        Image image = new Image(this.getClass().getResourceAsStream(url));
        Circle portrait = new Circle(50);
        portrait.setFill(new ImagePattern(image));
        Image frameImage = new Image(this.getClass().getResourceAsStream("/com/stormtale/stormtale/images/frame.png"));
        Rectangle frame = new Rectangle(110,100);
        frame.setFill(new ImagePattern(frameImage));
        portraitContainer.getChildren().add(portrait);
        portraitContainer.getChildren().add(frame);
        frame.setTranslateX(-5);
        portraitContainer.relocate(10,20);
        profilePane.getChildren().add(portraitContainer);

        Label name = new Label(character.getName()[0]);
        name.setFont(new Font(18));
        name.setTextFill(Color.rgb(48, 97, 74));
        name.relocate(125,5);
        profilePane.getChildren().add(name);

        ProgressBar healthBar = new ProgressBar();
        healthBar.setId("HealthBar");
        healthBar.progressProperty().bind(character.healthPercentageProperty());
        healthBar.setPrefSize(120,30);
        healthBar.relocate(120,35);
        profilePane.getChildren().add(healthBar);

        ProgressBar resourceBar = new ProgressBar();
        if (character.getResourceType() == "Мана") resourceBar.setId("ManaBar");
        else resourceBar.setId("StaminaBar");
        resourceBar.progressProperty().bind(character.resourcePercentageProperty());
        resourceBar.setPrefSize(120,30);
        resourceBar.relocate(120,70);
        profilePane.getChildren().add(resourceBar);

        HBox conditions = new HBox();
        conditions.setPrefSize(120,30);
        conditions.setSpacing(5);
        conditions.relocate(120,105);
        if (character.getConditions() != null) {
            for (AbstractCondition condition: character.getConditions()
                 ) {
                Image icon = new Image(this.getClass().getResourceAsStream(condition.getIconURL()));
                Rectangle iconRectangle = new  Rectangle(25,25);
                iconRectangle.setFill(new ImagePattern(icon));
                conditions.getChildren().add(iconRectangle);
            }
        }
        profilePane.getChildren().add(conditions);
        character.conditionCountProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                conditions.getChildren().clear();
                if (character.getConditions() != null) {
                    for (AbstractCondition condition: character.getConditions()
                    ) {
                        Image icon = new Image(this.getClass().getResourceAsStream(condition.getIconURL()));
                        Rectangle iconRectangle = new  Rectangle(25,25);
                        iconRectangle.setFill(new ImagePattern(icon));
                        conditions.getChildren().add(iconRectangle);
                    }
                }
            }
        });
        box.getChildren().add(profilePane);
    }

    private void checkForLevelUp(AbstractScene nextScene) {
        if (world.getMainCharacter().getLevel() < 6 && world.getMainCharacter().getExp() >= world.getMainCharacter().getMaxExp()) {
            world.getMainCharacter().addLevel(1);
            Integer newExp = world.getMainCharacter().getExp() - world.getMainCharacter().getMaxExp();
            world.getMainCharacter().setExp(newExp);
            clearMainText();
            clearButtons();
            addText("Вы достигли уровня" + world.getMainCharacter().getLevel() + "!");
            addText("\nВы получаете следующие преимущества:");
            addText(world.getMainCharacter().levelUp());
            //if companions level up, add their things here also
            Button button = new Button();
            setButton(button,"Далее",0,0);
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    checkForLevelUp(nextScene);
                }
            });
        } else nextScene(nextScene);
    }

    private void drawMap() {
        RightBox.getChildren().clear();
        Pane mapPane = new Pane();
        //mapPane.setId("MapPane");
        mapPane.setPrefSize(250,300);
        Rectangle clip = new Rectangle();
        clip.setArcWidth(4);
        clip.setArcHeight(4);
        mapPane.setClip(clip);
        mapPane.layoutBoundsProperty().addListener((ov, oldValue, newValue) -> {
            clip.setWidth(newValue.getWidth());
            clip.setHeight(newValue.getHeight());
        });
        StackPane mapStack = new StackPane(mapPane);
        mapStack.setId("MapPane");
        mapStack.setPrefSize(250,300);
        ArrayList<AbstractLocation> connected = new ArrayList<>();
        drawTile(mapPane,115,140, world.getCurrentLocation(),connected);
        Circle dot = new Circle(125,150,5,Color.BLACK);
        mapPane.getChildren().add(dot);
        RightBox.getChildren().add(mapStack);
    }

    private void drawTile(Pane mapPane, Integer currentX, Integer currentY, AbstractLocation location, ArrayList<AbstractLocation> connected) {
        connected.add(location);
        Rectangle tile = new Rectangle(20, 20);
        tile.setFill(location.getColor());
        tile.relocate(currentX, currentY);
        mapPane.getChildren().add(tile);
        location.setConnected();
        if (location.getConnectedTop() != null && !connected.contains(location.getConnectedTop())) {
            Line line = new Line(currentX + 10, currentY, currentX + 10, currentY - 20);
            mapPane.getChildren().add(line);
            drawTile(mapPane, currentX, currentY - 40, location.getConnectedTop(), connected);
        }
        if (location.getConnectedBottom() != null && !connected.contains(location.getConnectedBottom())) {
            Line line = new Line(currentX + 10, currentY + 20, currentX + 10, currentY + 40);
            mapPane.getChildren().add(line);
            drawTile(mapPane, currentX, currentY + 40, location.getConnectedBottom(), connected);
        }
        if (location.getConnectedLeft() != null && !connected.contains(location.getConnectedLeft())) {
            Line line = new Line(currentX, currentY + 10, currentX - 20, currentY + 10);
            mapPane.getChildren().add(line);
            drawTile(mapPane, currentX - 40, currentY, location.getConnectedLeft(), connected);
        }
        if (location.getConnectedRight() != null && !connected.contains(location.getConnectedRight())) {
            Line line = new Line(currentX + 20, currentY + 10, currentX + 40, currentY + 10);
            mapPane.getChildren().add(line);
            drawTile(mapPane, currentX + 40, currentY, location.getConnectedRight(), connected);
        }
    }

    private void closeMenu () {
        int n = MainPane.getChildren().size() - 1;
        while (n > 0) {
            MainPane.getChildren().remove(n);
            n--;
        }
        showMainText();
    }

    private void hideButtons() {
        for (int i = 0; i < ButtonGrid.getChildren().size(); i++) {
            ButtonGrid.getChildren().get(i).setVisible(false);
            ButtonGrid.getChildren().get(i).setManaged(false);
            for (int j = 0; j < 15; j++) {
                buttonsForKeys[i] = null;
            }
        }
    }

    private void showButtons() {
        for (int i = 0; i <  ButtonGrid.getChildren().size(); i++) {
            ButtonGrid.getChildren().get(i).setVisible(true);
            ButtonGrid.getChildren().get(i).setManaged(true);
            int j = GridPane.getRowIndex(ButtonGrid.getChildren().get(i)) * 5 + GridPane.getColumnIndex(ButtonGrid.getChildren().get(i));
            if(ButtonGrid.getChildren().get(i) instanceof  Button)buttonsForKeys[j] = (Button)ButtonGrid.getChildren().get(i);
        }
    }

    private void deleteVisibleButtons() {
        Iterator<Node> iterator = ButtonGrid.getChildren().iterator();
        while (iterator.hasNext()){
            Node node = iterator.next();
            if (node.isVisible()) {
                int j = GridPane.getRowIndex(node) * 5 + GridPane.getColumnIndex(node);
                buttonsForKeys[j] = null;
                iterator.remove();
            }
        }
    }

    private void showMainText () {
        MainField.setVisible(true);
        MainField.setManaged(true);
    }

    private void hideMainText () {
        MainField.setVisible(false);
        MainField.setManaged(false);
    }

    private void clearMainText () {
        MainField.getChildren().clear();
        MainField.resize(MainPane.getPrefWidth(),0);
    }

    private void addText (String string) {
        Text text = new Text(string);
        MainField.getChildren().add(text);
    }

}