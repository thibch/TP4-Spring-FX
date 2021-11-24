package fr.ul.tp3_exo2_fx.controller;

import fr.ul.tp3_exo2_fx.Card;
import fr.ul.tp3_exo2_fx.HTMLManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class EditView {
    @FXML private TextField searchField;
    @FXML private Button searchButton;
    @FXML private Label titleText;
    @FXML private TextField titleField;
    @FXML private TextField typeField;
    @FXML private TextField priceField;
    @FXML private Button validateButton;

    public EditView() {
    }

    @FXML
    public void initialize() {
        titleText.setText("Modifier le carte");
        disableAll(true);
    }

    public void disableAll(boolean bool) {
        titleField.setDisable(bool);
        typeField.setDisable(bool);
        priceField.setDisable(bool);
        validateButton.setDisable(bool);
    }

    public void searchButton(ActionEvent actionEvent) {

        String isbn = searchField.getText();

        // Search for card in db
        Card card = HTMLManager.callGETCard(isbn);

        if (card.getId() > 0) {
            searchButton.setDisable(true);
            searchField.setDisable(true);
            disableAll(false);

            titleField.setText(card.getNom());
            typeField.setText(card.getType());
            priceField.setText("" + card.getNiveau());
        }

    }

    public void validateButton(ActionEvent actionEvent) {
        HTMLManager.callPUTCard(
                new Card(Integer.parseInt(searchField.getText()),
                        titleField.getText(),
                        typeField.getText(),
                        Integer.parseInt(priceField.getText())));
        disableAll(true);
    }

    public void onReturnClick(ActionEvent actionEvent) throws IOException {
        FirstViewController.switchScene("first-view.fxml", actionEvent, 320, 240);
    }
}
