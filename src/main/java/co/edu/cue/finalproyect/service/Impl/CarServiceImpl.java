package co.edu.cue.finalproyect.service.Impl;

import co.edu.cue.finalproyect.Model.Car;
import co.edu.cue.finalproyect.Model.CarDTO;
import co.edu.cue.finalproyect.persistencia.Persistencia;
import co.edu.cue.finalproyect.service.CarService;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarServiceImpl implements CarService {
   ArrayList<Car> carArrayList = new ArrayList<>();
    HashMap<String,Car> carHashMap = new HashMap<String,Car>();

    //crea un carro  y lo añade a la lista
    // En ese caso como son carros me parecio interesante que el identificador fuera la misma placa aunque como la logica
    // no esta desarrolladora no se que tan optimo podría ser que este sea el identificador y no un dato

    public void create(String name, String type, String ubication, String plate, double price, double days, String model,
                       String brand, ImageView linkImage) throws IOException {
        carArrayList.add(new Car(linkImage,plate,name,type,ubication,price,model,brand));
        Persistencia.saveCar(carArrayList);
        carHashMap.put(plate,new Car(linkImage,plate,name, type, ubication, price, model,brand));
    }
    // elimina un objeto con el identificador
    public void eliminate(String plate){
        carHashMap.remove(plate);
    }
    // recorre por medio de un foreach
    public void wander(){
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
    public Stream<Car> search(String name){
        return carArrayList.stream()
                .filter(c-> name.equalsIgnoreCase(c.getName()))
                .limit(1);
    }

    //retorna una lista con el DTOs
    public List<CarDTO> genereListDTOs(){
        return  carArrayList.stream()
                .map(c-> new CarDTO(c.getName(),c.getPrice()))
                .collect(Collectors.toList());
    }
}
