package co.edu.cue.finalproyect.service;

import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;

import java.io.IOException;

public interface CarService {

    public void create(String name, String type, String ubication, String plate, double price, String model,
                       String brand, TableView tableView, ImageView linkImage, String thumbUrl) throws IOException;
}
