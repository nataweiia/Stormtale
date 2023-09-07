package com.stormtale.stormtale.game;

import javafx.scene.paint.Color;

public class Location {
    public static AbstractLocation testLocation = new AbstractLocation(Color.rgb(156,148,121)) {

        @Override
        public void setConnected() {
            setConnectedTop(Location.testLocation2);
        }
    };

    public static AbstractLocation testLocation2 = new AbstractLocation(Color.rgb(156,148,121)) {
        @Override
        public void setConnected() {
            setConnectedBottom(Location.testLocation);
            setConnectedTop(testLocation3);
        }
    };

    public static AbstractLocation testLocation3 = new AbstractLocation(Color.rgb(156,148,121)) {
        @Override
        public void setConnected() {
            setConnectedLeft(testLocationShrub);
            setConnectedTop(testLocation4);
            setConnectedBottom(Location.testLocation2);
        }
    };

    public static AbstractLocation testLocation4 = new AbstractLocation(Color.rgb(156,148,121)) {
        @Override
        public void setConnected() {
            setConnectedRight(testLocation5);
            setConnectedBottom(Location.testLocation3);
        }
    };

    public static AbstractLocation testLocation5 = new AbstractLocation(Color.rgb(102,99,88)) {
        @Override
        public void setConnected() {
            setConnectedLeft(testLocation4);
        }
    };

    public static AbstractLocation testLocationShrub = new AbstractLocation(Color.rgb(156,148,121)) {
        @Override
        public void setConnected() {
            setConnectedRight(testLocation3);
        }
    };

    public static AbstractLocation testLocation21 = new AbstractLocation(Color.rgb(153,82,186)) {
        @Override
        public void setConnected() {
            setConnectedTop(testLocation22);
        }
    };

    public static AbstractLocation testLocation22 = new AbstractLocation(Color.rgb(84,186,82)) {
        @Override
        public void setConnected() {
            setConnectedBottom(testLocation21);
        }
    };

    public static AbstractLocation ScholarHome = new AbstractLocation(Color.rgb(247,234,92),"Форпост Таки") {
        @Override
        public void setConnected() {
            setConnectedBottom(RichStreet1);
        }
    };
    public static AbstractLocation RichStreet1 = new AbstractLocation(Color.rgb(247,234,92),"Форпост Таки") {
        @Override
        public void setConnected() {
            setConnectedTop(ScholarHome);
            setConnectedLeft(RichStreet2);
        }
    };
    public static AbstractLocation RichStreet2 = new AbstractLocation(Color.rgb(247,234,92),"Форпост Таки") {
        @Override
        public void setConnected() {
            setConnectedRight(RichStreet1);
            setConnectedLeft(RichStreet3);
        }
    };
    public static AbstractLocation RichStreet3 = new AbstractLocation(Color.rgb(247,234,92),"Форпост Таки") {
        @Override
        public void setConnected() {
            setConnectedRight(RichStreet2);
            setConnectedBottom(Pier1);
        }
    };

    public static AbstractLocation Pier1 = new AbstractLocation(Color.rgb(73,142,191),"Форпост Таки") {
        @Override
        public void setConnected() {
            setConnectedTop(RichStreet3);
            setConnectedBottom(Pier2);
            setConnectedLeft(Bureau1);
        }
    };

    public static AbstractLocation Pier2 = new AbstractLocation(Color.rgb(73,142,191),"Форпост Таки") {
        @Override
        public void setConnected() {
            setConnectedTop(Pier1);
            setConnectedBottom(LowStreet1);
        }
    };

    public static AbstractLocation Bureau1 = new AbstractLocation(Color.rgb(120,73,191),"Форпост Таки") {
        @Override
        public void setConnected() {
            setConnectedRight(Pier1);
            setConnectedLeft(Bureau2);
        }
    };

    public static AbstractLocation Bureau2 = new AbstractLocation(Color.rgb(120,73,191),"Форпост Таки") {
        @Override
        public void setConnected() {
            setConnectedRight(Bureau1);
            setConnectedBottom(SamuraiHome);
        }
    };

    public static AbstractLocation SamuraiHome = new AbstractLocation(Color.rgb(191,73,73),"Форпост Таки") {
        @Override
        public void setConnected() {
            setConnectedTop(Bureau2);
        }
    };

    public static AbstractLocation LowStreet1 = new AbstractLocation(Color.rgb(191,183,73),"Форпост Таки") {
        @Override
        public void setConnected() {
            setConnectedTop(Pier2);
            setConnectedLeft(RogueHome);
            setConnectedRight(LowStreet2);
        }
    };

    public static AbstractLocation LowStreet2 = new AbstractLocation(Color.rgb(191,183,73),"Форпост Таки") {
        @Override
        public void setConnected() {
            setConnectedLeft(LowStreet1);
            setConnectedRight(LowStreet3);
        }
    };

    public static AbstractLocation LowStreet3 = new AbstractLocation(Color.rgb(191,183,73),"Форпост Таки") {
        @Override
        public void setConnected() {
            setConnectedLeft(LowStreet2);
            setConnectedRight(LowStreet4);
        }
    };

    public static AbstractLocation LowStreet4 = new AbstractLocation(Color.rgb(191,183,73),"Форпост Таки") {
        @Override
        public void setConnected() {
            setConnectedLeft(LowStreet3);
        }
    };

    public static AbstractLocation RogueHome = new AbstractLocation(Color.rgb(92,71,48),"Форпост Таки") {
        @Override
        public void setConnected() {
            setConnectedRight(LowStreet1);
        }
    };
}
