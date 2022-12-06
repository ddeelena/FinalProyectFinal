package co.edu.cue.finalproyect.controller;

import co.edu.cue.finalproyect.HelloApplication;
import co.edu.cue.finalproyect.model.Car;
import co.edu.cue.finalproyect.model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ListUserViewController implements Initializable {
    ObservableList<Person> userObservableList= FXCollections.observableArrayList();
    ModelFactoryController mfc= ModelFactoryController.getInstance();


    @FXML
    private TableColumn<?, ?> cellphoneUser;

    @FXML
    private TableColumn<?, ?> cityUser;

    @FXML
    private TableColumn<?, ?> idUser;

    @FXML
    private TableColumn<?, ?> nameUser;

    @FXML
    private TableView<Person> tableUser;

    @FXML
    void back(ActionEvent event) throws IOException {
        HelloApplication.cee(event);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        load();
        tableUser.setItems(userObservableList);
    }
    public void load(){
         ArrayList<Person> list = mfc.getArrayList();
        for (Person cli: list) {
            userObservableList.add(cli);
        }
    }
}

