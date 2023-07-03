package com.stormtale.stormtale.Controllers;

import com.stormtale.stormtale.game.*;
import com.stormtale.stormtale.game.inventory.Inventory;
import com.stormtale.stormtale.game.inventory.Item;
import com.stormtale.stormtale.World;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.fxml.Initializable;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
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
    VBox ProfileBox;

    World world;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //create with textflow?
        addText("Вступительный текст о том как офигенна и восхитительна наша игра.\n");
        addText("WelcomeText\n\n");
        addText("WelcomeText");
        Button newGame = new Button();
        setButton(newGame,"Новая игра",0,0);
        newGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                World newWorld = new World();
                world = newWorld;
                MainCharacter mc = new MainCharacter();
                world.setMainCharacter(mc);
                characterCreation(mc);
            }
        });
        Button button = new Button();
        setButtonHover(button,"11", "Вступительный текст о том как офигенна и восхитительна наша игра.\nЭто подсказка",2,1);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                World newWorld = new World();
                world = newWorld;
                MainCharacter mc = new MainCharacter();
                String[] names = new String[6];
                for (int i = 0; i < 6; i++) {
                    names[i] = "Эфиселия";
                }
                mc.setName(names);
                mc.setCharacterClass("Ученый");
                mc.setFemale(true);
                mc.setMaxHealth(15);
                mc.setCurrentHealth(10);
                mc.setCurrentResource(10);
                mc.setMaxResource(15);
                mc.addCondition(Condition.testCondition);
//                NPC enemy = new NPC();
//                Combat combat = new Combat(mc,enemy);
//                System.out.println(mc.getCurrentHealth());
//                combat.turn();
                System.out.println(mc.getCurrentHealth());
                world.setMainCharacter(mc);
                world.getMainCharacter().setPortraitUrl("/com/stormtale/stormtale/images/rooster.png");
                world.getMainCharacter().setImageUrl("/com/stormtale/stormtale/images/test.png");
                showProfile(mc);
