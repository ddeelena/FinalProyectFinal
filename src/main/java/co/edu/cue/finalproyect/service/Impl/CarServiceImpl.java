package co.edu.cue.finalproyect.service.Impl;

import co.edu.cue.finalproyect.Model.Car;
import co.edu.cue.finalproyect.Model.CarDTO;
import co.edu.cue.finalproyect.persistencia.Persistencia;
import co.edu.cue.finalproyect.service.CarService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.*;


public class CarServiceImpl implements CarService {
    Car carSelect= new Car();
    HashMap<String,Car> carHashMap = new HashMap<>();
    ObservableList<Car> carObservableList = FXCollections.observableArrayList();

    public HashMap<String, Car> getCarHashMap() {
        return carHashMap;
    }
    //crea un carro  y lo añade a la lista
    // En ese caso como son carros me parecio interesante que el identificador fuera la misma placa aunque como la logica
    // no esta desarrolladora no se que tan optimo podría ser que este sea el identificador y no un dato

    public void create(String name, String type, String ubication, String plate, double price, String model,
                       String brand, TableView tableView, ImageView linkimage, String thumbUrl) throws IOException {
        //carArrayList.add(new Car(linkImage,plate,name,type,ubication,price,model,brand));
        Car car = new Car(linkimage,plate,name, type, ubication, price, model,brand);
        System.out.println(linkimage);
        carHashMap.put(plate,car);
       // Persistencia.saveCar(carHashMap,thumbUrl);

        Persistencia.guardarRecursoBancoXML(car);
        carObservableList.add(car);
        tableView.setItems(carObservableList);
        tableView.refresh();
    }
    @Override
    public Car selectCar(TableView<Car> tblCar){
       return carSelect = tblCar.getSelectionModel().getSelectedItem();
    }
    public Car search(String plate){
        for(Map.Entry<String, Car> entrada: carHashMap.entrySet()) {
            return entrada.getKey().equals(plate) ? entrada.getValue() : null;
        }
        return null;
    }
    // elimina un objeto con el identificador
    public void eliminate(String plate){
        carHashMap.remove(plate);
    }
    public void edit(Car car, TableView<Car> tblCar){
        try {
            if(!carObservableList.contains(car)){
                editCar(car);
            }

        }catch (NumberFormatException e){

        }catch (NullPointerException ex){

        }
    }
    public void editCar(Car car){
        for(Map.Entry<String, Car> entrada: carHashMap.entrySet()) {
            if(entrada.getValue().equals(car)){

                entrada.getValue().setLinkImage(car.getLinkImage());
                entrada.getValue().setPrice(car.getPrice());
                entrada.getValue().setPlate(car.getPlate());
                entrada.getValue().setUbication(car.getUbication());
                entrada.getValue().setName(car.getName());
                entrada.getValue().setModel(car.getModel());
                entrada.getValue().setType(car.getType());
                entrada.getValue().setBrand(car.getBrand());
            }
        }
    }
    public void fillInput(){

    }
    // recorre por medio de un foreach
 /*   public void wander(){
        for(Map.Entry<String, Car> entrada: carHashMap.entrySet()) {
            String clave= entrada.getKey();
            Car car=entrada.getValue();
            System.out.println(car.getName());
        }
    }
    //recorre solo los valores
    public void wanderValue(){
        for (Car c : carHashMap.values()) {
            System.out.println(c.getName());
        }
    }
    //recorre solo los identificadores
    public void wanderKeySet(){
        for (String c : carHashMap.keySet()) {
            System.out.println(c);
        }
    }
    // Otra manera un poco igual de recorrer
    public void wander2(){
        for (String c: carHashMap.keySet()) {
            System.out.println("key: " + c + " value: " + carHashMap.get(c).getName());
        }
    }
    //funcion para cuando se seleccione ver por tipo

    //public int compare(Car o1, Car o2) {return  o1.getType().compareTo(o2.getType());}

    public void orden(){
        carArrayList.sort(new ComparatorCar());
    }

    //busca un carro por nombre
    public Stream<Car> searchArray(String plate){
        return carArrayList.stream()
                .filter(c-> plate.equalsIgnoreCase(c.getName()))
                .limit(1);
    }

    //retorna una lista con el DTOs
    public List<CarDTO> genereListDTOs(){
        return  carArrayList.stream()
                .map(c-> new CarDTO(c.getName(),c.getPrice()))
                .collect(Collectors.toList());
    }*/

}
