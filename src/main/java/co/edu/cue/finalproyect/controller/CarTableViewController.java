package co.edu.cue.finalproyect.controller;

import co.edu.cue.finalproyect.Model.Car;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class CarTableViewController implements Initializable {
    ModelFactoryController mfc= ModelFactoryController.getInstance();

    @FXML
    private TableColumn<?, ?> brand;

    @FXML
    private TableColumn<?, ?> name;

    @FXML
    private TableColumn<Car, String> photo;

    @FXML
    private TableColumn<?, ?> price;

    @FXML
    private TableView<Car> tableCar;

    @FXML
    private TableColumn<Car, ?> type;

    @FXML
    void selectCar(ActionEvent event) {

    }

    private final  ObservableList<Car> data = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        brand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        photo.setCellValueFactory(new PropertyValueFactory<>("linkPhoto"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));

       // ImageView image = new ImageView(new Image(("photos/kia.jpg")));
        //Image image = new Image(("@photos/kia.jpg"));
        ImageView image2 = new ImageView(new Image("/resources/co/edu/cue/finalproyect/photos/Logo.png"));
        Car car = new Car(image2,"xds 234","kia","moto","armenia",4000,"fer","kia");
        data.add(car);

        tableCar.setItems(data);
    }

}
