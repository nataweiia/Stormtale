package com.stormtale.stormtale.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class Scene {

    //@FXML
    //TextFlow MainField;

    public void Clean (TextFlow MainField) {
        //MainField.getChildren().clear();
        MainField.getChildren().clear();
    }

    public static void Add (String string, TextFlow MainField) {
        //add text to MainField
        //Label text = new Label(string);
        Text text = new Text(string);
        text.setId("MainText");
        MainField.getChildren().add(text);
    }
}
