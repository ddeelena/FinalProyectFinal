package co.edu.cue.finalproyect.controller;

import co.edu.cue.finalproyect.HelloApplication;
import co.edu.cue.finalproyect.Model.Car;
import co.edu.cue.finalproyect.persistencia.Persistencia;
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

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
    void turnOffList(ActionEvent event) throws IOException {
        HelloApplication.init(event);
    }

    @FXML
    void selectCar(ActionEvent event) throws IOException {
        Car car = mfc.select(tableCar);
        mfc.carSelect(car);
        HelloApplication.login(event);
    }

    private final  ObservableList<Car> data = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        brand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        photo.setCellValueFactory(new PropertyValueFactory<>("linkPhoto"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));

        try {
            cargarTable();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }catch (NullPointerException e){
            System.out.println("arreglo vacio");
        }
    }
    public  void cargarTable() throws IOException {
        Car car = Persistencia.cargarRecursoTiendaXML();
            data.add(car);

        tableCar.setItems(data);
        tableCar.refresh();
    }

}
