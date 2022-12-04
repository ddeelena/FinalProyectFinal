package co.edu.cue.finalproyect.service;

import co.edu.cue.finalproyect.Model.Car;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.HashMap;

public interface CarService {
    public void create(String name, String type, String ubication, String plate, double price, String model,
                       String brand, TableView tableView, ImageView linkImage, String thumbUrl) throws IOException;
    Car selectCar(TableView<Car> tblCar);
    HashMap<String, Car> getCarHashMap();
}
