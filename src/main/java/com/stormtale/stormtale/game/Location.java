package com.stormtale.stormtale.game;

import java.io.Serializable;

public class Location implements Serializable {
    public static AbstractLocation testLocation = new AbstractLocation(156,148,121) {

        @Override
        public void setConnected() {
            setConnectedTop(Location.testLocation2);
        }

        @Override
        public AbstractScene getScene() {
            return Scene.testScene1;
        }
    };

    public static AbstractLocation testLocation2 = new AbstractLocation(156,148,121) {
        @Override
        public void setConnected() {
            setConnectedBottom(Location.testLocation);
            setConnectedTop(testLocation3);
        }

        @Override
        public AbstractScene getScene() {
            return Scene.testScene2;
        }
    };

    public static AbstractLocation testLocation3 = new AbstractLocation(156,148,121) {
        @Override
        public void setConnected() {
            setConnectedLeft(testLocationShrub);
            setConnectedTop(testLocation4);
            setConnectedBottom(Location.testLocation2);
        }

        @Override
        public AbstractScene getScene() {
            return Scene.testScene3;
        }
    };

    public static AbstractLocation testLocation4 = new AbstractLocation(156,148,121) {
        @Override
        public void setConnected() {
            setConnectedRight(testLocation5);
            setConnectedBottom(Location.testLocation3);
        }

        @Override
        public AbstractScene getScene() {
            return Scene.testScene4;
        }
    };

    public static AbstractLocation testLocation5 = new AbstractLocation(102,99,88) {
        @Override
        public void setConnected() {
            setConnectedLeft(testLocation4);
        }
        @Override
        public AbstractScene getScene() {
            return Scene.testScene5;
        }
    };

    public static AbstractLocation testLocationShrub = new AbstractLocation(156,148,121) {
        @Override
        public void setConnected() {
            setConnectedRight(testLocation3);
        }
        @Override
        public AbstractScene getScene() {
            return Scene.shrub;
        }
    };

    public static AbstractLocation testLocation21 = new AbstractLocation(153,82,186) {
        @Override
        public void setConnected() {
            setConnectedTop(testLocation22);
        }
        @Override
        public AbstractScene getScene() {
            return Scene.testScene21;
        }
    };

    public static AbstractLocation testLocation22 = new AbstractLocation(84,186,82) {
        @Override
        public void setConnected() {
            setConnectedBottom(testLocation21);
        }
        @Override
        public AbstractScene getScene() {
            return Scene.testScene22;
        }
    };

    public static AbstractLocation ScholarHome = new AbstractLocation(247,234,92,"Форпост Таки") {
        @Override
        public void setConnected() {
            setConnectedBottom(RichStreet1);
        }
        @Override
        public AbstractScene getScene() {
            return Scene.ScholarHome;
        }
    };
    public static AbstractLocation RichStreet1 = new AbstractLocation(247,234,92,"Форпост Таки") {
        @Override
        public void setConnected() {
            setConnectedTop(ScholarHome);
            setConnectedLeft(RichStreet2);
        }
        @Override
        public AbstractScene getScene() {
            return Scene.RichStreet1;
        }
    };
    public static AbstractLocation RichStreet2 = new AbstractLocation(247,234,92,"Форпост Таки") {
        @Override
        public void setConnected() {
            setConnectedRight(RichStreet1);
            setConnectedLeft(RichStreet3);
        }
        @Override
        public AbstractScene getScene() {
            return Scene.RichStreet2;
        }
    };
    public static AbstractLocation RichStreet3 = new AbstractLocation(247,234,92,"Форпост Таки") {
        @Override
        public void setConnected() {
            setConnectedRight(RichStreet2);
            setConnectedBottom(Pier1);
        }
        @Override
        public AbstractScene getScene() {
            return Scene.RichStreet3;
        }
    };

    public static AbstractLocation Pier1 = new AbstractLocation(73,142,191,"Форпост Таки") {
        @Override
        public void setConnected() {
            setConnectedTop(RichStreet3);
            setConnectedBottom(Pier2);
            setConnectedLeft(Bureau1);
        }
        @Override
        public AbstractScene getScene() {
            return Scene.Pier1;
        }
    };

    public static AbstractLocation Pier2 = new AbstractLocation(73,142,191,"Форпост Таки") {
        @Override
        public void setConnected() {
            setConnectedTop(Pier1);
            setConnectedBottom(LowStreet1);
        }
        @Override
        public AbstractScene getScene() {
            return Scene.Pier2;
        }
    };

