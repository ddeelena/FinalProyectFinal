package co.edu.cue.finalproyect.controller;

import co.edu.cue.finalproyect.HelloApplication;
import co.edu.cue.finalproyect.execeptions.Alert;
import co.edu.cue.finalproyect.model.Car;
import co.edu.cue.finalproyect.persistencia.Persistencia;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CarTableViewController implements Initializable {
    Alert alert = new Alert();
    ModelFactoryController mfc= ModelFactoryController.getInstance();
    private final  ObservableList<Car> data = FXCollections.observableArrayList();

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
        Car car = mfc.getCarSelect(tableCar);
        mfc.carSelect(car);
        HelloApplication.login(event);
    }

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
        if(car == null){
            alert.alertError("Lo sentimos los datos no se pudieron cargar","Error");
        }else {
            data.add(car);
            tableCar.setItems(data);
            tableCar.refresh();
        }
    }

}
