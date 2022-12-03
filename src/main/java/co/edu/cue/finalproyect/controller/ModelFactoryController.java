package co.edu.cue.finalproyect.controller;

import co.edu.cue.finalproyect.Model.Person;
import co.edu.cue.finalproyect.service.Impl.RentCarServiceImpl;
import co.edu.cue.finalproyect.service.ModelFactoryControllerService;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.ArrayList;


public class ModelFactoryController implements ModelFactoryControllerService {
        RentCarServiceImpl rentCarService;
        private static class SingletonHolder {
            // El constructor de Singleton puede ser llamado desde aquí al ser protected
            private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
        }

        // Método para obtener la instancia de nuestra clase
        public static ModelFactoryController getInstance() {
            return SingletonHolder.eINSTANCE;
        }

        public ModelFactoryController() {
            System.out.println("invocación clase singleton");
            rentCarService = new RentCarServiceImpl();
        }
        public  ArrayList<Person> getArrayList(){
           return rentCarService.getPersonService().getArrayList();

        }
        public void init (){
            rentCarService.getPersonService().init();
        }
        public void createCar(String name, String type, String ubication, String plate, double price, String model,
                              String brand, TableView tableView, ImageView linkImage, String thumbUrl) throws IOException {
            rentCarService.getCarService().create(name, type, ubication, plate, price, model, brand,tableView,linkImage,thumbUrl);
        }
        public Boolean login(String userRegis, String passwordRegis, ArrayList<Person> arrayList){
            return rentCarService.getLoginService().login(userRegis, passwordRegis, arrayList);
        }
        public Boolean comprobationPassword(String pass, String pass2){
            return rentCarService.getLoginService().comprobationPassword(pass, pass2);
        }
        public Boolean comprobationAdmi(ArrayList<Person> arrayList){
            return rentCarService.getLoginService().comprobationAdmi(arrayList);
        }
        public void createClient(String name, String id, String cellphone, String gender, String user, String password, String direction, String location){
            rentCarService.getPersonService().createClient(name, id, cellphone, gender, user, password, direction, location);
        }


}
