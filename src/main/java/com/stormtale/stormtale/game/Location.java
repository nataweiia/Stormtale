package com.stormtale.stormtale.game;

import javafx.scene.paint.Color;

public class Location {
    public static AbstractLocation testLocation = new AbstractLocation(Color.rgb(148,121,156),new AbstractLocation[]{Location.testLocation2,null,null,null}) {

    };

    public static AbstractLocation testLocation2 = new AbstractLocation(Color.rgb(121,156,136),new AbstractLocation[]{null,Location.testLocation,null,null}) {
    };
}
