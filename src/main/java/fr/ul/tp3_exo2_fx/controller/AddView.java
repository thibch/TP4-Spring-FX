package fr.ul.tp3_exo2_fx.controller;

import fr.ul.tp3_exo2_fx.Card;
import fr.ul.tp3_exo2_fx.HTMLManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddView {
    @FXML private TextField titleField;
    @FXML private TextField typeField;
    @FXML private TextField priceField;

    public AddView(){
    }


    public void validateButton(ActionEvent actionEvent) {
        HTMLManager.callPOSTCard(
                new Card(0,
                        titleField.getText(),
                        typeField.getText(),
                        Integer.parseInt(priceField.getText())));
    }

    public void onReturnClick(ActionEvent actionEvent) throws IOException {
        FirstViewController.switchScene("first-view.fxml", actionEvent, 320, 240);
    }
}
