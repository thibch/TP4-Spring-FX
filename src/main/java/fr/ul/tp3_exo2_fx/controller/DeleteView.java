package fr.ul.tp3_exo2_fx.controller;

import fr.ul.tp3_exo2_fx.HTMLManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

public class DeleteView {
    @FXML private TextField searchField;
    @FXML private Text doneText;

    public void validateButton(ActionEvent actionEvent) {
        String isbn = searchField.getText();
        doneText.setText("NOT DONE");
        HTMLManager.callDELETECard(isbn);
        doneText.setText("DONE");
    }

    public void onReturnClick(ActionEvent actionEvent) throws IOException {
        FirstViewController.switchScene("first-view.fxml", actionEvent, 320, 240);
    }
}
