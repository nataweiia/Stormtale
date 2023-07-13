module com.stormtale.stormtale {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.stormtale.stormtale to javafx.fxml;
    exports com.stormtale.stormtale;
    exports com.stormtale.stormtale.Controllers;
    opens com.stormtale.stormtale.Controllers to javafx.fxml;
    exports com.stormtale.stormtale.game.inventory;
    opens com.stormtale.stormtale.game.inventory to javafx.fxml;
    exports com.stormtale.stormtale.game;
    opens com.stormtale.stormtale.game to javafx.fxml;
    exports com.stormtale.stormtale.game.combat;
    opens com.stormtale.stormtale.game.combat to javafx.fxml;
    exports com.stormtale.stormtale.game.npc;
    opens com.stormtale.stormtale.game.npc to javafx.fxml;
}