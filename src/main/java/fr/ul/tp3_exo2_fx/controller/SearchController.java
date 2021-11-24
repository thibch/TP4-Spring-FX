package fr.ul.tp3_exo2_fx.controller;

import fr.ul.tp3_exo2_fx.Card;
import fr.ul.tp3_exo2_fx.HTMLManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

public class SearchController {
    @FXML private Button validateButton;
    @FXML private Text cardText;
    @FXML private TextField searchField;

    public void validateButton(ActionEvent actionEvent) {
        Card card = HTMLManager.callGETCard(searchField.getText());
        cardText.setText(card.toString().replace(", ", "\n").replace("{", "\n").replace("}", ""));
    }

    public void onReturnClick(ActionEvent actionEvent) throws IOException {
        FirstViewController.switchScene("first-view.fxml", actionEvent, 320, 240);
    }
}
