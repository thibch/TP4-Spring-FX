module fr.ul.tp3_exo2_fx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javax.ws.rs.api;
    requires jersey.client;
    requires json.simple;


    opens fr.ul.tp3_exo2_fx to javafx.fxml;
    exports fr.ul.tp3_exo2_fx;
    exports fr.ul.tp3_exo2_fx.controller;
    opens fr.ul.tp3_exo2_fx.controller to javafx.fxml;
}