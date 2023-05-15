package com.stormtale.stormtale.Controllers;

import com.stormtale.stormtale.game.MainCharacter;
import com.stormtale.stormtale.game.inventory.Inventory;
import com.stormtale.stormtale.game.inventory.Item;
import com.stormtale.stormtale.World;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.fxml.Initializable;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.scene.paint.Color;
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

    World world;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //addButton(ButtonGrid);
        //Scene scene = new Scene();
        //SceneAdd("Welcome text");
        //scene.Add("Welcome Text");
        //create with textflow?
        Scene.Add ("Вступительный текст о том как офигенна и восхитительна наша игра.\n", MainField);
        Scene.Add ("WelcomeText\n\n", MainField);
        Scene.Add ("WelcomeText", MainField);


        /*Buttons.addButton(ButtonGrid, "",0,0);
        Buttons.addButton(ButtonGrid, "",0,1);
        Buttons.addButton(ButtonGrid, "",0,2);
        Buttons.addButton(ButtonGrid, "",0,3);
        Buttons.addButton(ButtonGrid, "",0,4);
        Buttons.addButton(ButtonGrid, "",1,0);
        Buttons.addButton(ButtonGrid, "",1,1);
        Buttons.addButton(ButtonGrid, "",1,2);
        Buttons.addButton(ButtonGrid, "",1,3);
        Buttons.addButton(ButtonGrid, "",1,4);
        Buttons.addButton(ButtonGrid, "",2,0);*/
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
                //MainScroll.setVisible(true);
                //showSaveMenu();
                //closeMenu();
                //showPopUp();
                //characterCreation();
            }
        });
        Buttons.addButton(ButtonGrid, "",2,2);
        Buttons.addButton(ButtonGrid, "",2,3);
        Buttons.addButton(ButtonGrid, "",2,4);
        showSaveMenu();
    }

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
        button.setId("DisButton");
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
                LoadButton.setId("MenuButton");
            } else {
                name.setText("---");
                LoadButton.setId("MenuDisButton");
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
                        LoadButton.setId("MenuButton");
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
    }

    private void characterCreation(MainCharacter mc) {
        clearMainText();
        clearButtons();
        addText("Вступление");
        Button next = new Button();
        setButton(next,"Далее",0,0);
        next.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
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
        addText("Распределите характеристики:"); //elaborate here
        GridPane statMenu = new GridPane();
        statMenu.setId("Menu");
        statMenu.setPrefWidth(200);
        RowConstraints firstRow = new RowConstraints(40);
        statMenu.getRowConstraints().add(firstRow);
        HBox firstMenuSlot = new HBox(5);
        for (int i = 1; i < 5; i++) {
            RowConstraints row = new RowConstraints(40);
            statMenu.getRowConstraints().add(row);
            HBox menuSlot = new HBox(5);
        }
//        SaveMenu.setPrefWidth(520);
//        for (int i = 0; i < 10; i++) {
//            RowConstraints row = new RowConstraints(50);
//            SaveMenu.getRowConstraints().add(row);
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


    private void showPopUp () { //WIP
        StackPane PopUpStack = new StackPane();
        PopUpStack.setId("PopUp");
        MainGrid.add(PopUpStack,0,0,3,2);
        Region shade = new Region();
        shade.prefWidthProperty().bind(MainGrid.widthProperty());
        shade.prefHeightProperty().bind(MainGrid.heightProperty());
        PopUpStack.getChildren().add(shade);
        Button close = new Button("close");
        PopUpStack.getChildren().add(close);
        close.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                MainGrid.getChildren().remove(PopUpStack);
            }
        });
    }
}