    public static AbstractLocation Bureau1 = new AbstractLocation(120,73,191,"Форпост Таки") {
        @Override
        public void setConnected() {
            setConnectedRight(Pier1);
            setConnectedLeft(Bureau2);
        }
        @Override
        public AbstractScene getScene() {
            return Scene.Bureau1;
        }
    };

    public static AbstractLocation Bureau2 = new AbstractLocation(120,73,191,"Форпост Таки") {
        @Override
        public void setConnected() {
            setConnectedRight(Bureau1);
            setConnectedBottom(SamuraiHome);
        }
        @Override
        public AbstractScene getScene() {
            return Scene.Bureau2;
        }
    };

    public static AbstractLocation SamuraiHome = new AbstractLocation(191,73,73,"Форпост Таки") {
        @Override
        public void setConnected() {
            setConnectedTop(Bureau2);
        }
        @Override
        public AbstractScene getScene() {
            return Scene.SamuraiHome;
        }
    };

    public static AbstractLocation LowStreet1 = new AbstractLocation(191,183,73,"Форпост Таки") {
        @Override
        public void setConnected() {
            setConnectedTop(Pier2);
            setConnectedLeft(RascalHome);
            setConnectedRight(LowStreet2);
        }
        @Override
        public AbstractScene getScene() {
            return Scene.LowStreet1;
        }
    };

    public static AbstractLocation LowStreet2 = new AbstractLocation(191,183,73,"Форпост Таки") {
        @Override
        public void setConnected() {
            setConnectedLeft(LowStreet1);
            setConnectedRight(LowStreet3);
        }
        @Override
        public AbstractScene getScene() {
            return Scene.LowStreet2;
        }
    };

    public static AbstractLocation LowStreet3 = new AbstractLocation(191,183,73,"Форпост Таки") {
        @Override
        public void setConnected() {
            setConnectedLeft(LowStreet2);
            setConnectedRight(LowStreet4);
        }
        @Override
        public AbstractScene getScene() {
            return Scene.LowStreet3;
        }
    };

    public static AbstractLocation LowStreet4 = new AbstractLocation(191,183,73,"Форпост Таки") {
        @Override
        public void setConnected() {
            setConnectedLeft(LowStreet3);
        }
        @Override
        public AbstractScene getScene() {
            return Scene.LowStreet4;
        }
    };

    public static AbstractLocation RascalHome = new AbstractLocation(92,71,48,"Форпост Таки") {
        @Override
        public void setConnected() {
            setConnectedRight(LowStreet1);
        }
        @Override
        public AbstractScene getScene() {
            return Scene.RascalHome;
        }
    };

    public static AbstractLocation Forest1 = new AbstractLocation(39,117,25,"Ближний лес") {
        @Override
        public void setConnected() {
            setConnectedBottom(Forest2);
        }

        @Override
        public AbstractScene getScene() {
            return Scene.Forest;
        }
    };

    public static AbstractLocation Forest2 = new AbstractLocation(39,117,25,"Ближний лес") {
        @Override
        public void setConnected() {
            setConnectedTop(Forest1);
            setConnectedLeft(Forest3);
            setConnectedRight(Forest5);
        }

        @Override
        public AbstractScene getScene() {
            return Scene.Forest;
        }
    };

    public static AbstractLocation Forest3 = new AbstractLocation(39,117,25,"Ближний лес") {
        @Override
        public void setConnected() {
            setConnectedRight(Forest2);
            setConnectedBottom(Forest4);
        }

        @Override
        public AbstractScene getScene() {
            return Scene.Forest;
        }
    };

    public static AbstractLocation Forest4 = new AbstractLocation(39,117,25,"Ближний лес") {
        @Override
        public void setConnected() {
            setConnectedTop(Forest3);
        }

        @Override
        public AbstractScene getScene() {
            return Scene.Forest;
        }
    };

    public static AbstractLocation Forest5 = new AbstractLocation(39,117,25,"Ближний лес") {
        @Override
        public void setConnected() {
            setConnectedLeft(Forest2);
            setConnectedBottom(Forest7);
            setConnectedRight(Forest6);
        }

        @Override
        public AbstractScene getScene() {
            return Scene.Forest;
        }
    };

    public static AbstractLocation Forest6 = new AbstractLocation(39,117,25,"Ближний лес") {
        @Override
        public void setConnected() {
            setConnectedLeft(Forest5);
        }

        @Override
        public AbstractScene getScene() {
            return Scene.Forest;
        }
    };

    public static AbstractLocation Forest7 = new AbstractLocation(39,117,25,"Ближний лес") {
        @Override
        public void setConnected() {
            setConnectedTop(Forest5);
        }

        @Override
        public AbstractScene getScene() {
            return Scene.Forest;
        }
    };
}
