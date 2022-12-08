package co.edu.cue.finalproyect.controller;

import co.edu.cue.finalproyect.HelloApplication;
import co.edu.cue.finalproyect.execeptions.Alert;
import co.edu.cue.finalproyect.model.Car;
import co.edu.cue.finalproyect.model.Client;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
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
        skipLogin(event);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        brand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        photo.setCellValueFactory(new PropertyValueFactory<>("linkPhoto"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
       // init();
         mfc.fillTable(data);
         tableCar.setItems(data);
/*        try {
            cargarTable();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }catch (NullPointerException e){
            System.out.println("arreglo vacio");
        }*/
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
    @FXML
    void skipLogin(ActionEvent event) throws IOException {
        Client client1 = mfc.getClient();
        System.out.println(client1.isCondition()+ client1.getName());
        if(client1.isCondition() ){
            HelloApplication.ViewLn(event);
        }else {
            HelloApplication.login(event);
        }
    }
    public void init(){
        ImageView imageView = new ImageView();
        ImageView linkImage;
        final FileChooser fileChooser = new FileChooser();
        File file =  fileChooser.showOpenDialog(new Stage());
        try{
            if(file.getName().contains(".jpg") || file.getName().contains(".png")){
               String thumbUrl = file.toURI().toURL().toString();
                System.out.println(file.toURI().toURL().toString());
               Image imgLoad = new Image(thumbUrl);
               imageView.setImage(imgLoad);
                System.out.println(imageView);
                linkImage = new ImageView(imageView.getImage());
                Car car = new Car(linkImage,"der","der","plastico","Arm",2,"ford","ne",false);
                HashMap<String,Car> carHashMap = mfc.getHashMap();
                carHashMap.put("der",car);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