//                Scene scene1 = new Scene();
//                Scene scene2 = new Scene();
//                scene1.setText("test text");
//                scene2.setText("some text");
//                ButtonInfo button11 = new ButtonInfo();
//                button11.setName("Далее");
//                button11.setRow(0);
//                button11.setColumn(1);
//                button11.setType("Continue");
//                button11.setNextScene(scene2);
//                scene1.addButton(button11);
                nextScene(scene1);
                //DEAL WITH IT

            }
        });
        //showSaveMenu();
    }

    public static Scene scene1 = new Scene() { //test, delete later
        @Override
        public void setUpScene(World world) {
            scene1.setText("success");
            //test changing, text for example
            //if not works, change get methods with ifs maybe? idk
            //override a bunch of this shit
        }
    };

    private void setButton (Button button, String text, int row, int column) {
        button.setText(text);
        button.setPadding(new Insets(5));
        button.setPrefSize(110,35);
        button.setId("Button");
        ButtonGrid.setHalignment(button, HPos.CENTER);
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
        ButtonGrid.add(button, column, row);
    }

    private void clearButtons () {
        ButtonGrid.getChildren().clear();
    }

    private void combatInstance (Combat combat) {
        //hideMap()

        //give rewards upon winning, get rewards from enemies

    }

    private void nextScene (Scene scene) {
        clearMainText();
        clearButtons();
        world.setCurrentLocation(scene.getLocation()); //add map change here
        //world.addTime(5); //randomise, link to time/date label
        //scene.setPronouns(world.getMainCharacter()); //for male or female
        //maybe smth like (if !=female)
        scene.setUpScene(world);
        addText(scene.getText());
        ArrayList<ButtonInfo> buttons = scene.getButtons();
        //add buttons
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
                    case Item:
                        button.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                addText("\n+1 " + buttonInfo.getItem().getName() + ".");
                                //do smth with saves here, idk
                                //maybe keep all scenes in world?
                                //check with world if already taken or smth
                                //world.getMainCharacter().addItem(buttonInfo.getItem());
                                ButtonGrid.getChildren().remove(button);
                            }
                        });
                        break;
                    case Combat:
                        //start combat, remember scene
                        //write in combat optional post-combat scene, if null return to remembered scene
                        break;
                    case Continue:
                        button.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                //do smth with scenes, search through id? open file if nextFile not empty?
                                nextScene(buttonInfo.getNextScene());
                            }
                        });
                        break;
                    case Dialogue:
                        button.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                //map.setVisibility(false); or smth like that
                                //maybe show portrait window?
                                AbstractNPC dialoguePartisipant = buttonInfo.getNpc(); //dialogue interface?
                                nextScene(buttonInfo.getNextScene());
                            }
                        });
                        break;
                    case Movement:
                        button.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                String location = buttonInfo.getNewLocation();
                                //move character on map
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

    private void displayInventory (Inventory inventory) { //WIP, rework, save in worldstate MB?
        ArrayList<Item> inv = inventory.getInv();
        if (inv.size() < 6) {
            for (int i = 0; i < inv.size(); i++) {
                Button button = new Button();
                setButtonHover(button, inv.get(i).getName(), inv.get(i).getItem(), 0, i);
                //interaction with item, WIP
            }
        }
        else {
            Integer n = inv.size(); //WRONG
            Integer x = 0;
            while (n > 0) {
                if (n > 5 && x == 0) {
                    for (int i = 0; i < 5; i++) {
                        Button button = new Button();
                        setButtonHover(button, inv.get(i).getName(), inv.get(i).getItem(), 0, i);
                        //interaction with item, WIP
                    }
                    Button button = new Button();
                    setButton(button, ">>",2,4);
                }
                if (n > 5 && x > 0) {
                    for (int i = 0; i < 5; i++) {
                        Button button = new Button();
                        setButtonHover(button, inv.get(x * 5 + i).getName(), inv.get(x * 5 + i).getItem(), 0, i);
                        //interaction with item, WIP
                    }
                    Button buttonRight = new Button();
                    setButton(buttonRight, ">>",2,4);
                    Button buttonLeft = new Button();
                    setButton(buttonLeft, "<<",2,4);
                    //way to store the page, WIP

                }
                if (n < 5) {
                    for (int i = 0; i < n; i++) {
                        Button button = new Button();
                        setButtonHover(button, inv.get(x * 5 + i).getName(), inv.get(x * 5 + i).getItem(), 0, i);
                        //interaction with item, WIP
                    }
                    Button buttonLeft = new Button();
                    setButton(buttonLeft, "<<",2,4);
                    //way to store the page, WIP
                }
                x = x + 5;
                n = n - 5;
            }
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
                    name.setText(tempWorld.getCurrentLocation() + ", " + tempWorld.getCurrentTime().getCurrentTime());
                    in.close();
                    fileIn.close();
                } catch (IOException | ClassNotFoundException c) {
                    c.printStackTrace();
                }
            } else {
                name.setText("---");
                LoadButton.setDisable(true);
            }
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
                    }
                    name.setText(world.getCurrentLocation() + ", " + world.getCurrentTime().getCurrentTime());
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
                        } catch (IOException | ClassNotFoundException c) {
                            c.printStackTrace();
                        }
                    }
                    closeMenu(); //add loaded window here
                }
            });
            SaveSlot.getChildren().add(LoadButton);
            SaveSlot.getChildren().add(name);
            Region space = new Region();
            HBox.setHgrow(space,Priority.ALWAYS);
            SaveSlot.getChildren().add(space);
            Button DeleteButton = new Button();
            DeleteButton.setText("Удалить");
            DeleteButton.setTextFill(Color.WHITE);
            DeleteButton.setPrefSize(80,25);
            DeleteButton.setMinSize(80,25);
            DeleteButton.setId("MenuButton");
            SaveSlot.getChildren().add(DeleteButton);
            DeleteButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                    saveFile.delete();
                    name.setText("---");
                }
            });
        }
        SaveMenu.setLayoutX((MainPane.getPrefWidth() - 520) / 2 );
        SaveMenu.setLayoutY(20);
        hideMainText();
        MainPane.getChildren().add(SaveMenu);
        Button back = new Button();
        setButton(back,"Назад",0,0);
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                closeMenu();
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
                chooseSex(mc);
            }
        });
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
        addText("Выбор класса\n\n");
        addText("САМУРАЙ\nОписание самурая\n\n");
        addText("УЧЕНЫЙ\nОписание ученого\n\n");
        addText("ПРОХИНДЕЙ\nОписание прохиндея\n\n");
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

        MainField.getChildren().add(statMenu);
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
        addText("Старый знакомый пришласил ");
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
            }
        });
    }

    private void showProfile(AbstractCharacter character) {
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
        double health = character.getCurrentHealth();
        healthBar.setProgress(health / character.getMaxHealth());
        healthBar.setPrefSize(120,30);
        healthBar.relocate(120,35);
        profilePane.getChildren().add(healthBar);

        ProgressBar resourceBar = new ProgressBar();
        resourceBar.setId("ResourceBar");
        double progress = character.getCurrentResource();
        resourceBar.setProgress(progress / character.getMaxResource());
        resourceBar.setPrefSize(120,30);
        resourceBar.relocate(120,70);
        profilePane.getChildren().add(resourceBar);

        HBox conditions = new HBox();
        conditions.setPrefSize(120,30);
        conditions.setSpacing(5);
        conditions.relocate(120,105);
        if (world.getMainCharacter().getConditions() != null) {
            for (AbstractCondition condition: world.getMainCharacter().getConditions()
                 ) {
                Image icon = new Image(this.getClass().getResourceAsStream(condition.getIconURL()));
                Rectangle iconRectangle = new  Rectangle(25,25);
                iconRectangle.setFill(new ImagePattern(icon));
                conditions.getChildren().add(iconRectangle);
                //add description
            }
        }
        profilePane.getChildren().add(conditions);

        ProfileBox.getChildren().add(profilePane);

    }

    private void closeMenu () {
        int n = MainPane.getChildren().size() - 1;
        while (n > 0) {
            MainPane.getChildren().remove(n);
            n--;
        }
        showMainText();
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