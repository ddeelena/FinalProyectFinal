package co.edu.cue.finalproyect.controller;

import co.edu.cue.finalproyect.HelloApplication;
import co.edu.cue.finalproyect.model.Car;
import co.edu.cue.finalproyect.model.Client;
import javafx.css.FontCssMetaData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoanCarViewController implements Initializable {
    ModelFactoryController mfc= ModelFactoryController.getInstance();

    @FXML
    private Label brandCar;

    @FXML
    private Label idUser;

    @FXML
    private ImageView imageCar;

    @FXML
    private Label nameCar;

    @FXML
    private Label nameUser;

    @FXML
    private TextField numberCount;

    @FXML
    private Label priceCar;

    @FXML
    void returnSelect(ActionEvent event) {

    }

    @FXML
    private ChoiceBox<?> typeCount;

    @FXML
    void editUser(ActionEvent event) throws IOException {
        HelloApplication.user(event);
    }

    @FXML
    void readyLoan(ActionEvent event) {

    }
    @FXML
    void asiento(ActionEvent event) {

    }
    @FXML
    void porta(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setLabel();
    }
    public void setLabel(){
       // Car car = mfc.getCarSelect();
        Client client = mfc.getClient();
        nameUser.setText(client.getName());
        idUser.setText(client.getId());
/*        nameCar.setText(car.getName());
        imageCar.setImage(car.getLinkImage().getImage());
        priceCar.setText(String.valueOf(car.getPrice()));
        brandCar.setText(car.getBrand());*/
    }
}
