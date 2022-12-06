package co.edu.cue.finalproyect.controller;

import co.edu.cue.finalproyect.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class StartViewController implements Initializable {

    ObservableList<String> country = FXCollections.observableArrayList("Ecuador","Colombia");
    ObservableList<String> city = FXCollections.observableArrayList("Armenia","Bogota","Pereira");

    ObservableList<String> cityEc = FXCollections.observableArrayList("Manta","Guayaquil","Quito");
    @FXML
    private ChoiceBox<String> cityChoise;

    @FXML
    private ChoiceBox<String> countryChoise;

    @FXML
    void loginAdmi(ActionEvent event) throws IOException {
        HelloApplication.login(event);
    }

    @FXML
    void searchResult(ActionEvent event) throws IOException {
        HelloApplication.tableV(event);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        countryChoise.setValue("Colombia");
        cityChoise.setValue("Bogota");
        cityChoise.setItems(city);
    }
    public boolean es(){
        if(!countryChoise.getValue().equals(null)){
            return true;
        }
        return false;
    }
    public void select () {
        if (countryChoise.getValue().equals("Colombia")) {
            cityChoise.setValue("Bogota");
            cityChoise.setItems(city);
        } else if (countryChoise.getValue().equals("Ecuador")) {
            cityChoise.setValue("Quito");
            cityChoise.setItems(cityEc);
        }
    }
}
