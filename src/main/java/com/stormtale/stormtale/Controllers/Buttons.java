package com.stormtale.stormtale.Controllers;

import javafx.geometry.Bounds;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.stage.PopupWindow;
import javafx.util.Duration;

public class Buttons { //remove later

    public static void addButton (GridPane grid, String text, int row, int column) {
        Button button = new Button(text);
        button.setPadding(new Insets(5));
        button.setPrefSize(110,35);
        button.setId("Button");
        grid.setHalignment(button, HPos.CENTER);
        grid.add(button, column, row);
    }

    public static void setButton (Button button, GridPane grid, String text, int row, int column) {
        button.setText(text);
        button.setPadding(new Insets(5));
        button.setPrefSize(110,35);
        button.setId("Button");
        grid.setHalignment(button, HPos.CENTER);
        grid.add(button, column, row);
    }

    public static void setDisabledButton (Button button, GridPane grid, String text, int row, int column) {
        button.setText(text);
        button.setPadding(new Insets(5));
        button.setPrefSize(110,35);
        button.setId("DisButton");
        grid.setHalignment(button, HPos.CENTER);
        grid.add(button, column, row);
    }

    public static void setButtonHover (Button button, GridPane grid, String text, String tooltip, int row, int column) {
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
        grid.setHalignment(button, HPos.CENTER);
        grid.add(button, column, row);
    }

    public static void clearButtons (GridPane grid) {
        grid.getChildren().clear();
    }


    public static void addDisabledButton (GridPane grid, String text, int row, int column) {
        Button button = new Button(text);
        button.setPadding(new Insets(5));
        button.setPrefSize(110,35);
        button.setId("DisButton");
        grid.setHalignment(button, HPos.CENTER);
        grid.add(button, column, row);
    }

    public static void addButtonHover (GridPane grid, String text, String tooltip, int row, int column) {
        Button button = new Button(text);
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
        grid.setHalignment(button, HPos.CENTER);
        grid.add(button, column, row);
    }
}
