package co.edu.cue.finalproyect.controller;

import co.edu.cue.finalproyect.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class StartViewController implements Initializable {
    ModelFactoryController mfc =  ModelFactoryController.getInstance();
    ObservableList<String> citys = FXCollections.observableArrayList("Armenia","Bogota","Pereira");

    LocalDate dateSince;
    LocalDate dateUntil;
    String country;
    String city;

    @FXML
    private ChoiceBox<String> cityChoise;

    @FXML
    private DatePicker sinceDate;

    @FXML
    private DatePicker untilDate;
    @FXML
    private ChoiceBox<String> countryChoise;

    @FXML
    void loginAdmi(ActionEvent event) throws IOException {
        HelloApplication.login(event);
    }

    @FXML
    void searchResult(ActionEvent event) throws IOException {
        getData();
        HelloApplication.tableV(event);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("initialize ");
        countryChoise.setValue("Colombia");
        cityChoise.setValue("Bogota");
        cityChoise.setItems(citys);
        CompletableFuture.runAsync(()-> {
            try {
                System.out.println("llamado");
                mfc.init();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void getData(){
        dateSince = sinceDate.getValue();
        dateUntil = untilDate.getValue();
        city = String.valueOf(cityChoise.getValue());
        country = String.valueOf(countryChoise.getValue());
        setDateLoan();
    }
    public void setDateLoan(){
        mfc.setDateLoan(dateUntil);
        mfc.setDeliveryLoan(dateSince);

    }

}
