package fr.ul.tp3_exo2_fx.controller;

import fr.ul.tp3_exo2_fx.HTMLManager;
import fr.ul.tp3_exo2_fx.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class FirstViewController {
    @FXML
    private Button addCard;
    @FXML
    private Button searchCard;
    @FXML
    private Button deleteCard;
    @FXML
    private Button editCard;
    @FXML
    private Label cards;

    private static Stage stage;

    public FirstViewController() {
    }

    public void onAddCardClick(ActionEvent actionEvent) throws IOException {
        switchScene("add-view.fxml", actionEvent, 320, 240);
    }

    public void onSearchCardClick(ActionEvent actionEvent) throws IOException {
        switchScene("search-view.fxml", actionEvent, 320, 240);
    }

    public void onDeleteCardClick(ActionEvent actionEvent) throws IOException {
        switchScene("delete-view.fxml", actionEvent, 320, 240);
    }

    public void onEditCardClick(ActionEvent actionEvent) throws IOException {
        switchScene("edit-view.fxml", actionEvent, 320, 500);
    }

    public static void switchScene(String fxml, ActionEvent actionEvent, int v, int v1) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml));
        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(fxmlLoader.load(), v, v1));
        stage.show();
    }
}
